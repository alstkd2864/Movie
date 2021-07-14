import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;

public class firstEx01 extends MovieEx implements test {

	//객체를 배열로 받아서 객체화함
	MovieEx1 [] ex = {new MovieEx1(1),new MovieEx1(2),new MovieEx1(3)};


	@Override
	public void seat() {

	}

	@Override
	public void click() {
		//버튼 클릭 리스너 사용
		am10.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				dispose();//해당 창을 닫기
				ex[0].rePaint();
				ex[0].backClick();
				if(ex[0].clickSubmit2())return;{	
					ex[0].reservationOut();
				}
				ex[0].submit =false;

			}
		}); 

		pm15.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {

				dispose();
				ex[1].rePaint();
				ex[1].backClick();

				if(ex[1].clickSubmit2())return;{		
					ex[1].reservationOut();
				}

			}
		});

		pm20.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {

				dispose();
				ex[2].rePaint();
				ex[2].backClick();

				if(ex[2].clickSubmit2())return;{
					
					ex[2].reservationOut();
				}
			}
		});  
	}
	//제일먼저 나온다..
	@Override
	public void rePaint() {
		// TODO Auto-generated method stub
		setTitle("영화 설명"); //해당 창의 타이틀 설정
		setLayout(null);//위치와 크기 조절 가능하게 해준다.
		page1.setLayout(null);
		//부모에 들어있는 btn을 가져 와서 사용
		am10.setBounds(400, 450, 100, 50);
		page1.add(am10);
		add(page1);

		pm15.setBounds(600, 450, 100, 50);
		page1.add(pm15);
		add(page1);

		pm20.setBounds(800, 450, 100, 50);
		page1.add(pm20);
		add(page1);

		//페이지에 uml 이미지 가져오는 방법
		try {
			poster.setIcon(new ImageIcon(new URL("https://movie-phinf.pstatic.net/20210126_174/1611638248803840HH_JPEG/movie_image.jpg?type=m665_443_2"))); //영화설명의 이미지란 ,
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}		
		page1.add(poster);
		add(page1);
		poster.setBounds(50, 30, 500, 500);

		text.setText("귀멸의 칼날"); // 영화설명의 제목
		page1.add(text);
		add(page1);
		text.setBounds(500, 60, 300, 80);
		text.setFont(font);

		text2.setText("남은 좌석:"+ex[0].seatCount[0]);
		page1.add(text2);
		add(page1);
		text2.setBounds(410,400,100,50);


		text3.setText("남은 좌석:"+ex[1].seatCount[1]);
		page1.add(text3);
		add(page1);
		text3.setBounds(610,400,100,50);

		text4.setText("남은 좌석:"+ex[2].seatCount[2]);
		page1.add(text4);
		add(page1);
		text4.setBounds(810,400,100,50);

		summary.setText("줄거리:혈귀로 변해버린 여동생 ‘네즈코’를  \r\n" + 
				"인간으로 되돌릴 단서를 찾아 비밀조직 귀살대에 들어간 ‘탄지로.’\r\n" + 
				"‘젠이츠’,‘이노스케’와 새로운 임무 수행을 위해 무한열차에 탑승 후\r\n" + 
				" 귀살대 최강 검사 염주 ‘렌고쿠’와 합류한다.\r\n" + 

				" 달리는 무한열차에서 승객들이 하나 둘 흔적 없이 사라지자\r\n" + 
				" 숨어있는 식인 혈귀의 존재를 직감하는 ‘렌고쿠’.\r\n" + 

				" 귀살대 ‘탄지로’ 일행과 최강 검사 염주 ‘렌고쿠’는\r\n" + 
				" 어둠 속을 달리는 무한열차에서 모두의 목숨을 구하기 위해\r\n" + 
				" 예측불가능한 능력을 가진 혈귀와 목숨을 건 혈전을 시작하는데…");
		page1.add(summary);
		add(page1);
		summary.setBounds(380, 130, 600, 250);
		summary.setFont(font2);//해당 컴포넌트의 폰트를 바꿔준다.
		summary.setBorder(null);//해당 컴포넌트의	 경계선를 없애준다
		summary.setFocusable(false); // 해당 컴포넌트의 포커스를 false로 강제 지정
		summary.setBackground(null);


		setSize(1000,600);//프레임의 크기
		setResizable(false);//창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);//창이 가운데 나오게
		setVisible(true);//창이 보이게	
		page1.setBounds(0, 0, 1000, 600);
		
		if(clickSubmit()) return;{
			click();
		}
		submit =false;
	}

	@Override
	public  void seatClick() {


	}	

	@Override
	public void reservationOut() {

	}

	@Override
	public void backClick() {

	}

	public firstEx01() {

	}



}
