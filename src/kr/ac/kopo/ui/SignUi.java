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
			System.out.println("ȸ�������� �����մϴ�.");
			String user_id;
			while (true) {
				user_id = scanStr("���̵� �Է����ּ���");
				if (!ms.exists(user_id)) {
					System.out.println("�̹� �����ϴ� ȸ���Դϴ�.");
					scanStr("");
				} else {
					break;
				}
			}
			String password;
			while (true) {
				password = scanStr("��й�ȣ�� �Է����ּ���");
				String passcheck = scanStr("��й�ȣ�� �ٽ� �ѹ� �Է����ּ���");
				if (password.equals(passcheck))
					break;
				else {
					System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
					scanStr("");
				}
			}
			String name = scanStr("�̸��� �Է����ּ���");
			String bDay = scanStr("��������� �Է����ּ���(�� : 2002-01-05)");
			int gender = scanInt("������ �Է����ּ���(1.�� 2.��)") - 1;
			String mobile = scanStr("��ȭ��ȣ�� �Է����ּ���(�� : 010-1154-7845)");
			String telecom = scanStr("��Ż縦 �Է����ּ��� ");
			String randomNumber = ms.randomNumber();
			System.out.println(telecom + "-" + mobile + "�� ������ȣ�� �߼��Ͽ����ϴ�.");
			System.out.println("������ȣ�� [" + randomNumber + "] �Դϴ�.");
			String comp = scanStr("������ȣ�� �Է����ּ���");
			if (!comp.equals(randomNumber)) {
				System.out.println("������ȣ�� ��ġ���� �ʽ��ϴ�");
				scanStr("");
				return;
			}
			String email = scanStr("�̸����� �Է����ּ���");
			ms.signIn(user_id, password, name, bDay, gender, mobile, email);
		} else {
			System.out.println("���� �α��� �����Դϴ�");
			System.out.println("�α׾ƿ� �� �õ����ּ���.");
			scanStr("");
		}
	}

}
