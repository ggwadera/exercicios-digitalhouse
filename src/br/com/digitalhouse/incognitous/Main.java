package br.com.digitalhouse.incognitous;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new PessoaFisica("Rua 1", "João", "12411443", "joao@empresa.com", "Financeiro", 2000, Cargo.FUNCIONARIO, LocalDate.now(), "32623333"));
        funcionarios.add(new PessoaFisica("Rua F", "Maria", "45134512", "maria@empresa.com", "Vendas", 4000, Cargo.SUPERVISOR, LocalDate.of(2019, 1, 20), "436214134"));
        funcionarios.add(new PessoaFisica("Rua 20", "Pedro", "76234562", "pedro@empresa.com", "Marketing", 4000, Cargo.GERENTE, LocalDate.of(2015, 5, 10), "686823344"));
        funcionarios.add(new PessoaJuridica("Rua Z", "Marcos", "67653497", "marcos@empresa.com", "TI", 2000, LocalDate.of(2019, 12, 3), "683634551"));
        funcionarios.add(new PessoaJuridica("Rua Y", "Fernanda", "45451223", "fernanda@empresa.com", "TI", 2000, LocalDate.of(2018, 6, 27), "334441231"));

        Funcionario funcionario1 = funcionarios.get(0);
        Funcionario funcionario2 = funcionarios.get(4);
        Funcionario supervisor = funcionarios.get(1);
        Funcionario gerente = funcionarios.get(2);
        gerente.setUltimaFerias(LocalDate.now().minusMonths(3));

        funcionario1.consultarContraCheque();

        System.out.println();
        System.out.println(funcionario1.podeTirarFerias() ? funcionario1.getNome() + " pode tirar férias!" : funcionario1.getNome() + " não pode tirar férias");
        System.out.println(supervisor.podeTirarFerias() ? supervisor.getNome() + " pode tirar férias!" : supervisor.getNome() + " não pode tirar férias");
        System.out.println(gerente.podeTirarFerias() ? gerente.getNome() + " pode tirar férias!" : gerente.getNome() + " não pode tirar férias");

        supervisor.setEmFerias(true);

        System.out.println();
        funcionario2.pedirDemissao();
        funcionarios.forEach(Funcionario::trabalhar);

        System.out.println();
        System.out.println("Gerente pode demitir supervisor? " + gerente.podeDemitir(supervisor)); // true
        System.out.println("Supervisor pode demitir gerente? " + supervisor.podeDemitir(gerente)); // false
        System.out.println("Supervisor pode demitir funcionário? " + supervisor.podeDemitir(funcionario1)); // true

        System.out.println();
        gerente.reajustarSalario(supervisor, 1.1); // deve funcionar
        gerente.reajustarSalario(funcionario1, 0.9); // não deve funcionar (não pode reduzir)
        supervisor.reajustarSalario(gerente, 1.6); // não deve funcionar (cargo não permitido)

        System.out.println();
        funcionario1.pedirAumento(1.05);
        funcionario1.pedirAumento(1.05);
        funcionario1.pedirAumento(1.05);
        funcionario1.pedirAumento(1.05);
        funcionario1.pedirAumento(1.05);
        funcionario1.pedirAumento(1.05);

    }

}
