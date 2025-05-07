package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.ReviewDAO;
import kr.ac.kopo.vo.ReviewVO;

public class BookReviewService {
	private ReviewDAO rvdao;

	public BookReviewService() {
		rvdao = new ReviewDAO();
	}

	public void add(ReviewVO v) {
		v.setUser_id(ServiceFactory.getMemberInstance().getId());
		if (rvdao.exists(v.getBook_cd(), v.getUser_id())) {
			rvdao.update(v);
			System.out.println("\n���䰡 �����Ǿ����ϴ�");
		} else {
			rvdao.insert(v);
			System.out.println("\n���� ����� �Ϸ�Ǿ����ϴ�");
		}
	}

	public List<ReviewVO> searchBoardTop5(String book_cd) {
		return rvdao.selectBoardTop5(book_cd);
	}
	
	public double avgGrade(String book_cd) {
		return rvdao.avgGrade(book_cd);
	}
}
