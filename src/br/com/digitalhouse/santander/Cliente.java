package br.com.digitalhouse.santander;

public class Cliente {

    private long id;
    private String sobrenome;
    private String rg;
    private String cpf;
    private Conta conta;

    public Cliente(long id, String sobrenome, String rg, String cpf, Conta conta) {
        this.id = id;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.cpf = cpf;
        this.conta = conta;
    }
}
