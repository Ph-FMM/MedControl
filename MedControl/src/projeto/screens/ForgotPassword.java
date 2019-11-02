package projeto.screens;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ForgotPassword extends JFrame{
	private JPanel panel;
	private JButton btReturn,btSave;
	private JLabel lbSelecAsk,lbNewPass,lbAgainPass,lbUsername,lbError;
	private JTextField tfUsername;
	private JTextField tfResposta;
	private JPasswordField tfPassword,tfAgainPass;
	private JComboBox<String> cbPerguntas;
	
	public ForgotPassword() {
		initComponents();
		events();
	}
	
	public void initComponents() {
		setTitle("I have forgotten my password :(");
		setSize(320,480);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(SignInPagePanel.btLogMed);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 320, 480);
		panel.setBackground(Color.darkGray.brighter());
		panel.setLayout(null);
		add(panel);
		
		lbUsername = new JLabel("Informe seu nome de usuário: ");
		lbUsername.setBounds(20, 60, 250, 25);
		lbUsername.setForeground(Color.white);
		panel.add(lbUsername);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(20, 80, 150, 25);
		panel.add(tfUsername);
		
		lbSelecAsk = new JLabel("Selecione a pergunta de segurança:");
		lbSelecAsk.setBounds(20, 150, 250, 25);
		lbSelecAsk.setForeground(Color.white);
		panel.add(lbSelecAsk);
		
		cbPerguntas = new JComboBox<String>();
		cbPerguntas.setBounds(20, 180, 250, 25);
		cbPerguntas.setModel(
				new javax.swing.DefaultComboBoxModel<String>(
						new String[] { 
								"Qual sua música favorita?", 
								"Qual sua banda favorita?", 
								"Qual seu Álbum favorito?" 
								}));
		panel.add(cbPerguntas);
		
		tfResposta = new JTextField();
		tfResposta.setBounds(10,170,200,25);
		panel.add(tfResposta);
		
		lbError = new JLabel("Resposta incorreta!");
		lbError.setBounds(10,180,200,25);
		lbError.setVisible(false);
		lbError.setForeground(Color.red);
		panel.add(lbError);
		
		lbNewPass = new JLabel("Informe a nova senha: ");
		lbNewPass.setBounds(20, 250, 200, 25);
		lbNewPass.setForeground(Color.white);
		panel.add(lbNewPass);
		
		tfPassword = new JPasswordField();
		tfPassword.setBounds(20, 270, 150, 25);
		panel.add(tfPassword);
		
		lbAgainPass = new JLabel("Informe a nova senha novamente: ");
		lbAgainPass.setBounds(20, 310, 200, 25);
		lbAgainPass.setForeground(Color.white);
		panel.add(lbAgainPass);
		
		tfAgainPass = new JPasswordField();
		tfAgainPass.setBounds(20, 330, 150, 25);
		panel.add(tfAgainPass);
		
		btReturn = new JButton("CANCEL");
		btReturn.setBounds(70, 410, 90, 25);
		btReturn.setBackground(Color.darkGray);
		btReturn.setForeground(Color.white);
		btReturn.setFocusPainted(false);
		btReturn.setBorderPainted(false);
		panel.add(btReturn);
		
		btSave = new JButton("SAVE");
		btSave.setBounds(210, 410, 90, 25);
		btSave.setBackground(Color.darkGray);
		btSave.setForeground(Color.white);
		btSave.setFocusPainted(false);
		btSave.setBorderPainted(false);
		panel.add(btSave);
	}
	
	public void events() {
		btReturn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeFrame.homeFrame.setEnabled(true);
				dispose();
				
			}
		});
		
		btSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean aux = false;
				
				String user = tfUsername.getText();
				String senha = new String(tfPassword.getPassword());
				String senhaConfirm = new String(tfAgainPass.getPassword());
				
				if(user.equals("")) {
					aux = true;
				}
				
				if(senha.equals("")) {
					aux = true;
				}
				
				if(senhaConfirm.equals("")) {
					aux = true;
				}
				
				if(!(senha.equals(senhaConfirm))) {
					aux = true;
				}
				System.out.println(user);
				HomeFrame.usuario.readUser(user);
				
				if(aux==false) {
					HomeFrame.btUser.setText(user);

					if(HomeFrame.usuario.updatePassword(tfResposta.getText(),senha)) {
						SignInFrame frame = new SignInFrame();
						frame.setVisible(true);
						dispose();
					}
					else {
						lbError.setVisible(true);
					}
				}
			}
		});
	}
}
