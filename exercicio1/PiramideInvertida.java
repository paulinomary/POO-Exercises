package exercicio1;

import java.util.Scanner;

public class PiramideInvertida {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter N : ");

            int n = sc.nextInt();
            //i linha atual
            //n linhas totais
            //j são os espaços
            for(int i=n; i>0; i--) {
                for(int j=0;j<n-i;j++) System.out.print(" ");
                for(int j=0;j<(i*2);j++) System.out.print('*');
                System.out.println();
            }
        }
}
