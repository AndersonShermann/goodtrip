package goodtrip;


public class Passagem   {
    
    private Integer id;
    private Real data_viagem;
    private String poltrona;
    private Real valor;
    private Usuario usuario;
    private Horario horario;
    

    private Integer getId() {
        return this.id;
    }
    
    private Integer setId(Integer id) {
        this.id = id;
    }
    
    private Real getData_viagem() {
        return this.data_viagem;
    }
    
    private Real setData_viagem(Real data_viagem) {
        this.data_viagem = data_viagem;
    }
    
    private String getPoltrona() {
        return this.poltrona;
    }
    
    private String setPoltrona(String poltrona) {
        this.poltrona = poltrona;
    }
    
    private Real getValor() {
        return this.valor;
    }
    
    private Real setValor(Real valor) {
        this.valor = valor;
    }
    
}
