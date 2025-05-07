package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.FullBookVO;

public class FullBookDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	public FullBookDAO() {
	}
	
	public FullBookVO select(String book_cd) {
		conn = ConnectionFactory.getConn("BOOK_SYS", "1234");
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append("from BOOK_TEXT ");
		sql.append("where book_cd = ?");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, book_cd);
			rs = pstmt.executeQuery();
			FullBookVO bookText = null;
			if (rs.next()) {
				bookText = new FullBookVO(rs.getString(1), rs.getClob(2));
			}
			return bookText;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
	}
}
