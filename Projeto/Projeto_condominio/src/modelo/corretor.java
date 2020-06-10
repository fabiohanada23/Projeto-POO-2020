package modelo;
public class corretor {
    Long id;
    String nome;
    String cpf;
    String ap_visita;
    String num_registro;
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
    public String getNum_registro() { 
        return num_registro;
    } 
    public void setNum_registro(String num_registro) { 
        this.num_registro = num_registro;
    } 

}
