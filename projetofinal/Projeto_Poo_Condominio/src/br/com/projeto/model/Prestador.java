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
public class Prestador {
    //atributos
    private int id_prestador;
    private String nome;
    private String cpf;
    private String ap_visita;
    private String tipo_servico;
    
    //getters e setters

    public int getId_prestador() {
        return id_prestador;
    }

    public void setId_prestador(int id_prestador) {
        this.id_prestador = id_prestador;
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

    public String getTipo_servico() {
        return tipo_servico;
    }

    public void setTipo_servico(String tipo_servico) {
        this.tipo_servico = tipo_servico;
    }
    
}
