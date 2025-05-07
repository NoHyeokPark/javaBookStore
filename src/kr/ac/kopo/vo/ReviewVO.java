package kr.ac.kopo.vo;

public class ReviewVO {
	private String book_cd;
	private String user_id;
	private String review_content; // id
	private int grade;
	private String reg_Date;
	
	public ReviewVO() {
	}
	
	public ReviewVO(String book_cd, String user_id, String review_content, int grade, String reg_Date) {
		super();
		this.book_cd = book_cd;
		this.user_id = user_id;
		this.review_content = review_content;
		this.grade = grade;
		this.reg_Date = reg_Date;
	}


	public String getBook_cd() {
		return book_cd;
	}

	public void setBook_cd(String book_cd) {
		this.book_cd = book_cd;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getReg_Date() {
		return reg_Date;
	}

	public void setReg_Date(String reg_Date) {
		this.reg_Date = reg_Date;
	}
	
	
}
