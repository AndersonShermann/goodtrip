package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Usuario;

public class UsuarioDAO {
	//create
	public void create(Usuario usuario) {
		String sql = "insert into usuario (nome_usuario, cpf, senha) values(?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionMySQL.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, usuario.getNome());
            pstm.setInt(2, usuario.getCpf());
            pstm.setString(3, usuario.getSenha());
            
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
	public List<Usuario> read(){
		List<Usuario> usuario = new ArrayList<Usuario>();
		
		String sql = "select * from usuario;";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        
        try{
            conn = ConnectionMySQL.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            
            while(rset.next()){
                Usuario usuario1 = new Usuario();
                
                usuario1.setId(rset.getInt("id_usuario"));
                usuario1.setNome(rset.getString("nome_usuario"));
                usuario1.setCpf(rset.getInt("cpf"));
                usuario1.setSenha(rset.getString("senha"));
                
                usuario.add(usuario1);
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
		return usuario;
    }
		
	
	//update
	public void update(Usuario usuario) {
		 String sql = "UPDATE usuario SET nome_usuario = ?, cpf = ?, senha = ? WHERE id_usuario = ?;";
	        
	        Connection conn = null;
	        PreparedStatement pstm = null;
	        
	        try{
	            conn = ConnectionMySQL.createConnectionToMySQL();
	            pstm = conn.prepareCall(sql);
	            
	            pstm.setString(1, usuario.getNome());
	            pstm.setInt(2, usuario.getCpf());
	            pstm.setString(3, usuario.getSenha());
	            pstm.setInt(4, usuario.getId());
	            
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
		String sql = "DELETE FROM usuario where id_usuario = ?;";
        
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
	
	//readById
	public Usuario readById(int id) {
		Usuario usuario = new Usuario();
		
		String sql = "SELECT * from usuario WHERE id_usuario = ?;";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
		
		try{
            conn = ConnectionMySQL.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            pstm.setInt(1, id);
                    
            rset = pstm.executeQuery();
            if (rset.next()) {
                usuario.setId(rset.getInt("id_usuario"));
                usuario.setNome(rset.getString("nome_usuario"));
                usuario.setCpf(rset.getInt("cpf"));
                usuario.setSenha(rset.getString("senha"));	
            }
             
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
		return new Usuario();
		
	}
}
