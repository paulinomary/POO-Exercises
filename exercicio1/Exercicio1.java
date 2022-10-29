package exercicio1;

import java.util.Scanner;

public class Exercicio1 {

    static Scanner scan = new Scanner(System.in);
    public static int ano;
    public static int mes;
    public static int dia;
    public static int bissexto;

    public static void main(String[] args) {
        getAno();


    }
    //Método que vai buscar o ano através do Scanner
    public static void getAno(){
        System.out.print("Insira o ano: ");
        ano = scan.nextInt();
        getMes();
        scan.close();
    }

    //Método que vai buscar o mês através do Scanner, se o mês estiver dentro do intervalo aceitável segue para o próximo passo
    //Se não não sai do erro até ser inserido um valor dentro do intervalo devido
    public static void getMes(){
        System.out.print("Insira o mês: ");
        mes = scan.nextInt();
        if(mes >= 1 && mes <= 12){
            getDia();
        }
        else {
            do erroMes();
                while (mes < 1 || mes > 12);
            getDia();


        }
    }

    //Método que pede ao utilizador o dia através do Scanner
    public static void getDia(){
        System.out.print("Insira o dia: ");
        dia = scan.nextInt();
        validaApresenta();
        scan.close();
    }

    //Método que dá scan a uma nova entrada do dia quando o utilizador insere um dia que não é válido
    public static void erroDia(){
        System.out.println("O dia que inseriu não é válido...");
        System.out.println("Insira outro dia: ");
        dia = scan.nextInt();

    }

    //Dá scan através do Scanner a uma nova entrada do mês quando este não está no intervalo correto
    public static void erroMes(){
        System.out.println("O mês que inseriu não é válido...");
        System.out.println("Insira outro mês: ");
        mes = scan.nextInt();

    }

    //Verificação se o ano introduzido é bissexto, se for o int bissexto toma valor 1, se não for toma valor 0
    public static void checkBissexto() {
        if (((ano % 4 == 0) && (ano % 100!= 0)) || (ano % 400 == 0)){
            bissexto = 1;
        }
        else {
            bissexto = 0 ;
        }
    }

    //Método onde existe a verificação dos dias chamada do método da estação correspondente
    public static void validaApresenta() {
        if (mes == 1) {
            if (dia >= 1 && dia <= 31) {
                inverno();
            } else {
                do erroDia();
                while (dia < 1 || dia > 31);
                validaApresenta();
            }
        }

        if (mes == 2) {
            checkBissexto();
            if (bissexto == 1 && dia >= 1 && dia <= 29) {
                inverno();
            } else if (bissexto == 0 && dia >= 1 && dia <= 28) {
                inverno();
            } else {
                do erroDia();
                while (dia < 1 || dia > 29);
                validaApresenta();
            }
        }

        if (mes == 3){
            if (dia >= 1 && dia <= 19){
                inverno();
            }
            else if (dia >= 20 && dia <= 31){
                primavera();
            }
            else{
                do erroDia();
                while (dia < 1 || dia > 31);
                validaApresenta();
            }
        }

        if (mes == 4){
            if (dia >= 1 && dia <= 30) {
                primavera();
            } else {
                do erroDia();
                while (dia < 1 || dia > 30);
                validaApresenta();
            }
        }

        if (mes == 5){
            if (dia >= 1 && dia <= 31) {
                primavera();
            } else {
                do erroDia();
                while (dia < 1 || dia > 31);
                validaApresenta();
            }
        }

        if (mes == 6){
            if (dia >= 1 && dia <= 20){
                primavera();
            }
            else if (dia >= 21 && dia <= 30){
                verao();
            }
            else{
                do erroDia();
                while (dia < 1 || dia > 30);
                validaApresenta();
            }
        }

        if (mes == 7){
            if (dia >= 1 && dia <= 31) {
                verao();
            } else {
                do erroDia();
                while (dia < 1 || dia > 31);
                validaApresenta();
            }
        }

        if (mes == 8){
            if (dia >= 1 && dia <= 31) {
                verao();
            } else {
                do erroDia();
                while (dia < 1 || dia > 31);
                validaApresenta();
            }
        }

        if (mes == 9){
            if (dia >= 1 && dia <= 22){
                verao();
            }
            else if (dia >= 23 && dia <= 30){
                outono();
            }
            else{
                do erroDia();
                while (dia < 1 || dia > 30);
                validaApresenta();
            }
        }

        if (mes == 10){
            if (dia >= 1 && dia <= 31) {
                outono();
            } else {
                do erroDia();
                while (dia < 1 || dia > 31);
                validaApresenta();
            }
        }

        if (mes == 11){
            if (dia >= 1 && dia <= 30) {
                outono();
            } else {
                do erroDia();
                while (dia < 1 || dia > 30);
                validaApresenta();
            }
        }

        if (mes == 12){
            if (dia >= 1 && dia <= 20){
                outono();
            }
            else if (dia >= 21 && dia <= 31){
                inverno();
            }
            else{
                do erroDia();
                while (dia < 1 || dia > 31);
                validaApresenta();
            }
        }

    }

    //Construção da figura do inverno
    public static void inverno() {

        System.out.println("Inverno");
        //Parte de cima do desenho
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j < 6 - i; j++) // nº de espaços antes dos *'s
                System.out.print("  ");
            for (int k = 0; k <= 2 * i - 1; k++) {
                if (k == 0 || k == 2 * i - 1)  // Desenha a linha mais à esquerda e a do meio
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            for (int m = 0; m <= 2 * i - 1; m++) {
                if (m == 2 * i - 1)  //Desenha a linha + à direita
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

        // Parte de baixo do desenho
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j < 6 - i; j++) // nº de espaços antes dos *'s
                System.out.print("  ");
            for (int k = 0; k <= 2 * i - 1; k++) {
                if (k == 0 || k == 2*i-1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            for (int m = 0; m <= 2 * i-1; m++) {
                if (m == 2* i-1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    //Criação da figura da primavera
    public static void primavera(){
        System.out.println("Primavera");

        //A primavera é representada por um simbolo repetido 2x
        for (int i = 0; i < 2; i++) {
            for (int x = 5; x >= 1; x--) {
                for (int j = 1; j < 6 - x; j++) // nº de espaços antes dos *'s
                    System.out.print("  ");
                for (int k = 0; k <= 2 * x-1; k++) {
                    if (k == 0)
                        System.out.print("**");
                    else if(k==2*x-1){
                        System.out.print("*");
                    }
                    else
                        System.out.print(" ");
                }
                for (int m = 0; m <= 2 * x-1; m++) {
                    if (m == 2* x-2)
                        System.out.print("**");
                    else
                        System.out.print(" ");
                }
                System.out.println();
            }
        }
    }

    //Criação da figura do verão
    public static void verao(){
        System.out.println("Verão");

        // Parte de cima do desenho
        for (int i = 5; i <= 5; i++) {
            for (int j = 1; j < 6 - i; j++) // nº de espaços antes dos *'s
                System.out.print("  ");
            for (int k = 0; k <= 2 * i - 1; k++) {
                if (k == 0 || k == 2* i -1)
                    System.out.print("*");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }

        // Parte de baixo do desenho
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j < 6 - i; j++) // nº de espaços antes dos *'s
                System.out.print("  ");
            for (int k = 0; k <= 2 * i - 1; k++) {
                if (k == 0 || k == 2* i -1)
                    System.out.print("*");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    // Criação da figura do exercicio1.outono
    public static void outono(){
        System.out.println("Outono");


        for (int i = 5; i <= 5; i++) {
            for (int j = 1; j < 6 - i; j++) // nº de espaços antes dos *'s
                System.out.print(" ");
            for (int k = 0; k <= 2 * i - 1; k++) {
                if (k == 0 || k == 2* i -1)
                    System.out.print("***");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
            //Parte de Baixo
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j < 6 - i; j++) // nº de espaços antes dos *'s
                System.out.print(" ");
            for (int k = 0; k <= 2 * i - 1; k++) {
                if (k == 0 || k == 2* i -1)
                    System.out.print("***");
                else
                    System.out.print(" ");
            }
            System.out.println("");
        }
    }
}