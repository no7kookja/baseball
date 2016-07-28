package playerMenu;

public class Pitcher extends Player {
	private POSITION position = POSITION.PITCHER;
	private double win, lose, save, hold, blown, game,starting, inning,strikeOut,fourBall,homeRun;
	
	
	public Pitcher(double no, String playerName, String teamName, POSITION position, double win, double lose, double save, double hold, double blown, double game, double starting, double inning, double strikeOut, double fourBall, double homeRun){
		super(no, game, playerName, teamName);
		this.position = position;
		
		
	}
}
