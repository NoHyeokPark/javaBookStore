package kr.ac.kopo.ui;

public class ExitUi extends BaseUi {
	@Override
	public void run() throws Exception {
		clear();
		System.out.println("\n\n========================================");
		System.out.println("\t홈페이지를 끕니다.");
		System.out.println("========================================");
		System.exit(0);
	}
}
