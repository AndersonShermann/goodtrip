package modelos;

import java.sql.Time;

public class Horario {
	//atributos
	private int id;
	private String hora_saida;
	private String tempo_viagem;
	
	//construtor
	public Horario(String hora_saida, String tempo_viagem) {
		this.hora_saida = hora_saida;
		this.tempo_viagem = tempo_viagem;
	}
	
	

	public Horario(int id, String hora_saida, String tempo_viagem) {
		this.id = id;
		this.hora_saida = hora_saida;
		this.tempo_viagem = tempo_viagem;
	}



	//getters e setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHora_saida() {
		return hora_saida;
	}

	public void setHora_saida(String hora_saida) {
		this.hora_saida = hora_saida;
	}

	public String getTempo_viagem() {
		return tempo_viagem;
	}

	public void setTempo_viagem(String tempo_viagem) {
		this.tempo_viagem = tempo_viagem;
	}
	


	//tostring
	@Override
	public String toString() {
		return "Horario [id=" + id + ", hora_saida=" + hora_saida + ", tempo_viagem=" + tempo_viagem;
	}



	


	
}
