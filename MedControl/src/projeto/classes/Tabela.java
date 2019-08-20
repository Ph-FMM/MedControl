package projeto.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import projeto.screens.HomeFrame;
import projeto.sql.Sql;

public class Tabela {
	private String[] nome = new String[10],descri= new String[10];
	private int[] tamx = new int[10],tamy = new int[10],id = new int[10];
	private int length=0,idUser;
	
	public Tabela() {
		
	}
	
	public void createTabela(String nome,String desc,int tamX,int tamY){
		try {
			setNome(nome,length);
			setDescri(desc,length);
			setTamx(tamX,length);
			setTamy(tamY,length);
			
			Connection conn = Sql.getConexao();
			System.out.println(Sql.statusConection()+": createTabela()");
			
			String query = "INSERT INTO tabelas(nome,tamx,tamy,descri,idUser) "
						 + "VALUES(?,?,?,?,?)";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			
			stmt.setString(1, nome);
			stmt.setInt(2, tamX);
			stmt.setInt(3, tamY);
			stmt.setString(4, desc);
			stmt.setInt(5, HomeFrame.usuario.getId());
			
			stmt.execute();
			conn.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void readTabela(int idUser){
		int i=0;
		try {
			setIdUser(idUser);
			
			Connection conn = Sql.getConexao();
			System.out.println(Sql.statusConection()+": readTabela()");
			Statement stmt = conn.createStatement();
			String query = "SELECT id, nome, tamx, tamy, descri, idUser "
						 + "FROM tabelas WHERE idUser = '"+idUser+"';";
			
			ResultSet rs = stmt.executeQuery(query);
			
			
			while(rs.next()) {
				setId(rs.getInt("id"),i);
				setNome(rs.getString("nome"),i);
				setTamx(rs.getInt("tamx"),i);
				setTamy(rs.getInt("tamy"),i);
				setDescri(rs.getString("descri"),i);
				setIdUser(rs.getInt("idUser"));
				setLength(getLength() + 1);
				i++;
			}
			
			conn.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateTabela(String nome,String desc,int tamX,int tamY,int id,int i){
		try {
			Connection conn = Sql.getConexao();
			System.out.println(Sql.statusConection()+": updateTabela()");
			String query = "UPDATE tabelas SET nome = ?, tamx = ?, tamy = ?, "
						 + "descri = ? WHERE id = ?;";
			PreparedStatement stmt = conn.prepareStatement(query);
			
			stmt.setString(1, nome);
			stmt.setInt(2, tamX);
			stmt.setInt(3, tamY);
			stmt.setString(4, desc);
			stmt.setInt(5, id);
			
			stmt.execute();
			
			conn.close();
			
			setNome(nome,i);
			setTamx(tamX,i);
			setTamy(tamY,i);
			setDescri(desc,i);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteTabela(int id){
		try {
			Connection conn = Sql.getConexao();
			System.out.println(Sql.statusConection()+": deleteTabela()");
			Statement stmt = conn.createStatement();
			String query = "DELETE FROM tabelas WHERE id = "+id+";";
			
			stmt.execute(query);
			
			conn.close();
			
			for(int i=0;i<length-1;i++) {
				setId(getId(i+1), i);
				setNome(getNome(i+1),i);
				setTamx(getTamx(i+1),i);
				setTamy(getTamy(i+1),i);
				setDescri(getDescri(i+1),i);
				i++;
			}
			
			setLength(getLength()-1);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getNome(int pos) {
		return nome[pos];
	}

	public void setNome(String nome,int pos) {
		this.nome[pos] = nome;
	}

	public String getDescri(int pos) {
		return descri[pos];
	}

	public void setDescri(String descri,int pos) {
		this.descri[pos] = descri;
	}

	public int getTamx(int pos) {
		return tamx[pos];
	}

	public void setTamx(int tamx,int pos) {
		this.tamx[pos] = tamx;
	}

	public int getTamy(int pos) {
		return tamy[pos];
	}

	public void setTamy(int tamy,int pos) {
		this.tamy[pos] = tamy;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getId(int pos) {
		return id[pos];
	}

	public void setId(int id,int pos) {
		this.id[pos] = id;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}


