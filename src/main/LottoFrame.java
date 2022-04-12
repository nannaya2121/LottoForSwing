package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class LottoFrame extends JFrame {

	private JPanel contentPane;
	
	public LottoFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(2000, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel one = new JLabel("돈");
		one.setFont(new Font("Dialog", Font.BOLD, 30));
		one.setHorizontalAlignment(SwingConstants.CENTER);
		one.setBounds(59, 46, 100, 100);
		BevelBorder border=new BevelBorder(BevelBorder.RAISED);//3차원적인 테두리 효과를 위한것이고 양각의 옵션을 준다.
		one.setBorder(border);//라벨에 적용시킨다.
		contentPane.add(one);
		
		JLabel two = new JLabel("을");
		two.setFont(new Font("Dialog", Font.BOLD, 30));
		two.setHorizontalAlignment(SwingConstants.CENTER);
		two.setBorder(border);
		two.setBounds(174, 46, 100, 100);
		contentPane.add(two);
		
		JLabel three = new JLabel("법");
		three.setFont(new Font("Dialog", Font.BOLD, 30));
		three.setHorizontalAlignment(SwingConstants.CENTER);
		three.setBounds(286, 46, 100, 100);
		three.setBorder(border);
		contentPane.add(three);
		
		JLabel four = new JLabel("시");
		four.setFont(new Font("Dialog", Font.BOLD, 30));
		four.setHorizontalAlignment(SwingConstants.CENTER);
		four.setBounds(401, 46, 100, 100);
		four.setBorder(border);
		contentPane.add(four);
		
		JLabel five = new JLabel("다");
		five.setFont(new Font("Dialog", Font.BOLD, 30));
		five.setHorizontalAlignment(SwingConstants.CENTER);
		five.setBounds(513, 46, 100, 100);
		five.setBorder(border);
		contentPane.add(five);
		
		JLabel six = new JLabel("!!!");
		six.setFont(new Font("Dialog", Font.BOLD, 30));
		six.setHorizontalAlignment(SwingConstants.CENTER);
		six.setBounds(628, 46, 100, 100);
		six.setBorder(border);
		contentPane.add(six);
		
		JButton choiceBtn = new JButton("로또번호 생성하기");
		choiceBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Set<Integer> set = new HashSet<Integer>();

		        for (int i = 0; set.size() < 6; ++i) {
		            int num = (int) (Math.random()*45) + 1;
		            set.add((num));
		        }

		        System.out.println("set >>> " + set);

		        List<Integer> list = new ArrayList<Integer>(set);
		        Collections.sort(list);
		        
		        one.setText(Integer.toString(list.get(0)));
		        two.setText(Integer.toString(list.get(1)));
		        three.setText(Integer.toString(list.get(2)));
		        four.setText(Integer.toString(list.get(3)));
		        five.setText(Integer.toString(list.get(4)));
		        six.setText(Integer.toString(list.get(5)));
				
			}
		});
		choiceBtn.setFont(new Font("Dialog", Font.BOLD, 30));
		choiceBtn.setBounds(174, 204, 439, 76);
		contentPane.add(choiceBtn);
		
	}
}
