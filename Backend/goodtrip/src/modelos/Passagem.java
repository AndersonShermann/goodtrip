package modelos;

public class Passagem {
	//atributos
	private int id;
	private String data_viagem;
	private String poltrona;
	private double valor;
	
	private Horario horario;
	private Usuario usuario; 
	
	//construtor
	public Passagem() {
	}

	public Passagem(int id, String data_viagem, String poltrona, Double valor) {
		this.id = id;
		this.data_viagem = data_viagem;
		this.poltrona = poltrona;
		this.valor = valor;
	}

	public Passagem(String data_viagem, String poltrona, Double valor) {
		this.data_viagem = data_viagem;
		this.poltrona = poltrona;
		this.valor = valor;
	}
	
	//getters e setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData_viagem() {
		return data_viagem;
	}

	public void setData_viagem(String data_viagem) {
		this.data_viagem = data_viagem;
	}

	public String getPoltrona() {
		return poltrona;
	}

	public void setPoltrona(String poltrona) {
		this.poltrona = poltrona;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	//tostring

	@Override
	public String toString() {
		return "Passagem [id=" + id + ", data_viagem=" + data_viagem + ", poltrona=" + poltrona + ", valor=" + valor
				+ "]";
	}

	public Passagem getUsuario() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
