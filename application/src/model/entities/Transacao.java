package model.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transacao {

    private String id;
    private String tipo; // "DEPOSITO" ou "SAQUE"
    private BigDecimal valor;
    private LocalDate data;

    // Construtor da classe Transacao
    public Transacao(String id, String tipo, BigDecimal valor, LocalDate data) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
    }

    // Métodos getters para acessar os atributos
    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    // Método para representar a transação em formato de string
    @Override
    public String toString() {
        return "Transacao{" +
                "id='" + id + '\'' +
                ", tipo='" + tipo + '\'' +
                ", valor=" + valor +
                ", data=" + data +
                '}';
    }
}