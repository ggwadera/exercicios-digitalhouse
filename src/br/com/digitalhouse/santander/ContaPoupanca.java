package br.com.digitalhouse.santander;

public class ContaPoupanca extends Conta {

    private double taxaDeJuros;

    public ContaPoupanca(double taxaDeJuros) {
        super();
        this.taxaDeJuros = taxaDeJuros;
    }

    public double getTaxaDeJuros() {
        return taxaDeJuros;
    }

    public void setTaxaDeJuros(double taxaDeJuros) {
        this.taxaDeJuros = taxaDeJuros;
    }

    public void recolherJuros() {
        this.saldo *= (1 + this.taxaDeJuros);
        System.out.println("Juros mensais recolhidos com sucesso!");
        printSaldo();
    }

    @Override
    public void sacarDinheiro(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
        } else {
            this.saldo -= valor;
            System.out.println("Valor sacado com sucesso!");
            printSaldo();
        }
    }
}
