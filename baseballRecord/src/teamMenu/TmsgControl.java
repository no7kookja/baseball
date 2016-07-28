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
		System.out.println("1. txt파일");
		System.out.println("2. Serializable활용");
		
		
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
			System.out.println("NO\t팀명\t경기\t승\t무\t패\t승률\t득점\t홈런\t도루\t볼넷%\t삼진%\t타율\t출루율\t장타율");
			System.out.println("---------------------------------------------------------------------------------------------------------");
			for (int i = 0; i < teams[0].getSize(); i++) {
				System.out.printf("%.0f \t %s \t %.0f \t %.0f\t%.0f\t%.0f\t%.3f\t%.0f\t%.0f\t%.0f\t%.1f\t%.1f\t%.3f\t%.3f\t%.3f\n",teams[i].getNum(),teams[i].getTeamName(),teams[i].getGame(),teams[i].getWin()
						,teams[i].getDraw(),teams[i].getLose(),teams[i].getWinningRate(),teams[i].getScore(),teams[i].getHomeRun(),teams[i].getStealAbase(),teams[i].getFourBall()
						,teams[i].getStrikeOut(),teams[i].getBatAver(),teams[i].getOnBaseAver(),teams[i].getSlugAver());
			}
			System.out.println("---------------------------------------------------------------------------------------------------------");
			
		} else {
			System.out.println("데이터가 존재 하지 않습니다. ");
			
		}
		
	}
	
	
	
	public void teamDelete(){
		if (teams!=null) {
			System.out.println("다음 리스트에서 삭제할 팀 번호를 선택하세요.");
			teamView();
			System.out.print("삭제 팀 번호 입력 : ");
			int deleteTeam = numInsert();
			teams = tdmg.teamDelete(deleteTeam);
			System.out.println("삭제 결과");
			teamView();
		} else {
			System.out.println("데이터가 존재 하지 않습니다. ");
			
		}
	}
	
	public void teamAdd(){
		if (teams[0].getSize()<10) {
			Team newTeam = new Team(teams[0].getSize()+1,
					stringInsert("팀 명"),
					doubleInsert("경기수"),
					doubleInsert("승리한 경기수"),
					doubleInsert("패한 경기수"),
					doubleInsert("무승부 경기수"),
					doubleInsert("승률"),
					doubleInsert("득점"),
					doubleInsert("홈런수"),
					doubleInsert("도루수"),
					doubleInsert("볼넷율"),
					doubleInsert("삼진율"),
					doubleInsert("타율"),
					doubleInsert("출루율"),
					doubleInsert("장타율")) ;

			teams = tdmg.teamAdd(newTeam);
		} else {
			System.out.println("\n10개 이상의 구단은 추가할 수 없습니다.");
			
		}
		
		
		
	}
	
	public double doubleInsert(String title){
		System.out.print(title + " 입력 : ");
		Scanner s = new Scanner(System.in);
		return s.nextDouble();
	}
	
	public String stringInsert(String title){
		System.out.print(title + " 입력 : ");
		Scanner s = new Scanner(System.in);
		return s.next();
	}
	
	
	public void teamCompare(){
		if (teams!=null) {
			System.out.println("다음 리스트에서 비교 팀의 번호를 선택하세요");
			teamView();
			int team1 = (int)doubleInsert("비교 팀 번호")-1;
			int compareMenu=0;
			String condition="";
			if (team1>=0&&team1<teams[0].getSize()) {
				compareMenu = detailMenu("비교");
				if (compareMenu!=0) {
					System.out.println("===============");
					System.out.println("1. 크거나 같은 팀 비교");
					System.out.println("2. 작거나 같은 팀 비교");
					System.out.println("===============");
					int num = (int)doubleInsert("메뉴");
					switch (num) {
					case 1:condition = "over";break;
					case 2:condition = "under";break;
					default: break;
					}
					compareFunction(compareMenu, condition, team1);;
					
					
				} else {
					System.out.println(" 상위 메뉴로!");
				}
		
				
			} else {
				System.out.println(" 팀번호 잘못 입력!!");
				
			}
		} else {
			System.out.println("데이터가 존재 하지 않습니다. ");
		}	
	}
	
	public int detailMenu(String title){
		System.out.println("=============");
		System.out.println("1. 경기수 "+title);
		System.out.println("2. 승수 "+title);
		System.out.println("3. 무승부수 "+title);
		System.out.println("4. 패배수 "+title);
		System.out.println("5. 승률  "+title);
		System.out.println("6. 득점 "+title);
		System.out.println("7. 홈런 "+title);
		System.out.println("8. 도루 "+title);
		System.out.println("9. 볼넷율 "+title);
		System.out.println("10. 삼진율 "+title);
		System.out.println("11. 타율 "+title);
		System.out.println("12. 출루율 "+title);
		System.out.println("13. 장타율 "+title);
		System.out.println("0. 상위 메뉴로");
		System.out.println("=============");
		int menu = (int)doubleInsert("메뉴");
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
		//결과 저장할 배열, 배열[0]=몇개의 팀인지 저장.
		int[] resultIndex = new int[10];
		int resultSize = 0;
		
		//기준팀 인덱스 기준으로 위로 for문
		for (int i = team1+1; i < teams[0].getSize(); i++) {
			if (condition.equals("over")?record[team1][menu-1]<=record[i][menu-1]:record[team1][menu-1]>=record[i][menu-1]) {
				resultIndex[resultSize] = i;
				resultSize++;
			}
				
		}
		
		//기준팀 인덱스 기준으로 아래로 for문
		for (int i = team1-1; i > -1; i--) {
			if (condition.equals("over")?record[team1][menu-1]<=record[i][menu-1]:record[team1][menu-1]>=record[i][menu-1]) {
				resultIndex[resultSize] = i;
				resultSize++;
			}
				
		}
		String str = "";
		switch (menu) {
		case 1:str="경기수가";	break;
		case 2:str="승리한 경기수가";	break;
		case 3:str="무승부한 경기수가";	break;
		case 4:str="패한 경기수가";	break;
		case 5:str="승률이";	break;
		case 6:str="득점이";	break;
		case 7:str="홈런이";	break;
		case 8:str="도루가";	break;
		case 9:str="볼넷율이";	break;
		case 10:str="삼진율이";	break;
		case 11:str="타율이";	break;
		case 12:str="출루율이";	break;
		case 13:str="장타율이";	break;

		default:
			break;
		}
		
		 
		
		System.out.println("=========================================================================================================");
		switch (condition) {
		case "over":System.out.printf("* %s보다 %s 크거나 같은 팀 리스트\n", teams[team1].getTeamName(),str);
			break;
		case "under":System.out.printf("* %s보다 %s 작거나 같은 팀 리스트\n", teams[team1].getTeamName(),str);
			break;

		default:
			break;
		}
		
		System.out.println("NO\t팀명\t경기\t승\t무\t패\t승률\t득점\t홈런\t도루\t볼넷%\t삼진%\t타율\t출루율\t장타율");
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
		
			System.out.println("다음 리스트에서 수정할 팀의 번호를 선택하세요");
			teamView();
			int team1 = (int)doubleInsert("수정할 팀 번호")-1;
			teamView(teams[team1]);
			int updateMenu=0;
			if (team1>=0&&team1<teams[0].getSize()) {
				updateMenu = detailMenu("수정");
				if (updateMenu!=0) {
					
					String str = "";
					switch (updateMenu) {
					case 1:str="경기수";	break;
					case 2:str="승리한 경기수";	break;
					case 3:str="무승부한 경기수";	break;
					case 4:str="패한 경기수";	break;
					case 5:str="승률";	break;
					case 6:str="득점";	break;
					case 7:str="홈런";	break;
					case 8:str="도루";	break;
					case 9:str="볼넷율";	break;
					case 10:str="삼진율";	break;
					case 11:str="타율";	break;
					case 12:str="출루율";	break;
					case 13:str="장타율";	break;
	
					default:break;
					}
					
					double updateValue = doubleInsert(str);
					teams = tdmg.teamUpdate(team1, updateMenu, updateValue);
					teamView(teams[team1]);
				} else {
					System.out.println(" 상위 메뉴로!");
				}
			} else {
				System.out.println(" 팀번호 잘못 입력!!");
				
			}
		} else {
			System.out.println("데이터가 존재 하지 않습니다. ");
		
	}
		
	}
	
}
