package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Cidade;
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
	            pstm.setInt(3, 3);
	            pstm.setInt(4, 4);
	            
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
	                horario1.setHora_saida(rset.getTime("hora_saida"));;
	                horario1.setTempo_viagem(rset.getTime("tempo_viagem"));;
	                
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
			 String sql = "UPDATE horario SET hora_saida = ?, tempo_viagem = ?, fk_cidade_id_cidade_origem = ?, fk_cidade_id_cidade_destino = ? WHERE id_horario = ?;";
		        
		        Connection conn = null;
		        PreparedStatement pstm = null;
		        
		        try{
		            conn = ConnectionMySQL.createConnectionToMySQL();
		            pstm = conn.prepareCall(sql);
		            
		            pstm.setTime(1, horario.getHora_saida());
		            pstm.setTime(2, horario.getTempo_viagem());
		            pstm.setInt(3, 5);
		            pstm.setInt(4, 6);
		            pstm.setInt(5, horario.getId());
		            
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
	}
