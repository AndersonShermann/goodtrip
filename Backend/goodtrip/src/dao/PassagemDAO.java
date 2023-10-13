package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.ConnectionMySQL;
import modelos.Passagem;



public class PassagemDAO {
	//Create
	public void create(Passagem passagem) {
		String sql = "insert into passagem (valor, poltrona, data_viagem, fk_usuario_id_usuario) values(?, ?, ?, ?);";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionMySQL.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            pstm.setDouble(1, passagem.getValor());
            pstm.setString(2, passagem.getPoltrona());
            pstm.setString(3, passagem.getData_viagem());
            pstm.setInt(4, 27);
            
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
	
	//Read
	
	
	//Update
	
	
	//Delete
	
	
	
}
