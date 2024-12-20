# Processamento de Transações Bancárias

Este projeto é um sistema simples para processar transações bancárias utilizando Java 17 e a API de Streams.
O sistema permite filtrar, ordenar e agrupar transações, demonstrando o uso eficiente de Streams no Java.

## Funcionalidades

- **Filtrar Transações**: Possui a capacidade de filtrar transações por tipo (depósito ou saque).
- **Ordenar Transações**: Permite ordenar as transações com base no valor.
- **Agrupar Transações**: Agrupa as transações por tipo, facilitando a análise.

## Tecnologias

- Java 17
- IDE de sua escolha (Eclipse, IntelliJ, NetBeans, etc.)

## Estrutura do Projeto

O projeto contém duas classes principais:

1. **Transacao**: Representa uma transação bancária com atributos como `id`, `tipo`, `valor` e `data`.
2. **Program**: Classe que contém o método `main`, onde as transações são criadas e processadas utilizando Streams.

### Classe Transacao

```java
public class Transacao {
    private String id;
    private String tipo; // "DEPOSITO" ou "SAQUE"
    private BigDecimal valor;
    private LocalDate data;

    // Construtor e métodos getters
}
```

### Classe Program

```java
public class Program {
    public static void main(String[] args) {
        // Criação e processamento das transações
    }
}
```

## Como Executar
1. Clone o repositório ou baixe os arquivos.
2. Abra o projeto em sua IDE favorita.
3. Certifique-se de que está usando o JDK 17.
4. Compile e execute a classe Main.

## Exemplo de Saída
- Ao executar o programa, você verá uma saída semelhante a:

`Transações de Depósito:
Transacao{id='1', tipo='DEPOSITO', valor=1500.00, data=2023-10-01}
Transacao{id='3', tipo='DEPOSITO', valor=800.00, data=2023-10-03}
Transacao{id='5', tipo='DEPOSITO', valor=1200.00, data=2023-10-05}`

`Transações Ordenadas por Valor:
Transacao{id='4', tipo='SAQUE', valor=150.00, data=2023-10-04}
Transacao{id='2', tipo='SAQUE', valor=200.00, data=2023-10-02}
Transacao{id='3', tipo='DEPOSITO', valor=800.00, data=2023-10-03}
Transacao{id='5', tipo='DEPOSITO', valor=1200.00, data=2023-10-05}
Transacao{id='1', tipo='DEPOSITO', valor=1500.00, data=2023-10-01}`

`Transações Agrupadas por Tipo:
DEPOSITO:
Transacao{id='1', tipo='DEPOSITO', valor=1500.00, data=2023-10-01}
Transacao{id='3', tipo='DEPOSITO', valor=800.00, data=2023-10-03}
Transacao{id='5', tipo='DEPOSITO', valor=1200.00, data=2023-10-05}
SAQUE:
Transacao{id='2', tipo='SAQUE', valor=200.00, data=2023-10-02}
Transacao{id='4', tipo='SAQUE', valor=150.00, data=2023-10-04}`

##### Este projeto é apenas um exemplo didático para demonstrar o uso de Streams no Java. Sinta-se à vontade para melhorar e expandir o sistema conforme necessário.

##### Comentários sobre Expressões Lambda

- **Expressão Lambda**: Uma expressão lambda é uma forma concisa de representar uma função anônima que pode ser passada como argumento,
ou usada para criar instâncias de interfaces funcionais (interfaces com um único método abstrato). No código, as expressões lambda
são utilizadas em métodos como `filter`, `sorted` e `forEach`.

- `filter(transacao -> "DEPOSITO".equals(transacao.getTipo()))`: Aqui, a expressão lambda verifica se o tipo da transação é "DEPOSITO".
Para cada `Transacao` na lista, essa função retorna `true` ou `false`, filtrando apenas aquelas que satisfazem a condição.

- `sorted(Comparator.comparing(Transacao::getValor))`: Esta expressão usa uma referência de método para obter o valor das
transações e ordenar a lista com base nesse valor. `Transacao::getValor` é uma maneira concisa de referenciar o método 
`getValor` da classe `Transacao`.

- `forEach(System.out::println)`: Este é um exemplo de método de referência, que é uma forma ainda mais concisa de passar uma função.
Aqui, ele imprime cada transação na lista.

*As expressões lambda tornam o código mais legível e reduzido, permitindo que você escreva funções diretamente onde são necessárias,
sem a necessidade de criar classes anônimas ou métodos separados.*