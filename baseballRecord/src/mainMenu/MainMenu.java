package mainMenu;

import java.io.IOException;
import java.util.Scanner;

import playerMenu.PlayerMenu;
import teamMenu.Menu;
import teamMenu.TeamMenu;

public class MainMenu implements Menu{
	TeamMenu teamM;
	PlayerMenu playerM;
	
	public MainMenu(){
		teamM = new TeamMenu();
		playerM = new PlayerMenu();
	}

	@Override
	public void menuView() {
		System.out.println("===============");
		System.out.println("1. 팀메뉴");
		System.out.println("2. 선수메뉴");
		System.out.println("0. 프로그램 종료");
		
	}

	@Override
	public int menuNumSelect() {
		Scanner s = new Scanner(System.in);
		System.out.print("메뉴 선택 : ");
		int num = s.nextInt();
		boolean menuCheck = menuCheck(0, 2, num);
		
		return num;
	}

	@Override
	public boolean menuCheck(int start, int end, int num) {
		if (num<start||num>end) {
			return false;
		}
		return true;
	}

	@Override
	public void messagePro(int menu) throws IOException {
		switch (menu) {
		case 1: while (teamM.menuLoop()) {}	break;
		case 2: while (teamM.menuLoop()) {}	break;
		default:
			break;
		}
		
	}

	@Override
	public boolean menuLoop() throws IOException {
		menuView();
		int menu = menuNumSelect();
		if (menu==0) {
			System.out.println("\n프로그램 종료.");return false;
		} 
		messagePro(menu);
		
		return true;
	}

}
