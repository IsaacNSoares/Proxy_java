package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LojaProxyTest {

    @BeforeEach
    void setUp() {
        BancoERP.addLoja(new Loja(1, "Filial Centro", "Juiz de Fora", 15000.0f, 32.5f));
        BancoERP.addLoja(new Loja(2, "Filial Independência", "Juiz de Fora", 28500.0f, 38.0f));
    }

    @Test
    void deveRetornarDadosCadastraisLoja() {
        LojaProxy loja = new LojaProxy(1);

        assertEquals(Arrays.asList("Filial Centro", "Juiz de Fora"), loja.obterDadosCadastrais());
    }

    @Test
    void deveRetornarFaturamentoLoja() {
        UsuarioERP usuario = new UsuarioERP("Ana", true);
        LojaProxy loja = new LojaProxy(2);

        assertEquals(Arrays.asList(28500.0f, 38.0f), loja.obterFaturamento(usuario));
    }

    @Test
    void deveRetornarExcecaoUsuarioNaoAutorizadoConsultarFaturamentoLoja() {
        try {
            UsuarioERP usuario = new UsuarioERP("Joana", false);
            LojaProxy loja = new LojaProxy(2);

            loja.obterFaturamento(usuario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Usuário não autorizado", e.getMessage());
        }
    }
}