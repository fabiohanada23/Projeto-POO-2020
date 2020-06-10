package modelo;
public class Visitante {
    Long id;
    String nome;
    String cpf;
    String ap_visita;
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getAp_visita() {
        return ap_visita;
    }
    public void setAp_visita(String ap_visita) {
        this.ap_visita = ap_visita;

    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    } 
    public String getNome() { 
        return nome;
    } 
    public void setNome(String nome) { 
        this.nome = nome;
    } 
}

