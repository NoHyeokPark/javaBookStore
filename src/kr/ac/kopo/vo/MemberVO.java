package kr.ac.kopo.vo;

public class MemberVO {
	private String id;
	private String password;
	private String name;
	private String birthDay;
	private int gender;
	private String mobile;
	private String e_mail;
	private String regDate;
	private int cash;
	private int no;
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public MemberVO() {

	}
	public MemberVO(String id, String password, String name, String birthDay, int gender, String mobile,
			String e_mail) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.birthDay = birthDay;
		this.gender = gender;
		this.mobile = mobile;
		this.e_mail = e_mail;
	}

	public MemberVO(String id, String password, String name, String birthDay, int gender, String mobile,
			String e_mail, int no, int cash) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.birthDay = birthDay;
		this.gender = gender;
		this.mobile = mobile;
		this.e_mail = e_mail;
		this.no = no;
		this.cash = cash;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}
}
