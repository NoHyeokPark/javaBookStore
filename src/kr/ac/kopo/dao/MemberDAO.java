package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.MemberVO;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public MemberDAO() {

	}
	
	public void upDateColStr(int no, String value, String colum) {
		conn = ConnectionFactory.getConn("BOOK_SYS", "1234");
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE MEMBER_M ");
		switch(colum) {
		case "pass":
			sql.append("SET USER_PASSWORD = ? ");
			break;
		case "pon":
			sql.append("SET MOBILE = ? ");
			break;
		case "email":
			sql.append("SET E_MAIL = ? ");
			break;	
		}
		sql.append("WHERE USER_NO = ? ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, value);
			pstmt.setInt(2, no);
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
	
	public void upDateCash(int price, int no) {
		conn = ConnectionFactory.getConn("BOOK_SYS", "1234");
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE MEMBER_M ");
		sql.append("SET CASH = CASH + ? ");
		sql.append("WHERE USER_NO = ? ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, price);
			pstmt.setInt(2, no);
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
	
	public boolean dropMember(MemberVO m) {
		conn = ConnectionFactory.getConn("BOOK_SYS", "1234");
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM MEMBER_M ");
		sql.append("WHERE USER_NO = ?");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, m.getNo());
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

	public void setMember(MemberVO m) {
		conn = ConnectionFactory.getConn("BOOK_SYS", "1234");
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO MEMBER_M ");
		sql.append("(USER_ID, USER_PASSWORD, USER_NM, BIRTH_DATE, GENDER, MOBILE, E_MAIL, ADMIN)");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, 0)");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getBirthDay());
			pstmt.setInt(5, m.getGender());
			pstmt.setString(6, m.getMobile());
			pstmt.setString(7, m.getE_mail());
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

	public MemberVO getMember(String id) {
		MemberVO member;
		conn = ConnectionFactory.getConn("BOOK_SYS", "1234");
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append("from MEMBER_M ");
		sql.append("where user_id = ?");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getInt(11), rs.getInt(8));
				return member;
			} else {
				return null;
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

	}
	
	public String selectID(String name, String mobile) {
		conn = ConnectionFactory.getConn("BOOK_SYS", "1234");
		StringBuilder sql = new StringBuilder();
		sql.append("select USER_ID ");
		sql.append("from MEMBER_M ");
		sql.append("where USER_NM = ? and MOBILE = ?");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, name);
			pstmt.setString(2, mobile);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			} else {
				return null;
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

	}
	
	

}
