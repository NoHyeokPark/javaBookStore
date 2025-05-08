package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.service.BucketService;
import kr.ac.kopo.service.ServiceFactory;
import kr.ac.kopo.vo.BucketVO;

public class BucketUi extends BaseUi {
	private BucketService bcs;
	private List<BucketVO> lst;

	public BucketUi() {
		bcs = ServiceFactory.getBucketInstance();
	}

	@Override
	public void run() throws Exception {
		while (true) {
			clear();
			int sum = 0;
			lst = bcs.view();
			System.out.println("==========================================");
			System.out.println("\t��ٱ���");
			System.out.println("==========================================");
			System.out.println("å �̸�\t����\t����");
			System.out.println("==========================================");
			if (lst.isEmpty()) {
				System.out.println("\t��ǰ�� �������� �ʽ��ϴ�");
				System.out.println("==========================================");
				return;
			}
			for (BucketVO bc : lst) {
				System.out.printf("%s\t%d��\t%d��\n", bc.getBook_nm(), bc.getQty(), bc.getPrice() * bc.getQty());
				sum += bc.getPrice() * bc.getQty();
			}
			System.out.printf("%s\t  \t%d��\n", "�հ�", sum);
			System.out.println("==========================================");
			String choice = scanStr("1. ���� 2. ���� ���� 3.���� 0.���ư���");
			switch (choice) {
			case "1":
				if (scanStr("���� " + sum + "�� �����Ͻðڽ��ϱ�?(Y/N)").toUpperCase().equals("Y")) {
					if (ServiceFactory.getCashInstance().charge(-sum)) {
						if (ServiceFactory.getOrderInstance().insert(lst)) {
							bcs.deleteAll();
							System.out.println("���Ű� �Ϸ� �Ǿ����ϴ�.");
							scanStr("");
						}
					}
				}
				break;
			case "2":
				int idx = scanInt("���° ���� �����Ͻðڽ��ϱ�?");
				int qty = scanInt("��� �����Ͻðڽ��ϱ�? (+-number)");
				if (lst.get(idx - 1).getQty() + qty > 0) {
					if (bcs.updateOne(lst.get(idx - 1).getBook_cd(), qty))
						System.out.println("���������� �����Ǿ����ϴ�.");
				} else {
					if (bcs.deleteOne(lst.get(idx - 1).getBook_cd()))
						System.out.println("���������� �����Ǿ����ϴ�.");
				}
				break;
			case "3":
				if (bcs.deleteAll())
					System.out.println("���������� �����Ǿ����ϴ�.");
				break;
			case "0":
				return;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
			}

		}
	}
}
