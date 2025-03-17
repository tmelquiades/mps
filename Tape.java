/*
ocp:
agora Tape tem subclasses (NormalTape, LancamentoTape e InfantilTape)
p/ caso seja preciso adicionar novos tipos de filmes, que dai basta criar uma nova subclasse sem modificar codigo existente
*/
public class Tape {
  public static final int NORMAL = 0;
  public static final int LANCAMENTO = 1;
  public static final int INFANTIL = 2;

  private String titulo;
  private int codigoDePreco;

  public Tape(String titulo, int codigoDePreco) {
    this.titulo = titulo;
    this.codigoDePreco = codigoDePreco;
  }

  public String getTitulo() {
    return titulo;
  }

  public int getCodigoDePreco() {
    return codigoDePreco;
  }

  public void setCodigoDePreco(int codigoDePreco) {
    this.codigoDePreco = codigoDePreco;

  public abstract double calcularValor(int diasAlugada);
  public abstract int calcularPontos(int diasAlugada);

  }
}

class NormalTape extends Tape {
    public NormalTape(String titulo) {
        super(titulo);
    }

    @Override
    public double calcularValor(int diasAlugada) {
        double valor = 2;
        if (diasAlugada > 2) {
            valor += (diasAlugada - 2) * 1.5;
        }
        return valor;
    }
    
    @Override
    public int calcularPontos(int diasAlugada) {
        return 1;
    }
}

class LancamentoTape extends Tape {
    public LancamentoTape(String titulo) {
        super(titulo);
    }

    @Override
    public double calcularValor(int diasAlugada) {
        return diasAlugada * 3;
    }
    
    @Override
    public int calcularPontos(int diasAlugada) {
        return (diasAlugada > 1) ? 2 : 1;
    }
}

class InfantilTape extends Tape {
    public InfantilTape(String titulo) {
        super(titulo);
    }

    @Override
    public double calcularValor(int diasAlugada) {
        double valor = 1.5;
        if (diasAlugada > 3) {
            valor += (diasAlugada - 3) * 1.5;
        }
        return valor;
    }
    
    @Override
    public int calcularPontos(int diasAlugada) {
        return 1;
    }
}
