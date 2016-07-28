package teamMenu;

import java.io.IOException;
import java.util.Scanner;

public class TeamMenu implements Menu{
	TmsgControl tmsg;
	TdataManager tdmg;
	
	TeamMenu(){
		tdmg = new TdataManager();
		tmsg = new TmsgControl(tdmg);
		
	}
	
	
	@Override
	public void menuView() {
		System.out.println("1. ���Ͽ���");
		System.out.println("2. ������ ���");
		
	}

	@Override
	public int menuSelect() {
		Scanner s = new Scanner(System.in);
		System.out.print("�޴� ���� : ");
		int menu = s.nextInt();
		boolean menuCheck = menuCheck(0, 6, menu);
		
		return menu;
	}

	@Override
	public boolean menuCheck(int start, int end, int menu) {
		if (menu<start||menu>end) {
			return false;
		}
		return true;
	}

	@Override
	public void messagePro(int menu) throws IOException {
		switch (menu) {
		case 1: tmsg.txtOpen(); break;
		case 2: tmsg.teamView();			
			break;

		default:
			break;
		}
		
	}
	
	
	

	@Override
	public boolean menuLoop() throws IOException {
		menuView();
		int menu = menuSelect();
		if (menu==0) {
			System.out.println("���α׷� ����.");return false;
		} 
		messagePro(menu);
		
		return true;
	}
	
	
	public static void main(String[] args) throws IOException {
		TeamMenu tm = new TeamMenu();
		while (tm.menuLoop()) {
			
		}

	}
	
	

}
