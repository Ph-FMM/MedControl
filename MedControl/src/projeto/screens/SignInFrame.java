package projeto.screens;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import projeto.classes.User;
import projeto.images.Image;
import projeto.sql.Sql;

public class SignInFrame extends JFrame{
	
	private Image img;
	private String auth,senha;
	private JLabel lbUser,lbPswd,logar,bckgrd,red,forgotPass;
	private JTextField tfUser;
	private JSeparator sep1,sep2;
	private JPasswordField pfSenha;
	private JButton btSignIn,btReturn,btRegister;
	private JPanel panel;
	
	public static User usuario;
	
	private String bdAuthEmail = null;
	private String bdAuthName = null;
	private String bdSenha = null;
	
	Font f1 = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		
	public SignInFrame() {
		
		img = new Image();
		
		initComponents();
		events();
	}
	
	public void initComponents() {
		setTitle("Sign In with Med Control");
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
		
		logar = new JLabel("Log in to Med Control");
		logar.setFont(f1);
		logar.setForeground(Color.white);
		logar.setBounds(10, 10, 250, 40);
		panel.add(logar);
		
		lbUser = new JLabel("Username: ");
		lbUser.setBounds(10, 120, 80, 25);
		lbUser.setForeground(Color.white);
		panel.add(lbUser);
		
		tfUser = new JTextField(5);
		tfUser.setBounds(10, 150, 280, 25);
		tfUser.setBackground(Color.darkGray);
		tfUser.setForeground(Color.white);
		tfUser.setCaretColor(Color.white);
		tfUser.setOpaque(false);
		tfUser.setBorder(new EmptyBorder(0,0,0,0));
		panel.add(tfUser);
		
		sep1 = new JSeparator();
		sep1.setBounds(10, 175, 280, 5);
		sep1.setOrientation(SwingConstants.HORIZONTAL);
		sep1.setBackground(Color.white.darker());
		sep1.setForeground(Color.white.darker());
		panel.add(sep1);
		
		lbPswd = new JLabel("Password:");
		lbPswd.setBounds(10, 190, 80, 25);
		lbPswd.setForeground(Color.white);
		panel.add(lbPswd);
		
		pfSenha = new JPasswordField(5);
		pfSenha.setBounds(10, 220, 280, 25);
		pfSenha.setBackground(Color.darkGray);
		pfSenha.setForeground(Color.white);
		pfSenha.setCaretColor(Color.white);
		pfSenha.setOpaque(false);
		pfSenha.setBorder(new EmptyBorder(0,0,0,0));
		panel.add(pfSenha);
		
		sep2 = new JSeparator();
		sep2.setBounds(10, 245, 280, 5);
		sep2.setOrientation(SwingConstants.HORIZONTAL);
		sep2.setBackground(Color.white.darker());
		sep2.setForeground(Color.white.darker());
		panel.add(sep2);
		
		btSignIn = new JButton("Log In");		
		btSignIn.setBounds(105, 300, 100, 40);
		btSignIn.setBackground(Color.red.darker());
		btSignIn.setForeground(Color.white);
		btSignIn.setFocusPainted(false);
		btSignIn.setBorderPainted(false);
		panel.add(btSignIn);
		
		forgotPass = new JLabel("Esqueci a senha");
		forgotPass.setBounds(30,410,100,25);
		forgotPass.setForeground(Color.white);
		panel.add(forgotPass);
		
		btReturn = new JButton("Return");
		btReturn.setBounds(140, 410, 80, 25);
		btReturn.setBackground(Color.darkGray);
		btReturn.setForeground(Color.white);
		btReturn.setFocusPainted(false);
		btReturn.setBorderPainted(false);
		panel.add(btReturn);
		
		red = new JLabel("Username or Password are incorrect");
		red.setBounds(45, 70, 230, 60);
		red.setForeground(Color.red);
		red.setVisible(false);
		panel.add(red);
		
		btRegister = new JButton("Register");
		btRegister.setBounds(210, 410, 90, 25);
		btRegister.setBackground(Color.darkGray);
		btRegister.setForeground(Color.white);
		btRegister.setFocusPainted(false);
		btRegister.setBorderPainted(false);
		panel.add(btRegister);
		
		bckgrd = new JLabel();
		bckgrd.setBounds(0, 0, 320, 480);
		bckgrd.setIcon(img.getBackgrd_login());
		panel.add(bckgrd);
		
		HomeFrame.homeFrame.setEnabled(false);
	}
	
	private void events(){
		forgotPass.addMouseListener(new MouseListener() {
			public void mouseExited(MouseEvent e) {
				forgotPass.setForeground(Color.white);
				
			}
			
			public void mouseEntered(MouseEvent e) {
				forgotPass.setForeground(Color.red);
				
			}
			
			public void mouseClicked(MouseEvent e) {
				ForgotPassword frame = new ForgotPassword();
				frame.setVisible(true);
				dispose();
				
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btReturn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				HomeFrame.homeFrame.setEnabled(true);
				dispose();
			}
		});
		
		btSignIn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String status = null;
				
				auth = tfUser.getText();
				senha = new String(pfSenha.getPassword());
				
				try {
					
					java.sql.Connection conn = Sql.getConexao();
					System.out.println(Sql.statusConection());
					
					String query = "SELECT email, userName, senha, stats FROM conta WHERE email = '"
									+auth+"' OR userName = '"+auth+"'";
					
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					
					while(rs.next()) {
						bdAuthEmail = rs.getString("email");
						bdAuthName = rs.getString("userName");
						bdSenha = rs.getString("senha");
						status = rs.getString("stats");
					}
					
					conn.close();
				}
				catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				
				if((auth.equals(bdAuthEmail)||auth.equals(bdAuthName))&&senha.equals(bdSenha)) {
					if(status.equals("1")) {
						HomeFrame.usuario.readUser(bdAuthName);
						
						HomeFrame.table.readTabela(HomeFrame.usuario.getId());
						
						HomeFrame.btUser.setText(bdAuthName);
						HomeFrame.homeFrame.setEnabled(true);
						dispose();
						
						HomeFrame.homepagePanel.setVisible(true);
						HomeFrame.signInPagePanel.setVisible(false);
						
						
						
						try {
							if(HomeFrame.usuario.getNome().equals(null)) {
								HomeFrame.configPagePanel.setVisible(true);
								HomeFrame.configPagePanel.accountbt.setVisible(true);
								HomeFrame.configPagePanel.auxAccount = true;
								AccountPage.newAcc = true;
								HomeFrame.configPagePanel.btPersonalData.doClick();
								
								infos();
								System.out.println("mama");
							}
						}		
						catch(NullPointerException ex) {
							HomeFrame.configPagePanel.setVisible(true);
							HomeFrame.homepagePanel.setVisible(false);
							HomeFrame.configPagePanel.accountbt.setVisible(true);
							AccountPage.newAcc = true;
							HomeFrame.configPagePanel.btPersonalData.doClick();
							
							HomeFrame.configPagePanel.auxAccount = true;
							
							infos();
							System.out.println("mama");
						}
						
						HomeFrame.menuEnabled(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Your account was desactivated");
						
						red.setVisible(true);
						
						sep1.setBackground(Color.red);
						sep1.setForeground(Color.red);
						
						sep2.setBackground(Color.red);
						sep2.setForeground(Color.red);
					}
				}
				else {
					red.setVisible(true);
					
					sep1.setBackground(Color.red);
					sep1.setForeground(Color.red);
					
					sep2.setBackground(Color.red);
					sep2.setForeground(Color.red);
				}
			}
		});
		
		btRegister.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				HomeFrame.homeFrame.setEnabled(true);
				dispose();
				CadastroFrame cad = new CadastroFrame();
				cad.setVisible(true);
			}
		});
	}
	
	public static void infos() {
		try {
			Connection conn = Sql.getConexao();
			System.out.println(Sql.statusConection()+": infos()");
			Statement stmt = conn.createStatement();
			String query = "SELECT conta.userName,usuario.nome,usuario.idade,"
					+ "usuario.peso,usuario.peso,usuario.cpf,usuario.cep,usuario."
					+ "endereco FROM usuario INNER JOIN conta ON conta.id =  usuario.idConta "
					+ "WHERE conta.userName = '"+HomeFrame.usuario.getUserName()+"';";
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				HomeFrame.usuario.setNome(rs.getString("nome"));
				HomeFrame.usuario.setIdade(rs.getInt("idade"));
				HomeFrame.usuario.setPeso(rs.getFloat("peso"));
				HomeFrame.usuario.setCpf(rs.getString("cpf"));
				HomeFrame.usuario.setCep(rs.getString("cep"));
				HomeFrame.usuario.setEndereco(rs.getString("endereco"));
			}
			conn.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
