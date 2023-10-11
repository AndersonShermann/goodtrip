package modelos;

public class Horario {
	//atributos
	private int id;
	private float hora_saida;
	
	private Cidade cidade;
	
	//construtor
	public Horario() {
	}

	public Horario(int id, float hora_saida) {
		this.id = id;
		this.hora_saida = hora_saida;
	}

	public Horario(float hora_saida) {
		this.hora_saida = hora_saida;
	}

	//getters e setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getHora_saida() {
		return hora_saida;
	}

	public void setHora_saida(float hora_saida) {
		this.hora_saida = hora_saida;
	}

	//tostring
	@Override
	public String toString() {
		return "Horario [id=" + id + ", hora_saida=" + hora_saida + "]";
	}
	
}
