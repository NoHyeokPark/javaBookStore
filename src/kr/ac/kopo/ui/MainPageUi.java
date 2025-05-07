package kr.ac.kopo.ui;

import kr.ac.kopo.exception.ChoiceOutOfBoundException;
import kr.ac.kopo.service.ServiceFactory;

public class MainPageUi extends BaseUi {

	public MainPageUi() {
	}

	private String menu() {
		System.out.println("----------------------------");
		System.out.println("PolyBooks�� ���� ���� ȯ���մϴ�.");
		System.out.println("----------------------------");
		if (ServiceFactory.getMemberInstance().logcheck()) {
			System.out.println("\t1. �α���");
		} else {
			System.out.println("\t1. �α׾ƿ�");
		}
		System.out.println("\t2. ȸ������");
		System.out.println("\t3. å �˻�");
		System.out.println("\t4. ��ٱ���");
		System.out.println("\t5. ������");
		System.out.println("\t6. ����������");
		System.out.println("\t0. ����");
		String type = scanStr("\t�׸��� �����ϼ��� : ");
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
					throw new ChoiceOutOfBoundException("\n\t�޴���ȣ�� �߸����õǾ����ϴ�");
				}
			} catch (ChoiceOutOfBoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
