package playerMenu;

public class Batter extends Player {
	
	private double plateAppearance,atBat,hit, homeRun, score, hitScore, fourBall,strikeOut,stealBase;

	
	
	public Batter(double no, String playerName, String teamName, POSITION position, double game, double plateAppearance,double atBat,double hit, double homeRun, double score, double hitScore, double fourBall,double strikeOut,double stealBase){
		super(no, game, playerName, teamName, position);

		this.plateAppearance =plateAppearance;
		this.atBat=atBat;
		this.hit=hit; 
		this.homeRun=homeRun; 
		this.score=score; 
		this.hitScore=hitScore; 
		this.fourBall=fourBall;
		this.strikeOut=strikeOut;
		this.stealBase=stealBase;
	}







	public double getPlateAppearance() {
		return plateAppearance;
	}



	public void setPlateAppearance(double plateAppearance) {
		this.plateAppearance = plateAppearance;
	}



	public double getAtBat() {
		return atBat;
	}



	public void setAtBat(double atBat) {
		this.atBat = atBat;
	}



	public double getHit() {
		return hit;
	}



	public void setHit(double hit) {
		this.hit = hit;
	}



	public double getHomeRun() {
		return homeRun;
	}



	public void setHomeRun(double homeRun) {
		this.homeRun = homeRun;
	}



	public double getScore() {
		return score;
	}



	public void setScore(double score) {
		this.score = score;
	}



	public double getHitScore() {
		return hitScore;
	}



	public void setHitScore(double hitScore) {
		this.hitScore = hitScore;
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



	public double getStealBase() {
		return stealBase;
	}



	public void setStealBase(double stealBase) {
		this.stealBase = stealBase;
	}
	
	
	
}
