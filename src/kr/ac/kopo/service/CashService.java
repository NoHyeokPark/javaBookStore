package kr.ac.kopo.service;

import kr.ac.kopo.dao.MemberDAO;

public class CashService {
	private MemberDAO memberdao;

	public CashService() {
		memberdao = new MemberDAO();
	}

	public boolean charge(int pay) {
		System.out.println("결제중 ...");
		if (ServiceFactory.getMemberInstance().getCash() + pay >= 0) {
			memberdao.upDateCash(pay, ServiceFactory.getMemberInstance().getNo());
			System.out.println("결제가 완료되었습니다.");
			return true;
		} else {
			System.out.println("잔액이 부족합니다.");
			return false;
		}
	}

}
