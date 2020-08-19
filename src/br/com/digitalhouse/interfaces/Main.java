package br.com.digitalhouse.interfaces;

public class Main {

    public static void main(String[] args) {
        Pato pato = new Pato();
        Aviao aviao = new Aviao();
        SuperHomem superHomem = new SuperHomem();
        Voador[] voadores = {pato, aviao, superHomem};
        TorreDeControle torreDeControle = new TorreDeControle(voadores);
        torreDeControle.voemTodos();
    }
}
