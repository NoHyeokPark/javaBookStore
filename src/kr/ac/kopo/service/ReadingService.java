package kr.ac.kopo.service;

import kr.ac.kopo.dao.FullBookDAO;

public class ReadingService {
	private FullBookDAO fbdao;
	
	public ReadingService() {
		fbdao = new FullBookDAO();
	}
	public void getText(String book_cd) {
		fbdao.select(book_cd);
	}
}
