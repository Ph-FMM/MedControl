package projeto.screens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import projeto.sql.Sql;

public class AccountPage extends JPanel{
	
	private JPanel avatarPanel,personalInfoPanel,persDeletePanel;
	private JLabel userAvatar,lbEditAvatar,lbEmail;
	
	private JLabel lbusername = new JLabel("Display name");
	private JLabel lbnome = new JLabel("Name");
	private JLabel lbidade = new JLabel("Age");
	private JLabel lbpeso = new JLabel("Weight");
	private JLabel lbcpf = new JLabel("CPF");
	private JLabel lbcep = new JLabel("Postal code");
	private JLabel lbendereco = new JLabel("Address");
	
	static JLabel email = new JLabel();
	static JLabel username = new JLabel();
	static JLabel nome = new JLabel();
	static JLabel idade = new JLabel();
	static JLabel peso = new JLabel();
	static JLabel cpf = new JLabel();
	static JLabel cep = new JLabel();
	static JLabel endereco = new JLabel();
	
	static JTextField tfnome = new JTextField();
	static JTextField tfidade = new JTextField();
	static JTextField tfpeso = new JTextField(); 
	static JTextField tfcpf = new JTextField();
	static JTextField tfcep = new JTextField();
	static JTextArea taendereco = new JTextArea();
	
	private JButton btDelete;
	
	static JLabel lbSalvar,lbEditInfo;
	
	static JLabel[] lbInfos = {nome,idade,peso,cpf,cep,endereco};
	static JTextField[] tfInfos = {tfnome,tfidade,tfpeso,tfcpf,tfcep};
	
	static boolean newAcc = false;
	
	ImageIcon saveico = new ImageIcon(getClass().getResource("/projeto/images/save.png"));
	ImageIcon user_ico = new ImageIcon(getClass().getResource("/projeto/images/user.png"));
	ImageIcon editico = new ImageIcon(getClass().getResource("/projeto/images/editico.png"));
	
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	
	public AccountPage(){
		initComponents();
		events();
	}
	
	public void persInfo() {
		Border empty = BorderFactory.createEmptyBorder();
		TitledBorder title = BorderFactory.createTitledBorder(empty,"PERSONAL INFORMATION");
		title.setTitleColor(Color.white);
		
		personalInfoPanel = new JPanel();
		personalInfoPanel.setBounds(0, 270, (screen.width/3)+50, 250);
		personalInfoPanel.setBackground(new Color(75, 75, 75, 123));
		personalInfoPanel.setBorder(title);
		personalInfoPanel.setLayout(null);
		add(personalInfoPanel);
		
		lbusername.setBounds(10, 40, 100, 20);
		lbusername.setForeground(Color.decode("#b1b1b1"));
		personalInfoPanel.add(lbusername);
		
		username.setBounds(10, 65, 100, 20);
		username.setForeground(Color.white);
		personalInfoPanel.add(username);
		
		lbnome.setBounds(10, 100, 50, 20);
		lbnome.setForeground(Color.decode("#b1b1b1"));
		personalInfoPanel.add(lbnome);
		
		nome.setBounds(10, 125, 150, 20);
		nome.setForeground(Color.white);
		personalInfoPanel.add(nome);
		
		lbpeso.setBounds(10, 155, 50, 20);
		lbpeso.setForeground(Color.decode("#b1b1b1"));
		personalInfoPanel.add(lbpeso);
		
		peso.setBounds(10, 175, 50, 20);
		peso.setForeground(Color.white);
		personalInfoPanel.add(peso);
		
		lbidade.setBounds(80, 155, 50, 20);
		lbidade.setForeground(Color.decode("#b1b1b1"));
		personalInfoPanel.add(lbidade);
		
		idade.setBounds(80, 175, 50, 20);
		idade.setForeground(Color.white);
		personalInfoPanel.add(idade);
		
		lbcpf.setBounds(((screen.width/3)+50)/2, 40, 50, 20);
		lbcpf.setForeground(Color.decode("#b1b1b1"));
		personalInfoPanel.add(lbcpf);
		
		cpf.setBounds(((screen.width/3)+50)/2, 65, 100, 20);
		cpf.setForeground(Color.white);
		personalInfoPanel.add(cpf);
		
		lbcep.setBounds(((screen.width/3)+50)/2, 100, 80, 20);
		lbcep.setForeground(Color.decode("#b1b1b1"));
		personalInfoPanel.add(lbcep);
		
		cep.setBounds(((screen.width/3)+50)/2, 125, 100, 20);
		cep.setForeground(Color.white);
		personalInfoPanel.add(cep);
		
		lbendereco.setBounds(((screen.width/3)+50)/2, 155, 50, 20);
		lbendereco.setForeground(Color.decode("#b1b1b1"));
		personalInfoPanel.add(lbendereco);
		
		endereco.setBounds(((screen.width/3)+50)/2, 175, 150, 50);
		endereco.setForeground(Color.white);
		personalInfoPanel.add(endereco);

	}
	
	private void persEdit() {
		
		tfnome.setBounds(10, 125, 150, 20);
		tfnome.setVisible(false);
		personalInfoPanel.add(tfnome);
		
		tfidade.setBounds(80, 175, 50, 20);
		tfidade.setVisible(false);
		personalInfoPanel.add(tfidade);
		
		tfpeso.setBounds(10, 175, 50, 20);
		tfpeso.setVisible(false);
		personalInfoPanel.add(tfpeso);
		
		tfcpf.setBounds(((screen.width/3)+50)/2, 65, 100, 20);
		tfcpf.setVisible(false);
		personalInfoPanel.add(tfcpf);
		
		tfcep.setBounds(((screen.width/3)+50)/2, 125, 100, 20);
		tfcep.setVisible(false);
		personalInfoPanel.add(tfcep);
		
		taendereco.setBounds(((screen.width/3)+50)/2, 175, 150, 50);
		taendereco.setVisible(false);
		personalInfoPanel.add(taendereco);
	}
	
	public void persDelete() {
		Border empty = BorderFactory.createEmptyBorder();
		TitledBorder title = BorderFactory.createTitledBorder(empty,"SECURITY & PRIVACY");
		title.setTitleColor(Color.white);
		
		persDeletePanel = new JPanel();
		persDeletePanel.setBounds(0, 540, (screen.width/3)+50, screen.height-140);
		persDeletePanel.setBackground(new Color(75, 75, 75, 123));
		persDeletePanel.setBorder(title);
		persDeletePanel.setLayout(null);
		add(persDeletePanel);
		
		lbEmail = new JLabel("Email");
		lbEmail.setBounds(10, 20, 50, 20);
		lbEmail.setForeground(Color.decode("#b1b1b1"));
		persDeletePanel.add(lbEmail);
		
		email.setBounds(10, 40, 400, 20);
		email.setForeground(Color.white);
		persDeletePanel.add(email);
		
		btDelete = new JButton("Delete Account");
		btDelete.setBounds(((screen.width/3)+50)/3, 65, ((screen.width/3)+50)/3, 20);
		persDeletePanel.add(btDelete);
	}

	public void initComponents(){
		setBounds(280, 30, screen.width-290, screen.height-140);
		setOpaque(false);
		setLayout(null);
		setVisible(false);
		
		avatarPanel = new JPanel();
		avatarPanel.setBounds(0, 0, (screen.width/3)+50, 250);
		avatarPanel.setBackground(new Color(75, 75, 75, 123));
		Border empty = BorderFactory.createEmptyBorder();
		TitledBorder title = BorderFactory.createTitledBorder(empty,"AVATAR");
		title.setTitleColor(Color.decode("#b1b1b1"));
		avatarPanel.setBorder(title);
		avatarPanel.setLayout(new GridLayout(2,1,0,0));
		add(avatarPanel);
		
		userAvatar = new JLabel(user_ico);
		avatarPanel.add(userAvatar);
		
		lbEditAvatar = new JLabel(editico);
		lbEditAvatar.setBounds((screen.width/3)+30, 0, 20, 20);
		lbEditAvatar.setBackground(new Color(75, 75, 75, 123));
		add(lbEditAvatar);
		
		persInfo();
		persEdit();
		persDelete();
		
		lbEditInfo = new JLabel(editico);
		lbEditInfo.setBounds((screen.width/3)+30, 270, 20, 20);
		lbEditInfo.setBackground(new Color(75, 75, 75, 123));
		add(lbEditInfo);
		
		lbSalvar = new JLabel(saveico);
		lbSalvar.setBounds((screen.width/3)+30, 270, 20, 20);
		lbSalvar.setVisible(false);
		add(lbSalvar);
	}
	
	public void events() {
		lbEditInfo.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				for (int i = 0; i < lbInfos.length-1; i++) {
					lbInfos[i].setVisible(false);
					tfInfos[i].setVisible(true);
				}
				endereco.setVisible(false);
				taendereco.setVisible(true);
				lbSalvar.setVisible(true);
				lbEditInfo.setVisible(false);
				
				tfnome.setText(nome.getText());
				tfidade.setText(idade.getText());
				tfcpf.setText(cpf.getText());
				tfpeso.setText(peso.getText());
				tfcep.setText(cep.getText());
				taendereco.setText(endereco.getText());

	        }
		});
		
		lbSalvar.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(newAcc);
				if(newAcc) {
					String name=tfnome.getText(),zip=tfcep.getText(),
							   cpf1=tfcpf.getText(),address=taendereco.getText();
					int age = Integer.parseInt(tfidade.getText());
					float weight = Float.parseFloat(tfpeso.getText());
					
					try {
						Connection conn = Sql.getConexao();
						System.out.println(Sql.statusConection()+": INSERT dados");
						String query = "INSERT INTO usuario(idConta,nome,idade,peso,cpf,cep,"
								+ "endereco) VALUES(?,?,?,?,?,?,?)";
						PreparedStatement stmt = conn.prepareStatement(query);
						
						stmt.setInt(1, HomeFrame.usuario.getIdConta());
						stmt.setString(2, name);
						stmt.setInt(3, age);
						stmt.setFloat(4, weight);
						stmt.setString(5, cpf1);
						stmt.setString(6, zip);
						stmt.setString(7, address);
						
						stmt.execute();
						
						conn.close();
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
					
					HomeFrame.usuario.setNome(name);
					HomeFrame.usuario.setIdade(age);
					HomeFrame.usuario.setPeso(weight);
					HomeFrame.usuario.setCpf(cpf1);
					HomeFrame.usuario.setCep(zip);
					HomeFrame.usuario.setEndereco(address);
					
					nome.setText(HomeFrame.usuario.getNome());
					idade.setText(String.valueOf(HomeFrame.usuario.getIdade()));
					peso.setText(String.valueOf(HomeFrame.usuario.getPeso()));
					cpf.setText(HomeFrame.usuario.getCpf());
					cep.setText(HomeFrame.usuario.getCep());
					endereco.setText(HomeFrame.usuario.getEndereco());
					
					for (int i = 0; i < lbInfos.length-1; i++) {
						lbInfos[i].setVisible(true);
						tfInfos[i].setVisible(false);
					}
					endereco.setVisible(true);
					taendereco.setVisible(false);
					lbSalvar.setVisible(false);
					lbEditInfo.setVisible(true);
				}
				else {
					String name=tfnome.getText(),zip=tfcep.getText(),
							   cpf1=tfcpf.getText(),address=taendereco.getText();
					int age = Integer.parseInt(tfidade.getText());
					double weight = Double.parseDouble(tfpeso.getText());
					
					HomeFrame.usuario.updateUser(name,age,weight,cpf1,zip,address);
					
					nome.setText(HomeFrame.usuario.getNome());
					idade.setText(String.valueOf(HomeFrame.usuario.getIdade()));
					peso.setText(String.valueOf(HomeFrame.usuario.getPeso()));
					cpf.setText(HomeFrame.usuario.getCpf());
					cep.setText(HomeFrame.usuario.getCep());
					endereco.setText(HomeFrame.usuario.getEndereco());
						
					JOptionPane.showMessageDialog(null, "Informations updated");
						
					for (int i = 0; i < lbInfos.length-1; i++) {
						lbInfos[i].setVisible(true);
						tfInfos[i].setVisible(false);
					}
					endereco.setVisible(true);
					taendereco.setVisible(false);
					lbSalvar.setVisible(false);
					lbEditInfo.setVisible(true);
				}
	        }
		});
		
		btDelete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String senha = JOptionPane.showInputDialog("Password:");
				
				HomeFrame.usuario.deleteUser(HomeFrame.usuario.getUserName(),senha);
				
				
			}
		});
	}
	
	
}
