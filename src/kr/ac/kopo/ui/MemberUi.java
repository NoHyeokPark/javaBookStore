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
			String choice = scanStr("1. �α��� 2. ���̵� ã�� 3. ��й�ȣ ��߱� 0. ���ư���");
			switch(choice) {
			case "1":
				String id = scanStr("���̵� �Է� : ");
				String pass = scanStr("��й�ȣ �Է� : ");
				System.out.println((ms.login(id, pass)));
				scanStr("");
				break;
			case "2":
				String name = scanStr("�̸��� �Է��ϼ��� : ");
				String mobile = scanStr("��ȭ��ȣ�� �Է��ϼ��� : ");
				System.out.println(ms.findID(name, mobile));
				scanStr("");
				break;
			case "3":
				String findpassid = scanStr("���̵� �Է��ϼ��� : ");
				String pohn = scanStr("��ȭ��ȣ�� �Է��ϼ��� : ");
				System.out.println(ms.findPass(findpassid, pohn));
				scanStr("");
				break;
			case "0":
				return;	
			}							
		} else {
			ms.logOut();
			System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
			scanStr("");
		}
	}

}
