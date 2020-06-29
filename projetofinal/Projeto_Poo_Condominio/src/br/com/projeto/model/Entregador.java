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
public class Entregador {
    //atributos
    private int id_entregador;
    private String nome;
    private String cpf;
    private String ap_visita;
    private String tipo_entrega;
    
    //getters e setters

    public int getId_entregador() {
        return id_entregador;
    }

    public void setId_entregador(int id_entregador) {
        this.id_entregador = id_entregador;
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

    public String getTipo_entrega() {
        return tipo_entrega;
    }

    public void setTipo_entrega(String tipo_entrega) {
        this.tipo_entrega = tipo_entrega;
    }
    
}
