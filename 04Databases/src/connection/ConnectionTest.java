package connection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {
	public static void main(String[] args) throws Exception {
		ConnectionTest a = new ConnectionTest();
		a.testConnection1();
	}
	
	// 方式一
	public void testConnection1() throws SQLException{
		// Ctrl + T 可以显示出来
		// 获取Driver实现类对象
		Driver driver = new com.microsoft.sqlserver.jdbc.SQLServerDriver();
		
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=School";;
		Properties info = new Properties();
		info.setProperty("user", "sa");
		info.setProperty("password", "0420");
		
		Connection conn = driver.connect(url, info);
		System.out.println(conn);
	}
	
	// 方式二：对方式一的迭代：在如下的程序中不出现第三方的api，使得程序具有更好的可移植性
	public void testConnection2() throws Exception{
		// Ctrl + T 可以显示出来
		// 获取Driver实现类对象， 使用反射
		// Driver driver = new com.microsoft.sqlserver.jdbc.SQLServerDriver();
		Class claszz = Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Driver driver = (Driver) claszz.newInstance();
		
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=School";;
		Properties info = new Properties();
		info.setProperty("user", "sa");
		info.setProperty("password", "0420");
		
		Connection conn = driver.connect(url, info);
		System.out.println(conn);
	}
	
	// 方式三：使用DriverManager替换Driver
	public void testConnection3() throws Exception{
		// 1. 获取Driver实现类对象
		Class claszz = Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Driver driver = (Driver) claszz.newInstance();
		
		// 注册驱动
		DriverManager.registerDriver(driver);
		
		// 获取连接
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=School";
		Connection conn = DriverManager.getConnection(url, "sa", "0420");

		System.out.println(conn);
	}

	// 方式四：可以只是加载驱动，不用显示的注册驱动过了
	public void testConnection4() throws Exception{
		// 1. 提供另外三个连接基本信息
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=School";
		String username = "sa";
		String password = "0420";
		
		// 2. 加载Driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// 相较于方式三，可以省略如下的操作
		// Driver driver = (Driver) claszz.newInstance();
		
		// 注册驱动
		// DriverManager.registerDriver(driver);
		// 为什么可以省略上述操作？ 在SQL server的Driver类中，声明了如上操作
		// 3. 获取连接
		Connection conn = DriverManager.getConnection(url, "sa", "0420");

		System.out.println(conn);
	}
	
	// 方式五：将数据库连接需要的4个基本信息声明在
	// 配置文件中，通过读取配置文件的方式，获取连接
	public void testConnection5() throws Exception{
		// 1. 读取配置文件中4个基本信息
		InputStream ins = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
		Properties pros = new Properties();
		pros.load(ins);
		String user = pros.getProperty("user");
		String password = pros.getProperty("password");
		String url = pros.getProperty("url");
		String driverName = pros.getProperty("driverName");
		
		// 2. 加载Driver
		Class.forName(driverName);
		// 相较于方式三，可以省略如下的操作
		// Driver driver = (Driver) claszz.newInstance();
		
		// 注册驱动
		// DriverManager.registerDriver(driver);
		// 为什么可以省略上述操作？ 在SQL server的Driver类中，声明了如上操作
		// 3. 获取连接
		Connection conn = DriverManager.getConnection(url, user, password);

		System.out.println(conn);
	}	
}
