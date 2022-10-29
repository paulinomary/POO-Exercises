package exercicio4;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Colecao implements Serializable {
    protected String[] tema;


    public Colecao (){}
    public Colecao (String[] tema) {
        this.tema = tema;
    }

    public String[] getTema() {return tema;}
    public void setTema (String[] tema) {this.tema = tema;}

    public abstract int totalBook();

    public abstract Livro oldestBook();

    public abstract ArrayList getAllLivros();

}
