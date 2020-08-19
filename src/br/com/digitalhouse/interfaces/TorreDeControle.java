package br.com.digitalhouse.interfaces;

import java.util.List;

public class TorreDeControle {

    Voador[] voadores;

    public TorreDeControle(Voador[] voadores) {
        this.voadores = voadores;
    }

    public void voemTodos() {
        for (Voador voador : voadores) {
            voador.voar();
        }
    }
}
