package br.com.digitalhouse.incognitous;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

public abstract class Funcionario {

    private String endereco;
    private String nome;
    private String cpf;
    private String email;
    private String setor;
    private double salarioBase;
    private Cargo cargo;
    private boolean emFerias = false;
    private boolean ativo = true;

    private LocalDate dataDeAdmissao;
    private LocalDate dataDeDemissao;
    private LocalDate ultimaFerias;

    public Funcionario(String endereco, String nome, String cpf, String email, String setor, double salarioBase, Cargo cargo, LocalDate dataDeAdmissao) {
        this.endereco = endereco;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.setor = setor;
        this.salarioBase = salarioBase;
        this.cargo = cargo;
        this.dataDeAdmissao = dataDeAdmissao;
    }

    public void consultarContraCheque() {
        System.out.printf("Seu salário é de R$%.2f\n", this.salarioBase);
    }

    public boolean podeTirarFerias() {
        LocalDate agora = LocalDate.now();
        long mesesContratado = Period.between(this.dataDeAdmissao, agora).toTotalMonths();
        if (mesesContratado < 11) {
            return false;
        }
        if (ultimaFerias != null) {
            long mesesUltimaFerias = Period.between(this.ultimaFerias, agora).toTotalMonths();
            return mesesUltimaFerias >= 4;
        }
        return true;
    }

    public double receberBonificacao() {
        double bonificacao;
        switch (this.getCargo()) {
            case GERENTE:
                bonificacao = 0.12;
                break;
            case SUPERVISOR:
                bonificacao = 0.08;
                break;
            default:
                bonificacao = 0;
        }
        return bonificacao * this.salarioBase;
    }

    public boolean podeDemitir(Funcionario funcionario) {
        return this.cargo.ordinal() > funcionario.getCargo().ordinal();
    }

    public void reajustarSalario(Funcionario funcionario, double reajuste) {
        if (this.cargo != Cargo.GERENTE) {
            System.out.println("Somente gerentes podem reajustar salário.");
        } else if (funcionario.getCargo() == Cargo.GERENTE) {
            System.out.println("Gerentes não podem ter salário reajustado.");
        } else if (reajuste < 1) {
            System.out.println("Reajuste não pode reduzir o salário do funcionário.");
        } else {
            double salario = funcionario.getSalarioBase();
            double reajustado = salario * reajuste;
            funcionario.setSalarioBase(reajustado);
            System.out.println("Salário do funcionário " + funcionario.getNome() + " ajustado.");
            System.out.printf("Salário anterior: R$%.2f\n", salario);
            System.out.printf("Salário reajustado: R$%.2f\n", reajustado);
        }
    }

    public void trabalhar() {
        if (this.emFerias) {
            System.out.println(nome + " está de férias e não pode trabalhar!");
        } else if (!this.ativo) {
            System.out.println(nome + " não trabalha mais aqui.");
        } else {
            System.out.println(nome + " trabalhou!");
        }
    }

    public void pedirDemissao() {
        this.dataDeDemissao = LocalDate.now();
        this.ativo = false;
        System.out.println(this.nome + " foi demitido.");
    }

    public void pedirAumento(double aumento) {
        Random random = new Random();
        boolean aprovado = random.nextBoolean();
        if (aprovado) {
            this.salarioBase *= aumento;
            System.out.println("Aumento aprovado, parabéns!");
            this.consultarContraCheque();
        } else {
            System.out.println("Aumento recusado.");
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public boolean isEmFerias() {
        return emFerias;
    }

    public void setEmFerias(boolean emFerias) {
        this.emFerias = emFerias;
    }

    public LocalDate getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public void setDataDeAdmissao(LocalDate dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }

    public LocalDate getDataDeDemissao() {
        return dataDeDemissao;
    }

    public void setDataDeDemissao(LocalDate dataDeDemissao) {
        this.dataDeDemissao = dataDeDemissao;
    }

    public LocalDate getUltimaFerias() {
        return ultimaFerias;
    }

    public void setUltimaFerias(LocalDate ultimaFerias) {
        this.ultimaFerias = ultimaFerias;
    }
}
