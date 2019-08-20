package projeto.screens;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import projeto.classes.Tabela;

public class CreateTablePanel extends JPanel{
	
	private JPanel tableMenu,tablePanel,showTablePanel,panelBtTabela;
	private JButton btTabela,btAddMed;
	
	private JLabel lbNome2,lbTamX2,lbTamY2,lbDesc2;
	private JLabel lbNome3,lbTamX3,lbTamY3,lbDesc3;
	
	private JLabel lbDelete;
	private JButton btUpdate,btNext,btFoward;
	
	private JButton btSalvar;
	private JLabel lbNomeTabela,lbTamX,lbTamY,lbDesc;
	private JTextField tfNomeTabela,tfTamX,tfTamY;
	private JTextArea taDesc;
	
	private String nome,desc;
	private int tamx,tamy;
	
	ImageIcon deleteico = new ImageIcon(getClass().getResource("/projeto/images/deleteico.png"));
	
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	private JButton btUpdate2;
	
	public CreateTablePanel() {
		initComponents();
		events();
	}
	
	public void opcoesMenu(){
		btTabela = new JButton("Tabela");
		btTabela.setBounds(0, 10, 250, 70);
		btTabela.setBackground(Color.gray.darker());
		btTabela.setForeground(Color.white);
		btTabela.setFocusPainted(false);
		btTabela.setBorderPainted(false);
		add(btTabela);
		
		btAddMed = new JButton("Add Medicines");
		btAddMed.setBounds(0, 90, 250, 70);
		btAddMed.setBackground(Color.gray.darker());
		btAddMed.setForeground(Color.white);
		btAddMed.setFocusPainted(false);
		btAddMed.setBorderPainted(false);
		add(btAddMed);
	}
	
	public void clickTabela(){
		panelBtTabela = new JPanel();
		panelBtTabela.setBounds(280, 30, screen.width-290, screen.height-140);
		panelBtTabela.setOpaque(false);
		panelBtTabela.setLayout(null);
		panelBtTabela.setVisible(false);
		add(panelBtTabela);
		
		tablePanel = new JPanel();
		tablePanel.setBounds(0, 0, (screen.width/3)+50, 250);
		tablePanel.setBackground(new Color(75, 75, 75, 123));
		Border empty = BorderFactory.createEmptyBorder();
		TitledBorder title = BorderFactory.createTitledBorder(empty,"TABELA");
		title.setTitleColor(Color.decode("#b1b1b1"));
		tablePanel.setLayout(null);
		tablePanel.setBorder(title);
		panelBtTabela.add(tablePanel);
		
		lbNomeTabela = new JLabel("Nome:");
		lbNomeTabela.setBounds(10, 40, 50, 20);
		lbNomeTabela.setForeground(Color.decode("#b1b1b1"));
		tablePanel.add(lbNomeTabela);
		
		tfNomeTabela = new JTextField();
		tfNomeTabela.setBounds(10, 60, 150, 20);
		tablePanel.add(tfNomeTabela);
		
		lbTamX = new JLabel("Tamanho X:");
		lbTamX.setBounds(10, 90, 70, 20);
		lbTamX.setForeground(Color.decode("#b1b1b1"));
		tablePanel.add(lbTamX);
		
		tfTamX = new JTextField();
		tfTamX.setBounds(90, 90, 30, 20);
		tablePanel.add(tfTamX);
		
		lbTamY = new JLabel("Tamanho Y:");
		lbTamY.setBounds(10, 120, 70, 20);
		lbTamY.setForeground(Color.decode("#b1b1b1"));
		tablePanel.add(lbTamY);
		
		tfTamY = new JTextField();
		tfTamY.setBounds(90, 120, 30, 20);
		tablePanel.add(tfTamY);
		
		lbDesc = new JLabel("Description:");
		lbDesc.setBounds(((screen.width/3)+50)/2, 40, 70, 20);
		lbDesc.setForeground(Color.decode("#b1b1b1"));
		tablePanel.add(lbDesc);
		
		taDesc = new JTextArea();
		taDesc.setBounds(((screen.width/3)+50)/2, 60, 200, 80);
		tablePanel.add(taDesc);
		
		btSalvar = new JButton("Create Table");
		btSalvar.setBounds(((screen.width/3)+50)/3, 200, ((screen.width/3)+50)/3, 25);
		tablePanel.add(btSalvar);
		
		btUpdate2 = new JButton("Update");
		btUpdate2.setBounds(((screen.width/3)+50)/3, 200, ((screen.width/3)+50)/3, 25);
		btUpdate2.setVisible(false);
		tablePanel.add(btUpdate2);
	}
	private JPanel backPanel1;

	private JPanel backPanel2;

	private JPanel backPanel3;

	private Component backPanel4;
	public void showTables() {
		showTablePanel = new JPanel();
		showTablePanel.setBounds(0, 270, (screen.width/3)+50, 250);
		showTablePanel.setBackground(new Color(75, 75, 75, 123));
		Border empty = BorderFactory.createEmptyBorder();
		TitledBorder title = BorderFactory.createTitledBorder(empty,"CREATED TABELAS");
		title.setTitleColor(Color.decode("#b1b1b1"));
		showTablePanel.setLayout(null);
		showTablePanel.setBorder(title);
		showTablePanel.setVisible(false);
		panelBtTabela.add(showTablePanel);
		
		//Enunciado
		lbNome2 = new JLabel("Nome:");
		lbNome2.setBounds(10, 40, 50, 20);
		lbNome2.setForeground(Color.decode("#b1b1b1"));
		showTablePanel.add(lbNome2);
		
		lbTamX2 = new JLabel("Tamanho X:");
		lbTamX2.setBounds(10, 90, 70, 20);
		lbTamX2.setForeground(Color.decode("#b1b1b1"));
		showTablePanel.add(lbTamX2);
		
		lbTamY2 = new JLabel("Tamanho Y:");
		lbTamY2.setBounds(10, 120, 70, 20);
		lbTamY2.setForeground(Color.decode("#b1b1b1"));
		showTablePanel.add(lbTamY2);
		
		lbDesc2 = new JLabel("Description:");
		lbDesc2.setBounds(((screen.width/3)+50)/2, 40, 70, 20);
		lbDesc2.setForeground(Color.decode("#b1b1b1"));
		showTablePanel.add(lbDesc2);
		
		//Resposta
		lbNome3 = new JLabel();
		lbNome3.setBounds(10, 60, 150, 20);
		lbNome3.setBackground(new Color(75, 75, 75, 123));
		lbNome3.setForeground(Color.decode("#b1b1b1"));
		showTablePanel.add(lbNome3);
		
		backPanel2 = new JPanel();
		backPanel2.setBounds(10, 60, 150, 20);
		backPanel2.setBackground(Color.black);
		showTablePanel.add(backPanel2);
		
		lbTamX3 = new JLabel();
		lbTamX3.setBounds(90, 90, 30, 20);
		lbTamX3.setBackground(new Color(75, 75, 75, 123));
		lbTamX3.setForeground(Color.decode("#b1b1b1"));
		showTablePanel.add(lbTamX3);
		
		backPanel3 = new JPanel();
		backPanel3.setBounds(90, 90, 30, 20);
		backPanel3.setBackground(Color.black);
		showTablePanel.add(backPanel3);
		
		lbTamY3 = new JLabel();
		lbTamY3.setBounds(90, 120, 30, 20);
		lbTamY3.setBackground(new Color(75, 75, 75, 123));
		lbTamY3.setForeground(Color.decode("#b1b1b1"));
		showTablePanel.add(lbTamY3);
		
		backPanel4 = new JPanel();
		backPanel4.setBounds(90, 120, 30, 20);
		backPanel4.setBackground(Color.black);
		showTablePanel.add(backPanel4);
		
		
		lbDesc3 = new JLabel();
		lbDesc3.setBounds(((screen.width/3)+50)/2, 60, 200, 80);
		lbDesc3.setBackground(new Color(0, 0, 0, 0));
		lbDesc3.setForeground(Color.decode("#b1b1b1"));
		showTablePanel.add(lbDesc3);
		
		backPanel1 = new JPanel();
		backPanel1.setBounds(((screen.width/3)+50)/2, 60, 200, 80);
		backPanel1.setBackground(Color.black);
		showTablePanel.add(backPanel1);
		
		//Botoes
		btUpdate = new JButton("Update");
		btUpdate.setBounds(((screen.width/3)+50)/3, 200, ((screen.width/3)+50)/3, 25);
		showTablePanel.add(btUpdate);
		
		btNext = new JButton(">>");
		btNext.setBounds((((screen.width/3)+50)/3)+(((screen.width/3)+50)/3)+5,200,50,25);
		showTablePanel.add(btNext);
		
		btFoward = new JButton("<<");
		btFoward.setBounds((((screen.width/3)+50)/3)-55,200,50,25);
		btFoward.setEnabled(false);
		showTablePanel.add(btFoward);
		
		lbDelete = new JLabel(deleteico);
		lbDelete.setBounds((screen.width/3)+30, 0, 20, 20);
		showTablePanel.add(lbDelete);
		
	}
	
	public void initComponents() {
		setBounds(0, 40, screen.width, screen.height-40);
		setLayout(null);
		setOpaque(false);
		setVisible(false);
		
		opcoesMenu();
		
		tableMenu = new JPanel();
		tableMenu.setBackground(Color.gray.darker());
		tableMenu.setBounds(0, 0, 250, screen.height-40);
		add(tableMenu);
		
		clickTabela();
		
		showTables();
	}
	
	private boolean salvar = false;
	private int i=0,idTabela,posUpdate;
	
	public void events() {
		lbDelete.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				HomeFrame.table.deleteTabela(HomeFrame.table.getId(i));
				
				i=0;
				
				JOptionPane.showMessageDialog(null, "Tabela sucessfull deleted");
				
				btTabela.doClick();
				
				btFoward.setEnabled(false);
	        }
		});
		
		btUpdate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				tfNomeTabela.setText(HomeFrame.table.getNome(i));
				tfTamX.setText(String.valueOf(HomeFrame.table.getTamx(i)));
				tfTamY.setText(String.valueOf(HomeFrame.table.getTamy(i)));
				taDesc.setText(HomeFrame.table.getDescri(i));
				idTabela = HomeFrame.table.getId(i);
				posUpdate = i;
				
				btUpdate2.setVisible(true);
				btSalvar.setVisible(false);
			}
		});
		btUpdate2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String nome = tfNomeTabela.getText();
				String desc = taDesc.getText();
				int tamx = Integer.parseInt(tfTamX.getText());
				int tamy = Integer.parseInt(tfTamY.getText());
				
				HomeFrame.table.updateTabela(nome,desc,tamx,tamy,idTabela,posUpdate);
				
				tfNomeTabela.setText("");
				tfTamX.setText("");
				tfTamY.setText("");
				taDesc.setText("");
				
				btTabela.doClick();
				
				btUpdate2.setVisible(false);
				btSalvar.setVisible(true);
			}
		});
		
		btNext.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				i++;
				
				lbNome3.setText(HomeFrame.table.getNome(i));
				lbTamX3.setText(String.valueOf(HomeFrame.table.getTamx(i)));
				lbTamY3.setText(String.valueOf(HomeFrame.table.getTamy(i)));
				lbDesc3.setText(HomeFrame.table.getDescri(i));
				
				if(i>=HomeFrame.table.getLength()-1) {
					btNext.setEnabled(false);
				}
				btFoward.setEnabled(true);
			}
		});
		
		btFoward.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				i--;
				
				lbNome3.setText(HomeFrame.table.getNome(i));
				lbTamX3.setText(String.valueOf(HomeFrame.table.getTamx(i)));
				lbTamY3.setText(String.valueOf(HomeFrame.table.getTamy(i)));
				lbDesc3.setText(HomeFrame.table.getDescri(i));
				
				if(i<=0) { 
					btFoward.setEnabled(false);
				}
				btNext.setEnabled(true);
			}
		});
		
		btTabela.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				panelBtTabela.setVisible(true);
				
				if(HomeFrame.table.getId(0)!=0) {
					salvar = true;
					
					lbNome3.setText(HomeFrame.table.getNome(i));
					lbTamX3.setText(String.valueOf(HomeFrame.table.getTamx(i)));
					lbTamY3.setText(String.valueOf(HomeFrame.table.getTamy(i)));
					lbDesc3.setText(HomeFrame.table.getDescri(i));
				}
				showTablePanel.setVisible(salvar);
			}
		});
		
		btSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				nome = tfNomeTabela.getText();
				desc = taDesc.getText();
				tamx = Integer.parseInt(tfTamX.getText());
				tamy = Integer.parseInt(tfTamY.getText());
				
				HomeFrame.table.createTabela(nome,desc,tamx,tamy);
				
				tfNomeTabela.setText("");
				tfTamX.setText("");
				tfTamY.setText("");
				taDesc.setText("");
				
				if(HomeFrame.table.getId(0)!=0) {
					salvar = true;
					
					lbNome3.setText(HomeFrame.table.getNome(i));
					lbTamX3.setText(String.valueOf(HomeFrame.table.getTamx(i)));
					lbTamY3.setText(String.valueOf(HomeFrame.table.getTamy(i)));
					lbDesc3.setText(HomeFrame.table.getDescri(i));
				}
				showTablePanel.setVisible(salvar);
			}
		});
	}
}
