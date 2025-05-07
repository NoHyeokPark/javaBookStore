package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.BookDAO;
import kr.ac.kopo.vo.BookVO;

public class SearchService {
	private BookDAO bookDAO;
	private BookVO book;

	public SearchService() {
		bookDAO = new BookDAO();
	}

	public List<BookVO> search(String key, String list) {
			return bookDAO.select(key, list);
	
	}

	public void setBook(BookVO vo) {
		book = vo;
	}

	public BookVO getBook() {
		return book;
	}

}
