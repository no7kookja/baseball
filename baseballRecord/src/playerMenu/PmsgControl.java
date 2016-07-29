package playerMenu;

import java.io.IOException;
import java.util.Scanner;

import teamMenu.Team;

public class PmsgControl {
	PdataManager pdmg;
	private int playerType; //1=투수, 2=타자
	Player[] players;
	
	public void setPlayerType(int playerType) {
		this.playerType = playerType;
	}

	public PmsgControl(PdataManager pdmg){
		
		this.pdmg = pdmg;
	}
	
	public double doubleInsert(String title){
		System.out.print(title + " 입력 : ");
		Scanner s = new Scanner(System.in);
		return s.nextDouble();
	}
	
	public String stringInsert(String title){
		System.out.print(title + " 입력 : ");
		Scanner s = new Scanner(System.in);
		return s.next();
	}
	
	public Player[] txtOpen() throws IOException{
			
			System.out.println("==============");
			System.out.println("1. txt파일");
			System.out.println("2. Serializable활용");
			
			
			int num = (int)doubleInsert("메뉴");
			if (num==1) {
				this.players = pdmg.txtOpen();
			} else if(num==2){
				this.players = pdmg.serialOpen();
				
			} else{
				
				players = txtOpen();
			}
			return players;
	}
	
	public void pitcherView(){
		if (players!=null) {
			System.out.println("=========================================================================================================");
			System.out.println("NO\t선수명\t\t팀명\t포지션\t승\t패\t세이브\t홀드\t블론\t경기\t선발\t이닝\t삼진/9\t볼넷/9\t홈런/9");
			
			System.out.println("---------------------------------------------------------------------------------------------------------");
			for (int i = 0; i < players[0].getSize(); i++) {
				if (players[i].getPosition()==POSITION.PITCHER) {
					Pitcher pitcher = (Pitcher)players[i];
					System.out.printf("%.0f\t%s\t\t%s\t%s\t%.0f\t%.0f\t%.0f\t%.0f\t%.0f\t%.0f\t%.0f\t%.1f\t%.1f\t%.2f\t%.2f\n",
							pitcher.getNo(),pitcher.getPlayerName(),pitcher.getTeamName(),pitcher.getPosition(),pitcher.getWin()
							,pitcher.getLose(),pitcher.getSave(),pitcher.getHold(),pitcher.getBlown(),pitcher.getGame(),pitcher.getStarting()
							,pitcher.getInning(),pitcher.getStrikeOut(),pitcher.getFourBall(),pitcher.getHomeRun());
				}
				
			}
			System.out.println("---------------------------------------------------------------------------------------------------------");
			
		} else {
			System.out.println("데이터가 존재 하지 않습니다. ");
			
		}
		
	}
			
	public void pitcherView(Pitcher pitcher){
		System.out.println("=========================================================================================================");
		System.out.println("NO\t선수명\t\t팀명\t포지션\t승\t패\t세이브\t홀드\t블론\t경기\t선발\t이닝\t삼진/9\t볼넷/9\t홈런/9");
		
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.printf("%.0f\t%s\t\t%s\t%s\t%.0f\t%.0f\t%.0f\t%.0f\t%.0f\t%.0f\t%.0f\t%.1f\t%.1f\t%.2f\t%.2f\n",
				pitcher.getNo(),pitcher.getPlayerName(),pitcher.getTeamName(),pitcher.getPosition(),pitcher.getWin()
				,pitcher.getLose(),pitcher.getSave(),pitcher.getHold(),pitcher.getBlown(),pitcher.getGame(),pitcher.getStarting()
				,pitcher.getInning(),pitcher.getStrikeOut(),pitcher.getFourBall(),pitcher.getHomeRun());
		
		System.out.println("---------------------------------------------------------------------------------------------------------");
	}
	
	
	
	public void batterView(){
		if (players!=null) {
			System.out.println("=========================================================================================================");
			System.out.println("NO\t선수명\t\t팀명\t포지션\t경기\t타석\t타수\t안타\t홈런\t득점\t타점\t볼넷\t삼진\t도루");
			
			System.out.println("---------------------------------------------------------------------------------------------------------");
			for (int i = 0; i < players[0].getSize(); i++) {
				if (players[i].getPosition()!=POSITION.PITCHER) {
					Batter batter = (Batter)players[i];
					System.out.printf("%.0f\t%s\t\t%s\t%s\t%.0f\t%.0f\t%.0f\t%.0f\t%.0f\t %.0f\t%.0f\t%.0f\t%.0f\t%.0f\n",
							batter.getNo(),batter.getPlayerName(),batter.getTeamName(),batter.getPosition() ,batter.getGame(),batter.getPlateAppearance()
							,batter.getAtBat(),batter.getHit(),batter.getHomeRun(),batter.getScore(),batter.getHitScore(),batter.getFourBall(),batter.getStrikeOut(),batter.getStealBase());
				}
				
			}
			System.out.println("---------------------------------------------------------------------------------------------------------");
			
		} else {
			System.out.println("데이터가 존재 하지 않습니다. ");
			
		}
		
	}
	
	public void batterView(Batter batter){
		System.out.println("=========================================================================================================");
		System.out.println("NO\t선수명\t\t팀명\t포지션\t경기\t타석\t타수\t안타\t홈런\t득점\t타점\t볼넷\t삼진\t도루");
		
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.printf("%.0f\t%s\t\t%s\t%s\t%.0f\t%.0f\t%.0f\t%.0f\t%.0f\t %.0f\t%.0f\t%.0f\t%.0f\t%.0f\n",
				batter.getNo(),batter.getPlayerName(),batter.getTeamName(),batter.getPosition() ,batter.getGame(),batter.getPlateAppearance()
				,batter.getAtBat(),batter.getHit(),batter.getHomeRun(),batter.getScore(),batter.getHitScore(),batter.getFourBall(),batter.getStrikeOut(),batter.getStealBase());
	
		System.out.println("---------------------------------------------------------------------------------------------------------");
		
		
	}
	
	public void fileSave(){
		
		pdmg.fileSave();
		
	}
	
	public POSITION positionSelect(){
		System.out.println("-------------------");
		System.out.println("포지션을 선택해주세요.");
		System.out.println("1. FIRST_BASE_FIELDER");	
		System.out.println("2. SECOND_BASE_FIELDER");
		System.out.println("3. THIRD_BASE_FIELDER");
		System.out.println("4. RIGHT_FIELDER");
		System.out.println("5. SHORTSTOP");
		System.out.println("6. LEFT_FIELDER");
		System.out.println("7. CENTER_FIELDER");
		System.out.println("8. DESIGNATED_HITTER");
		System.out.println("9. CATCHER");
	
		int poti = (int)doubleInsert("포지션");
		POSITION[] positions = POSITION.values();
		return positions[poti];
	}
	
	
	
	public void add(){
		if (players[0].getSize()<500) {
			if (playerType ==1) {
				Pitcher pitcher = new Pitcher(players[0].getSize()+1, 
						stringInsert("선수이름"), 
						stringInsert("팀 명"), 
						POSITION.PITCHER,
						doubleInsert("승리경기수"), 
						doubleInsert("패한 경기수"),
						doubleInsert("세이브 수"),
						doubleInsert("홀드 수"),
						doubleInsert("블론 세이브 수"), 
						doubleInsert("경기 수"), 
						doubleInsert("선발경기 수"), 
						doubleInsert("이닝 수"), 
						doubleInsert("삼진 수"), 
						doubleInsert("볼넷 수"), 
						doubleInsert("홈런 수"));
				
				players = pdmg.add(pitcher);
			} else if(playerType==2){
				Batter batter = new Batter(players[0].getSize()+1, 
						stringInsert("선수이름"), 
						stringInsert("팀 명"), 
						positionSelect(), 
						doubleInsert("경기 수"), 
						doubleInsert("타석 수"), 
						doubleInsert("타수 수"),
						doubleInsert("안타 수"),
						doubleInsert("홈런 수"),
						doubleInsert("득점 수"),
						doubleInsert("타점 수"),
						doubleInsert("볼넷 수"),
						doubleInsert("삼진 수"),
						doubleInsert("도루 수"));
								
				players = pdmg.add(batter);
				
			}
	
			
		} else {
			System.out.println("\n 500명을 초과하였습니다.");
			
		}
		
	}
	
	public void delete(){
		if (players!=null) {
			System.out.println("다음 리스트에서 삭제할 선수 번호를 선택하세요.");
			if (playerType==1) {
				pitcherView();
			} else{
				batterView();
			}
			int deletePlayer = (int)doubleInsert("삭제 선수 번호");
			int deleteIndex = playerIndexSearch(playerType, deletePlayer);
			
			players = pdmg.delete(playerType,deleteIndex);
			System.out.println("삭제 결과");
			
			if (playerType==1) {
				pitcherView();
			} else{
				batterView();
			}
		} else {
			System.out.println("데이터가 존재 하지 않습니다. ");
			
		}
	}
	
	public int playerIndexSearch(int playerType, int no){
		int index=-1;
		for (int i = 0; i < players[0].getSize(); i++) {
			if (playerType==1) {
				if (players[i].getPosition()==POSITION.PITCHER&&players[i].getNo()==no) {
					index = i;
				}
			} else {
				if (players[i].getPosition()!=POSITION.PITCHER&&players[i].getNo()==no) {
					index = i;
				}
				
			}
			
		}
		return index;
	}
	
	public void update(){
		if (players!=null) {
		
			System.out.println("다음 리스트에서 수정할 선수의 번호를 선택하세요");
			if (playerType==1) {
				pitcherView();
				int player = (int)doubleInsert("수정할 선수 번호");
				int updateIndex = playerIndexSearch(playerType, player);
				
				pitcherView((Pitcher)players[updateIndex]);
				int updateMenu=0;
				if (player>=0&&player<players[0].getSize()) {
					updateMenu = pitcherMenu("수정");
					if (updateMenu!=0) {
						
						String str = "";
						switch (updateMenu) {
						case 1:str="팀명";	break;
						case 2:str="포지션";	break;
						case 3:str="승수";	break;
						case 4:str="패수";	break;
						case 5:str="세이브 수";	break;
						case 6:str="홀드 수";	break;      
						case 7:str="블론 수 ";	break;
						case 8:str="경기 수";	break;
						case 9:str="선발 수";	break;
						case 10:str="이닝 수";	break;
						case 11:str="삼진/9";	break;
						case 12:str="볼넷/9";	break;
						case 13:str="홈런/9";	break;
		
						default:break;
						}
						if (updateMenu<3) {
							String updateValue = stringInsert(str);
							players = pdmg.update(updateIndex, updateMenu, updateValue);
						} else {
							double updateValue = doubleInsert(str);
							players = pdmg.update(updateIndex, updateMenu, updateValue);
						}
						
						pitcherView((Pitcher)players[updateIndex]);
						
						
					}  else {
						System.out.println(" 상위 메뉴로!");
					}
				} else {
					System.out.println(" 선수번호 잘못 입력!!");
					
				}
				
			} else{
				
				
				batterView();
				int player = (int)doubleInsert("수정할 선수 번호")-1;
				int updateIndex = playerIndexSearch(playerType, player);
				
				batterView((Batter)players[updateIndex]);
				int updateMenu=0;
				if (player>=0&&player<players[0].getSize()) {
					updateMenu = batterMenu("수정");
					if (updateMenu!=0) {
						
						String str = "";
						switch (updateMenu) {
						case 1:str="팀명";	break;
						case 2:str="포지션";	break;
						case 3:str="경기 수";	break;
						case 4:str="타석 수";	break;
						case 5:str="타수";	break;
						case 6:str="안타 수";	break;      
						case 7:str="홈런 수 ";	break;
						case 8:str="득점 수";	break;
						case 9:str="타점 수";	break;
						case 10:str="볼넷 수";	break;
						case 11:str="삼진 수";	break;
						case 12:str="도루 수";	break;
				

						default:break;
						}
						if (updateMenu<3) {
							String updateValue = stringInsert(str);
							players = pdmg.update(updateIndex, updateMenu, updateValue);
						} else {
							double updateValue = doubleInsert(str);
							players = pdmg.update(updateIndex, updateMenu, updateValue);
						}
												
						batterView((Batter)players[updateIndex]);
						
						
					}  else {
						System.out.println(" 상위 메뉴로!");
					}
				} else {
					System.out.println(" 선수번호 잘못 입력!!");
					
				}
			}
			
			
			
		} else {
			System.out.println("데이터가 존재 하지 않습니다. ");
		
	}
		
	}
	
	public int pitcherMenu(String title){
		System.out.println("=============");
		System.out.println("1. 팀명 "+title);
		System.out.println("2. 포지션 "+title);
		System.out.println("3. 승수 "+title);
		System.out.println("4. 패수 "+title);
		System.out.println("5. 세이브 수  "+title);
		System.out.println("6. 홀드 수 "+title);
		System.out.println("7. 블론 수"+title);
		System.out.println("8. 경기 수 "+title);
		System.out.println("9. 선발 수 "+title);
		System.out.println("10. 이닝 수 "+title);
		System.out.println("11. 삼진/9 "+title);
		System.out.println("12. 볼넷/9 "+title);
		System.out.println("13. 홈런/9 "+title);
		System.out.println("0. 상위 메뉴로");
		System.out.println("=============");
		int menu = (int)doubleInsert("메뉴");
		return menu;		
	}
	
	public int batterMenu(String title){
		System.out.println("=============");
		System.out.println("1. 팀명 "+title);
		System.out.println("2. 포지션 "+title);
		System.out.println("3. 경기 수 "+title);
		System.out.println("4. 타석 수 "+title);
		System.out.println("5. 타수   "+title);
		System.out.println("6. 안타 수 "+title);
		System.out.println("7. 홈런 수"+title);
		System.out.println("8. 득점 수 "+title);
		System.out.println("9. 타점 수 "+title);
		System.out.println("10. 볼넷 수 "+title);
		System.out.println("11. 삼진 수 "+title);
		System.out.println("12. 도루 수 "+title);
		System.out.println("0. 상위 메뉴로");
		System.out.println("=============");
		int menu = (int)doubleInsert("메뉴");
		return menu;		
	}
	
	
	
	
	
}
