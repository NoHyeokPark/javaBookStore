package kr.ac.kopo.vo;

public class BucketVO {
	private int user_no;
	private String book_nm;
	private int price;
	private int qty;
	private String book_cd;

	public BucketVO() {
	}

	public BucketVO(int user_no, String book_nm, int price, int qty, String book_cd) {
		super();
		this.user_no = user_no;
		this.book_nm = book_nm;
		this.price = price;
		this.qty = qty;
		this.book_cd = book_cd;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getBook_nm() {
		return book_nm;
	}

	public void setBook_nm(String book_nm) {
		this.book_nm = book_nm;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getBook_cd() {
		return book_cd;
	}

	public void setBook_cd(String book_cd) {
		this.book_cd = book_cd;
	}

}
