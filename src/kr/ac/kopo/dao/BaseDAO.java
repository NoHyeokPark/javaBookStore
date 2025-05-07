package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.ac.kopo.util.ConnectionFactory;

public class BaseDAO {
	Connection conn;
	StringBuilder sql;
	PreparedStatement pstmt;
public BaseDAO() {
	conn = ConnectionFactory.getConn("BOOK_SYS", "1234");
	sql = new StringBuilder();
	sql.append("select ?");
	sql.append("from ?");
}
}
