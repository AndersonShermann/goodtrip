package crud;

import java.util.Scanner;

import dao.UsuarioDAO;
import modelos.Usuario;

public class UsuarioCRUD {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		int opcao = 0, id = 0, cpf = 0;
		
		String nome = "", senha = ""; 
		
		do {
			System.out.println("\n=================USUARIOS=================\n");
			System.out.println("1-CRIAR\n2-CONSULTAR\n3-ATUALIZAR\n4-DELETAR\n5-CONSULTAR POR ID\n0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch(opcao) {
			case 1:
				System.out.println("Nome:");
				nome = s.nextLine();
				
				System.out.println("CPF:");
				cpf = s.nextInt();
				
				System.out.println("Senha:");
				senha = s.next();
				
				Usuario usuario1 = new Usuario(nome, cpf, senha);
				
				usuarioDAO.create(usuario1);
				
				break;
			case 2:
				for(Usuario u : usuarioDAO.read()) {
					System.out.println(u.toString());
				}
				break;
			case 3:
				
				System.out.println("Id:");
				id = s.nextInt();
				s.nextLine();
				
				System.out.println("Nome:");
				nome = s.nextLine();
				
				System.out.println("CPF:");
				cpf = s.nextInt();
				
				System.out.println("Senha:");
				senha = s.next();
				
				Usuario usuario2 = new Usuario(id, nome, cpf, senha);
				usuarioDAO.update(usuario2);
				
				break;
			case 4:
				System.out.println("Digite um id: ");
				
				id = s.nextInt();
				s.nextLine();
				
				usuarioDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id: ");
				id = s.nextInt();
				s.nextLine();
				
				Usuario usuario3 = usuarioDAO.readById(id);
				System.out.println(usuario3.toString());
				break;
			default:
				
				break;
			}
			
		}while(opcao!=0);
		System.out.println("Volte Sempre!");
	}

}
