package br.com.digitalhouse.santander;

public abstract class Conta {

    protected double saldo;

    public double getSaldo() {
        return saldo;
    }

    protected void printSaldo() {
        System.out.printf("Seu saldo atual é de: R$%.2f.\n", this.saldo);
    }

    public void depositarDinheiro(double valor) {
        if (valor < 0) {
            System.out.println("Impossível depositar um valor negativo.");
        } else {
            this.saldo += valor;
            System.out.println("Valor depositado com sucesso!");
            printSaldo();
        }
    }

    public abstract void sacarDinheiro(double valor);

}
