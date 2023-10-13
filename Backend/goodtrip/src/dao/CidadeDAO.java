package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Cidade;
import modelos.Usuario;

public class CidadeDAO {
	//create
	public void create(Cidade cidade) {
		String sql = "insert into cidade (nome_cidade) values (?);";
        
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
	public List<Cidade> read(){
		List<Cidade> cidade = new ArrayList<Cidade>();
		
		String sql = "select * from cidade;";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        
        try{
            conn = ConnectionMySQL.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            
            while(rset.next()){
                Cidade cidade1 = new Cidade();
                
                cidade1.setId(rset.getInt("id_cidade"));
                cidade1.setNome(rset.getString("nome_cidade"));
                
                cidade.add(cidade1);
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
		return cidade;
    }
	//update
	public void update(Cidade cidade) {
		 String sql = "UPDATE cidade SET nome_cidade = ? WHERE id_cidade = ?;";
	        
	        Connection conn = null;
	        PreparedStatement pstm = null;
	        
	        try{
	            conn = ConnectionMySQL.createConnectionToMySQL();
	            pstm = conn.prepareCall(sql);
	            
	            pstm.setString(1, cidade.getNome());
	            pstm.setInt(2, cidade.getId());
	            
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
	
	//delete
	public void delete(int id) {
		String sql = "DELETE FROM cidade WHERE id_cidade = ?;";
        
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
