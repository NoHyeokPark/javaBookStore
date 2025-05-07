package kr.ac.kopo.vo;

public class CSBoardVO {
	private int no;
	private String title;
	private String writer; // id
	private String question;
	private String type;
	private String regDateCall;
	private String answer;
	private String regDateAns;
	private String csId;

	public CSBoardVO() {
		super();
	}

	public CSBoardVO(String title, String writer, String content) {
		super();
		this.title = title;
		this.writer = writer;
		this.question = content;
	}

	public CSBoardVO(String title, String writer, String content, String regDate, int no) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.question = content;
		this.regDateCall = regDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String call) {
		this.question = call;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRegDateCall() {
		return regDateCall;
	}

	public void setRegDateCall(String regDateCall) {
		this.regDateCall = regDateCall;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getRegDateAns() {
		return regDateAns;
	}

	public void setRegDateAns(String regDateAns) {
		this.regDateAns = regDateAns;
	}

	public String getCsId() {
		return csId;
	}

	public void setCsId(String csId) {
		this.csId = csId;
	}
}
