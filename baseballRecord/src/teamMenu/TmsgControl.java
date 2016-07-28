package teamMenu;

import java.io.IOException;
import java.util.Scanner;

public class TmsgControl {
	TdataManager tdmg;
	Team[] teams = new Team[10];
	
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
		
		
	}
	
	public void teamView(){
		System.out.println("=========================================================================================================");
		System.out.println("NO\t팀명\t경기\t승\t무\t패\t승률\t득점\t홈런\t도루\t볼넷%\t삼진%\t타율\t출루율\t장타율");
		System.out.println("---------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < teams[0].getSize(); i++) {
			System.out.printf("%.0f \t %s \t %.0f \t %.0f\t%.0f\t%.0f\t%.3f\t%.0f\t%.0f\t%.0f\t%.1f\t%.1f\t%.3f\t%.3f\t%.3f\n",teams[i].getNum(),teams[i].getTeamName(),teams[i].getGame(),teams[i].getWin()
					,teams[i].getDraw(),teams[i].getLose(),teams[i].getWinningRate(),teams[i].getScore(),teams[i].getHomeRun(),teams[i].getStealAbase(),teams[i].getFourBall()
					,teams[i].getStrikeOut(),teams[i].getBatAver(),teams[i].getOnBaseAver(),teams[i].getSlugAver());
		}
		System.out.println("---------------------------------------------------------------------------------------------------------");
		
	}
	
	public void teamDelete(){
		System.out.println("다음 리스트에서 삭제할 팀 번호를 선택하세요.");
		teamView();
		System.out.print("삭제 팀 번호 입력 : ");
		int deleteTeam = numInsert();
		teams = tdmg.teamDelete(deleteTeam);
		System.out.println("삭제 결과");
		teamView();
	}
	
	
	
}
