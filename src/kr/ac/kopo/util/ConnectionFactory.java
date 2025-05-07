package kr.ac.kopo.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("�뱶�씪�씠踰� 濡쒕뵫 �셿猷�...");

			// 2�떒怨� : DB�젒�냽 Connection 媛앹껜 �뼸湲�
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";

			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn : " + conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	
	public static Connection getConn(String user,String password) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("�뱶�씪�씠踰� 濡쒕뵫 �셿猷�...");

			// 2�떒怨� : DB�젒�냽 Connection 媛앹껜 �뼸湲�
			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			conn = DriverManager.getConnection(url, user, password);
			//System.out.println("conn : " + conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	}
}
