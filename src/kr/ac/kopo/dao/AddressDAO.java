package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.AddressVO;

public class AddressDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private List<AddressVO> addlst;
	
	public AddressDAO() {
	}
	
	public void insert(String name, String add, int no) {
		conn = ConnectionFactory.getConn("BOOK_SYS", "1234");
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ADDRESS ");
		sql.append("(ADDRESS_NM, ADDRESS, USER_NO)");
		sql.append("VALUES (?, ?, ?)");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, name);
			pstmt.setString(2, add);
			pstmt.setInt(3, no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
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
	
	public List<AddressVO> select(int user_no){
		addlst = new ArrayList<>();
		conn = ConnectionFactory.getConn("BOOK_SYS", "1234");
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append("from ADDRESS ");
		sql.append("where USER_NO = ? ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, user_no);
			rs = pstmt.executeQuery();			
			while(rs.next()) {
				AddressVO VO = new AddressVO(rs.getString(1), rs.getString(2), rs.getInt(3));
				addlst.add(VO);
			}
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
		return addlst;
	}
}
