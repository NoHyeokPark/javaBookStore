package kr.ac.kopo.vo;


public class AddressVO {
	private String adName;
	private String address;
	private int no;

	public AddressVO() {
	}

	public AddressVO(String adName, String address, int no) {
		super();
		this.adName = adName;
		this.address = address;
		this.no = no;
	}

	public String getAdName() {
		return adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

}