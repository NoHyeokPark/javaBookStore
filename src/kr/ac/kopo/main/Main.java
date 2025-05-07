package kr.ac.kopo.main;

import kr.ac.kopo.ui.MainPageUi;

public class Main {
/*
 * 팩토리 패턴을 사용한 이유
 * 서비스가 변경되어도 팩토리만 수정하게 하기 위해서
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
