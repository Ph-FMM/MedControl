package projeto.screens;

import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javafx.scene.control.ComboBox;

public class PerguntaFrame extends JFrame {
	
	private JPanel panel;
	private JLabel lbEmail;
	private JComboBox cbPergunta;
	private JButton btRegister;
	private AbstractButton btReturn;

	public PerguntaFrame(){
		initComponents();
		events();
	}
	
	public void initComponents(){
		setTitle("Sign In with Med Control");
		setSize(320,480);
		setLocationRelativeTo(SignInPagePanel.btLogMed);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 320, 480);
		panel.setBackground(Color.darkGray.brighter());
		panel.setLayout(null);
		add(panel);
		
		lbEmail = new JLabel("Email address: ");
		lbEmail.setBounds(10, 90, 110, 25);
		lbEmail.setForeground(Color.white);
		panel.add(lbEmail);
		
		cbPergunta = new JComboBox();
		cbPergunta.setBounds(10, 120, 280, 25);
		cbPergunta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Qual sua música favorita?", "Qual sua banda favorita?", "Qual seu álbum favorito?" }));
		panel.add(cbPergunta);
		
		btReturn = new JButton("CANCEL");
		btReturn.setBounds(70, 410, 90, 25);
		btReturn.setBackground(Color.darkGray);
		btReturn.setForeground(Color.white);
		btReturn.setFocusPainted(false);
		btReturn.setBorderPainted(false);
		panel.add(btReturn);
		
		btRegister = new JButton("CREATE ACCOUNT");		
		btRegister.setBounds(170, 410, 120, 25);
		btRegister.setBackground(Color.red);
		btRegister.setForeground(Color.white);
		btRegister.setFocusPainted(false);
		btRegister.setBorderPainted(false);
		panel.add(btRegister);
	}
	
	public void events(){
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
				
				HomeFrame.usuario.createUser(
						CadastroFrame.email, CadastroFrame.username,
						CadastroFrame.pswd, cbPergunta.getSelectedItem().toString());

					HomeFrame.homeFrame.setEnabled(true);
					HomeFrame.homepagePanel.setVisible(false);
					HomeFrame.signInPagePanel.setVisible(false);
					HomeFrame.btUser.setText(CadastroFrame.username);
					HomeFrame.menuEnabled(true);

					HomeFrame.configPagePanel.setVisible(true);
					AccountPage.newAcc = true;
					HomeFrame.configPagePanel.btPersonalData.doClick();
					HomeFrame.configPagePanel.accountbt.setVisible(true);
					HomeFrame.configPagePanel.auxAccount = true;

					
					
					dispose();
			}
		});
	}

	public static void main(String[] args) {
		

	}

}
