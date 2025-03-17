/*
srp:
extrai a geracao do extrato p/ a classe ExtratoGerador p/ separar as responsabilidades
a logica de calculo de valor e pontos tambem foi movida para Tape (e suas subclasses criadas)

ocp: [ver tape.java]
*/
import java.util.*;

public class Client {
    private String nome;
    private Collection<Rent> tapesAlugadas = new ArrayList<>();

    public Client(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void adicionaRent(Rent rent) {
        tapesAlugadas.add(rent);
    }

    public String extrato() {
        ExtratoGerador extratoGerador = new ExtratoGerador();
        return extratoGerador.gerarExtrato(this);
    }

    public Collection<Rent> getTapesAlugadas() {
        return tapesAlugadas;
    }
} 