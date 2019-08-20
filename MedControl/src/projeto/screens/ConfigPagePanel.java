package projeto.screens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JPanel;
import projeto.sql.Sql;

public class ConfigPagePanel extends JPanel{
	
	AccountPage accountbt;
	private JPanel configMenu;
	JButton btPersonalData;
	private JButton btGeneral;
	
	static String nick;
	static String nome;
	static int idade;
	static double peso;
	static String cep;
	static String cpf;
	static String endereco;
	static String email;
	
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	
	public ConfigPagePanel(){
		initComponents();
		events();
	}
	
	public void config(){
		btGeneral = new JButton("General");
		btGeneral.setBounds(0, 10, 250, 70);
		btGeneral.setBackground(Color.gray.darker());
		btGeneral.setForeground(Color.white);
		btGeneral.setFocusPainted(false);
		btGeneral.setBorderPainted(false);
		add(btGeneral);
		
		btPersonalData = new JButton("Account");
		btPersonalData.setBounds(0, 90, 250, 70);
		btPersonalData.setBackground(Color.gray.darker());
		btPersonalData.setForeground(Color.white);
		btPersonalData.setFocusPainted(false);
		btPersonalData.setBorderPainted(false);
		add(btPersonalData);
	}
	
	public void initComponents(){
		setBounds(0, 40, screen.width, screen.height-40);
		setLayout(null);
		setOpaque(false);
		setVisible(false);
		
		config();
		
		accountbt = new AccountPage();
		add(accountbt);
		
		configMenu = new JPanel();
		configMenu.setBackground(Color.gray.darker());
		configMenu.setBounds(0, 0, 250, screen.height-40);
		add(configMenu);

	}
	
	boolean auxAccount;
	private boolean auxGeneral = false;
	
	public void events(){
		btPersonalData.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(auxAccount==false){
					btPersonalData.setBackground(Color.gray.darker().darker());
					btPersonalData.setForeground(Color.red.darker());
					accountbt.setVisible(true);
					infos();
					auxAccount = true;
					System.out.println(AccountPage.newAcc);
					if(AccountPage.newAcc) {
						for (int i = 0; i < AccountPage.lbInfos.length-1; i++) {
							AccountPage.lbInfos[i].setVisible(false);
							AccountPage.tfInfos[i].setVisible(true);
						}
						AccountPage.taendereco.setVisible(true);
						AccountPage.endereco.setVisible(false);
						AccountPage.lbSalvar.setVisible(true);
						AccountPage.lbEditInfo.setVisible(false);
					}
				}
				else{
					auxAccount = false;
					btPersonalData.setBackground(Color.gray.darker());
					btPersonalData.setForeground(Color.white);
				}
			}
		});
		
		btGeneral.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(auxGeneral==false){
					btGeneral.setBackground(Color.gray.darker().darker());
					btGeneral.setForeground(Color.red.darker());
					auxGeneral = true;
				}
				else{
					auxGeneral = false;
					btGeneral.setBackground(Color.gray.darker());
					btGeneral.setForeground(Color.white);
				}
				
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
			
			nick = HomeFrame.usuario.getUserName();
			nome = HomeFrame.usuario.getNome();
			idade = HomeFrame.usuario.getIdade();
			peso = HomeFrame.usuario.getPeso();
			cpf = HomeFrame.usuario.getCpf();
			cep = HomeFrame.usuario.getCep();
			endereco = HomeFrame.usuario.getEndereco();
			email = HomeFrame.usuario.getEmail();
			
			AccountPage.username.setText(nick);
			AccountPage.nome.setText(nome);
			AccountPage.idade.setText(String.valueOf(idade));
			AccountPage.peso.setText(String.valueOf(peso));
			AccountPage.cpf.setText(cpf);
			AccountPage.cep.setText(cep);
			AccountPage.endereco.setText(endereco);
			AccountPage.email.setText(email);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
