package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.BookVO;

public class BookDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private List<BookVO> book;
	
	
	public BookDAO() {
	}

	public List<BookVO> select(String key, String list){
		book = new ArrayList<>();
		conn = ConnectionFactory.getConn("BOOK_SYS", "1234");
		StringBuilder sql = new StringBuilder();
		key = "%"+key+"%";
		sql.append("select * ");
		sql.append("from BOOK_M ");
		sql.append("where book_nm like ? ");
		if(list != null) {
			sql.append("and BOOK_TYPE = ? ");		
		}
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, key);
			if(list != null) {
				pstmt.setString(2, list);
			}
			rs = pstmt.executeQuery();			
			while(rs.next()) {
				BookVO VO = new BookVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
				book.add(VO);
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

		return book;
	}
}
