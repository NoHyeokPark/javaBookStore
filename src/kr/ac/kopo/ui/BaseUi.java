package kr.ac.kopo.ui;

import java.util.Scanner;

import kr.ac.kopo.util.ClearAble;

public abstract class BaseUi implements IBookUi, ClearAble {
	private Scanner sc;

	public BaseUi() {
		sc = new Scanner(System.in);
	}

	protected String scanStr(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}

	protected int scanInt(String msg) {
		System.out.print(msg);
		return Integer.parseInt(sc.nextLine());
	}
	
	@Override
	public void clear() {
		for(int i = 0; i < 50; i++) {
			System.out.println();
		}
		
	}

}
