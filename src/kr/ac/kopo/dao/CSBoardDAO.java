package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import kr.ac.kopo.service.ServiceFactory;
import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.CSBoardVO;

public class CSBoardDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private List<CSBoardVO> csBoard;

	public CSBoardDAO() {
	}

	public List<CSBoardVO> selectAllBoard() {
		csBoard = new ArrayList<>();
		conn = ConnectionFactory.getConn("BOOK_SYS", "1234");
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append("from CS_BOARD cs1 LEFT JOIN CS_BOARD_A cs2 on cs2.no = cs1.CS_NO ");
		sql.append("where cs1.user_no = ? ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, ServiceFactory.getMemberInstance().getNo());
			rs = pstmt.executeQuery();			
			while(rs.next()) {
				CSBoardVO VO = new CSBoardVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				VO.setCsId(rs.getString("CS_ID"));
				VO.setAnswer(rs.getString("ANSWER"));
				VO.setRegDateAns(rs.getString("ANS_DATE"));
				csBoard.add(VO);
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
		return csBoard;
	}
	
	public void insertUser(CSBoardVO v) {
		conn = ConnectionFactory.getConn("BOOK_SYS", "1234");
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO CS_BOARD ");
		sql.append("(title, writer, question, user_no)");
		sql.append("VALUES (?, ?, ?, ?)");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, v.getTitle());
			pstmt.setString(2, ServiceFactory.getMemberInstance().getName());
			pstmt.setString(3, v.getQuestion());
			pstmt.setInt(4, ServiceFactory.getMemberInstance().getNo());
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
