package MysqlDemo;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnMysql {

	// static final String JDBC_URL = "org.gjt.mm.mysql.Driver";
	static final String JDBC_URL = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/goonie_prod?characterEncoding=utf8";
	static final String USER_NAME = "goonie_db";
	static final String PASSWORD = "";

	public static void main(String[] args) {
		try {
			Class.forName(JDBC_URL);
			// ResultSet rs = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD).createStatement().executeQuery("select * from h_device");
			ResultSet rs = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD).createStatement().executeQuery("select * from h_device");
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("hostname");
				String ip = rs.getString("ip_address");
				System.out.println("ID : " + id);
				System.out.println("HOST : " + name);
				System.out.println("IP : " + ip);
			}
			//关闭链接
			rs.close();
//			DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD).close();
//			DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD).createStatement().close();
		} catch (SQLException q) {
			System.err.println(q.getErrorCode());
			System.err.println(q.getMessage());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
