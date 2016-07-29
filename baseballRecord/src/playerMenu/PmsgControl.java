package playerMenu;

import java.io.IOException;
import java.util.Scanner;

import teamMenu.Team;

public class PmsgControl {
	PdataManager pdmg;
	private int playerType; //1=����, 2=Ÿ��
	Player[] players;
	
	public void setPlayerType(int playerType) {
		this.playerType = playerType;
	}

	public PmsgControl(PdataManager pdmg){
		
		this.pdmg = pdmg;
	}
	
	public double doubleInsert(String title){
		System.out.print(title + " �Է� : ");
		Scanner s = new Scanner(System.in);
		return s.nextDouble();
	}
	
	public String stringInsert(String title){
		System.out.print(title + " �Է� : ");
		Scanner s = new Scanner(System.in);
		return s.next();
	}
	
	public Player[] txtOpen() throws IOException{
			
			System.out.println("==============");
			System.out.println("1. txt����");
			System.out.println("2. SerializableȰ��");
			
			
			int num = (int)doubleInsert("�޴�");
			if (num==1) {
				this.players = pdmg.txtOpen();
			} else if(num==2){
				this.players = pdmg.serialOpen();
				
			} else{
				
				players = txtOpen();
			}
			return players;
	}
	
	public void pitcherView(){
		if (players!=null) {
			System.out.println("=========================================================================================================");
			System.out.println("NO\t������\t\t����\t������\t��\t��\t���̺�\tȦ��\t���\t���\t����\t�̴�\t����/9\t����/9\tȨ��/9");
			
			System.out.println("---------------------------------------------------------------------------------------------------------");
			for (int i = 0; i < players[0].getSize(); i++) {
				if (players[i].getPosition()==POSITION.PITCHER) {
					Pitcher pitcher = (Pitcher)players[i];
					System.out.printf("%.0f\t%s\t\t%s\t%s\t%.0f\t%.0f\t%.0f\t%.0f\t%.0f\t%.0f\t%.0f\t%.1f\t%.1f\t%.2f\t%.2f\n",
							pitcher.getNo(),pitcher.getPlayerName(),pitcher.getTeamName(),pitcher.getPosition(),pitcher.getWin()
							,pitcher.getLose(),pitcher.getSave(),pitcher.getHold(),pitcher.getBlown(),pitcher.getGame(),pitcher.getStarting()
							,pitcher.getInning(),pitcher.getStrikeOut(),pitcher.getFourBall(),pitcher.getHomeRun());
				}
				
			}
			System.out.println("---------------------------------------------------------------------------------------------------------");
			
		} else {
			System.out.println("�����Ͱ� ���� ���� �ʽ��ϴ�. ");
			
		}
		
	}
			
	public void pitcherView(Pitcher pitcher){
		System.out.println("=========================================================================================================");
		System.out.println("NO\t������\t\t����\t������\t��\t��\t���̺�\tȦ��\t���\t���\t����\t�̴�\t����/9\t����/9\tȨ��/9");
		
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.printf("%.0f\t%s\t\t%s\t%s\t%.0f\t%.0f\t%.0f\t%.0f\t%.0f\t%.0f\t%.0f\t%.1f\t%.1f\t%.2f\t%.2f\n",
				pitcher.getNo(),pitcher.getPlayerName(),pitcher.getTeamName(),pitcher.getPosition(),pitcher.getWin()
				,pitcher.getLose(),pitcher.getSave(),pitcher.getHold(),pitcher.getBlown(),pitcher.getGame(),pitcher.getStarting()
				,pitcher.getInning(),pitcher.getStrikeOut(),pitcher.getFourBall(),pitcher.getHomeRun());
		
		System.out.println("---------------------------------------------------------------------------------------------------------");
	}
	
	
	
	public void batterView(){
		if (players!=null) {
			System.out.println("=========================================================================================================");
			System.out.println("NO\t������\t\t����\t������\t���\tŸ��\tŸ��\t��Ÿ\tȨ��\t����\tŸ��\t����\t����\t����");
			
			System.out.println("---------------------------------------------------------------------------------------------------------");
			for (int i = 0; i < players[0].getSize(); i++) {
				if (players[i].getPosition()!=POSITION.PITCHER) {
					Batter batter = (Batter)players[i];
					System.out.printf("%.0f\t%s\t\t%s\t%s\t%.0f\t%.0f\t%.0f\t%.0f\t%.0f\t %.0f\t%.0f\t%.0f\t%.0f\t%.0f\n",
							batter.getNo(),batter.getPlayerName(),batter.getTeamName(),batter.getPosition() ,batter.getGame(),batter.getPlateAppearance()
							,batter.getAtBat(),batter.getHit(),batter.getHomeRun(),batter.getScore(),batter.getHitScore(),batter.getFourBall(),batter.getStrikeOut(),batter.getStealBase());
				}
				
			}
			System.out.println("---------------------------------------------------------------------------------------------------------");
			
		} else {
			System.out.println("�����Ͱ� ���� ���� �ʽ��ϴ�. ");
			
		}
		
	}
	
	public void batterView(Batter batter){
		System.out.println("=========================================================================================================");
		System.out.println("NO\t������\t\t����\t������\t���\tŸ��\tŸ��\t��Ÿ\tȨ��\t����\tŸ��\t����\t����\t����");
		
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.printf("%.0f\t%s\t\t%s\t%s\t%.0f\t%.0f\t%.0f\t%.0f\t%.0f\t %.0f\t%.0f\t%.0f\t%.0f\t%.0f\n",
				batter.getNo(),batter.getPlayerName(),batter.getTeamName(),batter.getPosition() ,batter.getGame(),batter.getPlateAppearance()
				,batter.getAtBat(),batter.getHit(),batter.getHomeRun(),batter.getScore(),batter.getHitScore(),batter.getFourBall(),batter.getStrikeOut(),batter.getStealBase());
	
		System.out.println("---------------------------------------------------------------------------------------------------------");
		
		
	}
	
	public void fileSave(){
		
		pdmg.fileSave();
		
	}
	
	public POSITION positionSelect(){
		System.out.println("-------------------");
		System.out.println("�������� �������ּ���.");
		System.out.println("1. FIRST_BASE_FIELDER");	
		System.out.println("2. SECOND_BASE_FIELDER");
		System.out.println("3. THIRD_BASE_FIELDER");
		System.out.println("4. RIGHT_FIELDER");
		System.out.println("5. SHORTSTOP");
		System.out.println("6. LEFT_FIELDER");
		System.out.println("7. CENTER_FIELDER");
		System.out.println("8. DESIGNATED_HITTER");
		System.out.println("9. CATCHER");
	
		int poti = (int)doubleInsert("������");
		POSITION[] positions = POSITION.values();
		return positions[poti];
	}
	
	
	
	public void add(){
		if (players[0].getSize()<500) {
			if (playerType ==1) {
				Pitcher pitcher = new Pitcher(players[0].getSize()+1, 
						stringInsert("�����̸�"), 
						stringInsert("�� ��"), 
						POSITION.PITCHER,
						doubleInsert("�¸�����"), 
						doubleInsert("���� ����"),
						doubleInsert("���̺� ��"),
						doubleInsert("Ȧ�� ��"),
						doubleInsert("��� ���̺� ��"), 
						doubleInsert("��� ��"), 
						doubleInsert("���߰�� ��"), 
						doubleInsert("�̴� ��"), 
						doubleInsert("���� ��"), 
						doubleInsert("���� ��"), 
						doubleInsert("Ȩ�� ��"));
				
				players = pdmg.add(pitcher);
			} else if(playerType==2){
				Batter batter = new Batter(players[0].getSize()+1, 
						stringInsert("�����̸�"), 
						stringInsert("�� ��"), 
						positionSelect(), 
						doubleInsert("��� ��"), 
						doubleInsert("Ÿ�� ��"), 
						doubleInsert("Ÿ�� ��"),
						doubleInsert("��Ÿ ��"),
						doubleInsert("Ȩ�� ��"),
						doubleInsert("���� ��"),
						doubleInsert("Ÿ�� ��"),
						doubleInsert("���� ��"),
						doubleInsert("���� ��"),
						doubleInsert("���� ��"));
								
				players = pdmg.add(batter);
				
			}
	
			
		} else {
			System.out.println("\n 500���� �ʰ��Ͽ����ϴ�.");
			
		}
		
	}
	
	public void delete(){
		if (players!=null) {
			System.out.println("���� ����Ʈ���� ������ ���� ��ȣ�� �����ϼ���.");
			if (playerType==1) {
				pitcherView();
			} else{
				batterView();
			}
			int deletePlayer = (int)doubleInsert("���� ���� ��ȣ");
			int deleteIndex = playerIndexSearch(playerType, deletePlayer);
			
			players = pdmg.delete(playerType,deleteIndex);
			System.out.println("���� ���");
			
			if (playerType==1) {
				pitcherView();
			} else{
				batterView();
			}
		} else {
			System.out.println("�����Ͱ� ���� ���� �ʽ��ϴ�. ");
			
		}
	}
	
	public int playerIndexSearch(int playerType, int no){
		int index=-1;
		for (int i = 0; i < players[0].getSize(); i++) {
			if (playerType==1) {
				if (players[i].getPosition()==POSITION.PITCHER&&players[i].getNo()==no) {
					index = i;
				}
			} else {
				if (players[i].getPosition()!=POSITION.PITCHER&&players[i].getNo()==no) {
					index = i;
				}
				
			}
			
		}
		return index;
	}
	
	public void update(){
		if (players!=null) {
		
			System.out.println("���� ����Ʈ���� ������ ������ ��ȣ�� �����ϼ���");
			if (playerType==1) {
				pitcherView();
				int player = (int)doubleInsert("������ ���� ��ȣ");
				int updateIndex = playerIndexSearch(playerType, player);
				
				pitcherView((Pitcher)players[updateIndex]);
				int updateMenu=0;
				if (player>=0&&player<players[0].getSize()) {
					updateMenu = pitcherMenu("����");
					if (updateMenu!=0) {
						
						String str = "";
						switch (updateMenu) {
						case 1:str="����";	break;
						case 2:str="������";	break;
						case 3:str="�¼�";	break;
						case 4:str="�м�";	break;
						case 5:str="���̺� ��";	break;
						case 6:str="Ȧ�� ��";	break;      
						case 7:str="��� �� ";	break;
						case 8:str="��� ��";	break;
						case 9:str="���� ��";	break;
						case 10:str="�̴� ��";	break;
						case 11:str="����/9";	break;
						case 12:str="����/9";	break;
						case 13:str="Ȩ��/9";	break;
		
						default:break;
						}
						if (updateMenu<3) {
							String updateValue = stringInsert(str);
							players = pdmg.update(updateIndex, updateMenu, updateValue);
						} else {
							double updateValue = doubleInsert(str);
							players = pdmg.update(updateIndex, updateMenu, updateValue);
						}
						
						pitcherView((Pitcher)players[updateIndex]);
						
						
					}  else {
						System.out.println(" ���� �޴���!");
					}
				} else {
					System.out.println(" ������ȣ �߸� �Է�!!");
					
				}
				
			} else{
				
				
				batterView();
				int player = (int)doubleInsert("������ ���� ��ȣ")-1;
				int updateIndex = playerIndexSearch(playerType, player);
				
				batterView((Batter)players[updateIndex]);
				int updateMenu=0;
				if (player>=0&&player<players[0].getSize()) {
					updateMenu = batterMenu("����");
					if (updateMenu!=0) {
						
						String str = "";
						switch (updateMenu) {
						case 1:str="����";	break;
						case 2:str="������";	break;
						case 3:str="��� ��";	break;
						case 4:str="Ÿ�� ��";	break;
						case 5:str="Ÿ��";	break;
						case 6:str="��Ÿ ��";	break;      
						case 7:str="Ȩ�� �� ";	break;
						case 8:str="���� ��";	break;
						case 9:str="Ÿ�� ��";	break;
						case 10:str="���� ��";	break;
						case 11:str="���� ��";	break;
						case 12:str="���� ��";	break;
				

						default:break;
						}
						if (updateMenu<3) {
							String updateValue = stringInsert(str);
							players = pdmg.update(updateIndex, updateMenu, updateValue);
						} else {
							double updateValue = doubleInsert(str);
							players = pdmg.update(updateIndex, updateMenu, updateValue);
						}
												
						batterView((Batter)players[updateIndex]);
						
						
					}  else {
						System.out.println(" ���� �޴���!");
					}
				} else {
					System.out.println(" ������ȣ �߸� �Է�!!");
					
				}
			}
			
			
			
		} else {
			System.out.println("�����Ͱ� ���� ���� �ʽ��ϴ�. ");
		
	}
		
	}
	
	public int pitcherMenu(String title){
		System.out.println("=============");
		System.out.println("1. ���� "+title);
		System.out.println("2. ������ "+title);
		System.out.println("3. �¼� "+title);
		System.out.println("4. �м� "+title);
		System.out.println("5. ���̺� ��  "+title);
		System.out.println("6. Ȧ�� �� "+title);
		System.out.println("7. ��� ��"+title);
		System.out.println("8. ��� �� "+title);
		System.out.println("9. ���� �� "+title);
		System.out.println("10. �̴� �� "+title);
		System.out.println("11. ����/9 "+title);
		System.out.println("12. ����/9 "+title);
		System.out.println("13. Ȩ��/9 "+title);
		System.out.println("0. ���� �޴���");
		System.out.println("=============");
		int menu = (int)doubleInsert("�޴�");
		return menu;		
	}
	
	public int batterMenu(String title){
		System.out.println("=============");
		System.out.println("1. ���� "+title);
		System.out.println("2. ������ "+title);
		System.out.println("3. ��� �� "+title);
		System.out.println("4. Ÿ�� �� "+title);
		System.out.println("5. Ÿ��   "+title);
		System.out.println("6. ��Ÿ �� "+title);
		System.out.println("7. Ȩ�� ��"+title);
		System.out.println("8. ���� �� "+title);
		System.out.println("9. Ÿ�� �� "+title);
		System.out.println("10. ���� �� "+title);
		System.out.println("11. ���� �� "+title);
		System.out.println("12. ���� �� "+title);
		System.out.println("0. ���� �޴���");
		System.out.println("=============");
		int menu = (int)doubleInsert("�޴�");
		return menu;		
	}
	
	
	
	
	
}
