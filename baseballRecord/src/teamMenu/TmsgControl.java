package teamMenu;

import java.io.IOException;
import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class TmsgControl {
	TdataManager tdmg;
	Team[] teams;
	
	public TmsgControl(TdataManager tdmg){
		
		this.tdmg = tdmg;
	}
	
	
	public Team[] txtOpen() throws IOException{
		
		System.out.println("==============");
		System.out.println("1. txt����");
		System.out.println("2. SerializableȰ��");
		
		
		int num = numInsert();
		if (num==1) {
			this.teams = tdmg.txtOpen();
		} else if(num==2){
			this.teams = tdmg.serialOpen();
			
		} else{
			
			teams = txtOpen();
		}
		return teams;
	}
	
	public int numInsert(){
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		return num;
	}
	
	
	
	public void fileSave() throws IOException{
		tdmg.fileSave();
	}
	
	
	
	public void teamView(Team team){
		System.out.printf("%.0f \t %s \t %.0f \t %.0f\t%.0f\t%.0f\t%.3f\t%.0f\t%.0f\t%.0f\t%.1f\t%.1f\t%.3f\t%.3f\t%.3f\n",team.getNum(),team.getTeamName(),team.getGame(),team.getWin()
				,team.getDraw(),team.getLose(),team.getWinningRate(),team.getScore(),team.getHomeRun(),team.getStealAbase(),team.getFourBall()
				,team.getStrikeOut(),team.getBatAver(),team.getOnBaseAver(),team.getSlugAver());
		
	}
	
	public void teamView(){
		if (teams!=null) {
			System.out.println("=========================================================================================================");
			System.out.println("NO\t����\t���\t��\t��\t��\t�·�\t����\tȨ��\t����\t����%\t����%\tŸ��\t�����\t��Ÿ��");
			System.out.println("---------------------------------------------------------------------------------------------------------");
			for (int i = 0; i < teams[0].getSize(); i++) {
				System.out.printf("%.0f \t %s \t %.0f \t %.0f\t%.0f\t%.0f\t%.3f\t%.0f\t%.0f\t%.0f\t%.1f\t%.1f\t%.3f\t%.3f\t%.3f\n",teams[i].getNum(),teams[i].getTeamName(),teams[i].getGame(),teams[i].getWin()
						,teams[i].getDraw(),teams[i].getLose(),teams[i].getWinningRate(),teams[i].getScore(),teams[i].getHomeRun(),teams[i].getStealAbase(),teams[i].getFourBall()
						,teams[i].getStrikeOut(),teams[i].getBatAver(),teams[i].getOnBaseAver(),teams[i].getSlugAver());
			}
			System.out.println("---------------------------------------------------------------------------------------------------------");
			
		} else {
			System.out.println("�����Ͱ� ���� ���� �ʽ��ϴ�. ");
			
		}
		
	}
	
	
	
	public void teamDelete(){
		if (teams!=null) {
			System.out.println("���� ����Ʈ���� ������ �� ��ȣ�� �����ϼ���.");
			teamView();
			System.out.print("���� �� ��ȣ �Է� : ");
			int deleteTeam = numInsert();
			teams = tdmg.teamDelete(deleteTeam);
			System.out.println("���� ���");
			teamView();
		} else {
			System.out.println("�����Ͱ� ���� ���� �ʽ��ϴ�. ");
			
		}
	}
	
	public void teamAdd(){
		if (teams[0].getSize()<10) {
			Team newTeam = new Team(teams[0].getSize()+1,
					stringInsert("�� ��"),
					doubleInsert("����"),
					doubleInsert("�¸��� ����"),
					doubleInsert("���� ����"),
					doubleInsert("���º� ����"),
					doubleInsert("�·�"),
					doubleInsert("����"),
					doubleInsert("Ȩ����"),
					doubleInsert("�����"),
					doubleInsert("������"),
					doubleInsert("������"),
					doubleInsert("Ÿ��"),
					doubleInsert("�����"),
					doubleInsert("��Ÿ��")) ;

			teams = tdmg.teamAdd(newTeam);
		} else {
			System.out.println("\n10�� �̻��� ������ �߰��� �� �����ϴ�.");
			
		}
		
		
		
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
	
	
	public void teamCompare(){
		if (teams!=null) {
			System.out.println("���� ����Ʈ���� �� ���� ��ȣ�� �����ϼ���");
			teamView();
			int team1 = (int)doubleInsert("�� �� ��ȣ")-1;
			int compareMenu=0;
			String condition="";
			if (team1>=0&&team1<teams[0].getSize()) {
				compareMenu = detailMenu("��");
				if (compareMenu!=0) {
					System.out.println("===============");
					System.out.println("1. ũ�ų� ���� �� ��");
					System.out.println("2. �۰ų� ���� �� ��");
					System.out.println("===============");
					int num = (int)doubleInsert("�޴�");
					switch (num) {
					case 1:condition = "over";break;
					case 2:condition = "under";break;
					default: break;
					}
					compareFunction(compareMenu, condition, team1);;
					
					
				} else {
					System.out.println(" ���� �޴���!");
				}
		
				
			} else {
				System.out.println(" ����ȣ �߸� �Է�!!");
				
			}
		} else {
			System.out.println("�����Ͱ� ���� ���� �ʽ��ϴ�. ");
		}	
	}
	
	public int detailMenu(String title){
		System.out.println("=============");
		System.out.println("1. ���� "+title);
		System.out.println("2. �¼� "+title);
		System.out.println("3. ���ºμ� "+title);
		System.out.println("4. �й�� "+title);
		System.out.println("5. �·�  "+title);
		System.out.println("6. ���� "+title);
		System.out.println("7. Ȩ�� "+title);
		System.out.println("8. ���� "+title);
		System.out.println("9. ������ "+title);
		System.out.println("10. ������ "+title);
		System.out.println("11. Ÿ�� "+title);
		System.out.println("12. ����� "+title);
		System.out.println("13. ��Ÿ�� "+title);
		System.out.println("0. ���� �޴���");
		System.out.println("=============");
		int menu = (int)doubleInsert("�޴�");
		return menu;		
	}
	
	public void compareFunction(int menu, String condition, int team1){
		
		double[][] record = new double[10][13];
		for (int i = 0; i < teams[0].getSize(); i++) {
			record[i][0] = teams[i].getGame();
			record[i][1] = teams[i].getWin();
			record[i][2] = teams[i].getDraw();
			record[i][3] = teams[i].getLose();
			record[i][4] = teams[i].getWinningRate();
			record[i][5] = teams[i].getScore();
			record[i][6] = teams[i].getHomeRun();
			record[i][7] = teams[i].getStealAbase();
			record[i][8] = teams[i].getFourBall();
			record[i][9] = teams[i].getStrikeOut();
			record[i][10] = teams[i].getBatAver();
			record[i][11] = teams[i].getOnBaseAver();
			record[i][12] = teams[i].getSlugAver();
		}
		//��� ������ �迭, �迭[0]=��� ������ ����.
		int[] resultIndex = new int[10];
		int resultSize = 0;
		
		//������ �ε��� �������� ���� for��
		for (int i = team1+1; i < teams[0].getSize(); i++) {
			if (condition.equals("over")?record[team1][menu-1]<=record[i][menu-1]:record[team1][menu-1]>=record[i][menu-1]) {
				resultIndex[resultSize] = i;
				resultSize++;
			}
				
		}
		
		//������ �ε��� �������� �Ʒ��� for��
		for (int i = team1-1; i > -1; i--) {
			if (condition.equals("over")?record[team1][menu-1]<=record[i][menu-1]:record[team1][menu-1]>=record[i][menu-1]) {
				resultIndex[resultSize] = i;
				resultSize++;
			}
				
		}
		String str = "";
		switch (menu) {
		case 1:str="������";	break;
		case 2:str="�¸��� ������";	break;
		case 3:str="���º��� ������";	break;
		case 4:str="���� ������";	break;
		case 5:str="�·���";	break;
		case 6:str="������";	break;
		case 7:str="Ȩ����";	break;
		case 8:str="���簡";	break;
		case 9:str="��������";	break;
		case 10:str="��������";	break;
		case 11:str="Ÿ����";	break;
		case 12:str="�������";	break;
		case 13:str="��Ÿ����";	break;

		default:
			break;
		}
		
		 
		
		System.out.println("=========================================================================================================");
		switch (condition) {
		case "over":System.out.printf("* %s���� %s ũ�ų� ���� �� ����Ʈ\n", teams[team1].getTeamName(),str);
			break;
		case "under":System.out.printf("* %s���� %s �۰ų� ���� �� ����Ʈ\n", teams[team1].getTeamName(),str);
			break;

		default:
			break;
		}
		
		System.out.println("NO\t����\t���\t��\t��\t��\t�·�\t����\tȨ��\t����\t����%\t����%\tŸ��\t�����\t��Ÿ��");
		System.out.println("---------------------------------------------------------------------------------------------------------");
		teamView(teams[team1]);
		System.out.println("---------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < resultSize; i++) {
			teamView(teams[resultIndex[i]]);
		}
		System.out.println("---------------------------------------------------------------------------------------------------------");
		
		
		
	}
	
	public void teamUpdate(){
		if (teams!=null) {
		
			System.out.println("���� ����Ʈ���� ������ ���� ��ȣ�� �����ϼ���");
			teamView();
			int team1 = (int)doubleInsert("������ �� ��ȣ")-1;
			teamView(teams[team1]);
			int updateMenu=0;
			if (team1>=0&&team1<teams[0].getSize()) {
				updateMenu = detailMenu("����");
				if (updateMenu!=0) {
					
					String str = "";
					switch (updateMenu) {
					case 1:str="����";	break;
					case 2:str="�¸��� ����";	break;
					case 3:str="���º��� ����";	break;
					case 4:str="���� ����";	break;
					case 5:str="�·�";	break;
					case 6:str="����";	break;
					case 7:str="Ȩ��";	break;
					case 8:str="����";	break;
					case 9:str="������";	break;
					case 10:str="������";	break;
					case 11:str="Ÿ��";	break;
					case 12:str="�����";	break;
					case 13:str="��Ÿ��";	break;
	
					default:break;
					}
					
					double updateValue = doubleInsert(str);
					teams = tdmg.teamUpdate(team1, updateMenu, updateValue);
					teamView(teams[team1]);
				} else {
					System.out.println(" ���� �޴���!");
				}
			} else {
				System.out.println(" ����ȣ �߸� �Է�!!");
				
			}
		} else {
			System.out.println("�����Ͱ� ���� ���� �ʽ��ϴ�. ");
		
	}
		
	}
	
}
