package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.BucketVO;

public class BucketDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private List<BucketVO> bucketlst;

	public BucketDAO() {
	}

	public boolean update(int user_no, String book_cd, int qty) {
		conn = ConnectionFactory.getConn("BOOK_SYS", "1234");
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE BUCKET ");
		sql.append("SET QTY = QTY + ? ");
		sql.append("WHERE USER_NO = ? AND BOOK_CD = ? ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, qty);
			pstmt.setInt(2, user_no);
			pstmt.setString(3, book_cd);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
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
		return true;
	}

	public boolean delete(int user_no, String book_cd) {
		conn = ConnectionFactory.getConn("BOOK_SYS", "1234");
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM BUCKET ");
		sql.append("WHERE USER_NO = ? AND BOOK_CD = ? ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, user_no);
			pstmt.setString(2, book_cd);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
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
		return true;
	}
	
	public boolean delete(int user_no) {
		conn = ConnectionFactory.getConn("BOOK_SYS", "1234");
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM BUCKET ");
		sql.append("WHERE USER_NO = ? ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, user_no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
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
		return true;
	}

	public List<BucketVO> select(int no) {
		bucketlst = new ArrayList<>();
		conn = ConnectionFactory.getConn("BOOK_SYS", "1234");
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append("from BUCKET ");
		sql.append("where user_no = ? ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BucketVO VO = new BucketVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
				bucketlst.add(VO);
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
		return bucketlst;
	}

	public void insert(int no, String name, int price, int qty, String cd) {
		conn = ConnectionFactory.getConn("BOOK_SYS", "1234");
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO BUCKET ");
		sql.append("(USER_NO, BOOK_NM, PRICE, QTY, BOOK_CD)");
		sql.append("VALUES (?, ?, ?, ?, ?)");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			pstmt.setString(2, name);
			pstmt.setInt(3, price);
			pstmt.setInt(4, qty);
			pstmt.setString(5, cd);
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

}
