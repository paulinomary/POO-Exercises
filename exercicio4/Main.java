package exercicio4;

import java.io.*;
import java.util.ArrayList;

public class Main {

    static Biblioteca biblio = new Biblioteca();

    public static void main(String[] args) throws IOException {

        // CRIAR BIBLIO
        defaultBiblio();

        // LISTAR O NUMERO DE LIVROS DE CADA UMA DAS COLEÇOES e MOSTRAR O LIVRO MAIS ANTIGO DE CADA UMA DAS COLECOES


        for (Colecao col : biblio.getCol()) {
            System.out.println("A colecao contem " + col.totalBook() + " livros!");
            System.out.println("O livro mais antigo da colecao é: " + col.oldestBook().getTitulo() + ", " + col.oldestBook().getAno());
        }

        // MOSTRAR TODOS OS LIVROS DAS COLECOES COM O TEMA AVENTURA
        biblio.adventure();

        // ESCREVER TODAS AS COLECOES NUM FICHEIRO DE OBJETOS
        biblio.objectFile();

        // ESCREVER TODOS OS LIVROS NUM FICHEIRO TXT
        biblio.txtFile();
    }


    // criacao de livros por default
    private static void defaultBiblio () {
        String[] t = new String[]{"Aventura" , "Romance"};
        String[] t2 = new String[]{"Romance", "Fantasia"};
        Livro l1 = new Livro("A Rainha Vermelha", 2015);
        Livro l2 = new Livro("O Nome do Vento", 2007);
        Livro l3 = new Livro("A Guerra dos Tronos", 1996);
        Livro l4 = new Livro("The Hitchhiker's Guide to the Galaxy", 1979);
        Livro l5 = new Livro("Os Homens que Não Amavam as Mulheres", 2005);
        Livro l6 = new Livro("A Viajante do Tempo", 1991);
        ArrayList<Livro> LivrosPub = new ArrayList();
        LivrosPub.add(l1);
        LivrosPub.add(l2);
        LivrosPub.add(l3);
        Livro[] livrosPri = new Livro[]{l4, l5, l6};
        Privada priv = new Privada(t, 5,livrosPri);
        Publica publ = new Publica(t2,LivrosPub);
        biblio.addCol(priv);
        biblio.addCol(publ);

    }
}
