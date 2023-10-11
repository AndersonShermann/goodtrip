package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySQL {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/goodtrip";
    
    
    public static Connection createConnectionToMySQL() throws Exception{
    	//Faz com que a classe seja carregada pela JVM
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //Cria conexão com banco de dados
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        
        return connection;
    }
    
    public static void main(String[] args) throws Exception {
        //Recupera uma conexão com o banco de dados
        Connection con = createConnectionToMySQL();
        
        //Testa conexão
        if(con!=null){
            System.out.println("Conexão obtida com sucesso!\n" + con);
            con.close();
        }
    }
}
