package teamMenu;

import java.io.IOException;
import java.util.Scanner;

public class TeamMenu implements Menu{
	TmsgControl tmsg;
	TdataManager tdmg;
	
	public TeamMenu(){
		tdmg = new TdataManager();
		tmsg = new TmsgControl(tdmg);
		
	}
	
	
	@Override
	public void menuView() {
		System.out.println("===============");
		System.out.println("1. 파일오픈");
		System.out.println("2. 파일저장");
		System.out.println("3. 팀 추가");
		System.out.println("4. 팀 프린트");
		System.out.println("5. 팀 정보 비교");
		System.out.println("6. 팀 정보 변경");
		System.out.println("7. 팀 정보 삭제");
		System.out.println("0. 상위메뉴로");
		
	}

	@Override
	public int menuNumSelect() {
		Scanner s = new Scanner(System.in);
		System.out.print("메뉴 선택 : ");
		int num = s.nextInt();
		boolean menuCheck = menuCheck(0, 6, num);
		
		return num;
	}

	@Override
	public boolean menuCheck(int start, int end, int num) {
		if (num<start||num>end) {
			return false;
		}
		return true;
	}

	public MENU_TEAM makeENUM(int num){
		MENU_TEAM[] menus = MENU_TEAM.values();
		return menus[num];
	}
	
	@Override
	public void messagePro(int num) throws IOException {
		MENU_TEAM menu = makeENUM(num);
		switch (menu) {
		case FILE_OPEN: tmsg.txtOpen(); break;
		case FILE_SAVE: tmsg.fileSave(); break;
		case ADD_TEAM: tmsg.teamAdd(); break;
		case PRINT_TEAM: tmsg.teamView(); break;
		case COMPARE_TEAM: tmsg.teamCompare(); break;
		case UPDATE_TEAM: tmsg.teamUpdate(); break;
		case DELETE_TEAM: tmsg.teamDelete(); break;

		default:
			break;
		}
		
	}
	
	
	

	@Override
	public boolean menuLoop() throws IOException {
		menuView();
		int menu = menuNumSelect();
		if (menu==0) {
			System.out.println("\n상위 메뉴로!");return false;
		} 
		messagePro(menu);
		
		return true;
	}
	
	
	
	
	

}
