package main;

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
public class RegistFrame extends JFrame {
	
	private JPanel contentPane;
	private JTextField idField;
	private JPasswordField passwordField;
	private JPasswordField rePasswordField;
	
	public RegistFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(2000, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JButton returnBaseBtn = new JButton("돌아가기");
		returnBaseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				Main main = new Main();
				main.setVisible(true);
				
			}
		});
		returnBaseBtn.setBounds(204, 391, 185, 47);
		contentPane.add(returnBaseBtn);
		
		JLabel regLabel = new JLabel("회원가입");
		regLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		regLabel.setHorizontalAlignment(SwingConstants.CENTER);
		regLabel.setBounds(173, 29, 216, 53);
		contentPane.add(regLabel);
		
		JLabel idLabel = new JLabel("아이디");
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		idLabel.setBounds(188, 83, 88, 30);
		contentPane.add(idLabel);
		
		idField = new JTextField();
		idField.setBounds(198, 116, 181, 28);
		contentPane.add(idField);
		idField.setColumns(10);
		
		JLabel pwLabel = new JLabel("비밀번호");
		pwLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pwLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		pwLabel.setBounds(188, 156, 88, 30);
		contentPane.add(pwLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(198, 198, 191, 28);
		contentPane.add(passwordField);
		
		rePasswordField = new JPasswordField();
		rePasswordField.setBounds(198, 280, 191, 28);
		contentPane.add(rePasswordField);
		
		JLabel rePwLabel = new JLabel("비밀번호 확인");
		rePwLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rePwLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		rePwLabel.setBounds(188, 238, 119, 30);
		contentPane.add(rePwLabel);
		
		JButton registBtn = new JButton("회원가입");
		registBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean idFix = false;
				boolean pwFix = false;
				
				//아이디 유효성 검사 완료
				String id = idField.getText();
				
				String resultID = id.trim().replaceAll(" ", "");
				//int resultLeng = resultID.length();
				String onlyEng = resultID.replaceAll("[^a-zA-Z0-9]", "");
				
				MySQLDB db1 = new MySQLDB();
				boolean idDuplicate = db1.idDup(onlyEng);
				
				if(idDuplicate == true) {
					idField.setText("");
					passwordField.setText("");
					rePasswordField.setText("");
					JOptionPane.showMessageDialog(contentPane, "아이디가 중복됩니다.", "회원가입 불가", 
							JOptionPane.WARNING_MESSAGE);
				}
				
				
//				System.out.println("입력된 ID값 : "+resultID);
//				System.out.println("입력된 ID 길이 : "+resultLeng);
				System.out.println("영어로만 입력된 아이디 : " + onlyEng);
				System.out.println("영어로만 입력된 아이디 길이: " + onlyEng.length());
				
				if(onlyEng.length()>0) {
					System.out.println("영어로만 이루어진 올바른 아이디 입니다.");
					System.out.println("DB에 저장될 아이디 : " + onlyEng);
					idFix = true;
				}else {
					System.out.println("영어가 아닌 다른 문자가 섞여 있습니다.");
					JOptionPane.showMessageDialog(contentPane, "영어로만 아이디를 입력해주세요.", "회원가입 불가", 
							JOptionPane.WARNING_MESSAGE);
				}
				
				
				
				// 패스워드 유효성 검사 완료
				String pw = passwordField.getText();
				String rePw = rePasswordField.getText();
				
				System.out.println("첫번째 PW 값 : " + pw);
				System.out.println("두번째 PW 값 : " + rePw);
				
				if(pw == null || pw.equals("")) {
					System.out.println("비밀번호가 비었습니다.");
					JOptionPane.showMessageDialog(contentPane, "비밀번호를 입력하셔야 합니다.", "회원가입 불가", 
							JOptionPane.WARNING_MESSAGE);
				}else {
					String resultPW = pw.trim().replaceAll(" ", "");
					if(resultPW.equals(rePw)) {
						System.out.println("비밀번호가 일치 합니다.");
						System.out.println("DB에 저장될 PW : " + pw);
						pwFix = true;
					}else {
						passwordField.setText("");
						rePasswordField.setText("");
						System.out.println("비밀번호가 일치하지 않습니다.");
						JOptionPane.showMessageDialog(contentPane, "비밀번호가 일치하지 않습니다.", "회원가입 불가", 
								JOptionPane.WARNING_MESSAGE);
					}
					
				}
				
				if(idFix == true && pwFix == true && idDuplicate==false) {
					MySQLDB db = new MySQLDB();
					db.insert(onlyEng, pw);
					System.out.println("insert 완료");
					setVisible(false);
					Main main = new Main();
					main.setVisible(true);
				}
				
				
				
				
//				if(pw.equals(rePw)) {
//					System.out.println("비밀번호가 일치합니다");
//				}else {
//					System.out.println("비밀번호가 일치하지 않습니다");
//					JOptionPane.showMessageDialog(contentPane, "비밀번호가 일치하지 않습니다.", "회원가입 불가", 
//							JOptionPane.WARNING_MESSAGE);
//				}
				
				
				
				
				
				//디비 입력 가능
//				String id = textField.getText();
//				String pw = passwordField.getText();
//				System.out.println("id 값 : " + id);
//				System.out.println("pw 값 : " + pw);
//				
//				MySQLDB db = new MySQLDB();
//				db.insert(id, pw);
//				System.out.println("insert 완료");
//				
//				setVisible(false);
//				Main main = new Main();
//				main.setVisible(true);
			}
		});
		registBtn.setBounds(204, 320, 185, 47);
		contentPane.add(registBtn);
	}
}
