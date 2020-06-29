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
public class Visitante {
    //atributos
    private int id_visitante;
    private String nome;
    private String cpf;
    private String ap_visita;
    
    //getters e setters

    public int getId_visitante() {
        return id_visitante;
    }

    public void setId_visitante(int id_visitante) {
        this.id_visitante = id_visitante;
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
    
}
