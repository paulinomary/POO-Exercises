package exercicio3;

import java.util.ArrayList;

public class Equipa {

    protected String nome;
    protected ArrayList<Player> player;
    protected int n;

    public Equipa(String namePlayer) {}
    public Equipa(String nome, int n, ArrayList<Player> player) {
        this.nome = nome;
        this.n = n;
        this.player = player;
    }

    public void setPlayer(ArrayList<Player> player) {this.player = player;}
    public ArrayList<Player> getPlayer () {return player;}
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getn() {
        return n;
    }
    public void setn(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " & Numero de Elementos: " + n;
    }
}
