package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.service.BookReviewService;
import kr.ac.kopo.service.BucketService;
import kr.ac.kopo.service.SearchService;
import kr.ac.kopo.service.ServiceFactory;
import kr.ac.kopo.vo.BookVO;
import kr.ac.kopo.vo.ReviewVO;

public class BookViewUi extends BaseUi {
	private SearchService ss;
	private BucketService bcs;
	private BookReviewService brs;

	public BookViewUi() {
		ss = ServiceFactory.getSearchInstance();
		bcs = ServiceFactory.getBucketInstance();
		brs = ServiceFactory.getReviewInstance();
	}

	@Override
	public void run() throws Exception {
		clear();
		BookVO book = ss.getBook();
		List<ReviewVO> list = brs.searchBoardTop5(book.getBook_cd());
		System.out.println("å ���� ǥ��");
		System.out.println("==========================================");
		System.out.printf("\t\t%s\n", book.getBook_nm());
		System.out.println("==========================================");
		double avgGrade = brs.avgGrade(book.getBook_cd());
		System.out.printf("�帣 :%s\n�۰� :%s\n��� :%s\n�Ⱓ�� :%s\n���� :%d\n ���� :%.1f\n", book.getType(), book.getWriter(),
				book.getNation(), book.getPublicationDate(), book.getPrice(), avgGrade);
		System.out.println("==========================================");
		System.out.println("\t����");
		System.out.println("==========================================");
		System.out.println("�ۼ���\t����\t����\t�����");
		System.out.println("==========================================");
		for (ReviewVO board : list) {
			System.out.println(board.getUser_id() + "\t" + board.getReview_content() + "\t" + board.getGrade() + "\t"
					+ board.getReg_Date());
		}
		System.out.println("1. ��ٱ��� ��� // 2.���侲�� // 0. ���ư���");
		String key = scanStr("\t���ϴ� �ൿ�� �Է��ϼ��� : ");
		switch (key) {
		case "1":
			if (ServiceFactory.getMemberInstance().logcheck()) {
				System.out.println("�α��� ���ּ���.");
				scanStr("");
				break;
			}
			int qty = scanInt("� �����ðڽ��ϱ�?");
			if (qty != 0) {
				bcs.addBucket(book.getBook_nm(), book.getPrice(), qty, book.getBook_cd());
			}
			System.out.println("�߰��Ǿ����ϴ�");
			break;
		/*case "2":
			ReadingUi ui = new ReadingUi();
			ui.setBook(book.getBook_cd());
			ui.run();
			break;*/
		case "2":
			if (ServiceFactory.getMemberInstance().logcheck()) {
				System.out.println("�α��� ���ּ���.");
				scanStr("");
				break;
			}
			String content = scanStr("������ �Է��ϼ��� : ");
			int grade = scanInt("������ �Է��ϼ��� (1~5) : ");
			ReviewVO review = new ReviewVO();
			review.setReview_content(content);
			review.setGrade(grade);
			review.setBook_cd(book.getBook_cd());
			brs.add(review);
			break;
		case "0":
			return;
		}
	}
}
