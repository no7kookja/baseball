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
		System.out.println("NO\t����\t���\t��\t��\t��\t�·�\t����\tȨ��\t����\t����%\t����%\tŸ��\t�����\t��Ÿ��");
		for (int i = 0; i < teams.length; i++) {
			System.out.printf("%.0f \t %s \t %.0f \t %.0f\t%.0f\t%.0f\t%.3f\t%.0f\t%.0f\t%.0f\t%.1f\t%.1f\t%.3f\t%.3f\t%.3f\n",teams[i].getNum(),teams[i].getTeamName(),teams[i].getGame(),teams[i].getWin()
					,teams[i].getDraw(),teams[i].getLose(),teams[i].getWinningRate(),teams[i].getScore(),teams[i].getHomeRun(),teams[i].getStealAbase(),teams[i].getFourBall()
					,teams[i].getStrikeOut(),teams[i].getBatAver(),teams[i].getOnBaseAver(),teams[i].getSlugAver());
		}
		
	}
	
	
	
}
