package kr.ac.kopo.vo;

public class BookVO {
	private String book_cd;
	private String book_nm;
	private String type;
	private String writer;
	private String nation;
	private String publicationDate;
	private int price;

	public BookVO() {
	}

	public BookVO(String book_cd, String book_nm, String type, String writer, String nation, String publicationDate,
			int price) {
		super();
		this.book_cd = book_cd;
		this.book_nm = book_nm;
		this.type = type;
		this.writer = writer;
		this.nation = nation;
		this.publicationDate = publicationDate;
		this.price = price;
	}

	public String getBook_cd() {
		return book_cd;
	}

	public void setBook_cd(String book_cd) {
		this.book_cd = book_cd;
	}

	public String getBook_nm() {
		return book_nm;
	}

	public void setBook_nm(String book_nm) {
		this.book_nm = book_nm;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
