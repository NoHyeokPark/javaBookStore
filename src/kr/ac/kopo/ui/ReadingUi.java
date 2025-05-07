package kr.ac.kopo.ui;

import kr.ac.kopo.service.ReadingService;
import kr.ac.kopo.service.ServiceFactory;

public class ReadingUi extends BaseUi {
	private ReadingService rs;
	private String book_cd;
	
	public ReadingUi() {
		rs = ServiceFactory.getReadingInstance();
	}
	
	public void setBook(String book_cd) {
		this.book_cd = book_cd;
	}

	@Override
	public void run() throws Exception {
		rs.getText(book_cd);
	}
}
