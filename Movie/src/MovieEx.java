import java.awt.*; // awt기능 묶어서 허용 (가독성) 이하 동일
import java.awt.event.*;
import java.net.*;
import javax.swing.*;

public class MovieEx extends JFrame{
	/*패널1*/
	static JButton[] btn = new JButton[25];
	String [] btntext = {"A1","A2","A3","A4","A5","B1","B2","B3","B4","B5","C1","C2","C3","C4","C5","D1","D2","D3","D4","D5","E1","E2","E3","E4","E5"}; // 텍스트 배열
	int [] btnColor = new int[25]; // 컬러 구분해 주는 배열
	int [] btnCount = new int[25];//버튼 예약후에 클릭하면 안되는걸 세어주는 배열	
	int [] seatCount = {25,25,25};//남은 좌석 배열

	int count=0;//없어도 됨
	
	//폰트 설정 Font(폰트이름,폰트 스타일 , 폰트 크기)
	Font font = new Font("helvitica", Font.BOLD, 50);
	Font font2 = new Font("helvitica", Font.BOLD, 20);
	Font font3 = new Font("helvitica", Font.BOLD, 100);
	//라벨 
	JLabel text = new JLabel();
	JLabel text2 = new JLabel();
	JLabel text3 = new JLabel();
	JLabel text4 = new JLabel();
	JLabel text5 = new JLabel();
	
	//텍스트아리아 
	JTextArea summary  = new JTextArea();
	//패널
	JPanel page = new JPanel();
	JPanel page1 = new JPanel();
	//버튼
	JButton am10 = new JButton("10시");
	JButton pm15 = new JButton("15시");
	JButton pm20 = new JButton("20시");

	JButton bt = new JButton("영화표 구매");
	JButton b = new JButton("예약 취소");
	JButton b2 = new JButton("뒤로가기");
	//라벨
	JLabel poster = new JLabel();

	//마우스 한번만 클릭하게 해주는 것 submit을 false로 둬서 한번 실행하게 한뒤에 submit을 true로 변경하여 실행되지 않게한다.
	boolean submit = false;
	boolean clickSubmit() {

		if(submit){
			return submit;
		}else{
			submit = true;
			return false;
		}
	}
	
	boolean submit2 = false;
	boolean clickSubmit2() {

		if(submit2){
			return submit2;
		}else{
			submit2 = true;
			return false;
		}
	}


	void firstMain() {
		setTitle("영화 예매 프로그램");    
		setLayout(null);//위치와 크기 조절 가능하게 해준다.
		page.setLayout(null);//레이아웃배치관리자값을 null 값으로 준것임(위치와 크기 조절 가능하게 해준다.)
		setSize(600,435);//프레임의 크기
		setResizable(false);//창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);//창이 가운데 나오게
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //모든 프레임 종료시
		setVisible(true);//창이 보이게	
		page.setBounds(0, 0, 600, 435);//해당 컴포넌트의 절대 위치와 크기 지정 setBounds(x좌표,y좌표,가로길이,세로길이)
		bt.setBounds(182, 140, 245, 100);
		page.add(bt);
		bt.setBorderPainted(false);//버튼 테두리 설정
		bt.setBackground(new Color(8,18,27));//해당 컴포넌트의 배경의 색깔을 지정
		bt.setForeground(Color.white);//해당 컴포넌트의 글자색을 변경
		//bt.setContentAreaFilled(false);
		//bt.setFocusPainted(false);
		add(page);

		try {
			//setIcon 메소드를 사용하여 해당 이미지를 URL 값으로 가져온다.
			poster.setIcon(new ImageIcon(new URL("https://st2.depositphotos.com/1758336/5895/i/600/depositphotos_58955513-stock-photo-empty-movie-theater-with-red.jpg")));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		page.add(poster);
		add(page);
		poster.setBounds(0, -50, 800, 500);

	}

	void firstClick() {
		bt.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				//리스트 나오는 부분
				dispose();
				//스레드로 스윙 충돌을 막아준다. 
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new MovieList();

					}
				});

			}

		});
	}

	public MovieEx() {

	}

}
