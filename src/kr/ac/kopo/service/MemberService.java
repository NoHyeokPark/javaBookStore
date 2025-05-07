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
				return "��й�ȣ�� [" + newPass + "]�� ��߱޵Ǿ����ϴ�";
			}
		}
		return "��ġ�ϴ� ȸ���� �����ϴ�";
	}

	public String findID(String name, String mobile) {
		String id = memberDAO.selectID(name, mobile);
		if (id != null)
			return "ȸ������ ���̵�� "+id.subSequence(0, id.length()-3)+"*** �Դϴ�.";
		else
			return "��ġ�ϴ� ȸ���� �����ϴ�";
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
			return member.getName() + "�� ȯ���մϴ�.";
		} else {
			return "��ġ�ϴ� ȸ���� �����ϴ�.";
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
