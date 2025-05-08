package kr.ac.kopo.ui;

import kr.ac.kopo.exception.ChoiceOutOfBoundException;
import kr.ac.kopo.service.ServiceFactory;

public class MainPageUi extends BaseUi {

	public MainPageUi() {
	}

	private String menu() {
		clear();
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("\r\n"
				+ "ooooooooo.             oooo                   oooooooooo.                      oooo                 \r\n"
				+ "`888   `Y88.           `888                   `888'   `Y8b                     `888                 \r\n"
				+ " 888   .d88'  .ooooo.   888  oooo    ooo       888     888  .ooooo.   .ooooo.   888  oooo   .oooo.o \r\n"
				+ " 888ooo88P'  d88' `88b  888   `88.  .8'        888oooo888' d88' `88b d88' `88b  888 .8P'   d88(  \"8 \r\n"
				+ " 888         888   888  888    `88..8'         888    `88b 888   888 888   888  888888.    `\"Y88b.  \r\n"
				+ " 888         888   888  888     `888'          888    .88P 888   888 888   888  888 `88b.  o.  )88b \r\n"
				+ "o888o        `Y8bod8P' o888o     .8'          o888bood8P'  `Y8bod8P' `Y8bod8P' o888o o888o 8\"\"888P' \r\n"
				+ "                             .o..P'                                                                 \r\n"
				+ "                             `Y8P'                                                                  \r\n"
				+ "                                                                                                    \r\n"
				+ "                                                                                ");
		System.out.println("------------------------------------------------------------------------------------------------");
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
