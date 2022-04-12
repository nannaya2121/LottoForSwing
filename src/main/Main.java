package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import db.MySQLDB;

@SuppressWarnings("serial")
public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField idInputField;
	private JTextField pwInputField;
	private JButton loginBtn;
	private JButton memRegBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(2000, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel loginLabel = new JLabel("로그인");
		loginLabel.setOpaque(true);
		loginLabel.setBackground(Color.PINK);
		loginLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setBounds(166, 75, 266, 82);
		contentPane.add(loginLabel);
		
		idInputField = new JTextField();
		idInputField.setBounds(166, 190, 159, 51);
		idInputField.setColumns(10);
		contentPane.add(idInputField);
		
		pwInputField = new JPasswordField();
		pwInputField.setColumns(10);
		pwInputField.setBounds(166, 253, 159, 51);
		contentPane.add(pwInputField);
		
		loginBtn = new JButton("로그인");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String loginID = idInputField.getText();
				String loginPW = pwInputField.getText();
				
				System.out.println("loginID 값 : " + loginID);
				System.out.println("loginPW 값 : " + loginPW);
				
				MySQLDB db = new MySQLDB();
				int loginResult = db.login(loginID, loginPW);
				if(loginResult == 1000) {
					LottoFrame lf = new LottoFrame();
					lf.setVisible(true);
					setVisible(false);
					System.out.println("로그인 성공했으니 다른창을 띄워주세요");
				}else {
					JOptionPane.showMessageDialog(contentPane, "아이디나 비밀번호가 틀립니다.", "로그인 불가", 
							JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		loginBtn.setBounds(353, 190, 79, 110);
		contentPane.add(loginBtn);
		
		memRegBtn = new JButton("회원가입");
		memRegBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistFrame rf = new RegistFrame();
				rf.setVisible(true);
				setVisible(false);
			}
		});
		memRegBtn.setBounds(166, 325, 266, 44);
		contentPane.add(memRegBtn);
		
		
	}
}
