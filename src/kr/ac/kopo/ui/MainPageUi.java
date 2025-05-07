package kr.ac.kopo.ui;

import kr.ac.kopo.exception.ChoiceOutOfBoundException;
import kr.ac.kopo.service.ServiceFactory;

public class MainPageUi extends BaseUi {

	public MainPageUi() {
	}

	private String menu() {
		System.out.println("----------------------------");
		System.out.println("PolyBooks에 오신 것을 환영합니다.");
		System.out.println("----------------------------");
		if (ServiceFactory.getMemberInstance().logcheck()) {
			System.out.println("\t1. 로그인");
		} else {
			System.out.println("\t1. 로그아웃");
		}
		System.out.println("\t2. 회원가입");
		System.out.println("\t3. 책 검색");
		System.out.println("\t4. 장바구니");
		System.out.println("\t5. 고객센터");
		System.out.println("\t6. 마이페이지");
		System.out.println("\t0. 종료");
		String type = scanStr("\t항목을 선택하세요 : ");
		return type;
	}

	@Override
	public void run() throws Exception {
		while (true) {
			try {
				String choice = menu();
				IBookUi ui = null;
				switch (choice) {
				case "1":
					ui = new MemberUi();
					break;
				case "2":
					ui = new SignUi();
					break;
				case "3":
					ui = new SearchUi();
					break;
				case "4":
					ui = new BucketUi();
					break;
				case "5":
					ui = new CSCenterUi();
					break;
				case "6":
					ui = new MyPageUi();
					break;
				case "0":
					ui = new ExitUi();
					break;
				}
				if (ui != null)
					ui.run();
				else {
					throw new ChoiceOutOfBoundException("\n\t메뉴번호가 잘못선택되었습니다");
				}
			} catch (ChoiceOutOfBoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
