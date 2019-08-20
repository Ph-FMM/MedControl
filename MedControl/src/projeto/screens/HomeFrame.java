package projeto.screens;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import projeto.classes.Tabela;
import projeto.classes.User;
import projeto.sql.Sql;

public class HomeFrame extends JFrame{
	
	public static SignInPagePanel signInPagePanel;
	public static ConfigPagePanel configPagePanel;
	public static CreateTablePanel createTablePanel;
	public static TablesPanel tablesPanel;
	
	public static User usuario;
	public static Tabela table;
	
	public static JButton btLogout;
	static JButton btAccount;
	
	private JPanel top,panelBt1,pnUsername;	
	private JLabel background,logo;
	private JButton btCreateTable,btSearchDiseases,btSearchDoctors,
					btChatDoctors,btTutorial;
	
	public static JPanel homepagePanel;
	public static JButton btHome,btTables,btNotif,btConfig,btOthers,btUser;
	public static HomeFrame homeFrame;
	
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	
	Font f1 = new Font(Font.SANS_SERIF,Font.PLAIN,17);
	Font f2 = new Font(Font.SANS_SERIF,Font.BOLD,18);
	
	ImageIcon logoIco = new ImageIcon(getClass().getResource("/projeto/images/logoIco.png"));
	ImageIcon background_img = new ImageIcon(getClass().getResource("/projeto/images/background.png"));
	ImageIcon logo_img = new ImageIcon(getClass().getResource("/projeto/images/Med Control Logo.png"));
	ImageIcon config_ico = new ImageIcon(getClass().getResource("/projeto/images/config.png"));
	ImageIcon notif_ico = new ImageIcon(getClass().getResource("/projeto/images/notif.png"));
	ImageIcon user_ico = new ImageIcon(getClass().getResource("/projeto/images/user.png"));
	ImageIcon home_ico = new ImageIcon(getClass().getResource("/projeto/images/home.png"));
	ImageIcon table_ico = new ImageIcon(getClass().getResource("/projeto/images/table.png"));
	ImageIcon others_ico = new ImageIcon(getClass().getResource("/projeto/images/others.png"));
	
	public HomeFrame() {
		initComponents();
		events();
		
		usuario = new User();
		table = new Tabela();
	}
	
	public void menu() {
		
		top = new JPanel();
		top.setBounds(0, 0, screen.width, 40);
		top.setBackground(Color.gray.darker().darker());
		top.setLayout(null);
		add(top);
		
		btHome = new JButton("  Home Page");
		btHome.setBounds(30, 0, 170, 40);
		btHome.setIcon(home_ico);
		btHome.setBackground(Color.darkGray);
		btHome.setForeground(Color.red);
		btHome.setFont(f1);
		btHome.setFocusPainted(false);
		btHome.setBorderPainted(false);
		btHome.setEnabled(false);
		top.add(btHome);
		
		btTables = new JButton("  Tables");
		btTables.setBounds(220, 0, 125, 40);
		btTables.setIcon(table_ico);
		btTables.setBackground(Color.darkGray);
		btTables.setForeground(Color.gray);
		btTables.setFont(f1);
		btTables.setFocusPainted(false);
		btTables.setBorderPainted(false);
		btTables.setEnabled(false);
		top.add(btTables);
		
		btUser = new JButton();
		btUser.setBounds(screen.width-200,0, 200, 40);
		btUser.setIcon(user_ico);
		btUser.setText("  Username");
		btUser.setBackground(Color.darkGray);
		btUser.setForeground(Color.gray);
		btUser.setFont(f1);
		btUser.setHorizontalAlignment(SwingConstants.LEADING);
		btUser.setFocusPainted(false);
		btUser.setBorderPainted(false);
		btUser.setEnabled(false);
		top.add(btUser);
		
		btConfig = new JButton();
		btConfig.setBounds(screen.width-270, 0, 50, 40);
		btConfig.setIcon(config_ico);
		btConfig.setBackground(Color.darkGray);
		btConfig.setForeground(Color.gray);
		btConfig.setFont(f1);
		btConfig.setFocusPainted(false);
		btConfig.setBorderPainted(false);
		btConfig.setEnabled(false);
		top.add(btConfig);
		
		btNotif = new JButton();
		btNotif.setBounds(screen.width-330, 0, 50, 40);
		btNotif.setIcon(notif_ico);
		btNotif.setBackground(Color.darkGray);
		btNotif.setForeground(Color.gray);
		btNotif.setFont(f1);
		btNotif.setFocusPainted(false);
		btNotif.setBorderPainted(false);
		btNotif.setEnabled(false);
		top.add(btNotif);
		
		btOthers = new JButton();
		btOthers.setBounds(screen.width-390, 0, 50, 40);
		btOthers.setIcon(others_ico);
		btOthers.setBackground(Color.darkGray);
		btOthers.setForeground(Color.gray);
		btOthers.setFont(f1);
		btOthers.setFocusPainted(false);
		btOthers.setBorderPainted(false);
		btOthers.setEnabled(false);
		top.add(btOthers);
	}

	public static void menuEnabled(boolean bool) {
		btHome.setEnabled(bool);
		btConfig.setEnabled(bool);
		btNotif.setEnabled(bool);
		btOthers.setEnabled(bool);
		btTables.setEnabled(bool);
		btUser.setEnabled(bool);
	}
	
	public void homePage() {
		
		logo = new JLabel();
		logo.setBounds(200, 150, 350, 350);
		logo.setIcon(logo_img);
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		homepagePanel.add(logo);
		
		panelBt1 = new JPanel();
		panelBt1.setBounds(screen.width-600, 150, 350, 350);
		panelBt1.setLayout(new GridLayout(5,0,0,10));
		panelBt1.setBackground(Color.darkGray);
		panelBt1.setOpaque(false);
		homepagePanel.add(panelBt1);
		
		btCreateTable = new JButton("<html>Create New Table</html>");
		btCreateTable.setFont(f1);
		btCreateTable.setForeground(Color.white);
		btCreateTable.setOpaque(false);
		btCreateTable.setContentAreaFilled(false);
		btCreateTable.setFocusPainted(false);
		panelBt1.add(btCreateTable);
		
		btSearchDiseases = new JButton("<html>Search For Diseases</html>");
		btSearchDiseases.setFont(f1);
		btSearchDiseases.setForeground(Color.white);
		btSearchDiseases.setOpaque(false);
		btSearchDiseases.setContentAreaFilled(false);
		btSearchDiseases.setFocusPainted(false);
		panelBt1.add(btSearchDiseases);

		btSearchDoctors = new JButton("<html>Search For Close Doctors</html>");
		btSearchDoctors.setFont(f1);
		btSearchDoctors.setForeground(Color.white);
		btSearchDoctors.setOpaque(false);
		btSearchDoctors.setContentAreaFilled(false);
		btSearchDoctors.setFocusPainted(false);
		panelBt1.add(btSearchDoctors);
		
		btChatDoctors = new JButton("<html>Chat With Doctors</html>");
		btChatDoctors.setFont(f1);
		btChatDoctors.setForeground(Color.white);
		btChatDoctors.setOpaque(false);
		btChatDoctors.setContentAreaFilled(false);
		btChatDoctors.setFocusPainted(false);
		panelBt1.add(btChatDoctors);
		
		btTutorial = new JButton("<html>Tutorial</html>");
		btTutorial.setFont(f1);
		btTutorial.setForeground(Color.white);
		btTutorial.setOpaque(false);
		btTutorial.setContentAreaFilled(false);
		btTutorial.setFocusPainted(false);
		panelBt1.add(btTutorial);
	}

	public void userItens(JPanel panel){
		btAccount = new JButton("Account");
		btAccount.setBackground(Color.darkGray);
		btAccount.setForeground(Color.gray);
		btAccount.setFont(f1);
		btAccount.setFocusPainted(false);
		btAccount.setBorderPainted(false);
		panel.add(btAccount);
		
		btLogout = new JButton("Logout");
		btLogout.setBackground(Color.darkGray);
		btLogout.setForeground(Color.gray);
		btLogout.setFont(f1);
		btLogout.setFocusPainted(false);
		btLogout.setBorderPainted(false);
		panel.add(btLogout);
	}
		
	public void initComponents() {
		
		setTitle("Med Control");
		setSize(screen.width,screen.height);
		setIconImage(logoIco.getImage());
		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		setLayout(null);
		
		homepagePanel = new JPanel();
		homepagePanel.setBounds(0, 40, screen.width, screen.height-40);
		homepagePanel.setOpaque(false);
		homepagePanel.setLayout(null);
		homepagePanel.setVisible(false);
		add(homepagePanel);
		
		signInPagePanel = new SignInPagePanel();
		add(signInPagePanel);
		
		configPagePanel = new ConfigPagePanel();
		add(configPagePanel);
		
		createTablePanel = new CreateTablePanel();
		add(createTablePanel);
		
		tablesPanel = new TablesPanel();
		add(tablesPanel);
		
		pnUsername = new JPanel();
		pnUsername.setBounds(screen.width-200, 40, 200, 100);
		pnUsername.setBackground(Color.darkGray);
		pnUsername.setLayout(new GridLayout(2, 1, 0, 0));
		pnUsername.setVisible(false);
		add(pnUsername);
		userItens(pnUsername);
		
		background = new JLabel();
		background.setIcon(background_img);
		add(background);
		background.setBounds(0,40,screen.width,screen.height);
		
		menu();
		
		homePage();
	}
	
	private boolean aux=false;
	
	private void events() {
		
		SignInPagePanel.btLogMed.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				SignInFrame login = new SignInFrame();
				login.setVisible(true);
				homeFrame.setEnabled(false);
			}
		});
		
		btUser.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(aux) {
					pnUsername.setVisible(false);
					aux = false;
				}
				else {
					pnUsername.setVisible(true);
					aux = true;
				}
			}
		});
		
		btLogout.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				menuEnabled(false);
				
				pnUsername.setVisible(false);
				
				signInPagePanel.setVisible(true);
				homepagePanel.setVisible(false);
				configPagePanel.setVisible(false);
				
				btUser.setText("Username");
			}
		});
		
		btConfig.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				configPagePanel.setVisible(true);
				homepagePanel.setVisible(false);
				createTablePanel.setVisible(false);
			}
		});
		
		btHome.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				homepagePanel.setVisible(true);
				configPagePanel.setVisible(false);
				createTablePanel.setVisible(false);
			}
		});
		
		btCreateTable.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				createTablePanel.setVisible(true);
				homepagePanel.setVisible(false);
				configPagePanel.setVisible(false);
				
				verifTable();
			}
		});
		
		btTables.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				tablesPanel.setVisible(true);
				homepagePanel.setVisible(false);
			}
		});
	}
	
	public void verifTable() {
		int pos=0;
		try {
			Connection conn = Sql.getConexao();
			System.out.println(Sql.statusConection()+": verifTable()");
			Statement stmt = conn.createStatement();
			String query = "SELECT id FROM tabelas WHERE "
						 + "idUser = '"+usuario.getId()+"';";
			
			ResultSet rs = stmt.executeQuery(query);
			
			
			while(rs.next()) {
				table.setId(rs.getInt("id"),pos);
				pos++;
			}
			
			conn.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				homeFrame = new HomeFrame();
				homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				homeFrame.setLocationRelativeTo(null);
				homeFrame.setVisible(true);
			}
		});

	}
}
