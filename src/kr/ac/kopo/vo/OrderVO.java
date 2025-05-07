package kr.ac.kopo.vo;

import java.sql.Date;

public class OrderVO {
	private String invoice_no;
	private String book_nm;
	private String order_nm;
	private Date outboundDate;
	private String status;
	private int orderQTY;
	private int no;
	private String book_cd;

	public String getBook_cd() {
		return book_cd;
	}

	public void setBook_nm(String book_nm) {
		this.book_nm = book_nm;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public OrderVO() {
	}

	public OrderVO(String invoice_no, String book_nm, String order_nm, String status, int orderQTY, int no) {
		super();
		this.invoice_no = invoice_no;
		this.book_nm = book_nm;
		this.order_nm = order_nm;
		this.status = status;
		this.orderQTY = orderQTY;
		this.no = no;
	}

	public OrderVO(String invoice_no, String book_cd, String order_nm, Date outboundDate, String status,
			int orderQTY, int no, String book_nm) {
		super();
		this.invoice_no = invoice_no;
		this.book_nm = book_nm;
		this.order_nm = order_nm;
		this.outboundDate = outboundDate;
		this.status = status;
		this.orderQTY = orderQTY;
		this.no = no;
		this.book_cd = book_cd;
	}

	public String getInvoice_no() {
		return invoice_no;
	}

	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}

	public String getBook_nm() {
		return book_nm;
	}

	public void setBook_cd(String book_nm) {
		this.book_nm = book_nm;
	}

	public String getOrder_nm() {
		return order_nm;
	}

	public void setOrder_nm(String order_nm) {
		this.order_nm = order_nm;
	}

	public Date getOutboundDate() {
		return outboundDate;
	}

	public void setOutboundDate(Date outboundDate) {
		this.outboundDate = outboundDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getOrderQTY() {
		return orderQTY;
	}

	public void setOrderQTY(int orderQTY) {
		this.orderQTY = orderQTY;
	}

	public int getNo() {
		return no;
	}

	public void setId(int no) {
		this.no = no;
	}
}
