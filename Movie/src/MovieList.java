import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
public class MovieList{
	private final Map<String, ImageIcon> imageMap; // 이미지와 함께 스트링을 가지도록 하고 싶다면 맵을 이용하여 데이터를 관리할 필요가 있다.
	public MovieList() {
		firstEx01 ex = new firstEx01();
		firstEx02 ex2 = new firstEx02();
		firstEx03 ex3 = new firstEx03();
		firstEx04 ex4 = new firstEx04();
		firstEx05 ex5 = new firstEx05();
		
		String[] nameList = {"귀멸의 칼날", "미나리", "소울", "라야", "리스타트"}; // 5개의 영화 추가
		//위에 선언한 이미지 맵에 createImageMap(String[] list)메소드 값 넣기
		imageMap = createImageMap(nameList);
		//리스트 생성
		JList list = new JList(nameList);
		//리스트의
		list.setCellRenderer(new MovieListRenderer());

		JScrollPane scroll = new JScrollPane(list);
		scroll.setPreferredSize(new Dimension(800, 800));

		JFrame frame = new JFrame();
		frame.add(scroll);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setTitle("영화 리스트");  
		frame.setVisible(true);

		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {

				if(list.isSelectedIndex(0)) {	
					ex.rePaint();
					if(ex.clickSubmit()) return;{
						ex.reservationOut();
					}	
					System.out.println("----------경계선 --------------");
				}
				else if(list.isSelectedIndex(1)) {

					ex2.page1.removeAll();		
					ex2.rePaint();// 내가 만든 리페인트	
					if(ex2.clickSubmit()) return;{
						ex2.reservationOut();
					}

					System.out.println("----------경계선2--------------");
					ex2.submit=false;
					ex2.submit2=false;
				}
				else if(list.isSelectedIndex(2)) {  // 영화리스트에서 3번영화눌를때 이미지출력~

					ex3.page1.removeAll();		
					ex3.rePaint();// 내가 만든 리페인트	
					if(ex3.clickSubmit()) return;{
						ex3.reservationOut();
					}

					System.out.println("----------경계선3--------------");
					ex3.submit=false;
					ex3.submit2=false;
				}	else if(list.isSelectedIndex(3)) {  // 영화리스트에서 4번영화눌를때 이미지출력~

					ex4.page1.removeAll();		
					ex4.rePaint();// 내가 만든 리페인트	
					if(ex4.clickSubmit()) return;{
						ex4.reservationOut();
					}

					System.out.println("----------경계선4--------------");
					ex4.submit=false;
					ex4.submit2=false;
				}	else if(list.isSelectedIndex(4)) {  // 영화리스트에서 4번영화눌를때 이미지출력~

					ex5.page1.removeAll();		
					ex5.rePaint();// 내가 만든 리페인트	
					if(ex4.clickSubmit()) return;{
						ex4.reservationOut();
					}

					System.out.println("----------경계선5--------------");
					ex5.submit=false;
					ex5.submit2=false;
				}

			}
		});   
	}
	//DefaultListCellRenderer 셀 안에 들어가는 데이터의 정렬을 조절
	//즉 리스트내에 항목에 사용하는 디폴트의 렌더링 객체를 구축
	public class MovieListRenderer extends DefaultListCellRenderer {

		Font font = new Font("helvitica", Font.BOLD, 50);


		@Override
		public Component getListCellRendererComponent( //getListCellRendererComponent메서드를 사용하여 지정된 값을 표시하도록 설정된 컴퍼넌트를 리턴한다
				JList list, Object value, int index,
				boolean isSelected, boolean cellHasFocus) {

			JLabel label = (JLabel) super.getListCellRendererComponent(
					list, value, index, isSelected, cellHasFocus);
			label.setIcon(imageMap.get((String) value));
			label.setHorizontalTextPosition(JLabel.RIGHT);//라벨 글자의 수평 위치 변경하기
			label.setFont(font);
			// Color b = new Color(120,225,0);
			//  label.setBackground(b);
			return label;
		}
	}

	//해쉬맵 메소드를 만들어서 사용한다.
	// key 값으로 value값 사용
	private Map<String, ImageIcon> createImageMap(String[] list) {
		Map<String, ImageIcon> map = new HashMap<>();
		try {
			map.put("귀멸의 칼날", new ImageIcon(new URL("https://movie-phinf.pstatic.net/20210126_174/1611638248803840HH_JPEG/movie_image.jpg?type=m665_443_2")));
			map.put("미나리", new ImageIcon(new URL("https://movie-phinf.pstatic.net/20210303_117/1614748615541W5Yoz_JPEG/movie_image.jpg?type=m665_443_2")));
			map.put("소울", new ImageIcon(new URL("https://movie-phinf.pstatic.net/20210107_160/1609984702837oNdmw_JPEG/movie_image.jpg?type=m665_443_2")));
			map.put("라야", new ImageIcon(new URL("https://movie-phinf.pstatic.net/20210215_30/1613366376318deAa1_JPEG/movie_image.jpg?type=m665_443_2")));
			map.put("리스타트", new ImageIcon(new URL("https://movie-phinf.pstatic.net/20210218_140/1613615349840eEK4k_JPEG/movie_image.jpg?type=m665_443_2")));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}
}