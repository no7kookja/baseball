package teamMenu;

import java.io.IOException;

public interface Menu {
	
	void menuView();
	int menuNumSelect();
	boolean menuCheck(int start, int end, int menu);
	void messagePro(int menu) throws IOException;
	boolean menuLoop() throws IOException;
	
}
