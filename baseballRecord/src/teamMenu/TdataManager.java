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
	
	FileInputStream fis;
	ObjectInputStream ois;
	
	public Team[] txtOpen() throws IOException{
		FileReader fReader = new FileReader("야구 팀 정보.txt");
		BufferedReader bReader = new BufferedReader(fReader);
		String readLine = "";
		int i = 0;
		while ((readLine = bReader.readLine())!=null) {
			StringTokenizer st = new StringTokenizer(readLine, "#");
			
			if (st.countTokens()==15) {
				teams[i] = new Team(Double.parseDouble(st.nextToken()),st.nextToken(),Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));
				i++;
			} else{
				
				System.out.println("누락된 정보가 있습니다. ");
			}
			
			
			
		}
		return teams;
		
	}
	
	
	
	
}
