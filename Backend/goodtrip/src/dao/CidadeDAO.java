package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.ConnectionMySQL;
import modelos.Cidade;

public class CidadeDAO {
	//create
	public void create(Cidade cidade) {
		String sql = "UPDATE cidade SET nome_cidade = ? WHERE id_cidade = ?;";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionMySQL.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, cidade.getNome());
            
            pstm.execute();
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            //Fecha as conexões
            try{
                if(pstm != null){
                pstm.close();
            }
                
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
	//read
	
	//update
	
	//delete
}
