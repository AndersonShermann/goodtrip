package modelos;

import java.math.BigInteger;

public class Usuario {
	//atributos 
	private int id;
	private String nome;
	private int cpf;
	private String senha;

	//construtor
	public Usuario() {
	}

	public Usuario(int id, String nome, int cpf, String senha) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}

	public Usuario(String nome, int cpf, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
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

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	
	//tostring
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + "]";
	}
}
