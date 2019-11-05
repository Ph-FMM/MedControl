package projeto.screens;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;

import projeto.images.Image;
import projeto.sql.Sql;

public class ForgotPassword extends JFrame{
	private JPanel panel;
	private JButton btReturn,btSave;
	private JLabel lbSelecAsk,lbNewPass,lbAgainPass,lbUsername,lbError;
	private JTextField tfUsername;
	private JTextField tfResposta;
	private JPasswordField tfPassword,tfAgainPass;
	private JComboBox<String> cbPerguntas;
	private JLabel bckgrd;
	private Image img;
	
	public ForgotPassword() {
		img = new Image();
		
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
		
		lbSelecAsk = new JLabel("Selecione a pergunta e a resposta de segurança:");
		lbSelecAsk.setBounds(20, 150, 350, 25);
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
		tfResposta.setBounds(20,220,200,25);
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
		
		bckgrd = new JLabel();
		bckgrd.setBounds(0, 0, 320, 480);
		bckgrd.setIcon(img.getBackgrd_login());
		panel.add(bckgrd);
	}
	
	public void events() {
		btReturn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				HomeFrame.homeFrame.setEnabled(true);
				dispose();
				
			}
		});
		
		btSave.addActionListener(new ActionListener() {

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
				
				if(aux==false) {

					if(perguntaXresposta(user, cbPerguntas.getSelectedItem().toString(), tfResposta.getText(), senha)) {
						HomeFrame.btUser.setText(user);
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
	
	public static boolean perguntaXresposta(String user,String ask,String answer,String senha) {
		try {
			String pergunta = null,resposta = null;
			
			Connection conn = Sql.getConexao();
			System.out.println(Sql.statusConection()+": perguntaXresposta()");
			Statement stmt = conn.createStatement();
			String query = "SELECT pergunta, resposta"
					+ " FROM conta WHERE userName = '"+user+"';";
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				pergunta = rs.getString("pergunta");
				resposta = rs.getString("resposta");
			}
			
			System.out.println(ask);
			
			if(pergunta.equals(ask)&&resposta.equals(answer)){
				query = "UPDATE conta SET senha = ? WHERE userName = ?;";
				
				PreparedStatement prepStmt = (PreparedStatement) conn.prepareStatement(query);
				prepStmt.setString(1, senha);
				prepStmt.setString(2, user);
				
				prepStmt.execute();
				conn.close();
				
				return true;
			}
			else{
				conn.close();
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
	}
}
