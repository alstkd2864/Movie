import javax.swing.*;
public class BusinessMain{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieEx e = new MovieEx(); // 무비클래스를 인스턴스화시킴, 실행을위해
		try {
			//많이어두운느낌
			//UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
			//어두운느낌
			//느낌있는 ui를 위해서 lookandfeel을 사용한다.
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
			//테두리만 어두운느낌
			//UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		e.firstMain();
		e.firstClick(); 

	}
}
