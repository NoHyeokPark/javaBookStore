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
			System.out.println("원하는 책을 검색하실 수 있습니다.");
			if (typeList != null)
				System.out.printf("현재 적용중인 필터 : %s\n", typeList);
			System.out.println("----------------------------");
			System.out.println("1. 일반 검색");
			System.out.println("2. 장르한정 검색");
			System.out.println("0. 돌아가기");
			String type = scanStr("\t항목을 선택하세요 : ");
			switch (type) {
			case "1":
				String key = scanStr("\t키워드를 입력하세요 : ");
				bookView(ss.search(key, typeList));
				break;
			case "2":
				System.out.println("예시) 1. 에세이 2. 자기계발 3. 정치 4. 만화. 5.한국소설 6. 영미소설 7.어린이 8.일반 9.잡지 10.심리학 11.경제");
				typeList = scanStr("검색을 원하는 장르를 입력하세요 (0.필터제거): ");
				if (typeList.equals("0")) {
					typeList = null;
					System.out.println("필터가 제거되었습니다.");
					scanStr("");
				} else {
					System.out.println(typeList +"로 설정되었습니다.");
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
			System.out.println("검색결과가 존재하지 않습니다.");
			scanStr("");
		} else {
			while (true) {
				System.out.println("번호\t\t제목\t\t장르\t\t작가\t국가\t\t발간일\t가격");
				System.out
						.println("-----------------------------------------------------------------------------------");
				for (int i = 0; i < 10 && i + n < lst.size(); i++) {
					System.out.printf("%d%20s\t%5s\t%10s\t%5s\t%15s\t%7d\n", i + 1, lst.get(i + n).getBook_nm(),
							lst.get(i + n).getType(), lst.get(i + n).getWriter(), lst.get(i + n).getNation(),
							lst.get(i + n).getPublicationDate(), lst.get(i + n).getPrice());
					System.out.println(
							"-----------------------------------------------------------------------------------");
				}
				String choice = scanStr("책을 선택하시려면 #(책번호)를 입력하세요. 1. <<이전페이지 0. 메인페이지로 3. 다음페이지>>");
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
					System.out.println("잘못된 입력입니다.");
				}
			}
		}

	}

}
