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
        // Criando uma lista para armazenar as transações
        List<Transacao> transacoes = new ArrayList<>();

        // Adicionando algumas transações à lista
        transacoes.add(new Transacao("1", "DEPOSITO", new BigDecimal("1500.00"), LocalDate.of(2023, 10, 1)));
        transacoes.add(new Transacao("2", "SAQUE", new BigDecimal("200.00"), LocalDate.of(2023, 10, 2)));
        transacoes.add(new Transacao("3", "DEPOSITO", new BigDecimal("800.00"), LocalDate.of(2023, 10, 3)));
        transacoes.add(new Transacao("4", "SAQUE", new BigDecimal("150.00"), LocalDate.of(2023, 10, 4)));
        transacoes.add(new Transacao("5", "DEPOSITO", new BigDecimal("1200.00"), LocalDate.of(2023, 10, 5)));

        // Filtrando transações do tipo "DEPOSITO" utilizando Streams
        List<Transacao> depositos = transacoes.stream()
                // A expressão lambda aqui verifica se o tipo da transação é "DEPOSITO"
                .filter(transacao -> "DEPOSITO".equals(transacao.getTipo()))
                // Coletando as transações filtradas em uma nova lista
                .collect(Collectors.toList());

        // Exibindo as transações de depósito
        System.out.println("Transações de Depósito:");
        depositos.forEach(System.out::println); // Método de referência para imprimir cada transação

        // Ordenando as transações por valor
        List<Transacao> transacoesOrdenadas = transacoes.stream()
                // Usando Comparator.comparing para ordenar as transações pelo valor
                .sorted(Comparator.comparing(Transacao::getValor))
                // Coletando as transações ordenadas em uma nova lista
                .collect(Collectors.toList());

        // Exibindo as transações ordenadas por valor
        System.out.println("\nTransações Ordenadas por Valor:");
        transacoesOrdenadas.forEach(System.out::println); // Método de referência novamente

        // Agrupando transações por tipo
        Map<String, List<Transacao>> transacoesAgrupadas = transacoes.stream()
                // Agrupando as transações pelo tipo usando Collectors.groupingBy
                .collect(Collectors.groupingBy(Transacao::getTipo));

        // Exibindo as transações agrupadas por tipo
        System.out.println("\nTransações Agrupadas por Tipo:");
        transacoesAgrupadas.forEach((tipo, lista) -> {
            // Para cada tipo, imprime o tipo e a lista de transações associadas
            System.out.println(tipo + ":");
            lista.forEach(System.out::println); // Imprime cada transação na lista
        });
    }
}