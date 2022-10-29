package exercicio2;

import java.util.Scanner;

public class Exercicio2 {

    public static String[] text;
    public static boolean bool = true;
    public static int c = 0;

    // main
    public static void main(String[] args) {

        readAll(text); // aceita as 10 linhas até o utilizador meter uma linha vazia
        printAll(text); // print todas as linhas
        do{
            mainMenu();
        }while (bool = true);

    } // main

    // lê todas as linhas
    public static void readAll(String[] text) {
        System.out.println("Insira as suas linhas de texto: ");
        text = countLines();

    } // readAll

    // conta as linhas inseridas pelo utilizador e cria o array
    // com o comprimento c (numero de linhas inseridas pelo utilizador)
    public static String[] countLines() {
        Scanner sc = new Scanner(System.in);
        String[] ntext = new String[10];
        for (int i = 0; i < 10; i++) {
            ntext[i] = sc.nextLine();
            c += 1;
            if (ntext[i].length() == 0) {
                break;
            }
        }
        text = new String[c]; // definimos um comprimento ao array

        for(int i = 0; i < c; i++) {  // criamos uma nova array com os comprimento de todas as linhas inseridas
            text[i] = ntext[i];
        }

        return text;
    } // countLines

    // imprime todas as linhas inseridas pelo utilizador
    public static void printAll(String[] text) {
        for (int i = 0; i < 10; i++) {
            System.out.println(text[i]);
            if (text[i].length() == 0) {
                break;
            }
        }
    } // printAll

    // conta a linha com o número máximo de caracteres
    public static void countMaxChars(String[] text) {
        int index = 0;
        int lineLength = text[0].length();
        for(int i=1; i< text[i].length(); i++) {
            if(text[i].length() > lineLength) {
                index = i;
                lineLength = text[i].length();
            }
        }
        System.out.println(text[index] + "\n");
    } // countMaxChars

    // procura todas as linhas que contém uma palavra dada pelo utilizador
    public static void allWordLines(String [] text) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Insira a palavra que quer procurar: ");
        String pal = scan.nextLine();
        for (int i = 0; i < text[i].length(); i++) {
            if (text[i].contains(pal)) {
                System.out.println(text[i] + "\n");
            }
        }
    } // allWordLines

    // procura uma linha especifica dentro do conjunto dado pelo utilizador
    public static void lineIn(String [] text)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Insira a linha que quer procurar: ");
        String line = s.nextLine();
        for (int i = 0; i < text[i].length(); i++){
            if (line.equals(text[i])){
                System.out.println("A linha que procura encontra-se no conjunto inserido: " + text[i] + "\n");
            }
        }
    } // lineIn

    // procura a linha com mais vogais com base na sua contagem feita em countVowels
    public static void moreVowels(String [] text) {
        int[] count = countVowels(text);
        int max = 0;
        int pos = 0;
        for(int i = 0; i < count.length; i++) {
            if (count[i] > max){
                max = count[i];
                pos = i;
            }
        }
        System.out.println("A linha com mais vogais é: " + text[pos] + "\n");
    } // moreVowels

    // conta as vogais de cada linha guardando as num array de inteiros
    public static int[] countVowels(String [] text){
        int[] countText = new int [c];
        for(int i = 0; i < text.length; i++){
            int count = 0;
            for(int j =0; j < text[i].length(); j++){
                if(text[i].charAt(j) == 'a' ||
                        text[i].charAt(j) == 'e' ||
                        text[i].charAt(j) == 'i' ||
                        text[i].charAt(j) == 'o' ||
                        text[i].charAt(j) == 'u'){
                    count += 1;
                }

            }
            countText[i] = count;
        }
        return countText;
    } // countVowels

    // procura e devolve todas as linhas que tenham menos caracteres de comprimento que um numero dado pelo utilizador
    public static void lessChars(String [] text) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Insira o número máximo de caracteres que as frases podem ter: ");
        int number = scan.nextInt();
        for (int i = 0; i < text[i].length(); i++){
            if (text[i].length() <= number){
                System.out.println(text[i]+ "\n");
            }

        }
    } // lessChars

    // aceita a opção dada pelo utilizador, interpreta-a e direciona-a
    public static void mainMenu(){
        Scanner sc = new Scanner(System.in);
        int opcao;
        do{
            //Menu de seleção
            printMenu();

            // Entrada da opção
            opcao = sc.nextInt();

            // Validação dos dados da opção
            if(opcao < 1 || opcao > 7)
                System.out.println("A opção introduzida não é válida!");

            // Linha com + caracteres
            if(opcao == 1){
                System.out.println("Selecionou: Escrever a linha com mais caracteres.");
                countMaxChars(text);
            }
            // Todas as linhas com n caracteres < n
            else if(opcao == 2){
                System.out.println("Selecionou: Listar todas as linhas com um número de caracteres inferior a um valor.");
                lessChars(text);
            }
            // Linha com + vogais
            else if(opcao == 3){
                System.out.println("Selecionou: Escrever a linha com mais vogais.");
                moreVowels(text);
            }
            // Todas as linhas com uma palavra especifica
            else if(opcao == 4){
                System.out.println("Selecionou: Listar todas as linhas que incluem uma palavra:");
                allWordLines(text);
            }
            // Linha dentro do conjunto de linhas
            else if(opcao == 5){
                System.out.println("Selecionou: Saber se uma linha dada está incluida no conjunto de linhas:");
                lineIn(text);
            }
            // Novas Linhas
            else if(opcao == 6){
                System.out.println("Selecionou: Fornecer um novo conjunto de linhas:");
                readAll(text);
                printAll(text);
            }
            // Sair do programa
            else if(opcao == 7){
                System.out.println("Selecionou: Sair do programa.");
                System.out.println("Programa terminado!");
                System.exit(0); // Este método termina a execução do programa
                sc.close();
            }
        } while(opcao != 7);
    } // mainMenu

    // imprime as opções do utilizador (menu)
    public static void printMenu(){
        System.out.println("***  MENU  ***");
        System.out.println("1. Escrever a linha com mais caracteres");
        System.out.println("2. Listar todas as linhas com um número de caracteres inferior a um valor");
        System.out.println("3. Escrever a linha com mais vogais");
        System.out.println("4. Listar todas as linhas que incluem uma palavra");
        System.out.println("5. Saber se uma linha dada está incluída no conjunto de linhas");
        System.out.println("6. Fornecer novo conjunto de linhas que substituirá o que está em utilização");
        System.out.println("7. Sair do programa");
    }

} // Exercicio2