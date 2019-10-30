package projeto.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import projeto.classes.User;
import projeto.images.Image;
import projeto.sql.Sql;

public class CadastroFrame extends JFrame{
	
	public static User usuario;
	public static JPanel configpagePanel;
	public static String pswd,username,email;
	
	private Image img;
	private String pswdConfirm;
	private JLabel lbUser,lbEmail,lbPswd,lbPswdConfirm,logar;
	private JTextField tfUser,tfEmail;
	private JPasswordField pfSenha,pfSenhaConfirm;
	private JSeparator sep1,sep2,sep3,sep4;
	private JButton btRegister,btReturn;
	private JLabel bckgrd;
	private JPanel panel;
	private static CadastroFrame frame;
	
	Font f1 = new Font(Font.SANS_SERIF, Font.BOLD, 20);
	Font f2 = new Font(Font.SANS_SERIF, Font.BOLD, 8);
	
	
	public CadastroFrame(){
		
		img = new Image();
		
		initComponents();
		events();
	}
	
	public void initComponents() {
		
		setTitle("Sign In with Med Control");
		setSize(320,480);
		setLocationRelativeTo(SignInPagePanel.btLogMed);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 320, 480);
		panel.setBackground(Color.darkGray.brighter());
		panel.setLayout(null);
		add(panel);
		
		logar = new JLabel("Create An Account");
		logar.setFont(f1);
		logar.setForeground(Color.white);
		logar.setBounds(10, 10, 250, 40);
		panel.add(logar);
		
		lbEmail = new JLabel("Email address: ");
		lbEmail.setBounds(10, 90, 110, 25);
		lbEmail.setForeground(Color.white);
		panel.add(lbEmail);
		
		tfEmail = new JTextField(5);
		tfEmail.setBounds(10, 120, 280, 25);
		tfEmail.setBackground(Color.darkGray);
		tfEmail.setForeground(Color.white);
		tfEmail.setCaretColor(Color.white);
		tfEmail.setOpaque(false);
		tfEmail.setBorder(new EmptyBorder(0,0,0,0));
		panel.add(tfEmail);
		
		sep1 = new JSeparator();
		sep1.setBounds(10, 145, 280, 5);
		sep1.setOrientation(SwingConstants.HORIZONTAL);
		sep1.setBackground(Color.white.darker());
		sep1.setForeground(Color.white.darker());
		panel.add(sep1);
		
		lbUser = new JLabel("Display name: ");
		lbUser.setBounds(10, 160, 120, 25);
		lbUser.setForeground(Color.white);
		panel.add(lbUser);
		
		tfUser = new JTextField(5);
		tfUser.setBounds(10, 190, 280, 25);
		tfUser.setBackground(Color.darkGray);
		tfUser.setForeground(Color.white);
		tfUser.setCaretColor(Color.white);
		tfUser.setOpaque(false);
		tfUser.setBorder(new EmptyBorder(0,0,0,0));
		panel.add(tfUser);
		
		sep2 = new JSeparator();
		sep2.setBounds(10, 215, 280, 5);
		sep2.setOrientation(SwingConstants.HORIZONTAL);
		sep2.setBackground(Color.white.darker());
		sep2.setForeground(Color.white.darker());
		panel.add(sep2);
		
		lbPswd = new JLabel("Password: ");
		lbPswd.setBounds(10, 230, 80, 25);
		lbPswd.setForeground(Color.white);
		panel.add(lbPswd);
		
		pfSenha = new JPasswordField(5);
		pfSenha.setBounds(10, 260, 280, 25);
		pfSenha.setBackground(Color.darkGray);
		pfSenha.setForeground(Color.white);
		pfSenha.setCaretColor(Color.white);
		pfSenha.setOpaque(false);
		pfSenha.setBorder(new EmptyBorder(0,0,0,0));
		panel.add(pfSenha);
		
		sep3 = new JSeparator();
		sep3.setBounds(10, 285, 280, 5);
		sep3.setOrientation(SwingConstants.HORIZONTAL);
		sep3.setBackground(Color.white.darker());
		sep3.setForeground(Color.white.darker());
		panel.add(sep3);
		
		lbPswdConfirm = new JLabel("Password confirm: ");
		lbPswdConfirm.setBounds(10, 300, 120, 25);
		lbPswdConfirm.setForeground(Color.white);
		panel.add(lbPswdConfirm);
		
		pfSenhaConfirm = new JPasswordField(5);
		pfSenhaConfirm.setBounds(10, 330, 280, 25);
		pfSenhaConfirm.setBackground(Color.darkGray);
		pfSenhaConfirm.setForeground(Color.white);
		pfSenhaConfirm.setCaretColor(Color.white);
		pfSenhaConfirm.setOpaque(false);
		pfSenhaConfirm.setBorder(new EmptyBorder(0,0,0,0));
		panel.add(pfSenhaConfirm);
		
		sep4 = new JSeparator();
		sep4.setBounds(10, 355, 280, 5);
		sep4.setOrientation(SwingConstants.HORIZONTAL);
		sep4.setBackground(Color.white.darker());
		sep4.setForeground(Color.white.darker());
		panel.add(sep4);
		
		btRegister = new JButton("CREATE ACCOUNT");		
		btRegister.setBounds(170, 410, 120, 25);
		btRegister.setBackground(Color.red);
		btRegister.setForeground(Color.white);
		btRegister.setFocusPainted(false);
		btRegister.setBorderPainted(false);
		btRegister.setFont(f2);
		panel.add(btRegister);
		
		btReturn = new JButton("CANCEL");
		btReturn.setBounds(70, 410, 90, 25);
		btReturn.setBackground(Color.darkGray);
		btReturn.setForeground(Color.white);
		btReturn.setFocusPainted(false);
		btReturn.setBorderPainted(false);
		btReturn.setFont(f2);
		panel.add(btReturn);
		
		bckgrd = new JLabel();
		bckgrd.setBounds(0, 0, 320, 480);
		bckgrd.setIcon(img.getBackgrd_login());
		panel.add(bckgrd);
		
		HomeFrame.homeFrame.setEnabled(false);
	}
	
	public void events() {
		
		btReturn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				HomeFrame.homeFrame.setEnabled(true);
				dispose();
				SignInFrame login = new SignInFrame();
				login.setVisible(true);
			}
		});
		
		btRegister.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				boolean aux = false;
				
				username = tfUser.getText();
				email = tfEmail.getText();
				pswd = new String(pfSenha.getPassword());
				pswdConfirm = new String(pfSenhaConfirm.getPassword());
				
				if(username.equals("")) { 
					sep2.setForeground(Color.red);
					sep2.setBackground(Color.red);
					aux = true;
				}
				
				if(email.equals("")) { 
					sep1.setForeground(Color.red);
					sep1.setBackground(Color.red);
					aux = true;
				}
				
				if(pswd.equals("")) {
					sep3.setForeground(Color.red);
					sep3.setBackground(Color.red);
					aux = true;
				}
				
				if(pswdConfirm.equals("")) {
					sep4.setForeground(Color.red);
					sep4.setBackground(Color.red);
					aux = true;
				}
				
				if(!(pswd.equals(pswdConfirm))) {
					sep3.setForeground(Color.red);
					sep3.setBackground(Color.red);
					
					sep4.setForeground(Color.red);
					sep4.setBackground(Color.red);
					aux = true;
				}
				
				HomeFrame.usuario.readUser(username);

				if(aux==false) {
					HomeFrame.btUser.setText(username);

					PerguntaFrame frame = new PerguntaFrame();
					frame.setVisible(true);
					dispose();
				}
			}
		});
	}
}
