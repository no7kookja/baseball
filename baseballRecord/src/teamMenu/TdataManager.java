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
	FileManager fm;
	
	public Team[] txtOpen() throws IOException{
		fm = new FileManager();
		teams = fm.txtOpen();
		return teams;
		
	}
	
	public Team[] serialOpen(){
		fm = new FileManager();
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
		System.out.println(teams[0].getSize());
		teams[0].setSize(teams[0].getSize()-1);
		System.out.println(teams[0].getSize());
		return teams;
	}
	
	
	
	
	
	
}
