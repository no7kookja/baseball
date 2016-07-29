package playerMenu;

public class Pitcher extends Player {
	
	private double win, lose, save, hold, blown, starting, inning,strikeOut,fourBall,homeRun;
	
	
	public Pitcher(double no, String playerName, String teamName, POSITION position, double win, double lose, double save, double hold, double blown, double game, double starting, double inning, double strikeOut, double fourBall, double homeRun){
		super(no, game, playerName, teamName, position);

		this.win = win;
		this.lose = lose;
		this.save = save;
		this.hold = hold;
		this.blown = blown;
		this.starting = starting;
		this.inning = inning;
		this.strikeOut = strikeOut;
		this.fourBall = fourBall;
		this.homeRun = homeRun;
		
	}



	public double getWin() {
		return win;
	}


	public void setWin(double win) {
		this.win = win;
	}


	public double getLose() {
		return lose;
	}


	public void setLose(double lose) {
		this.lose = lose;
	}


	public double getSave() {
		return save;
	}


	public void setSave(double save) {
		this.save = save;
	}


	public double getHold() {
		return hold;
	}


	public void setHold(double hold) {
		this.hold = hold;
	}


	public double getBlown() {
		return blown;
	}


	public void setBlown(double blown) {
		this.blown = blown;
	}


	public double getStarting() {
		return starting;
	}


	public void setStarting(double starting) {
		this.starting = starting;
	}


	public double getInning() {
		return inning;
	}


	public void setInning(double inning) {
		this.inning = inning;
	}


	public double getStrikeOut() {
		return strikeOut;
	}


	public void setStrikeOut(double strikeOut) {
		this.strikeOut = strikeOut;
	}


	public double getFourBall() {
		return fourBall;
	}


	public void setFourBall(double fourBall) {
		this.fourBall = fourBall;
	}


	public double getHomeRun() {
		return homeRun;
	}


	public void setHomeRun(double homeRun) {
		this.homeRun = homeRun;
	}
	
	
}
