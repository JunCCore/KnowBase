package com.util;

public class FactoryUpload {

    public static void main(String[] args) {
        System.out.println("欢迎使用当前小程序！");
        if (args[0]!=null){
            String filepath = args[0];
            System.out.println("当前文件保存路径："+args[0]);
        }
    }
}
