package exercicio4;

import java.util.ArrayList;

public class Publica extends Colecao{
    private ArrayList<Livro> livros = new ArrayList<>();

    public Publica(){}
    public Publica (String[] temas, ArrayList<Livro> livros) {
        super(temas);
        this.livros = livros;
    }

    public ArrayList getLivros () {return livros;}
    public void setLivros (ArrayList<Livro> livros) {this.livros = livros;}

    @Override
    public int totalBook() {
        return livros.size();
    }

    @Override
    public Livro oldestBook() {

        Livro old = null;
        int oldest = this.livros.get(0).getAno();

        for (Livro l : this.livros) {
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
            all.add(l);
        }
        return all;
    }
}
