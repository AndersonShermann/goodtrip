package crud;

import java.util.Scanner;

import dao.CidadeDAO;
import modelos.Cidade;
import modelos.Usuario;

public class CidadeCRUD {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		CidadeDAO cidadeDAO = new CidadeDAO();
		int opcao = 0, id = 0;
		String nome = "";
		
		do {
			System.out.println("=================CIDADES=================");
			System.out.println("1-CRIAR\n2-CONSULTAR\n3-ATUALIZAR\n4-DELETAR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch(opcao) {
			case 1:
				System.out.println("Cidade: ");
				nome = s.nextLine();
				
				Cidade cidade1 = new Cidade(nome);
				cidadeDAO.create(cidade1);
				
				break;
			case 2:
				for(Cidade c : cidadeDAO.read()) {
					System.out.println(c.toString());
				}
				break;
			case 3:
				System.out.println("Id:");
				id = s.nextInt();
				s.nextLine();
				
				System.out.println("Nome:");
				nome = s.nextLine();
								
				Cidade cidade2 = new Cidade(id, nome);
				cidadeDAO.update(cidade2);
				break;
			case 4:
				System.out.println("Digite um id: ");
				
				id = s.nextInt();
				s.nextLine();
				
				cidadeDAO.delete(id);
				break;
			default:
				
				break;
			}
			
			
		}while(opcao!=0);
		
		
	}

}
