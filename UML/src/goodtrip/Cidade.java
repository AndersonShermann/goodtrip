package goodtrip;

import java.util.Set;
import java.util.HashSet;


public class Cidade {
    

    private Integer id;
    private String nome;
    private Set<Horario> horario;

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
    
}
