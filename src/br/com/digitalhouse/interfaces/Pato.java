package br.com.digitalhouse.interfaces;

public class Pato implements Voador {

    private int energia = 100;

    public int getEnergia() {
        return energia;
    }

    @Override
    public void voar() {
        if (energia >= 5) {
            this.energia -= 5;
            System.out.println("Estou voando como um pato!");
        } else {
            System.out.println("Não tenho energia suficiente para voar.");
        }
    }
}

