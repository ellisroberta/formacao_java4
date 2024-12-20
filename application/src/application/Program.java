package application;


import model.entities.Transacao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {
        List<Transacao> transacoes = new ArrayList<>();

        // Adicionando algumas transações
        transacoes.add(new Transacao("1", "DEPOSITO", new BigDecimal("1500.00"), LocalDate.of(2023, 10, 1)));
        transacoes.add(new Transacao("2", "SAQUE", new BigDecimal("200.00"), LocalDate.of(2023, 10, 2)));
        transacoes.add(new Transacao("3", "DEPOSITO", new BigDecimal("800.00"), LocalDate.of(2023, 10, 3)));
        transacoes.add(new Transacao("4", "SAQUE", new BigDecimal("150.00"), LocalDate.of(2023, 10, 4)));
        transacoes.add(new Transacao("5", "DEPOSITO", new BigDecimal("1200.00"), LocalDate.of(2023, 10, 5)));

        // Filtrando transações de depósito
        List<Transacao> depositos = transacoes.stream()
                .filter(transacao -> "DEPOSITO".equals(transacao.getTipo()))
                .collect(Collectors.toList());

        System.out.println("Transações de Depósito:");
        depositos.forEach(System.out::println);

        // Ordenando transações por valor
        List<Transacao> transacoesOrdenadas = transacoes.stream()
                .sorted(Comparator.comparing(Transacao::getValor))
                .collect(Collectors.toList());

        System.out.println("\nTransações Ordenadas por Valor:");
        transacoesOrdenadas.forEach(System.out::println);

        // Agrupando transações por tipo
        Map<String, List<Transacao>> transacoesAgrupadas = transacoes.stream()
                .collect(Collectors.groupingBy(Transacao::getTipo));

        System.out.println("\nTransações Agrupadas por Tipo:");
        transacoesAgrupadas.forEach((tipo, lista) -> {
            System.out.println(tipo + ":");
            lista.forEach(System.out::println);
        });
    }
}