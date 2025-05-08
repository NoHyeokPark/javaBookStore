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
		System.out.println("\t�ּҸ��");
		System.out.println("==========================================");
		System.out.println("�ּҸ�\t�ּ�");
		System.out.println("==========================================");
		if(lst.isEmpty()) {
			System.out.println("\t�ּҰ� �������� �ʽ��ϴ�");
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
			System.out.println("1. ����� ���");
			System.out.println("2. ����� ����");
			System.out.println("3. ����� ����");
			System.out.println("0. ���ư���");
			try {
				String choice = scanStr("���ϴ� �ɼ��� �����ϼ��� : ");
				switch (choice) {
				case "1":
					String name = scanStr("����� �̸��� �Է��ϼ��� : ");
					String add = scanStr("����� �ּҸ� �Է��ϼ��� : ");
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
					throw new ChoiceOutOfBoundException("\n\t�޴���ȣ�� �߸����õǾ����ϴ�");
				}
			} catch (ChoiceOutOfBoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
