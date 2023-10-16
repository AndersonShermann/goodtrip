package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Passagem;
import modelos.Passagem;


public class PassagemDAO {
	//Create
	public void create(Passagem passagem) {
		String sql = "insert into passagem (valor, poltrona, data_viagem, fk_horario_id_horario, fk_usuario_id_usuario) values(?, ?, ?, ?, ?);";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionMySQL.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            pstm.setDouble(1, passagem.getValor());
            pstm.setString(2, passagem.getPoltrona());
            pstm.setString(3, passagem.getData_viagem());
            pstm.setInt(4, 6);
            pstm.setInt(5, 27);
            
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
	public List<Passagem> read(){
		List<Passagem> passagem = new ArrayList<Passagem>();
		
		String sql = "select * from passagem;";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        
        try{
            conn = ConnectionMySQL.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            
            while(rset.next()){
                Passagem passagem1 = new Passagem();
                
                passagem1.setId(rset.getInt("id_passagem"));
                passagem1.setData_viagem(rset.getString("data_viagem"));;
                passagem1.setValor(rset.getDouble("valor"));;
                passagem1.setPoltrona(rset.getString("poltrona"));;
                
                passagem.add(passagem1);
            }
            
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
		return passagem;
    }
	
	//Update
	public void update(Passagem passagem) {
		 String sql = "UPDATE passagem SET valor = ?, poltrona = ?, data_viagem = ?, fk_horario_id_horario = ?, fk_usuario_id_usuario = ? WHERE id_passagem = ?;";
	        
	        Connection conn = null;
	        PreparedStatement pstm = null;
	        
	        try{
	            conn = ConnectionMySQL.createConnectionToMySQL();
	            pstm = conn.prepareCall(sql);
	            
	            pstm.setDouble(1, passagem.getValor());
	            pstm.setString(2, passagem.getPoltrona());
	            pstm.setString(3, passagem.getData_viagem());
	            pstm.setInt(4, 7);
	            pstm.setInt(5, 28);
	            pstm.setInt(6, passagem.getId());
	            
	            pstm.execute();
	        }catch(Exception e){
	            e.printStackTrace();
	        }finally{
	            //Fecha as conexões
	            try{
	                if(pstm!=null){
	                    pstm.close();
	                }
	                if(conn!=null){
	                    conn.close();
	                }
	            }catch(Exception e){
	                e.printStackTrace();
	            }
	        }
	    }
	
	//Delete
	public void delete(int id) {
		String sql = "DELETE FROM passagem where id_passagem = ?;";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionMySQL.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            pstm.setInt(1, id);
            pstm.execute();
            
        }catch(Exception e){
          e.printStackTrace();
        }finally{
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
		
	}
	
	
}
