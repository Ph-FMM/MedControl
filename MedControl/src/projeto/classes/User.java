package projeto.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import projeto.screens.HomeFrame;
import projeto.sql.Sql;

public class User {
	private String nome,cpf,cep,endereco;
	private String email,userName,senha;
	private double peso;
	private int idade,id,idConta;
	
	public User(){
		
	}
	
	//CRUD
	public void createUser(String emailuser, String username, String pswd) {
		try {
			setEmail(emailuser);
			setUserName(username);
			setSenha(pswd);
			
			java.sql.Connection conn = Sql.getConexao();
			System.out.println(Sql.statusConection()+": createUser()");
			
			String query = "INSERT INTO conta(email,userName,senha,stats) VALUES(?,?,?,?)";
			
			java.sql.PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, emailuser);
			stmt.setString(2, username);
			stmt.setString(3, pswd);
			stmt.setString(4, "1");
			
			stmt.execute();
			conn.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void readUser(String username) {
		try {
			Connection conn = Sql.getConexao();
			System.out.println(Sql.statusConection()+": readUser()");
			Statement stmt = conn.createStatement();
			
			String query = "SELECT conta.id,usuario.id, usuario.nome, usuario.idade, "
					+ "usuario.peso, usuario.endereco, usuario.cep, "
					+ "usuario.cpf, conta.email FROM usuario JOIN "
					+ "conta ON conta.id = usuario.idConta "
					+ "WHERE conta.userName = '"+username+"';";
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				setIdConta(rs.getInt("conta.id"));
				setId(rs.getInt("usuario.id"));
				setCep(rs.getString("cep"));
				setCpf(rs.getString("cep"));
				setEndereco(rs.getString("endereco"));
				setIdade(rs.getInt("idade"));
				setNome(rs.getString("usuario.nome"));
				setPeso(rs.getFloat("peso"));
				setEmail(rs.getString("email"));
			}
			
			setUserName(username);
			
			if(getIdConta()==0) {
				String query2 = "SELECT id FROM conta WHERE userName = '"+username+"';";
				rs = stmt.executeQuery(query2);
				
				while(rs.next()) setIdConta(rs.getInt("id"));
			}
			conn.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void updateUser(String nome,int idade,double peso,String cpf,String cep,String endereco) {
		try {
			Connection conn = Sql.getConexao();
			System.out.println(Sql.statusConection()+": updateUser()");
			String query = "UPDATE usuario SET nome = ?, idade = ?, peso = ?, "
						 + "cpf = ?, cep = ?, endereco = ? WHERE id = ?;";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			
			stmt.setString(1, nome);
			stmt.setInt(2, idade);
			stmt.setDouble(3, peso);
			stmt.setString(4, cpf);
			stmt.setString(5, cep);
			stmt.setString(6, endereco);
			stmt.setInt(7, id);
			
			stmt.execute();
			
			conn.close();
			
			setNome(nome);
			setIdade(idade);
			setPeso(peso);
			setCpf(cpf);
			setCep(cep);
			setEndereco(endereco);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteUser(String username,String senha) {
		try {
			Connection conn = Sql.getConexao();
			System.out.println(Sql.statusConection()+": deleteUser()");
			String query = "UPDATE conta SET `stats` = '0' WHERE senha = ? AND userName = ?;";
			PreparedStatement stmt = conn.prepareStatement(query);
			
			stmt.setString(1, senha);
			stmt.setString(2, username);
			
			stmt.execute();
			
			conn.close();
			
			JOptionPane.showMessageDialog(null, "Account sucessfull deleted");
			
			HomeFrame.btLogout.doClick();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Table: usuario
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}
	
	//Table: conta
	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdConta() {
		return idConta;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}
}
