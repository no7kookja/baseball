package playerMenu;

import java.io.IOException;
import java.util.Scanner;

import teamMenu.MENU_TEAM;

import interfaces.Menu;

public class PlayerMenu implements Menu{
	int playerType; //1=����, 2=Ÿ��
	PmsgControl pmsg;
	PdataManager pdmg;
			
	public PlayerMenu(){
		pdmg = new PdataManager();
		pmsg = new PmsgControl(pdmg);
		
	}		
	

	@Override
	public void menuView() {
		System.out.println("===============");
		System.out.println("1. ���Ͽ���");
		System.out.println("2. ��������");
		System.out.println("3. ���� �߰�");
		System.out.println("4. ���� ����Ʈ");
		System.out.println("5. ���� ���� ��");
		System.out.println("6. ���� ���� ����");
		System.out.println("7. ���� ���� ����");
		System.out.println("0. �����޴���");
		
	}
	
	public void playerTypeSelect(){
		System.out.println("===============");
		System.out.println("1. ���� ���� �޴�");
		System.out.println("2. Ÿ�� ���� �޴�");
		System.out.println("0. ���� �޴���");
		
	}

	@Override
	public int menuNumSelect() {
		Scanner s = new Scanner(System.in);
		System.out.print("�޴� ���� : ");
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
			System.out.println("\n���� �޴���!");return false;
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
			System.out.println("\n���� �޴���!");
			return false;
			
		} else {
			messagePro(menu);
			
		}
		return true;
		
	}
	
	
	
	
	
	 

}
