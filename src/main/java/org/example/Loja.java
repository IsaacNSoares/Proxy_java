package org.example;

import java.util.Arrays;
import java.util.List;

public class Loja implements ILoja {

    private Integer codigoFilial;
    private String nome;
    private String cidade;
    private Float faturamentoDiario;
    private Float margemLucro;

    public Loja(int codigoFilial) {
        this.codigoFilial = codigoFilial;
        Loja objeto = BancoERP.getLoja(codigoFilial);
        this.nome = objeto.nome;
        this.cidade = objeto.cidade;
        this.faturamentoDiario = objeto.faturamentoDiario;
        this.margemLucro = objeto.margemLucro;
    }

    public Loja(Integer codigoFilial, String nome, String cidade, Float faturamentoDiario, Float margemLucro) {
        this.codigoFilial = codigoFilial;
        this.nome = nome;
        this.cidade = cidade;
        this.faturamentoDiario = faturamentoDiario;
        this.margemLucro = margemLucro;
    }

    public Integer getCodigoFilial() {
        return codigoFilial;
    }

    @Override
    public List<String> obterDadosCadastrais() {
        return Arrays.asList(this.nome, this.cidade);
    }

    @Override
    public List<Float> obterFaturamento(UsuarioERP usuario) {
        return Arrays.asList(this.faturamentoDiario, this.margemLucro);
    }
}