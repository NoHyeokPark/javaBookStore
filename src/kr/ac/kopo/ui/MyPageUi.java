package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.exception.ChoiceOutOfBoundException;
import kr.ac.kopo.service.CashService;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.service.OrderService;
import kr.ac.kopo.service.ServiceFactory;
import kr.ac.kopo.vo.OrderVO;

public class MyPageUi extends BaseUi {
	private MemberService ms;
	private OrderService os;
	private CashService cs;

	public MyPageUi() {
		ms = ServiceFactory.getMemberInstance();
		os = ServiceFactory.getOrderInstance();
		cs = ServiceFactory.getCashInstance();
	}

	private void orderView(List<OrderVO> lst) {
		System.out.println("==========================================");
		System.out.println("\t�ֹ�/��� ��ȸ");
		System.out.println("==========================================");
		if (lst.isEmpty()) {
			System.out.println("\t��ǰ�� �������� �ʽ��ϴ�");
		} else {
			System.out.println("�����ȣ\tå �̸�\t�ֹ���\t�����\t����\t����");
			System.out.println("==========================================");
			for (OrderVO od : lst) {
				System.out.println(od.getInvoice_no() + "\t" + od.getBook_nm() + "\t" + od.getOrder_nm() + "\t"
						+ od.getOutboundDate() + "\t" + od.getStatus() + "\t" + od.getOrderQTY());
			}
		}
		System.out.println("==========================================");
	}

	@Override
	public void run() throws Exception {
		if (ms.logcheck()) {
			System.out.println("�α����� �ʿ��մϴ� ���� �������� ���ư��ϴ�");
			return;
		}

		while (true) {
			try {
				System.out.println("�����������Դϴ�.");
				System.out.println("1. ȸ�� ���� ����");
				System.out.println("2. ȸ�� Ż��");
				System.out.println("3. �ֹ�/��� ��ȸ");
				System.out.println("4. �ܾ� ����");
				System.out.println("5. ����� ���");
				System.out.println("0. ���ư���");
				String choice = scanStr("���ϴ� �ɼ��� �����ϼ��� : ");
				switch (choice) {
				case "1":
					if (!ms.passCorrect(scanStr("��й�ȣ�� Ȯ���մϴ�."))) {
						System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�");
						continue;
					}
					IBookUi mui = new MemberUpdateUi();
					mui.run();
					break;
				case "2":
					if (!ms.passCorrect(scanStr("��й�ȣ�� Ȯ���մϴ�."))) {
						System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�");
						continue;
					}
					String ans = scanStr("������ Ż���Ͻ÷��� \"����Ż��\"�� �Է����ּ���");
					if (!ans.equals("����Ż��"))
						continue;
					if (ms.delete()) {
						System.out.println("Ż�� �Ǿ����ϴ�.");
						ms.logOut();
						return;
					}else
						System.out.println("Ż�� �� ������ �߻��߽��ϴ�.");
					break;
				case "3":
					orderView(os.search(ms.getNo()));
					break;
				case "4":
					int cash = scanInt("�󸶳� �����Ͻðڽ��ϱ�?");
					if (cash >= 0) {
						cs.charge(cash);
						ms.upDateUserInfo();
					} else {
						System.out.println("�������� �ݾ��Դϴ�.");
					}
					break;
				case "5":
					IBookUi ui = new AddressUi();
					ui.run();
					break;
				case "0":
					return;
				default:
					throw new ChoiceOutOfBoundException("\n\t�޴���ȣ�� �߸����õǾ����ϴ�");
				}
			} catch (ChoiceOutOfBoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
