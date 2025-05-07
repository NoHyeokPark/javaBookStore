package kr.ac.kopo.service;

import java.util.Random;

import kr.ac.kopo.dao.MemberDAO;
import kr.ac.kopo.vo.MemberVO;

public class MemberService {
	private MemberDAO memberDAO;
	private MemberVO loginUser;

	public MemberService() {
		memberDAO = new MemberDAO();
	}
	
	public void upDateUserInfo() {
		loginUser = memberDAO.getMember(loginUser.getId());
	}

	public String randomNumber() {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			sb.append(random.nextInt(10));
		}
		return sb.toString();
	}
	
	public String findPass(String id, String pohn) {
		MemberVO user = memberDAO.getMember(id); 
		if(user != null) {
			if (user.getMobile().equals(pohn)) {
				String newPass = randomNumber();
				memberDAO.upDateColStr(user.getNo(), newPass, "pass");
				return "비밀번호가 [" + newPass + "]로 재발급되었습니다";
			}
		}
		return "일치하는 회원이 없습니다";
	}

	public String findID(String name, String mobile) {
		String id = memberDAO.selectID(name, mobile);
		if (id != null)
			return "회원님의 아이디는 "+id.subSequence(0, id.length()-3)+"*** 입니다.";
		else
			return "일치하는 회원이 없습니다";
	}

	public void upDateColStr(String value, String colum) {
		memberDAO.upDateColStr(loginUser.getNo(), value, colum);
	}

	public boolean logcheck() {
		return loginUser == null;
	}

	public boolean passCorrect(String pass) {
		return pass.equals(loginUser.getPassword()) ? true : false;
	}

	public boolean delete() {
		return memberDAO.dropMember(loginUser);
	}

	public boolean exists(String id) {
		return (memberDAO.getMember(id) == null);
	}

	public String getName() {
		return loginUser.getName();
	}
	
	public String getId() {
		return loginUser.getId();
	}

	public int getNo() {
		return loginUser.getNo();
	}

	public int getCash() {
		return loginUser.getCash();
	}

	public String login(String id, String pass) {
		MemberVO member = memberDAO.getMember(id);
		if (member.getPassword().equals(pass)) {
			loginUser = member;
			return member.getName() + "님 환영합니다.";
		} else {
			return "일치하는 회원이 없습니다.";
		}
	}

	public void logOut() {
		loginUser = null;
	}

	public void signIn(String id, String pass, String name, String bDay, int gender, String mobile, String email) {
		MemberVO m = new MemberVO(id, pass, name, bDay, gender, mobile, email);
		memberDAO.setMember(m);
	}
}
