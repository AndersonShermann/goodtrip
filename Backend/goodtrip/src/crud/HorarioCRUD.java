package crud;

import java.util.Scanner;

import dao.UsuarioDAO;
import modelos.Usuario;

public class HorarioCRUD {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		UsuarioDAO horarioDAO = new UsuarioDAO();
		
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
				
				Usuario horario1 = new Usuario(nome, cpf, senha);
				
				horarioDAO.create(horario1);
				
				break;
			case 2:

				break;
			case 3:
				

				
				break;
			case 4:

				break;
			case 5:

				break;
			default:
				
				break;
			}
			
		}while(opcao!=0);
		System.out.println("Volte Sempre!");
	}

	}
