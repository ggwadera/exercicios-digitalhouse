package br.com.digitalhouse.incognitous;

import java.time.LocalDate;

public class PessoaFisica extends Funcionario {
    private String nit;

    public PessoaFisica(String endereco, String nome, String cpf, String email, String setor, double salarioBase, Cargo cargo, LocalDate dataDeAdmissao, String nit) {
        super(endereco, nome, cpf, email, setor, salarioBase, cargo, dataDeAdmissao);
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}
