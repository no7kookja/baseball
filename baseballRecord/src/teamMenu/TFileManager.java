package teamMenu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;

public class TFileManager {
	Team[] teams = new Team[10];
	
	FileInputStream fis;
	ObjectInputStream ois;
	
	FileOutputStream fos;
	ObjectOutputStream oos;
	
	public Team[] txtOpen() throws IOException{
		FileReader fReader = new FileReader("�߱� �� ����.txt");
		BufferedReader bReader = new BufferedReader(fReader);
		String readLine = "";
		int i = 0;
		while ((readLine = bReader.readLine())!=null) {
			StringTokenizer st = new StringTokenizer(readLine, "#");
			
			if (st.countTokens()==15) {
				teams[i] = new Team(Double.parseDouble(st.nextToken()),st.nextToken(),Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));
				i++;
			} else{
				
				System.out.println("������ ������ �ֽ��ϴ�. ");
			}
			
		}
		
		bReader.close();
		fReader.close();
		return teams;
		
	}
	
	public Team[] serialOpen(){
		
		try {
			fis = new FileInputStream("teamData.txt");
			ois = new ObjectInputStream(fis);
			int size = ois.readInt();
			System.out.println("=== "+size +" ���� ���� ������ �ҷ��Խ��ϴ�.===");
			for (int i = 0; i < size; i++) {
				teams[i] = (Team)ois.readObject();
				
			}
			teams[0].setSize(size);
		


			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return teams;
		
	}
	
	public void fileSave(Team[] teams){
		
		try {
			fos = new FileOutputStream("teamData.txt");
			oos = new ObjectOutputStream(fos);
			
			int size = teams[0].getSize();
			oos.writeInt(size);
			
			for (int i = 0; i < size; i++) {
				oos.writeObject(teams[i]);
			}
			oos.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		

		
	}



}
