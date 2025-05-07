package kr.ac.kopo.ui;

import java.util.Scanner;

public abstract class BaseUi implements IBookUi {
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

}
