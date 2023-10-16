package crud;

import java.sql.Time;
import java.util.Scanner;

import dao.HorarioDAO;
import modelos.Horario;
import modelos.Usuario;

public class HorarioCRUD {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		HorarioDAO horarioDAO = new HorarioDAO();
		
		int opcao = 0, id = 0;
		
		String hora_saida, tempo_viagem;

		
		do {
			System.out.println("\n=================USUARIOS=================\n");
			System.out.println("1-CRIAR\n2-CONSULTAR\n3-ATUALIZAR\n4-DELETAR\n5-CONSULTAR POR ID\n0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch(opcao) {
			case 1:
				System.out.println("Hora Saída (HH:mm:ss)");
				hora_saida = s.nextLine();
				
				System.out.println("Tempo de Viagem:");
				tempo_viagem = s.nextLine();
				
				Horario horario1 = new Horario(hora_saida, tempo_viagem);
				
				horarioDAO.create(horario1);
				
				break;
			case 2:
				for(Horario h : horarioDAO.read()) {
					System.out.println(h.toString());
				}

				break;
			case 3:
				System.out.println("Id:");
				id = s.nextInt();
				s.nextLine();
				
				System.out.println("Hora de Saída (HH:mm:ss):");
				hora_saida = s.nextLine();
				
				System.out.println("Tempo de viagem (HH:mm:ss):");
				tempo_viagem = s.nextLine();
				
				
				Horario horario2 = new Horario(id, hora_saida, tempo_viagem);
				horarioDAO.update(horario2);

				
				break;
			case 4:
				System.out.println("Digite um id: ");
				
				id = s.nextInt();
				s.nextLine();
				
				horarioDAO.delete(id);
				break;
			default:
				
				break;
			}
			
		}while(opcao!=0);
		System.out.println("Volte Sempre!");
	}

	}
