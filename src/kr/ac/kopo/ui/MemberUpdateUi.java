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
			String choice = scanStr("1. ��й�ȣ ���� 2. ��ȭ��ȣ ���� 3. �̸��� ���� 0. ���ư���");
			switch (choice) {
			case "1":
				String pass = scanStr("��й�ȣ Ȯ�� : ");
				if (!ms.passCorrect(pass)) {
					System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�");
					break;
				}
				while (true) {
					String newPassWord = scanStr("������ ��й�ȣ�� �Է����ּ���");
					String passCheck = scanStr("��й�ȣ�� �ٽ� �ѹ� �Է����ּ���");
					if (newPassWord.equals(passCheck)) {
						ms.upDateColStr(newPassWord, "pass");
						ms.upDateUserInfo();
						break;
					} else
						System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				}
				break;
			case "2":
				String newPon = scanStr("���ο� ��ȭ��ȣ�� �Է��ϼ��� : ");
				ms.upDateColStr(newPon, "pon");
				ms.upDateUserInfo();
				break;
			case "3":
				String newEmail = scanStr("���ο� �̸����� �Է��ϼ��� : ");
				ms.upDateColStr(newEmail, "email");
				ms.upDateUserInfo();
				break;
			case "0":
				return;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}
}
