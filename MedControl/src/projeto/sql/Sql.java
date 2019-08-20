package projeto.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Sql {
	
	private static String status = "Not Connected";
	public static java.sql.Statement stmt;
	
	public Sql(){
		
	}
	
	public static java.sql.Connection getConexao() {
		java.sql.Connection connect = null;
		
		try {
			String driver = "com.mysql.jdbc.Driver";
			String myURL = "jdbc:mysql://localhost:3306/medcontrol";
			
			Class.forName(driver);
			
			connect = DriverManager.getConnection(myURL,"root","");
			
			if(connect!=null) status = "Sucessfull connected";
			else status = "Impossible to connect";
			
			stmt = connect.createStatement();
			
			return connect;
		}
		catch(ClassNotFoundException e) {
			System.out.println("O driver expecificado nao foi encontrado.");
			 
            return null;
		}
		catch (SQLException e) {
			System.out.println("Nao foi possivel conectar ao Banco de Dados.");
			 
            return null;
		}
	}
	
	public static String statusConection() {
		 
        return status;
 
    }
	
	public static boolean closeConexao() {
        try {
        	
            Sql.getConexao().close();
            return true;
 
        } catch (SQLException e) {
 
            return false;
        }
    }
	
	public static java.sql.Connection reiniciarConexao() {
		 
        closeConexao();
        return Sql.getConexao();
 
    }
}
