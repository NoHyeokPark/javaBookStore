package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.service.SearchService;
import kr.ac.kopo.service.ServiceFactory;
import kr.ac.kopo.vo.BookVO;

public class SearchUi extends BaseUi {
	private SearchService ss;

	public SearchUi() {
		ss = ServiceFactory.getSearchInstance();
	}

	@Override
	public void run() throws Exception {
		String typeList = null;
		while (true) {
			System.out.println("----------------------------");
			System.out.println("���ϴ� å�� �˻��Ͻ� �� �ֽ��ϴ�.");
			if (typeList != null)
				System.out.printf("���� �������� ���� : %s\n", typeList);
			System.out.println("----------------------------");
			System.out.println("1. �Ϲ� �˻�");
			System.out.println("2. �帣���� �˻�");
			System.out.println("0. ���ư���");
			String type = scanStr("\t�׸��� �����ϼ��� : ");
			switch (type) {
			case "1":
				String key = scanStr("\tŰ���带 �Է��ϼ��� : ");
				bookView(ss.search(key, typeList));
				break;
			case "2":
				System.out.println("����) 1. ������ 2. �ڱ��� 3. ��ġ 4. ��ȭ. 5.�ѱ��Ҽ� 6. ���̼Ҽ� 7.��� 8.�Ϲ� 9.���� 10.�ɸ��� 11.����");
				typeList = scanStr("�˻��� ���ϴ� �帣�� �Է��ϼ��� (0.��������): ");
				if (typeList.equals("0")) {
					typeList = null;
					System.out.println("���Ͱ� ���ŵǾ����ϴ�.");
					scanStr("");
				} else {
					System.out.println(typeList +"�� �����Ǿ����ϴ�.");
					scanStr("");
				}
				break;
			case "0":
				return;
			}
		}
	}

	private void bookView(List<BookVO> lst) throws Exception {
		int n = 0;
		if (lst == null) {
			System.out.println("�˻������ �������� �ʽ��ϴ�.");
			scanStr("");
		} else {
			while (true) {
				System.out.println("��ȣ\t\t����\t\t�帣\t\t�۰�\t����\t\t�߰���\t����");
				System.out
						.println("-----------------------------------------------------------------------------------");
				for (int i = 0; i < 10 && i + n < lst.size(); i++) {
					System.out.printf("%d%20s\t%5s\t%10s\t%5s\t%15s\t%7d\n", i + 1, lst.get(i + n).getBook_nm(),
							lst.get(i + n).getType(), lst.get(i + n).getWriter(), lst.get(i + n).getNation(),
							lst.get(i + n).getPublicationDate(), lst.get(i + n).getPrice());
					System.out.println(
							"-----------------------------------------------------------------------------------");
				}
				String choice = scanStr("å�� �����Ͻ÷��� #(å��ȣ)�� �Է��ϼ���. 1. <<���������� 0. ������������ 3. ����������>>");
				switch (choice) {
				case "#1":
				case "#2":
				case "#3":
				case "#4":
				case "#5":
				case "#6":
				case "#7":
				case "#8":
				case "#9":
				case "#10":
					IBookUi ui = new BookViewUi();
					ss.setBook(lst.get(Integer.parseInt(choice.substring(1)) - 1));
					ui.run();
					break;
				case "1":
					if (n > 9)
						n -= 10;
					else
						n = 0;
					break;
				case "3":
					if (n < lst.size() - 10)
						n += 10;
					break;
				case "0":
					return;
				default:
					System.out.println("�߸��� �Է��Դϴ�.");
				}
			}
		}

	}

}
