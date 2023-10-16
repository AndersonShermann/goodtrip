package crud;

import java.util.Scanner;

import dao.PassagemDAO;
import modelos.Passagem;
import modelos.Usuario;

public class PassagemCRUD {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		PassagemDAO passagemDAO = new PassagemDAO();
		
		int opcao = 0, id = 0, usuario;
		Double valor;
		String poltrona, data, horario;
		
		do {
			System.out.println("\n====================Passagens====================");
			System.out.println("1-CRIAR\\n2-CONSULTAR\\n3-ATUALIZAR\\n4-DELETAR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch(opcao) {
			case 1:
				System.out.println("Preço: ");
				valor = s.nextDouble();
				
				System.out.println("Poltrona");
				poltrona = s.next();
				
				System.out.println("Data da Viagem: ");
				data = s.next();
				
				Passagem passagem1 = new Passagem(data, poltrona, valor);
				
				passagemDAO.create(passagem1);
				
				break;
			case 2:
				for(Passagem p : passagemDAO.read()) {
					System.out.println(p.toString());
				}
				break;
			case 3:
				System.out.println("Id:");
				id = s.nextInt();
				s.nextLine();
				
				System.out.println("Valor");
				valor = s.nextDouble();
				
				System.out.println("Poltrona:");
				poltrona = s.next();
				
				System.out.println("Data:");
				data = s.next();
				
				
				Passagem passagem2 = new Passagem(id, data, poltrona, valor);
				passagemDAO.update(passagem2);
				break;
			case 4:
				System.out.println("Digite um id: ");
				
				id = s.nextInt();
				s.nextLine();
				
				passagemDAO.delete(id);
				break;
			default:
				break;
			}
						
		}while(opcao!=0);
		System.out.println("Volte Sempre!");
	}

}
