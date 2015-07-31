package swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//UI: User Interface 사용자 화면 
public class LottoUI extends JFrame implements ActionListener{
	/**
	 * serialVersionUID 는 시리얼 번호로 클래스 구분 식별번호
	 */
	private static final long serialVersionUID = 1L;
	// 필드
	Lotto lotto; 
	JButton btn;
	JPanel panelNorth, panelSouth;
	ImageIcon icon;
	List<JButton> btns;
	
	//생성자 class와 같은 녀석
	public LottoUI() {
		/* 로또 화면에 들어갈 부품(객체) 만들기 (객체의 생성자) */
		setTitle("로또 발생기");
		lotto = new Lotto();
		btns = new ArrayList<JButton>();
		panelNorth = new JPanel();
		panelSouth = new JPanel();
		btn = new JButton("로또 번호 추첨");
		/*만들어진 부품(객체)들을 큰 객체(프레임객체)에 조립하기*/
		btn.addActionListener(this); // this는 큰객체인 프레임을 가리킴
		panelNorth.add(btn);
		add(panelNorth, BorderLayout.NORTH);
		add(panelSouth, BorderLayout.SOUTH);
		setBounds(300, 400, 1200, 300); // 화면에서 x좌표, y좌표, 가로, 세로 길이
		setVisible(true);
	}
	// 멤버메소드 public void 나 return값
	@Override
	public void actionPerformed(ActionEvent e) {
		//버튼객체 6개를 만들고 
		if (btns.size() == 0) {
			JButton tmp = null;
			for (int i = 0; i < 6; i++) {
				tmp = new JButton();
				btns.add(tmp);
				panelSouth.add(tmp);
			}
		}
		// 6개의 랜덤숫자를 만들고 
		lotto.setLotto();
		int[] arr = lotto.getLotto();
		/*
		 디버깅 : 프로그램을 구성하는데는 필수적인 소스는 아니지만
		 에러 발생시 에러의 원인을 파악하기 위해 붙여 둔 소스. 	
		 * */
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]+"\t");
			
		}
		// 6개의 버튼 객체에 아이콘(이미지)을 붙인다. 
		for (int i = 0; i < arr.length; i++) {
			btns.get(i).setIcon(getIcon(arr[i]));
		}
		
	}
	
	//메소드가 복잡성을 이룰 때 이를 간소화 하기 위해서
	//ALT + Shift + M으로 메소드 리팩토링을 하는데
	//지금 상황은 리팩토링을 먼저하고 나중에 그 메소드를 완성하는 기법
	private Icon getIcon(int i) {
		String imgPath = "src/images/"+Integer.toString(i)+".gif";
		return new ImageIcon(imgPath);
	} 

}
