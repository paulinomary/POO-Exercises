package exercicio4;

import java.util.ArrayList;

public class Privada extends Colecao {
    private int maximo;
    private Livro[] livros;

    public Privada(){}
    public Privada (String[] temas, int maximo, Livro[] livros) {
        super(temas);
        this.livros = livros;
        this.maximo = maximo;
    }

    public Livro[] getLivros () {return livros;}
    public void setLivros (Livro[] livros) {this.livros = livros;}
    public int getMaximo() {
        return maximo;
    }
    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    @Override
    public int totalBook() {

        int t = 0;

        for(int i = 0; i < this.livros.length; ++i) {
            if (this.livros[i] != null) {
                t++;
            }
        }
        return t;
    }

    @Override
    public Livro oldestBook() {

        Livro old = null;
        int oldest = this.livros[0].getAno();

        for (Livro l : this.livros) {
            if (l == null) {
                break;
            }
            if (oldest <= l.getAno()) {
                old = l;
                oldest = l.getAno();
            }
        }
        return old;
    }

    @Override
    public ArrayList getAllLivros() {
        ArrayList<Livro> all = new ArrayList<>();

        for (Livro l : livros) {
            if (l == null) {
                break;
            }
            all.add(l);
        }
        return all;
    }
}
