# -*- coding: utf-8 -*-
"""
读取值班 Excel，按系统当天日期(北京时间)匹配值班人。
输出键值给 GitHub Actions: TODAY=... / PERSON=...
放在仓库根目录，与 duty.xlsx(即"普惠核心值班安排表.xlsx")同级使用。
"""
import os
from datetime import datetime, timezone, timedelta
from openpyxl import load_workbook

# 用北京时间作为"今天"，避免 runner 的 UTC 偏差推错人
TODAY = datetime.now(timezone(timedelta(hours=8))).strftime("%Y-%m-%d")

# Excel 文件名按需修改（与仓库中实际文件名保持一致）
XLSX = os.environ.get("DUTY_XLSX", "普惠核心值班安排表.xlsx")

wb = load_workbook(XLSX, data_only=True)

# 1) 优先找名称含"明细"的工作表，否则取最后一个
ws = None
for s in wb.worksheets:
    if "明细" in s.title:
        ws = s
        break
if ws is None:
    ws = wb.worksheets[-1]

# 2) 动态定位表头行，找到"日期"列与"值班人"列
date_col, person_col = None, None
header_idx = None
for i, r in enumerate(ws.iter_rows(values_only=True)):
    cells = [str(c).strip() if c is not None else "" for c in r]
    if "日期" in cells and any("值班人" in c for c in cells):
        header_idx = i
        for j, c in enumerate(cells):
            if c == "日期":
                date_col = j
            if "值班人" in c:
                person_col = j
        break

if header_idx is None:
    print(f"TODAY={TODAY}")
    print("PERSON=")
    raise SystemExit("未在 Excel 中找到含『日期』『值班人』的表头行")

def norm_date(v):
    if isinstance(v, datetime):
        return v.strftime("%Y-%m-%d")
    s = str(v).strip()
    for fmt in ("%Y-%m-%d %H:%M:%S", "%Y-%m-%d", "%Y/%m/%d %H:%M:%S", "%Y/%m/%d", "%Y.%m.%d"):
        try:
            return datetime.strptime(s, fmt).strftime("%Y-%m-%d")
        except Exception:
            pass
    return None

person = None
for idx, r in enumerate(ws.iter_rows(values_only=True)):
    if idx <= header_idx:
        continue
    dv = r[date_col] if date_col < len(r) else None
    pv = r[person_col] if person_col < len(r) else None
    if dv is None or pv is None:
        continue
    ds = norm_date(dv)
    if ds == TODAY:
        person = str(pv).strip()
        break

print(f"TODAY={TODAY}")
print(f"PERSON={person or ''}")
