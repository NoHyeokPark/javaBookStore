package kr.ac.kopo.vo;

import java.sql.Clob;

public class FullBookVO {
	private String book_cd;
	private Clob context;
	
	public FullBookVO() {
	}
	

	public FullBookVO(String book_cd, Clob context) {
		super();
		this.book_cd = book_cd;
		this.context = context;
	}


	public String getBook_cd() {
		return book_cd;
	}

	public void setBook_cd(String book_cd) {
		this.book_cd = book_cd;
	}

	public Clob getContext() {
		return context;
	}

	public void setContext(Clob context) {
		this.context = context;
	}
	
	
}
