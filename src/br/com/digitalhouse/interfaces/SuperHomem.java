package br.com.digitalhouse.interfaces;

public class SuperHomem implements Voador {

    private int experiencia = 0;

    public int getExperiencia() {
        return experiencia;
    }

    @Override
    public void voar() {
        this.experiencia += 3;
        System.out.println("Estou voando como um campeão!");
    }
}
