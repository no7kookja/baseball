package playerMenu;

import java.io.Serializable;

public class Player implements Serializable{
	private static int size;
	private double no, game;
	private String playerName, teamName;

	public Player(double no, double game, String playerName, String teamName) {
		super();
		this.no = no;
		this.game = game;
		this.playerName = playerName;
		this.teamName = teamName;
		size++;
	}

	public static int getSize() {
		return size;
	}

	public static void setSize(int size) {
		Player.size = size;
	}

	public double getNo() {
		return no;
	}

	public void setNo(double no) {
		this.no = no;
	}

	public double getGame() {
		return game;
	}

	public void setGame(double game) {
		this.game = game;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	
	
	
	
}
