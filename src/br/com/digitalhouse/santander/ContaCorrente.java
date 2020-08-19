package br.com.digitalhouse.santander;

public class ContaCorrente extends Conta {

    private double chequeEspecial;

    public ContaCorrente(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public void depositarCheque(double valor, String banco, String data) {
        this.saldo += valor;
        System.out.printf("Cheque de R$%.2f, do banco %s e data %s depositado com sucesso!", valor, banco, data);
        printSaldo();
    }

    @Override
    public void sacarDinheiro(double valor) {
        if (valor > this.saldo + this.chequeEspecial) {
            System.out.println("Saldo e cheque especial insuficientes.");
        } else if (valor > this.saldo) {
            if (this.saldo > 0) {
                valor -= this.saldo;
                this.saldo = 0;
            }
            this.chequeEspecial -= valor;
            System.out.println("Valor sacado do seu cheque especial com sucesso!");
            printSaldo();
        } else {
            this.saldo -= valor;
            System.out.println("Valor sacado do seu saldo com sucesso!");
            printSaldo();
        }
    }

    @Override
    public void printSaldo() {
        super.printSaldo();
        System.out.printf("Seu cheque especial atual é de: R$%.2f.\n", this.chequeEspecial);
    }
}
