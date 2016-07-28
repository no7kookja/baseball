package teamMenu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.StringTokenizer;

public class TdataManager {
	Team[] teams = new Team[10];
	TFileManager fm;
	
	public Team[] txtOpen() throws IOException{
		fm = new TFileManager();
		teams = fm.txtOpen();
		return teams;
		
	}
	
	public Team[] serialOpen(){
		fm = new TFileManager();
		teams = fm.serialOpen();
		return teams;
		
	}
	
	public void fileSave(){
		
		fm.fileSave(teams);
	}
	
	public Team[] teamDelete(int no){
		for (int i = no-1; i < teams[0].getSize()-1; i++) {
			teams[i+1].setNum(teams[i+1].getNum()-1);
			teams[i] = teams[i+1];
			
		}
		
		teams[0].setSize(teams[0].getSize()-1);
		
		return teams;
	}
	
	public Team[] teamAdd(Team newTeam){
		
		teams[teams[0].getSize()-1]=newTeam;
		return teams;
		
	}
	
	public Team[] teamUpdate(int team1,int updateMenu, double updateValue){
		switch (updateMenu) {
		case 1:teams[team1].setGame(updateValue);	break;
		case 2:teams[team1].setWin(updateValue);	break;
		case 3:teams[team1].setDraw(updateValue);	break;
		case 4:teams[team1].setLose(updateValue);	break;
		case 5:teams[team1].setWinningRate(updateValue);	break;
		case 6:teams[team1].setScore(updateValue);	break;
		case 7:teams[team1].setHomeRun(updateValue);	break;
		case 8:teams[team1].setStealAbase(updateValue);	break;
		case 9:teams[team1].setFourBall(updateValue);	break;
		case 10:teams[team1].setStrikeOut(updateValue);	break;
		case 11:teams[team1].setBatAver(updateValue);	break;
		case 12:teams[team1].setOnBaseAver(updateValue);	break;
		case 13:teams[team1].setSlugAver(updateValue);	break;


		default:
			break;
		}
		return teams;
	}
	
	
	
	
	
	
}
