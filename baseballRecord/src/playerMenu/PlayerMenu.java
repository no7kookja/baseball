package playerMenu;

import java.io.IOException;
import java.util.Scanner;

import teamMenu.MENU_TEAM;

import interfaces.Menu;

public class PlayerMenu implements Menu{
	int playerType; //1=투수, 2=타자
	PmsgControl pmsg;
	PdataManager pdmg;
			
	public PlayerMenu(){
		pdmg = new PdataManager();
		pmsg = new PmsgControl(pdmg);
		
	}		
	

	@Override
	public void menuView() {
		System.out.println("===============");
		System.out.println("1. 파일오픈");
		System.out.println("2. 파일저장");
		System.out.println("3. 선수 추가");
		System.out.println("4. 선수 프린트");
		System.out.println("5. 선수 정보 비교");
		System.out.println("6. 선수 정보 변경");
		System.out.println("7. 선수 정보 삭제");
		System.out.println("0. 상위메뉴로");
		
	}
	
	public void playerTypeSelect(){
		System.out.println("===============");
		System.out.println("1. 투수 정보 메뉴");
		System.out.println("2. 타자 정보 메뉴");
		System.out.println("0. 상위 메뉴로");
		
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

	
	public MENU_PLAYER makeENUM(int num){
		MENU_PLAYER[] menus = MENU_PLAYER.values();
		return menus[num];
	}
	
	@Override
	public void messagePro(int num ) throws IOException {
		MENU_PLAYER menu = makeENUM(num);
		switch (menu) {
		case FILE_OPEN: pmsg.txtOpen(); break;
		case FILE_SAVE: pmsg.fileSave(); break;
		case ADD_PLAYER: pmsg.add(); break;
		case PRINT_PLAYER: if (playerType==1) {pmsg.pitcherView();
							} else {pmsg.batterView();}
						break;
//		case COMPARE_PLAYER: pmsg.teamCompare(); break;
		case UPDATE_PLAYER: pmsg.update(); break;
		case DELETE_PLAYER: pmsg.delete(); break;

		default:
			break;
		}
		
	}

	@Override
	public boolean menuLoop() throws IOException {
		playerTypeSelect();
		playerType = menuNumSelect();
		if (playerType==0) {
			System.out.println("\n상위 메뉴로!");return false;
		} else {
			pmsg.setPlayerType(playerType);
			pdmg.setPlayerType(playerType);
			while (detailLoop()) {
								
			}
				
			
		}
		
		
		return true;
	}
	
	public boolean detailLoop() throws IOException{
		menuView();
		int menu = menuNumSelect();
		if(menu==0){
			System.out.println("\n상위 메뉴로!");
			return false;
			
		} else {
			messagePro(menu);
			
		}
		return true;
		
	}
	
	
	
	
	
	 

}
