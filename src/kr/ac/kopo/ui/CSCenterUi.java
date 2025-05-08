package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.service.CSService;
import kr.ac.kopo.service.ServiceFactory;
import kr.ac.kopo.vo.CSBoardVO;

public class CSCenterUi extends BaseUi {
	private CSService cs;

	public CSCenterUi() {
		cs = ServiceFactory.getCSInstance();
	}

	@Override
	public void run() throws Exception {
		clear();
		if (ServiceFactory.getMemberInstance().logcheck()) {
			System.out.println("�α��� ���ּ���.");
			return;
		}
		System.out.println("�������Դϴ� 1. �����ϱ� 2. ���� Ȯ�� 0. ���ư���");
		switch (scanStr("------------------------------------------")) {
		case "1":
			add();
			break;
		case "2":
			selectAll();
			break;
		case "0":
			return;
		default:
			System.out.println("�߸��� �Է��Դϴ�.");
		}

	}

	private void add() {
		String title = scanStr("������ �Է��ϼ��� : ");
		String content = scanStr("������ �Է��ϼ��� : ");
		CSBoardVO board = new CSBoardVO();
		board.setTitle(title);
		board.setQuestion(content);
		cs.addCS(board);
		System.out.println("\n���Ǳ� ����� �Ϸ�Ǿ����ϴ�");
		scanStr("");
	}

	private void selectAll() {
		List<CSBoardVO> list = cs.searchBoardAll();
		System.out.println("==========================================");
		System.out.println("\t���� ����");
		System.out.println("==========================================");
		System.out.println("��ȣ\t�����\t�۾���\t����");
		System.out.println("==========================================");
		if (list.isEmpty()) {
			System.out.println("\t���� �������� �ʽ��ϴ�");
		} else {
			int i = 1;
			for (CSBoardVO board : list) {
				System.out.print(
						i++ + "\t" + board.getRegDateCall() + "\t" + board.getWriter() + "\t" + board.getTitle());
				if (board.getAnswer() != null) {
					System.out.println(" [�亯 ��ϵ�]");
				} else {
					System.out.println();
				}
			}
		}
		System.out.println("==========================================");
		switch (scanStr("������ Ȯ���Ͻ÷��� #�� �Է��ϼ��� 0.���ư���")) {
		case "#":
			int idx = scanInt("Ȯ���ϰ���� �� ��ȣ�� �Է��ϼ���") - 1;
			detailView(list.get(idx));
			break;
		case "0":
			return;
		}

	}

	private void detailView(CSBoardVO board) {
		System.out.println("==========================================");
		System.out.println("\t�� ����");
		System.out.println("==========================================");
		System.out.println(board.getRegDateCall() + "\t " + board.getTitle());
		System.out.println("------------------------------------------");
		System.out.println(board.getQuestion());
		if (board.getAnswer() != null) {
			System.out.println("==================�亯=====================");
			System.out.println(board.getRegDateAns() + "\t " + board.getCsId());
			System.out.println("------------------------------------------");
			System.out.println(board.getAnswer());
			System.out.println("==========================================");
		} else {
			System.out.println("==========================================");
			System.out.println("������ ���Ǹ� ó�����Դϴ�. ���ݸ� �� ��ٷ��ּ���.");
		}
		scanStr("");
	}

}
