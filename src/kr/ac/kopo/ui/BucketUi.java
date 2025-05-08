package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.service.BucketService;
import kr.ac.kopo.service.ServiceFactory;
import kr.ac.kopo.vo.BucketVO;

public class BucketUi extends BaseUi {
	private BucketService bcs;
	private List<BucketVO> lst;

	public BucketUi() {
		bcs = ServiceFactory.getBucketInstance();
	}

	@Override
	public void run() throws Exception {
		while (true) {
			clear();
			int sum = 0;
			lst = bcs.view();
			System.out.println("==========================================");
			System.out.println("\t장바구니");
			System.out.println("==========================================");
			System.out.println("책 이름\t수량\t가격");
			System.out.println("==========================================");
			if (lst.isEmpty()) {
				System.out.println("\t물품이 존재하지 않습니다");
				System.out.println("==========================================");
				return;
			}
			for (BucketVO bc : lst) {
				System.out.printf("%s\t%d권\t%d원\n", bc.getBook_nm(), bc.getQty(), bc.getPrice() * bc.getQty());
				sum += bc.getPrice() * bc.getQty();
			}
			System.out.printf("%s\t  \t%d원\n", "합계", sum);
			System.out.println("==========================================");
			String choice = scanStr("1. 구매 2. 수량 변경 3.비우기 0.돌아가기");
			switch (choice) {
			case "1":
				if (scanStr("총합 " + sum + "원 구매하시겠습니까?(Y/N)").toUpperCase().equals("Y")) {
					if (ServiceFactory.getCashInstance().charge(-sum)) {
						if (ServiceFactory.getOrderInstance().insert(lst)) {
							bcs.deleteAll();
							System.out.println("구매가 완료 되었습니다.");
							scanStr("");
						}
					}
				}
				break;
			case "2":
				int idx = scanInt("몇번째 줄을 수정하시겠습니까?");
				int qty = scanInt("몇권 수정하시겠습니까? (+-number)");
				if (lst.get(idx - 1).getQty() + qty > 0) {
					if (bcs.updateOne(lst.get(idx - 1).getBook_cd(), qty))
						System.out.println("성공적으로 수정되었습니다.");
				} else {
					if (bcs.deleteOne(lst.get(idx - 1).getBook_cd()))
						System.out.println("성공적으로 삭제되었습니다.");
				}
				break;
			case "3":
				if (bcs.deleteAll())
					System.out.println("성공적으로 삭제되었습니다.");
				break;
			case "0":
				return;
			default:
				System.out.println("잘못된 입력입니다.");
			}

		}
	}
}
