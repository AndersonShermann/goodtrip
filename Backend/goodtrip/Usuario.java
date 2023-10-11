package goodtrip;

import java.util.Set;
import java.util.HashSet;

public class Usuario {
    

    private Integer id;
    private String nome;
    private Integer cpf;
    private String senha;
    private Set<Passagem  > passagem  ;
    

    private Integer getId() {
        return this.id;
    }

    private Integer setId(Integer id) {
        this.id = id;
    }
    
    private String getNome() {
        return this.nome;
    }
    
    private String setNome(String nome) {
        this.nome = nome;
    }
    
    private Integer getCpf() {
        return this.cpf;
    }
    
    private Integer setCpf(Integer cpf) {
        this.cpf = cpf;
    }
    
    private String getSenha() {
        return this.senha;
    }
    
    private String setSenha(String senha) {
        this.senha = senha;
    }
    
}
