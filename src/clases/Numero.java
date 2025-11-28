package clases;

public class Numero implements Comparable<Numero> {
    private int valor;

    public Numero(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    // Orden: ascendente
    @Override
    public int compareTo(Numero otro) {
        return Integer.compare(this.valor, otro.valor);
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
    
}