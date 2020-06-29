/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.model;

/**
 *
 * @author fabioh
 */
public class Corretor {
    
    //atributos
    private int id_corretor;
    private String nome;
    private String cpf;
    private String ap_visita;
    private String num_registro;
    
    
    //getters e setters

    public int getId_corretor() {
        return id_corretor;
    }

    public void setId_corretor(int id_corretor) {
        this.id_corretor = id_corretor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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

    public String getNum_registro() {
        return num_registro;
    }

    public void setNum_registro(String num_registro) {
        this.num_registro = num_registro;
    }
    
    
}
