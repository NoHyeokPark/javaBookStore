package kr.ac.kopo.service;

import kr.ac.kopo.dao.MemberDAO;

public class CashService {
	private MemberDAO memberdao;

	public CashService() {
		memberdao = new MemberDAO();
	}

	public boolean charge(int pay) {
		System.out.println("������ ...");
		if (ServiceFactory.getMemberInstance().getCash() + pay >= 0) {
			memberdao.upDateCash(pay, ServiceFactory.getMemberInstance().getNo());
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
			return true;
		} else {
			System.out.println("�ܾ��� �����մϴ�.");
			return false;
		}
	}

}
