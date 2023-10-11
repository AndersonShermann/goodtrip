 package modelos;

public class Cidade {
	//atributos
	private int id;
	private String nome;
	
	//construtor
	public Cidade() {
	}

	public Cidade(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Cidade(String nome) {
		this.nome = nome;
	}
		
	//getters e setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//tostring
	@Override
	public String toString() {
		return "Cidade [id=" + id + ", nome=" + nome + "]";
	} 
}
