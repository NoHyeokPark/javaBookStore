package kr.ac.kopo.ui;

import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.service.ServiceFactory;

public class MemberUpdateUi extends BaseUi {
	private MemberService ms;

	public MemberUpdateUi() {
		ms = ServiceFactory.getMemberInstance();
	}

	@Override
	public void run() throws Exception {
		while (true) {
			clear();
			String choice = scanStr("1. 비밀번호 변경 2. 전화번호 수정 3. 이메일 수정 0. 돌아가기");
			switch (choice) {
			case "1":
				String pass = scanStr("비밀번호 확인 : ");
				if (!ms.passCorrect(pass)) {
					System.out.println("비밀번호가 일치하지 않습니다");
					break;
				}
				while (true) {
					String newPassWord = scanStr("변경할 비밀번호를 입력해주세요");
					String passCheck = scanStr("비밀번호를 다시 한번 입력해주세요");
					if (newPassWord.equals(passCheck)) {
						ms.upDateColStr(newPassWord, "pass");
						ms.upDateUserInfo();
						break;
					} else
						System.out.println("비밀번호가 일치하지 않습니다.");
				}
				break;
			case "2":
				String newPon = scanStr("새로운 전화번호를 입력하세요 : ");
				ms.upDateColStr(newPon, "pon");
				ms.upDateUserInfo();
				break;
			case "3":
				String newEmail = scanStr("새로운 이메일을 입력하세요 : ");
				ms.upDateColStr(newEmail, "email");
				ms.upDateUserInfo();
				break;
			case "0":
				return;
			default:
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
}
