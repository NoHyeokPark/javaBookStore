package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.BucketVO;
import kr.ac.kopo.vo.OrderVO;

public class OrderDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private List<OrderVO> orderlst;
	
	public OrderDAO() {
	}
	
	public boolean insert(List<BucketVO> lst, int user_no, String user_nm, String invoice) {
		conn = ConnectionFactory.getConn("BOOK_SYS", "1234");
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ORDER_M ");
		sql.append("(BOOK_CD, ORDER_NM, STATUS, ORDER_QTY, USER_NO, BOOK_NM, INVOICE_NO) ");
		sql.append("VALUES (?, ?, 3, ?, ?, ?, ?) ");
		try {
			for(BucketVO row : lst) {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, row.getBook_cd());
			pstmt.setString(2, user_nm);
			pstmt.setInt(3, row.getQty());
			pstmt.setInt(4, user_no);
			pstmt.setString(5, row.getBook_nm());
			pstmt.setString(6, invoice);
			pstmt.executeUpdate();
			}
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
	
	public List<OrderVO> select(int user_no){
		orderlst = new ArrayList<>();
		conn = ConnectionFactory.getConn("BOOK_SYS", "1234");
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append("from ORDER_M m1 ");
		sql.append("join order_s s1 on s1.status_no = m1.status ");
		sql.append("where m1.USER_NO = ? ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, user_no);
			rs = pstmt.executeQuery();			
			while(rs.next()) {
				OrderVO VO = new OrderVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString("STATUS_NM"),
						rs.getInt(6), rs.getInt(7), rs.getString(8));
				orderlst.add(VO);
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

		return orderlst;
	}
}
