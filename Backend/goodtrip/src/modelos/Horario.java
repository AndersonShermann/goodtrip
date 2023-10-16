package modelos;

import java.sql.Time;

public class Horario {
	//atributos
	private int id;
	private Time hora_saida;
	private Time tempo_viagem;
	
	private Cidade cidade;
	
	//construtor
	public Horario() {
	}

	public Horario(int time, Time hora_saida) {
		this.id = time;
		this.hora_saida = hora_saida;
	}

	public Horario(Time hora_saida) {
		this.hora_saida = hora_saida;
	}

	public Horario(Time valueOf, Time valueOf2) {
		// TODO Auto-generated constructor stub
	}

	public Horario(int id2, Time valueOf, Time valueOf2) {
		// TODO Auto-generated constructor stub
	}

	//getters e setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Time getHora_saida() {
		return hora_saida;
	}

	public void setHora_saida(Time hora_saida) {
		this.hora_saida = hora_saida;
	}

	
	public Time getTempo_viagem() {
		return tempo_viagem;
	}

	public void setTempo_viagem(Time tempo_viagem) {
		this.tempo_viagem = tempo_viagem;
	}

	//tostring
	@Override
	public String toString() {
		return "Horario [id=" + id + ", hora_saida=" + hora_saida + ", tempo_viagem=" + tempo_viagem;
	}
	
}
