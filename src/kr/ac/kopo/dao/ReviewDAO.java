package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.ReviewVO;

public class ReviewDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private List<ReviewVO> reviewBoard;
	
	public ReviewDAO() {
	}
	
	public boolean exists(String book_cd, String user_id) {
		conn = ConnectionFactory.getConn("BOOK_SYS", "1234");
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append("from BOOK_REVIEW ");
		sql.append("where book_cd = ? and user_id = ?");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, book_cd);
			pstmt.setString(2, user_id);
			rs = pstmt.executeQuery();
			return rs.next();
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
	}
	
	public double avgGrade(String book_cd) {
		conn = ConnectionFactory.getConn("BOOK_SYS", "1234");
		StringBuilder sql = new StringBuilder();
		sql.append("select avg(grade) ");
		sql.append("from BOOK_REVIEW ");
		sql.append("where book_cd = ? ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, book_cd);
			rs = pstmt.executeQuery();			
			rs.next();
			return rs.getDouble(1);			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
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
	
	public List<ReviewVO> selectBoardTop5(String book_cd) {
		reviewBoard = new ArrayList<>();
		conn = ConnectionFactory.getConn("BOOK_SYS", "1234");
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append("from ");
		sql.append("(select * ");
		sql.append("from BOOK_REVIEW ");
		sql.append("where book_cd = ? ");
		sql.append("order by grade desc ) ");
		sql.append("where rownum < 6 ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, book_cd);
			rs = pstmt.executeQuery();			
			while(rs.next()) {
				ReviewVO VO = new ReviewVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
				reviewBoard.add(VO);
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
		return reviewBoard;
	}
	
	public void insert(ReviewVO v) {
		conn = ConnectionFactory.getConn("BOOK_SYS", "1234");
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO BOOK_REVIEW ");
		sql.append("(book_cd, user_id, review_content, grade)");
		sql.append("VALUES (?, ?, ?, ?)");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, v.getBook_cd());
			pstmt.setString(2, v.getUser_id());
			pstmt.setString(3, v.getReview_content());
			pstmt.setInt(4, v.getGrade());
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
	
	public void update(ReviewVO v) {
		conn = ConnectionFactory.getConn("BOOK_SYS", "1234");
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE BOOK_REVIEW ");
		sql.append("SET REVIEW_CONTENT = ?, GRADE = ?");
		sql.append("where book_cd = ? and user_id = ?");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, v.getReview_content());
			pstmt.setInt(2, v.getGrade());
			pstmt.setString(3, v.getBook_cd());
			pstmt.setString(4, v.getUser_id());
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
