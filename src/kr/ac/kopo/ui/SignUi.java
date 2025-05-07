package kr.ac.kopo.ui;

import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.service.ServiceFactory;

public class SignUi extends BaseUi {
	private MemberService ms;

	public SignUi() {
		ms = ServiceFactory.getMemberInstance();

	}

	@Override
	public void run() throws Exception {
		if (ms.logcheck()) {
			System.out.println("회원가입을 시작합니다.");
			String user_id;
			while (true) {
				user_id = scanStr("아이디를 입력해주세요");
				if (!ms.exists(user_id)) {
					System.out.println("이미 존재하는 회원입니다.");
					scanStr("");
				} else {
					break;
				}
			}
			String password;
			while (true) {
				password = scanStr("비밀번호를 입력해주세요");
				String passcheck = scanStr("비밀번호를 다시 한번 입력해주세요");
				if (password.equals(passcheck))
					break;
				else {
					System.out.println("비밀번호가 일치하지 않습니다.");
					scanStr("");
				}
			}
			String name = scanStr("이름을 입력해주세요");
			String bDay = scanStr("생년월일을 입력해주세요(예 : 2002-01-05)");
			int gender = scanInt("성별을 입력해주세요(1.남 2.여)") - 1;
			String mobile = scanStr("전화번호를 입력해주세요(예 : 010-1154-7845)");
			String telecom = scanStr("통신사를 입력해주세요 ");
			String randomNumber = ms.randomNumber();
			System.out.println(telecom + "-" + mobile + "로 인증번호를 발송하였습니다.");
			System.out.println("인증번호는 [" + randomNumber + "] 입니다.");
			String comp = scanStr("인증번호를 입력해주세요");
			if (!comp.equals(randomNumber)) {
				System.out.println("인증번호가 일치하지 않습니다");
				scanStr("");
				return;
			}
			String email = scanStr("이메일을 입력해주세요");
			ms.signIn(user_id, password, name, bDay, gender, mobile, email);
		} else {
			System.out.println("현재 로그인 상태입니다");
			System.out.println("로그아웃 후 시도해주세요.");
			scanStr("");
		}
	}

}
