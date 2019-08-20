package projeto.screens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SignInPagePanel extends JPanel{
	
	private JPanel panelTxt,panelLogIn;
	private JLabel txt_back1,txt_back2,txt_back3,lbLogIn;
	

	public static JButton btLogMed,btLogGoogle,btLogFace;
	
	ImageIcon txtback1 = new ImageIcon(getClass().getResource("/projeto/images/txtback1.jpg"));
	ImageIcon txtback2 = new ImageIcon(getClass().getResource("/projeto/images/txtback2.png"));
	ImageIcon txtback3 = new ImageIcon(getClass().getResource("/projeto/images/txtback3.png"));
	ImageIcon googleIcon = new ImageIcon(getClass().getResource("/projeto/images/LogarGoogle.png"));	
	ImageIcon MedIcon = new ImageIcon(getClass().getResource("/projeto/images/btMedControl.png"));	
	ImageIcon FaceIcon = new ImageIcon(getClass().getResource("/projeto/images/LogarFace.png"));

	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	
	Font f1 = new Font(Font.SANS_SERIF,Font.PLAIN,17);
	
	public SignInPagePanel(){
		initComponents();
	}
	
	public void initComponents(){
		setBounds(200,130,screen.width-400,screen.height-260);
		setLayout(null);
		setBackground(Color.gray.darker().darker());
		setVisible(true);
		
		txt_back1 = new JLabel();
		txt_back1.setIcon(txtback1);
		
		txt_back2 = new JLabel();
		txt_back2.setIcon(txtback2);
		
		txt_back3 = new JLabel();
		txt_back3.setIcon(txtback3);
		
		panelTxt = new JPanel();
		panelTxt.setBounds(0, 0, 400, getHeight());
		panelTxt.setBackground(Color.darkGray);
		panelTxt.setLayout(new GridLayout(3,1,0,11));
		add(panelTxt);
		
		panelTxt.add(txt_back1);
		panelTxt.add(txt_back2);
		panelTxt.add(txt_back3);
		
		lbLogIn = new JLabel("Log in with your account");
		lbLogIn.setBounds(440, 30, 200, 25);
		lbLogIn.setFont(f1);
		lbLogIn.setForeground(Color.gray.brighter());
		add(lbLogIn);
		
		panelLogIn = new JPanel();
		panelLogIn.setBounds(540, 150, 300, 170);
		panelLogIn.setOpaque(false);
		panelLogIn.setLayout(new GridLayout(3,1,0,10));
		add(panelLogIn);
		
		
		btLogMed = new JButton();
		btLogMed.setIcon(MedIcon);
		btLogMed.setSize(300,50);
		btLogMed.setForeground(Color.white);
		btLogMed.setBackground(Color.red);
		btLogMed.setOpaque(false);
		btLogMed.setFocusPainted(false);
		panelLogIn.add(btLogMed);
		
		btLogGoogle = new JButton();
		btLogGoogle.setIcon(googleIcon);
		btLogGoogle.setSize(300,50);
		btLogGoogle.setBackground(Color.white);
		btLogGoogle.setOpaque(false);
		btLogGoogle.setFocusPainted(false);
		panelLogIn.add(btLogGoogle);
		
		btLogFace = new JButton();
		btLogFace.setIcon(FaceIcon);
		btLogFace.setSize(300,50);
		btLogFace.setForeground(Color.white);
		btLogFace.setBackground(Color.blue);
		btLogFace.setOpaque(false);
		btLogFace.setFocusPainted(false);
		panelLogIn.add(btLogFace);
	}
}
