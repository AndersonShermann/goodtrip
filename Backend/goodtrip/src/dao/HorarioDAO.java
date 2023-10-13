package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Horario;

public class HorarioDAO {
	//create
		public void create(Horario horario) {
			String sql = "insert into horario (hora_saida, tempo_viagem, fk_cidade_id_cidade_origem, fk_cidade_id_cidade_destino)  values (?, ?, ?, ?)";
	        
	        Connection conn = null;
	        PreparedStatement pstm = null;
	        
	        try{
	            conn = ConnectionMySQL.createConnectionToMySQL();
	            pstm = conn.prepareStatement(sql);
	            
	            pstm.setTime(1, horario.getHora_saida());
	            pstm.setTime(2, horario.getTempo_viagem());
	            pstm.setInt(3, 1);
	            pstm.setInt(4, 2);
	            
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
		public List<Horario> read(){
			List<Horario> horario = new ArrayList<Horario>();
			
			String sql = "select * from horario;";
	        
	        Connection conn = null;
	        PreparedStatement pstm = null;
	        ResultSet rset = null;
	        
	        try{
	            conn = ConnectionMySQL.createConnectionToMySQL();
	            pstm = conn.prepareStatement(sql);
	            rset = pstm.executeQuery();
	            
	            while(rset.next()){
	                Horario horario1 = new Horario();
	                
	                horario1.setId(rset.getInt("id_horario"));
	                horario1.setNome(rset.getString("nome_horario"));
	                horario1.setCpf(rset.getInt("cpf"));
	                horario1.setSenha(rset.getString("senha"));
	                
	                horario.add(horario1);
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
			return horario;
	    }
			
		
		//update
		public void update(Horario horario) {
			 String sql = "UPDATE horario SET nome_horario = ?, cpf = ?, senha = ? WHERE id_horario = ?;";
		        
		        Connection conn = null;
		        PreparedStatement pstm = null;
		        
		        try{
		            conn = ConnectionMySQL.createConnectionToMySQL();
		            pstm = conn.prepareCall(sql);
		            
		            pstm.setString(1, horario.getNome());
		            pstm.setInt(2, horario.getCpf());
		            pstm.setString(3, horario.getSenha());
		            pstm.setInt(4, horario.getId());
		            
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
			String sql = "DELETE FROM horario where id_horario = ?;";
	        
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
		public Horario readById(int id) {
			Horario horario = new Horario();
			
			String sql = "SELECT * from horario WHERE id_horario = ?;";
	        
	        Connection conn = null;
	        PreparedStatement pstm = null;
	        ResultSet rset = null;
			
			try{
	            conn = ConnectionMySQL.createConnectionToMySQL();
	            pstm = conn.prepareStatement(sql);
	            
	            pstm.setInt(1, id);
	                    
	            rset = pstm.executeQuery();
	            if (rset.next()) {
	                horario.setId(rset.getInt("id_horario"));
	                horario.setNome(rset.getString("nome_horario"));
	                horario.setCpf(rset.getInt("cpf"));
	                horario.setSenha(rset.getString("senha"));	
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
			return new Horario();
			
		}
	}
