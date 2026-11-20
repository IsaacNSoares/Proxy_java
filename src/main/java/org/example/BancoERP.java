package org.example;

import java.util.HashMap;
import java.util.Map;

public class BancoERP {
    private static Map<Integer, Loja> lojas = new HashMap<>();

    public static Loja getLoja(Integer codigoFilial) {
        return lojas.get(codigoFilial);
    }

    public static void addLoja(Loja loja) {
        lojas.put(loja.getCodigoFilial(), loja);
    }
}