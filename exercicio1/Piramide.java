package exercicio1;

import java.util.Scanner;

public class Piramide {
    public static void main(String[] args) {
        int n, i, j, k;
        // j numero da linha
        // n numero de linhas inseridas pelo user
        // i espacos de dentro
        // k espaços de fora
        Scanner sc = new Scanner(System.in);
        System.out.print ("n= ");
        n = sc.nextInt();

        for (j = 1; j <= n; j++) {
            // espaco em branco parte da esquerda
            for (k = 1; k <= n-j; k++) System.out.print (" ");
            for (i = 1; i <= j; i++) System.out.print ("*"); // imprime metade da direita
            for (i = j-1; i > 0; i--) System.out.print ("*"); //imprime metade da esquerda
            System.out.println ();
        }


    }

}
/**
 * sendo j o número da linha vai até j dentro da linha
 *
 **/