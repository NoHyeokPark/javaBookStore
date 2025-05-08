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
			System.out.println("로그인 해주세요.");
			return;
		}
		System.out.println("고객센터입니다 1. 문의하기 2. 문의 확인 0. 돌아가기");
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
			System.out.println("잘못된 입력입니다.");
		}

	}

	private void add() {
		String title = scanStr("제목을 입력하세요 : ");
		String content = scanStr("내용을 입력하세요 : ");
		CSBoardVO board = new CSBoardVO();
		board.setTitle(title);
		board.setQuestion(content);
		cs.addCS(board);
		System.out.println("\n문의글 등록이 완료되었습니다");
		scanStr("");
	}

	private void selectAll() {
		List<CSBoardVO> list = cs.searchBoardAll();
		System.out.println("==========================================");
		System.out.println("\t문의 내역");
		System.out.println("==========================================");
		System.out.println("번호\t등록일\t글쓴이\t제목");
		System.out.println("==========================================");
		if (list.isEmpty()) {
			System.out.println("\t글이 존재하지 않습니다");
		} else {
			int i = 1;
			for (CSBoardVO board : list) {
				System.out.print(
						i++ + "\t" + board.getRegDateCall() + "\t" + board.getWriter() + "\t" + board.getTitle());
				if (board.getAnswer() != null) {
					System.out.println(" [답변 등록됨]");
				} else {
					System.out.println();
				}
			}
		}
		System.out.println("==========================================");
		switch (scanStr("내용을 확인하시려면 #을 입력하세요 0.돌아가기")) {
		case "#":
			int idx = scanInt("확인하고싶은 글 번호를 입력하세요") - 1;
			detailView(list.get(idx));
			break;
		case "0":
			return;
		}

	}

	private void detailView(CSBoardVO board) {
		System.out.println("==========================================");
		System.out.println("\t상세 내역");
		System.out.println("==========================================");
		System.out.println(board.getRegDateCall() + "\t " + board.getTitle());
		System.out.println("------------------------------------------");
		System.out.println(board.getQuestion());
		if (board.getAnswer() != null) {
			System.out.println("==================답변=====================");
			System.out.println(board.getRegDateAns() + "\t " + board.getCsId());
			System.out.println("------------------------------------------");
			System.out.println(board.getAnswer());
			System.out.println("==========================================");
		} else {
			System.out.println("==========================================");
			System.out.println("고객님의 문의를 처리중입니다. 조금만 더 기다려주세요.");
		}
		scanStr("");
	}

}
