package exercicio4;

import java.io.Serializable;

public class Livro implements Serializable {
    String titulo;
    int ano;

    public Livro(){}
    public Livro (String titulo, int ano) {
        this.ano = ano;
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", ano=" + ano +
                '}';
    }
}
