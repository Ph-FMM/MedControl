package projeto.screens;

import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javafx.scene.control.ComboBox;
import projeto.images.Image;

public class PerguntaFrame extends JFrame {
	
	private JPanel panel;
	private JLabel lbEmail,lbResposta;
	private JComboBox<String> cbPergunta;
	private JTextField tfResposta;
	private JButton btRegister;
	private JButton btReturn;
	private JLabel bckgrd;
	private Image img;

	public PerguntaFrame(){
		img = new Image();
		
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
		
		lbEmail = new JLabel("Pergunta de segurança: ");
		lbEmail.setBounds(10, 90, 200, 25);
		lbEmail.setForeground(Color.white);
		panel.add(lbEmail);
		
		cbPergunta = new JComboBox<String>();
		cbPergunta.setBounds(10, 120, 280, 25);
		cbPergunta.setModel(new javax.swing.DefaultComboBoxModel<String>(
				new String[] { 
						"Qual sua música favorita?", 
						"Qual sua banda favorita?", 
						"Qual seu Álbum favorito?" 
						}));
		panel.add(cbPergunta);
		
		lbResposta = new JLabel("Resposta: ");
		lbResposta.setBounds(10, 150, 100, 25);
		lbResposta.setForeground(Color.white);
		panel.add(lbResposta);
		
		tfResposta = new JTextField();
		tfResposta.setBounds(10,170,200,25);
		panel.add(tfResposta);
		
		btReturn = new JButton("CANCEL");
		btReturn.setBounds(70, 410, 90, 25);
		btReturn.setBackground(Color.darkGray);
		btReturn.setForeground(Color.white);
		btReturn.setFocusPainted(false);
		btReturn.setBorderPainted(false);
		panel.add(btReturn);
		
		btRegister = new JButton("CREATE");		
		btRegister.setBounds(170, 410, 120, 25);
		btRegister.setBackground(Color.red);
		btRegister.setForeground(Color.white);
		btRegister.setFocusPainted(false);
		btRegister.setBorderPainted(false);
		panel.add(btRegister);
		
		bckgrd = new JLabel();
		bckgrd.setBounds(0, 0, 320, 480);
		bckgrd.setIcon(img.getBackgrd_login());
		panel.add(bckgrd);
	}
	
	public void events(){
		btReturn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				HomeFrame.homeFrame.setEnabled(true);
				dispose();
			}
		});
		
		btRegister.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				HomeFrame.usuario.createUser(
						CadastroFrame.email, CadastroFrame.username,
						CadastroFrame.pswd, cbPergunta.getSelectedItem().toString(),tfResposta.getText());

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

}
