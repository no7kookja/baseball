package playerMenu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;

import teamMenu.Team;

public class PFileManager {
	Player[] players = new Player[300];
	
	FileInputStream fis;
	ObjectInputStream ois;
	
	FileOutputStream fos;
	ObjectOutputStream oos;
	
	public Player[] txtOpen(int playerType) throws IOException{
		
		FileReader fReader = null;
		switch (playerType) {
		case 1:fReader = new FileReader("야구 선수 투구.txt");break;
		case 2:fReader = new FileReader("야구 선수 타격.txt");break;
		default:
			break;
		}
		
		BufferedReader bReader = new BufferedReader(fReader);
		String readLine = "";
		int i = 0;
		readLine = bReader.readLine();
		while ((readLine = bReader.readLine())!=null) {
			
			StringTokenizer st = new StringTokenizer(readLine, "#");
			
			double no = Double.parseDouble(st.nextToken());
			String playerName = st.nextToken();
			String teamName = st.nextToken();
			POSITION position = POSITION.valueOf(st.nextToken());

			if (position==POSITION.PITCHER) {
				players[i] = new	Pitcher(no, playerName, teamName, position,
						Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), 
						Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), 
						Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), 
						Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())); i++;
						
			} else {
				players[i] = new	Batter(no, playerName, teamName, position, 
						Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), 
						Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), 
						Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), 
						Double.parseDouble(st.nextToken())); i++;
				
			}
		
		
		}
		
		bReader.close();
		fReader.close();
		return players;
		
	}
	
	public Player[] serialOpen(int playerType){
		
		try {
			fis = new FileInputStream("playerData.txt");
			ois = new ObjectInputStream(fis);
			int size = ois.readInt();
			System.out.println("=== "+size +" 명의 선수 정보를 불러왔습니다.===");
			for (int i = 0; i < size; i++) {
				Player player = (Player)ois.readObject();
				
				if (player.getPosition()==POSITION.PITCHER) {
					players[i] = (Pitcher)player;
				} else {
					players[i] = (Batter)player;
				}
				
		}
			players[0].setSize(size);
		


			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return players;
		
	}
	
	
public void fileSave(Player[] players){
		
		try {
			fos = new FileOutputStream("playerData.txt");
			oos = new ObjectOutputStream(fos);
			
			int size = players[0].getSize();
			oos.writeInt(size);
			
			for (int i = 0; i < size; i++) {
				oos.writeObject(players[i]);
			}
			oos.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		

		
	}

}
