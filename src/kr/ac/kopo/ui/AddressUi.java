package kr.ac.kopo.ui;


import java.util.List;

import kr.ac.kopo.exception.ChoiceOutOfBoundException;
import kr.ac.kopo.service.AddressService;
import kr.ac.kopo.service.ServiceFactory;
import kr.ac.kopo.vo.AddressVO;

public class AddressUi extends BaseUi {
	private AddressService adsv;
	public AddressUi() {
		adsv = ServiceFactory.getAddressInstance();
	}
	private void addressView(List<AddressVO> lst) {
		System.out.println("==========================================");
		System.out.println("\t주소목록");
		System.out.println("==========================================");
		System.out.println("주소명\t주소");
		System.out.println("==========================================");
		if(lst.isEmpty()) {
			System.out.println("\t주소가 존재하지 않습니다");
		} else {
			for(AddressVO avo : lst) {
				System.out.println(avo.getAdName() + "\t" + avo.getAddress());
			}
		}
		System.out.println("==========================================");	
		scanStr("");
	}

	@Override
	public void run() throws Exception {
		while (true) {
			clear();
			System.out.println("1. 배송지 등록");
			System.out.println("2. 배송지 보기");
			System.out.println("3. 배송지 삭제");
			System.out.println("0. 돌아가기");
			try {
				String choice = scanStr("원하는 옵션을 선택하세요 : ");
				switch (choice) {
				case "1":
					String name = scanStr("배송지 이름을 입력하세요 : ");
					String add = scanStr("배송지 주소를 입력하세요 : ");
					adsv.insert(name, add);
					break;
				case "2":
					addressView(adsv.view());
					break;
				case "3":
					break;
				case "0":
					return;
				default:
					throw new ChoiceOutOfBoundException("\n\t메뉴번호가 잘못선택되었습니다");
				}
			} catch (ChoiceOutOfBoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
