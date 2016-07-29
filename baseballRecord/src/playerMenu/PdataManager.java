package playerMenu;

import java.io.IOException;

import teamMenu.TFileManager;
import teamMenu.Team;

public class PdataManager {
	
	Player[] players = new Player[600];
	PFileManager pm;
	
	private int playerType;
	
	public void setPlayerType(int plyerType) {
		this.playerType = playerType;
	}

	public Player[] txtOpen() throws IOException{
		pm = new PFileManager();
		players = pm.txtOpen(playerType);
		return players;
		
	}
	
	public Player[] serialOpen(){
		pm = new PFileManager();
		players = pm.serialOpen(playerType);
		return players;
		
	}
	
	public void fileSave(){
		if (players[0].getSize()==0) {
			System.out.println("데이터가 존재 하지 않습니다.");
		} else {
			
			pm.fileSave(players);
		}
		
	}
	
	public Player[] add(Pitcher pitcher){
		
		players[players[0].getSize()-1]=pitcher;
		return players;
		
	}
	public Player[] add(Batter batter){
		
		players[players[0].getSize()-1]=batter;
		return players;
		
	}
	
	public Player[] delete(int playerType, int deleteIndex){

		
		for (int i = deleteIndex; i < players[0].getSize()-1; i++) {
			players[i] = players[i+1];
		}
		
		players[0].setSize(players[0].getSize()-1);
		return players;
	}
	
	
	
	public Player[] update(int updateIndex,int updateMenu, String updateValue){
		if (playerType==1) {
			Pitcher pitcher = (Pitcher)players[updateIndex];
			switch (updateMenu) {
			case 1:pitcher.setTeamName(updateValue);	break;
			case 2:pitcher.setPosition(POSITION.valueOf(updateValue));	break;
			default:break;
			}
			players[updateIndex] = pitcher;
		
		} else{
			Batter batter = (Batter)players[updateIndex];
			switch (updateMenu) {
			case 1:batter.setTeamName(updateValue);	break;
			case 2:batter.setPosition(POSITION.valueOf(updateValue));	break;
			default:break;
			}
			players[updateIndex] = batter;
			
			
			
		}
		return players;
	}
	
	public Player[] update(int updateIndex,int updateMenu, double updateValue){
		
		if (playerType==1) {
			Pitcher pitcher = (Pitcher)players[updateIndex];
			switch (updateMenu) {
			case 3:pitcher.setWin(updateValue);	break;
			case 4:pitcher.setLose(updateValue);	break;
			case 5:pitcher.setSave(updateValue);	break;
			case 6:pitcher.setHold(updateValue);	break;
			case 7:pitcher.setBlown(updateValue);	break;
			case 8:pitcher.setGame(updateValue);	break;
			case 9:pitcher.setStarting(updateValue);	break;
			case 10:pitcher.setInning(updateValue);	break;
			case 11:pitcher.setStrikeOut(updateValue);	break;
			case 12:pitcher.setFourBall(updateValue);	break;
			case 13:pitcher.setHomeRun(updateValue);	break;
			default:break;
			}
			players[updateIndex] = pitcher;
		
		} else {
			Batter batter = (Batter)players[updateIndex];
			switch (updateMenu) {
			case 3:batter.setGame(updateValue);	break;
			case 4:batter.setPlateAppearance(updateValue);	break;
			case 5:batter.setAtBat(updateValue);	break;
			case 6:batter.setHit(updateValue);	break;
			case 7:batter.setHomeRun(updateValue);	break;
			case 8:batter.setScore(updateValue);	break;
			case 9:batter.setHitScore(updateValue);	break;
			case 10:batter.setFourBall(updateValue);	break;
			case 11:batter.setStrikeOut(updateValue);	break;
			case 12:batter.setStealBase(updateValue);	break;
					default:break;
			}
			players[updateIndex] = batter;
			
			
			
		}
		return players;
	}
	
			
}
