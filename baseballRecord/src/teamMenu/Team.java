package teamMenu;

import java.io.Serializable;

public class Team implements Serializable{
	
	private static int count, size;
	private double  num, game, win, draw, 
		lose, winningRate, score, homeRun, stealAbase, 
		fourBall, strikeOut, batAver, onBaseAver, slugAver;

	private String teamName;

	public Team(double num, String teamName, double game, double win, double draw, double lose,
			double winningRate, double score, double homeRun,
			double stealAbase, double fourBall, double strikeOut,
			double batAver, double onBaseAver, double slugAver ) {
		super();
		this.num = num;
		this.game = game;
		this.win = win;
		this.draw = draw;
		this.lose = lose;
		this.winningRate = winningRate;
		this.score = score;
		this.homeRun = homeRun;
		this.stealAbase = stealAbase;
		this.fourBall = fourBall;
		this.strikeOut = strikeOut;
		this.batAver = batAver;
		this.onBaseAver = onBaseAver;
		this.slugAver = slugAver;
		this.teamName = teamName;
		this.count++;
		this.size++;
	}
	
//	public Team(Team team){
//		super();
//		this.num = team.getNum();
//		this.game = team.getGame();
//		this.win = team.getWin();
//		this.draw = team.getDraw();
//		this.lose = team.getLose();
//		this.winningRate = team.getWinningRate();
//		this.score = team.getScore();
//		this.homeRun = team.getHomeRun();
//		this.stealAbase = team.getStealAbase();
//		this.fourBall = team.getFourBall();
//		this.strikeOut = team.getStrikeOut();
//		this.batAver = team.getBatAver();
//		this.onBaseAver = team.getOnBaseAver();
//		this.slugAver = team.getSlugAver();
//		this.teamName = team.getTeamName();
//		
//	}

	

	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	public int getSize() {
		return size;
	}



	public void setSize(int size) {
		this.size = size;
	}



	public double getNum() {
		return num;
	}

	public void setNum(double num) {
		this.num = num;
	}

	public double getGame() {
		return game;
	}

	public void setGame(double game) {
		this.game = game;
	}

	public double getWin() {
		return win;
	}

	public void setWin(double win) {
		this.win = win;
	}

	public double getDraw() {
		return draw;
	}

	public void setDraw(double draw) {
		this.draw = draw;
	}

	public double getLose() {
		return lose;
	}

	public void setLose(double lose) {
		this.lose = lose;
	}

	public double getWinningRate() {
		return winningRate;
	}

	public void setWinningRate(double winningRate) {
		this.winningRate = winningRate;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public double getHomeRun() {
		return homeRun;
	}

	public void setHomeRun(double homeRun) {
		this.homeRun = homeRun;
	}

	public double getStealAbase() {
		return stealAbase;
	}

	public void setStealAbase(double stealAbase) {
		this.stealAbase = stealAbase;
	}

	public double getFourBall() {
		return fourBall;
	}

	public void setFourBall(double fourBall) {
		this.fourBall = fourBall;
	}

	public double getStrikeOut() {
		return strikeOut;
	}

	public void setStrikeOut(double strikeOut) {
		this.strikeOut = strikeOut;
	}

	public double getBatAver() {
		return batAver;
	}

	public void setBatAver(double batAver) {
		this.batAver = batAver;
	}

	public double getOnBaseAver() {
		return onBaseAver;
	}

	public void setOnBaseAver(double onBaseAver) {
		this.onBaseAver = onBaseAver;
	}

	public double getSlugAver() {
		return slugAver;
	}

	public void setSlugAver(double slugAver) {
		this.slugAver = slugAver;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	
	
	
	
}
