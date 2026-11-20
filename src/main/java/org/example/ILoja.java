package org.example;

import java.util.List;

public interface ILoja {
    List<String> obterDadosCadastrais();
    List<Float> obterFaturamento(UsuarioERP usuario);
}