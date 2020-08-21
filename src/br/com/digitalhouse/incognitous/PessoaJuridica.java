package br.com.digitalhouse.incognitous;

import java.time.LocalDate;

public class PessoaJuridica extends Funcionario {

    private String cnpj;

    public PessoaJuridica(String endereco, String nome, String cpf, String email, String setor, double salarioBase, LocalDate dataDeAdmissao, String cnpj) {
        super(endereco, nome, cpf, email, setor, salarioBase, Cargo.FUNCIONARIO, dataDeAdmissao);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
