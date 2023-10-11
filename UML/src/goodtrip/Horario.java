package goodtrip;

import java.util.Set;
import java.util.HashSet;


public class Horario {
    
    private Integer id;
    private Real hora_saida;
    private Set<Passagem  > passagem  ;
    private Cidade cidade;

    private Integer getId() {
        return this.id;
    }

    private Integer setId(Integer id) {
        this.id = id;
    }

    private Real getHora_saida() {
        return this.hora_saida;
    }

    private Real setHora_saida(Real hora_saida) {
        this.hora_saida = hora_saida;
    }
    
}
