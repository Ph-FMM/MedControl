package projeto.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Sql {
	
	private final static String HOST = "localhost";
	private final static String PORT = "3306";
	private final static String DATABASE = "medcontrol";
	private final static String USER = "root";
	private final static String PASS = "1234";
	
	private final static String driver = "com.mysql.jdbc.Driver";	
	private final static String myURL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
	
	private static String status = "Not Connected";
	
	public static java.sql.Connection getConexao() {
		java.sql.Connection connect = null;
		
		try {

			Class.forName(driver);
			
			connect = DriverManager.getConnection(myURL,USER,PASS);
			
			if(connect!=null) status = "Sucessfull connected";
			else status = "Impossible to connect";
			
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
