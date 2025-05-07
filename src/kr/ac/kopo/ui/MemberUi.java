package kr.ac.kopo.ui;

import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.service.ServiceFactory;

public class MemberUi extends BaseUi {

	private MemberService ms;

	public MemberUi() {
		ms = ServiceFactory.getMemberInstance();
	}

	@Override
	public void run() {
		if (ms.logcheck()) {
			String choice = scanStr("1. 로그인 2. 아이디 찾기 3. 비밀번호 재발급 0. 돌아가기");
			switch(choice) {
			case "1":
				String id = scanStr("아이디 입력 : ");
				String pass = scanStr("비밀번호 입력 : ");
				System.out.println((ms.login(id, pass)));
				scanStr("");
				break;
			case "2":
				String name = scanStr("이름을 입력하세요 : ");
				String mobile = scanStr("전화번호를 입력하세요 : ");
				System.out.println(ms.findID(name, mobile));
				scanStr("");
				break;
			case "3":
				String findpassid = scanStr("아이디를 입력하세요 : ");
				String pohn = scanStr("전화번호를 입력하세요 : ");
				System.out.println(ms.findPass(findpassid, pohn));
				scanStr("");
				break;
			case "0":
				return;	
			}							
		} else {
			ms.logOut();
			System.out.println("로그아웃 되었습니다.");
			scanStr("");
		}
	}

}
