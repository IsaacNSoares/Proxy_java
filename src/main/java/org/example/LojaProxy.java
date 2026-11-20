package org.example;

import java.util.List;

public class LojaProxy implements ILoja {

    private Loja loja;
    private Integer codigoFilial;

    public LojaProxy(Integer codigoFilial) {
        this.codigoFilial = codigoFilial;
    }

    @Override
    public List<String> obterDadosCadastrais() {
        if (this.loja == null) {
            this.loja = new Loja(this.codigoFilial);
        }
        return this.loja.obterDadosCadastrais();
    }

    @Override
    public List<Float> obterFaturamento(UsuarioERP usuario) {
        if (!usuario.isAdministrador()) {
            throw new IllegalArgumentException("Usuário não autorizado");
        }
        if (this.loja == null) {
            this.loja = new Loja(this.codigoFilial);
        }
        return this.loja.obterFaturamento(usuario);
    }
}