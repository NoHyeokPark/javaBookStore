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
		System.out.println("책 정보 표시");
		System.out.println("==========================================");
		System.out.printf("\t\t%s\n", book.getBook_nm());
		System.out.println("==========================================");
		double avgGrade = brs.avgGrade(book.getBook_cd());
		System.out.printf("장르 :%s\n작가 :%s\n언어 :%s\n출간일 :%s\n가격 :%d\n 평점 :%.1f\n", book.getType(), book.getWriter(),
				book.getNation(), book.getPublicationDate(), book.getPrice(), avgGrade);
		System.out.println("==========================================");
		System.out.println("\t리뷰");
		System.out.println("==========================================");
		System.out.println("작성자\t내용\t평점\t등록일");
		System.out.println("==========================================");
		for (ReviewVO board : list) {
			System.out.println(board.getUser_id() + "\t" + board.getReview_content() + "\t" + board.getGrade() + "\t"
					+ board.getReg_Date());
		}
		System.out.println("1. 장바구니 담기 // 2.리뷰쓰기 // 0. 돌아가기");
		String key = scanStr("\t원하는 행동을 입력하세요 : ");
		switch (key) {
		case "1":
			if (ServiceFactory.getMemberInstance().logcheck()) {
				System.out.println("로그인 해주세요.");
				scanStr("");
				break;
			}
			int qty = scanInt("몇개 담으시겠습니까?");
			if (qty != 0) {
				bcs.addBucket(book.getBook_nm(), book.getPrice(), qty, book.getBook_cd());
			}
			System.out.println("추가되었습니다");
			break;
		/*case "2":
			ReadingUi ui = new ReadingUi();
			ui.setBook(book.getBook_cd());
			ui.run();
			break;*/
		case "2":
			if (ServiceFactory.getMemberInstance().logcheck()) {
				System.out.println("로그인 해주세요.");
				scanStr("");
				break;
			}
			String content = scanStr("내용을 입력하세요 : ");
			int grade = scanInt("평점을 입력하세요 (1~5) : ");
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
