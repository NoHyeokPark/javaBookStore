package kr.ac.kopo.main;

import kr.ac.kopo.ui.MainPageUi;

public class Main {
/*
 * ���丮 ������ ����� ����
 * ���񽺰� ����Ǿ ���丮�� �����ϰ� �ϱ� ���ؼ�
 * 
 * 
 * */
	public static void main(String[] args) {
		MainPageUi lu = new MainPageUi();
		try {
			lu.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
