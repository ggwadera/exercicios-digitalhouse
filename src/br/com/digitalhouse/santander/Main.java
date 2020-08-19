package br.com.digitalhouse.santander;

public class Main {

    public static void main(String[] args) {
        ContaPoupanca contaPoupanca = new ContaPoupanca(0.05);
        Cliente cliente1 = new Cliente(1, "Silva", "10312312", "3587458943", contaPoupanca);
        contaPoupanca.depositarDinheiro(1500);
        contaPoupanca.recolherJuros();
        contaPoupanca.sacarDinheiro(400);

        System.out.println();

        ContaCorrente contaCorrente = new ContaCorrente(1000);
        Cliente cliente2 = new Cliente(2, "Souza", "847582399", "356727892", contaCorrente);
        contaCorrente.depositarDinheiro(300);
        contaCorrente.depositarCheque(700, "Caixa", "17/08/2020");
        contaCorrente.sacarDinheiro(1500);
    }
}
