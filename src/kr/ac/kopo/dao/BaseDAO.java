package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.util.ConnectionFactory;

public abstract class BaseDAO {
	private Connection conn;
	private StringBuilder sql;
	private PreparedStatement pstmt;
	private ResultSet rs;
public BaseDAO() {
	conn = ConnectionFactory.getConn("BOOK_SYS", "1234");
	sql = new StringBuilder();
}
}
