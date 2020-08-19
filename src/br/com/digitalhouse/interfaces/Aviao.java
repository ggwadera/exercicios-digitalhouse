package br.com.digitalhouse.interfaces;

public class Aviao implements Voador {

    private int horasDeVoo = 0;

    public int getHorasDeVoo() {
        return horasDeVoo;
    }

    @Override
    public void voar() {
        this.horasDeVoo += 13;
        System.out.println("Estou voando como um avião, e tenho " + this.horasDeVoo + " horas de voo");
    }
}
