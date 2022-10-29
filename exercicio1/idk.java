package exercicio1;

public class idk {
    public static void main(String[] args) {
        for (int i = 5; i >= 1; i--) {
//spaces
            for (int j = 1; j < 6 - i; j++) // nº de espaços antes dos *'s
                System.out.print("  ");
//stars

            for (int k = 0; k <= 2 * i-1; k++) {
                if (k == 0 || k == 2* i-1 )  // 0 são os primeiros *'s (primeira metade vertical) 2*i-1 é a posição dos *'s na segunda metade (vertical) do desenho
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            for (int m = 0; m <= 2 * i-1; m++) {
                if (m == 2* i-1)  // 0 são os primeiros *'s (primeira metade vertical) 2*i-1 é a posição dos *'s na segunda metade (vertical) do desenho
                    System.out.print("*");
                else
                    System.out.print(" ");
            }

            System.out.println();


        }

        for (int i = 1; i <= 5; i++) { // este 5 é metade de 10 que é o tamanho em linhas do desenho
//spaces
            for (int j = 1; j < 6 - i; j++) // nº de espaços antes dos *'s
                System.out.print("  ");
//stars
            for (int k = 0; k <= 2 * i - 1; k++) {
                if (k == 0 || k == 2*i-1) // 0 são os primeiros *'s (primeira metade vertical) 2*i-1 é a posição dos *'s na segunda metade (vertical) do desenho
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            for (int m = 0; m <= 2 * i-1; m++) {
                if (m == 2* i-1)  // 0 são os primeiros *'s (primeira metade vertical) 2*i-1 é a posição dos *'s na segunda metade (vertical) do desenho
                    System.out.print("*");
                else
                    System.out.print(" ");
            }

            System.out.println();


        }
    }
}
