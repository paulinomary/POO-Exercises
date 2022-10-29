package exercicio4;

import java.io.*;
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Colecao> col = new ArrayList<>();

    public Biblioteca (){}
    public Biblioteca (ArrayList<Colecao> col) {
        this.col = col;
    }

    public ArrayList<Colecao> getCol() {
        return col;
    }

    public void setCol(ArrayList<Colecao> col) {
        this.col = col;
    }

    public void addCol(Colecao col) {
        this.col.add(col);
    }

    public void adventure() {

        System.out.println("Livros com o tema aventura:");
        for (Colecao colecao: this.col) {
            String[] t = colecao.getTema();

            for (int i = 0; i < t.length; i++) {
                String ad = t[i];

                if (ad.equalsIgnoreCase("Aventura")) {
                    ArrayList all = colecao.getAllLivros();

                    for (int j = 0; j < all.size(); j++) {
                        Livro l = (Livro) all.get(j);
                        System.out.println(l.getTitulo());
                    }
                }
            }
        }
    }

    public void objectFile() {
        File file = new File("FileObject.obj");
        try {
            FileOutputStream fOS = new FileOutputStream(file);
            ObjectOutputStream oOS = new ObjectOutputStream(fOS);
            for (Colecao colecao: this.col) {
                oOS.writeObject(colecao);
            }
            oOS.close();
            System.out.println("Fichero De Objetos criado com todas as Colecoes");

        } catch (FileNotFoundException exc) {
            System.out.println("ERRO AO ACEDER AO FICHEIRO");

        } catch (IOException e) {
            System.out.println("Erro ao escrever o ficheiro");
        }
    }

    public void txtFile() {
        File file = new File("FileTxt.txt");
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Colecao colecao: this.col) {
                ArrayList<Livro> livros = colecao.getAllLivros();

                for (Livro l: livros) {
                    bw.write(l.getTitulo() + " " + l.getAno());
                    bw.newLine();
                }
            }
            bw.close();
            System.out.println("Fichero De Txt criado com todos livros");

        } catch (FileNotFoundException exc) {
            System.out.println("ERRO AO ACEDER AO FICHEIRO");

        } catch (IOException e) {
            System.out.println("Erro ao escrever o ficheiro");
        }
    }
}
