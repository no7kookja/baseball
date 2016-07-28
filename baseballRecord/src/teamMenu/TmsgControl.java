package teamMenu;

import java.io.IOException;

public class TmsgControl {
	TdataManager tdmg;
	Team[] teams = new Team[10];
	
	public TmsgControl(TdataManager tdmg){
		
		this.tdmg = tdmg;
	}
	
	
	public void txtOpen() throws IOException{
		this.teams = tdmg.txtOpen();
	}
	
	public void teamView(Team team){
		
		
	}
	
	public void teamView(){
		System.out.println(teams.length);
		System.out.println(teams[0].getTeamName());
		System.out.println("NO\t팀명\t경기\t승\t무\t패\t승률\t득점\t홈런\t도루\t볼넷%\t삼진%\t타율\t출루율\t장타율");
		for (int i = 0; i < teams.length; i++) {
			System.out.printf("%.0f \t %s \t %.0f \t %.0f\t%.0f\t%.0f\t%.3f\t%.0f\t%.0f\t%.0f\t%.1f\t%.1f\t%.3f\t%.3f\t%.3f\n",teams[i].getNum(),teams[i].getTeamName(),teams[i].getGame(),teams[i].getWin()
					,teams[i].getDraw(),teams[i].getLose(),teams[i].getWinningRate(),teams[i].getScore(),teams[i].getHomeRun(),teams[i].getStealAbase(),teams[i].getFourBall()
					,teams[i].getStrikeOut(),teams[i].getBatAver(),teams[i].getOnBaseAver(),teams[i].getSlugAver());
		}
		
	}
	
	
	
}
