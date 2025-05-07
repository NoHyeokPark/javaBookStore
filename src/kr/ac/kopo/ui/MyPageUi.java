package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.exception.ChoiceOutOfBoundException;
import kr.ac.kopo.service.CashService;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.service.OrderService;
import kr.ac.kopo.service.ServiceFactory;
import kr.ac.kopo.vo.OrderVO;

public class MyPageUi extends BaseUi {
	private MemberService ms;
	private OrderService os;
	private CashService cs;

	public MyPageUi() {
		ms = ServiceFactory.getMemberInstance();
		os = ServiceFactory.getOrderInstance();
		cs = ServiceFactory.getCashInstance();
	}

	private void orderView(List<OrderVO> lst) {
		System.out.println("==========================================");
		System.out.println("\t주문/배송 조회");
		System.out.println("==========================================");
		if (lst.isEmpty()) {
			System.out.println("\t물품이 존재하지 않습니다");
		} else {
			System.out.println("송장번호\t책 이름\t주문자\t출고일\t상태\t수량");
			System.out.println("==========================================");
			for (OrderVO od : lst) {
				System.out.println(od.getInvoice_no() + "\t" + od.getBook_nm() + "\t" + od.getOrder_nm() + "\t"
						+ od.getOutboundDate() + "\t" + od.getStatus() + "\t" + od.getOrderQTY());
			}
		}
		System.out.println("==========================================");
	}

	@Override
	public void run() throws Exception {
		if (ms.logcheck()) {
			System.out.println("로그인이 필요합니다 메인 페이지로 돌아갑니다");
			return;
		}

		while (true) {
			try {
				System.out.println("마이페이지입니다.");
				System.out.println("1. 회원 정보 수정");
				System.out.println("2. 회원 탈퇴");
				System.out.println("3. 주문/배송 조회");
				System.out.println("4. 잔액 충전");
				System.out.println("5. 배송지 등록");
				System.out.println("0. 돌아가기");
				String choice = scanStr("원하는 옵션을 선택하세요 : ");
				switch (choice) {
				case "1":
					if (!ms.passCorrect(scanStr("비밀번호를 확인합니다."))) {
						System.out.println("비밀번호가 일치하지 않습니다");
						continue;
					}
					IBookUi mui = new MemberUpdateUi();
					mui.run();
					break;
				case "2":
					if (!ms.passCorrect(scanStr("비밀번호를 확인합니다."))) {
						System.out.println("비밀번호가 일치하지 않습니다");
						continue;
					}
					String ans = scanStr("정말로 탈퇴하시려면 \"지금탈퇴\"를 입력해주세요");
					if (!ans.equals("지금탈퇴"))
						continue;
					if (ms.delete()) {
						System.out.println("탈퇴 되었습니다.");
						ms.logOut();
						return;
					}else
						System.out.println("탈퇴 중 오류가 발생했습니다.");
					break;
				case "3":
					orderView(os.search(ms.getNo()));
					break;
				case "4":
					int cash = scanInt("얼마나 충전하시겠습니까?");
					if (cash >= 0) {
						cs.charge(cash);
						ms.upDateUserInfo();
					} else {
						System.out.println("부적절한 금액입니다.");
					}
					break;
				case "5":
					IBookUi ui = new AddressUi();
					ui.run();
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
