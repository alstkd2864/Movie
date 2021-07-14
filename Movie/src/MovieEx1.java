import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;

public class MovieEx1 extends MovieEx implements test {
	private int reset;
	
	@Override
	public void seat() {
		// TODO Auto-generated method stu
		for(int i=0;i<btntext.length;i++) {		
			btn[i]=new JButton(btntext[i]);//버튼 초기화
			//btn2[i].setBackground();//백그라운드를 0,0,0,0으로 설정한다.
			if(btnColor[i] ==0) {
				btn[i].setForeground(Color.gray);
			}
			else if(btnColor[i]==1) {
				btn[i].setForeground(Color.red);
			}
			btn[i].setVisible(true);//보이게

			//btn2[i].setFont(font1);//폰트설정
			//btn2[i].setForeground(Color.gray);
			btn[i].setBorderPainted(false);// 버튼 테두리 설정
			btn[i].setContentAreaFilled(false);// 내용영역 채우기 안함
			btn[i].setFocusPainted(false);//버튼이 선택 되었을때 생기는 테두리 사용 안함
			page1.add(btn[i]);//프레임에 버튼 추가

		}
		add(page1);
		btn[0].setBounds(100,100, 80, 80); //버튼 크기,위치 지정
		btn[1].setBounds(200,100, 80, 80);//버튼 크기, 위치 지정
		btn[2].setBounds(300,100, 80, 80);//버튼 크기, 위치 지정*/
		btn[3].setBounds(400,100, 80, 80);
		btn[4].setBounds(500,100, 80, 80);
		
		btn[5].setBounds(100,200, 80, 80);
		btn[6].setBounds(200,200, 80, 80);
		btn[7].setBounds(300,200, 80, 80);
		btn[8].setBounds(400,200, 80, 80);
		btn[9].setBounds(500,200, 80, 80);

		btn[10].setBounds(100,300, 80, 80);
		btn[11].setBounds(200,300, 80, 80);
		btn[12].setBounds(300,300, 80, 80);
		btn[13].setBounds(400,300, 80, 80);
		btn[14].setBounds(500,300, 80, 80);

		btn[15].setBounds(100,400, 80, 80);
		btn[16].setBounds(200,400, 80, 80);
		btn[17].setBounds(300,400, 80, 80);
		btn[18].setBounds(400,400, 80, 80);
		btn[19].setBounds(500,400, 80, 80);
		
		btn[20].setBounds(100,500, 80, 80);
		btn[21].setBounds(200,500, 80, 80);
		btn[22].setBounds(300,500, 80, 80);
		btn[23].setBounds(400,500, 80, 80);
		btn[24].setBounds(500,500, 80, 80);
		
		//예약취소 	
		b.setBounds(200, 570, 100, 80);
		page1.add(b);
		add(page1);
		b.setBorderPainted(false);
		b.setContentAreaFilled(false);
		b.setFocusPainted(false);
		b.setVisible(true);
		//뒤로가기
		b2.setBounds(400, 570, 100, 80);
		page1.add(b2);
		add(page1);
		b2.setBorderPainted(false);
		b2.setContentAreaFilled(false);
		b2.setFocusPainted(false);
		b2.setVisible(true);

		text5.setText("S c r e e n");
		page1.add(text5);
		add(page1);
		text5.setBounds(100, 10, 800, 80);
		text5.setFont(font3);	
	}

	@Override
	public void click() {
		
		
	}
	//제일먼저 나온다..
	@Override
	public void rePaint() {
		//패널 바뀔때 사용
		page1.removeAll();
		page1.revalidate();
		page1.repaint();	

		setLayout(null);//위치와 크기 조절 가능하게 해준다.
		page1.setLayout(null);
	
		setTitle("영화 좌석");
		setSize(700,700);//프레임의 크기
		//setResizable(false);//창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);//창이 가운데 나오게
		page1.setBounds(0, 0, 700, 700);
		setVisible(true);//창이 보이게	

		seat();   		
		seatClick();
	}

	@Override
	public  void seatClick() {
		int i;
		for(i=0;i<btn.length;i++) {
			int j = i;	

			btn[i].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					int gubun;
					gubun=1;
					int cnt=0;
					btnCount[j]++;

					if(btnCount[j]>1) {
						JOptionPane.showMessageDialog(null,"이미 예약되어있는 자리입니다.");
					}
					else{	
						
						String reservation =JOptionPane.showInputDialog("예약하실 이름을 입력해 주세요");
						if((reservation != null)&&(reservation.length()>0)) {
							btn[j].setText(reservation);
							btntext[j] = reservation;
							btn[j].setForeground(Color.red);
							btnColor[j] = gubun;	

							if(reset == 1 ) {
								seatCount[0]-=1;
								
							}
							else if(reset == 2) {
								seatCount[1]-=1;
								
							}
							else if(reset == 3) {
								seatCount[2]-=1;
								
							}

						}
						else{
							btn[j].setText(btntext[j]);
							btnCount[j]= 0;
						}

					}	
				}

			});
		}
	}	

	@Override
	public void reservationOut() {
		b.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				boolean run2 = false;

				String reservation2 =JOptionPane.showInputDialog("예약을 취소하실 이름을 입력해주세요");
				for(int i =0;i<btntext.length;i++) {  
					if(btntext[i].equals(reservation2)) {			
						btnCount[i]= 0;
						btnColor[i]=0;
						btntext[i] = "취소";
						btn[i].setText(btntext[i]);
						btn[i].setForeground(Color.gray);
						run2=true;
						//break;
						submit =false;
						System.out.println(submit);
						if(reset == 1 ) {
							seatCount[0]+=1;
						
						}
						else if(reset == 2) {
							seatCount[1]+=1;
						
						}
						else if(reset == 3) {
							seatCount[2]+=1;
					
						}
					} 
				}
				if(!run2){
					JOptionPane.showMessageDialog(null,"예약자명을 잘못입력하셨거나 아무것도 입력하지 않으셨습니다.");
					submit =false;
					System.out.println(submit);
				}
			}         
		});
	}

	@Override
	public void backClick() {

		b2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
		
				dispose();

			}         
		});
	}

	public MovieEx1() {

	}
	public MovieEx1(int reset) {
		this.reset = reset;
	}

}
