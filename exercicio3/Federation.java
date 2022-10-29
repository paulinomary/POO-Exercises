package exercicio3;

import java.util.ArrayList;
import java.util.Scanner;

public class Federation {
    public static boolean bool;
    public static int option;
    public static ArrayList<String> listPos = new ArrayList<>();
    public static ArrayList<Base> base = new ArrayList<>();
    public static ArrayList<Extremo> extremo = new ArrayList<>();
    public static ArrayList<Poste> poste = new ArrayList<>();
    public static ArrayList<Equipa> equipa = new ArrayList<>();

    public static void main(String[] args) {
        listPos.add("base");
        listPos.add("extremo");
        listPos.add("poste");

        do{
            chooseOption();
        }while (bool);

    } //main

    public static void chooseOption(){

        do{
            menu();
            analisaOption();

            switch (option) {
                case 1 -> createTeam();
                case 2 -> addPlayer();
                case 3 -> valueCalc();
                case 4 -> teamRanking();
                case 5 -> playerRanking();
                case 6 -> {
                    bool = false;
                    System.out.println("Selecionou sair do programa!");
                    System.exit(0);
                }
            }
        }while (option != 6);
    } //chooseOption

    // option 1 - Criaçao da equipa
    public static void createTeam() {

        System.out.println("Equipas existentes: ");
        for (int i = 0; i<equipa.size(); i++)
            System.out.println("("+ (i + 1) + ") " + equipa.get(i).toString());

        ArrayList<Player> players = new ArrayList<>();

        String name = existTeam();

        int n = analisaNumber();

        introducePlayers(players, n,name);
        System.out.println("\nEquipa criada com sucesso!");
    }

    // option 2 - Adicionar player
    public static void addPlayer() {

        System.out.println("Equipas existentes: ");
        for (int i = 0; i<equipa.size(); i++)
            System.out.println("("+ (i + 1) + ") " + equipa.get(i).toString());

        Scanner scan = new Scanner(System.in);
        String nameTeam = verifyTeam();
        int index = indexTeam(nameTeam);
        boolean boo = false;

        do {
            if (equipa.get(index).getPlayer().size() > 12) {
                System.out.println("A equipa que introduziu ja esta cheia!");
                nameTeam = verifyTeam();
                index = indexTeam(nameTeam);
            } else {
                boo = true;
            }
        } while (!boo);

        String namePlayer = existPlayers(equipa.get(index).getPlayer());
        String pos = position();
        System.out.println("Introduza a media de pontos por jogo: ");
        double points = scan.nextDouble();
        System.out.println("Introduza a media de perdas de bola por jogo: ");
        double loses = scan.nextDouble();
        System.out.println("Introduza a media de assistencias por jogo: ");
        double assists = scan.nextDouble();
        System.out.println("Introduza a media de ressaltos por jogo: ");
        double bumps = scan.nextDouble();
        System.out.println("Introduza o tempo de jogo: ");
        double time = scan.nextDouble();
        Player player = new Player(nameTeam, namePlayer, pos, points, loses, assists, bumps, time);
        equipa.get(index).player.add(player);
        equipa.get(index).setn(equipa.get(index).n + 1);

        addPositions(nameTeam, namePlayer, pos, points, loses, assists, bumps, time);
        System.out.println("\nPlayer Adicionado!!");
    }

    // option 3 - Calculo da valia da equipa
    public static void valueCalc() {

        System.out.println("Equipas existentes: ");
        for (int i = 0; i<equipa.size(); i++)
            System.out.println("("+ (i + 1) + ") " + equipa.get(i).toString());

        String nameTeam = verifyTeam();

        int index = indexTeam(nameTeam);
        ArrayList<Player> players = equipa.get(index).getPlayer();

        ArrayList<Double> valueTeam = new ArrayList<>();
        positionCalc(players,valueTeam,nameTeam);
    }

    // option 4 - A melhor e a pior equipa
    public static void teamRanking () {

        System.out.println("Equipas existentes: ");
        for (int i = 0; i<equipa.size(); i++)
            System.out.println("("+ (i + 1) + ") " + equipa.get(i).toString());

        ArrayList<Double> valueRating = new ArrayList<>();
        ArrayList<String> nameRating = new ArrayList<>();

        for (Equipa i : equipa) {
            ArrayList<Double> valueTeam = new ArrayList<>();
            ArrayList<Player> players = i.getPlayer();

            positionCalc(players,valueTeam,i.getNome());

            double value = 0;
            for (Double aDouble : valueTeam) {
                value += aDouble;
            }
            nameRating.add(i.getNome());
            valueRating.add(value);
        }

        if (equipa.size() > 1) {
            minANDmax(valueRating,nameRating);
        } else {
            System.out.println("\nSo existe uma equipa + " + nameRating.get(0) + " logo encontra se no Ranking #1");
        }
    }

    // option 5 - O melhor de cada posicao
    public static void playerRanking()  {

        // Position base

        Base indexB = null;
        double maxB;

        if (base.size() > 0) {

            System.out.println("Base existentes: ");
            for (int i = 0; i<base.size(); i++)
                System.out.println("("+ (i+ 1) + ") " + base.get(i).name);

            maxB = base.get(0).getValue();

            for (Base value : base) {
                if (value.getTime() > 100) {
                    if (value.getValue() >= maxB) {
                        maxB = value.getValue();
                        indexB = value;
                    }
                }
            }
            if (indexB != null) {
                System.out.println("\nPlayer " + indexB.name + " da Team " + indexB.nameTeam + ": Ranking #1 da Posicao Base, com a valia de " + maxB + "\n");
            }
        }

        // Position Extremo

        Extremo indexE = null;
        double maxE;

        if (extremo.size() > 0) {
            System.out.println("Extremos existentes: ");
            for (int i = 0; i<extremo.size(); i++)
                System.out.println("("+ (i+1) + ") " + extremo.get(i).name);

            maxE = extremo.get(0).getValue();

            for (Extremo value : extremo) {
                if (value.getTime() > 100) {
                    if (value.getValue() >= maxE) {
                        maxE = value.getValue();
                        indexE = value;
                    }
                }
            }
            if (indexE != null) {
                System.out.println("\nPlayer " + indexE.name + " da Team " + indexE.nameTeam + ": Ranking #1 da Posicao Extremo, com a valia de " + maxE + "\n");
            }
        }

        // Position Poste

        Poste indexP = null;
        double maxP;
        if (poste.size() > 0) {
            System.out.println("Poste existentes: ");
            for (int i = 0; i<poste.size(); i++)
                System.out.println("("+ (i+ 1) + ") " + poste.get(i).name);

            maxP = poste.get(0).getValue();

            for (Poste value : poste) {
                if (value.getTime() > 100) {
                    if (value.getValue() >= maxP) {
                        maxP = value.getValue();
                        indexP = value;
                    }
                }
            }
            if (indexP != null) {
                System.out.println("\nPlayer " + indexP.name + " da Team " + indexP.nameTeam + ": Ranking #1 da Posicao Poste, com a valia de " + maxP + "\n");
            }
        }
    }

    // calcula das valias dos jogadores
    public static void positionCalc(ArrayList<Player> players, ArrayList<Double> valueTeam, String nameTeam) {
        for (Player player : players) {

            double points = player.getPoints();
            double lose = player.getLose();
            double assist = player.getAssist();
            double bumps = player.getBumps();

            double base;
            double extremo;
            double poste;

            if (player.pos.compareTo("Base".toLowerCase()) == 0) {
                base = 3 * points + 3 * assist + 2 * bumps - 3 * lose;
                valueTeam.add(base);
            } else if (player.pos.compareTo("Extremo".toLowerCase()) == 0) {
                extremo = 4 * points + 2 * assist + 2 * bumps - 3 * lose;
                valueTeam.add(extremo);
            } else if (player.pos.compareTo("Poste".toLowerCase()) == 0) {
                poste = 3 * points + 1 * assist + 3 * bumps - 3 * lose;
                valueTeam.add(poste);
            }
        }

        double value = 0;
        for (Double val : valueTeam) {
            value += val;
        }

        System.out.println("\nValia da Equipa " + nameTeam + ": " + value);
    }

    // A equipa no ranking #1 e no ultimo lugar
    public static void minANDmax(ArrayList<Double> valueRating, ArrayList<String> nameRating) {
        int n = valueRating.size();
        Double max = valueRating.get(0);
        Double min = valueRating.get(0);
        String nameMax = nameRating.get(0);
        String nameMin = nameRating.get(0);
        for (int i = 0;i < n; i++) {
            if (valueRating.get(i) > max) {
                max = valueRating.get(i);
                nameMax = nameRating.get(i);
            } else {
                min = valueRating.get(i);
                nameMin = nameRating.get(i);
            }
        }

        if (min.equals(max) && n == 2) {
            System.out.println("\nAs duas equipas " + nameMax + " & " + nameMin + " tem a mesma valia: " + max);
        } else if (min.equals(max) && n > 2) {
            System.out.println("\nTodas as equipas tem a mesma valia: " + max);
        } else {
            System.out.println("\nA Team " + nameMax + " no Ranking #1 com uma valia de " + max);
            System.out.println("A Team " + nameMin + " no ultimo lugar com uma valia de " + min);
        }
    }

    // Posicao da equipa no ArrayLíst equipa
    public static int indexTeam(String nameTeam) {
        int index = 0;
        for (int i = 0; i < equipa.size(); i++) {
            if (equipa.get(i).nome.compareTo(nameTeam) == 0) {
                index = i;
            }
        }
        return index;
    }

    // adicionar players ao criar uma equipa
    public static void introducePlayers(ArrayList<Player> players, int n, String name) {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i <n ; i++) {
            String namePlayer = existPlayers(players);
            String pos = position();
            System.out.println("Introduza a media de pontos por jogo: ");
            double points = scan.nextDouble();
            System.out.println("Introduza a media de perdas de bola por jogo: ");
            double loses = scan.nextDouble();
            System.out.println("Introduza a media de assistencias por jogo: ");
            double assists = scan.nextDouble();
            System.out.println("Introduza a media de ressaltos por jogo: ");
            double bumps = scan.nextDouble();
            System.out.println("Introduza o tempo de jogo: ");
            double time = scan.nextDouble();
            Player player = new Player(name,namePlayer,pos,points,loses,assists,bumps,time);
            players.add(player);

            addPositions(name, namePlayer, pos, points, loses, assists, bumps, time);
        }
        Equipa e = new Equipa(name, n , players);
        equipa.add(e);
    }

    public static void addPositions(String name, String namePlayer, String pos, double points, double loses, double assists, double bumps, double time) {
        if (pos.toLowerCase().compareTo("base") == 0) {
            Base b = new Base(name,namePlayer,points,loses,bumps,assists,time);
            base.add(b);
        } else if (pos.toLowerCase().compareTo("extremo") == 0) {
            Extremo e = new Extremo(name, namePlayer, points, loses, bumps, assists, time);
            extremo.add(e);
        } else if (pos.toLowerCase().compareTo("poste") == 0) {
            Poste p = new Poste(name, namePlayer, points, loses, bumps, assists, time);
            poste.add(p);
        }
    }

    // analisa se a posiçao do player inserida existe
    public static String position() {
        Scanner scan = new Scanner(System.in);
        String pos ;

        System.out.println("Intorduza a posicao do jogador: ");
        pos = scan.next();
        while(!listPos.contains(pos.toLowerCase())) {
            System.out.println("Posicao errada! Introduza Posicao: ");
            pos = scan.next();
        }
        return pos.toLowerCase();
    }

    // para adicionar um jogador precisa de meter numa equipa existente
    public static String verifyTeam() {
        ArrayList<String> Listname = new ArrayList<>();
        for (Equipa value : equipa) {
            Listname.add(value.nome.toLowerCase());
        }
        Scanner scan = new Scanner(System.in);
        String name;
        System.out.println("Introduza o nome da equipa: ");
        name = scan.next();
        while (!Listname.contains(name.toLowerCase())) {
            System.out.println("Este nome de equipa nao existe! Introduza outro nome: ");
            name = scan.next();
        }
        return name;
    }

    // ao adicionar jogador ve se este jogador ja existe na equipa
    public static String existPlayers(ArrayList<Player> players) {
        ArrayList<String> listName = new ArrayList<>();

        System.out.println("Jogadores existentes: ");
        for (int i = 0; i<players.size(); i++)
            System.out.println("("+ (i + 1) + ") " + players.get(i).name);

        for (Player player : players) {
            listName.add(player.name.toLowerCase());
        }

        Scanner scan = new Scanner(System.in);
        String name;
        System.out.println("Introduza o nome do jogador: ");
        name = scan.next();
        while (listName.contains(name.toLowerCase())) {
            System.out.println("Este jogador ja existe! Introduza outro: ");
            name = scan.next();
        }
        return name;
    }

    // analisa se esta equipa ja existe ou nao
    public static String existTeam() {
        ArrayList<String> listName = new ArrayList<>();
        for (Equipa value : equipa) {
            listName.add(value.nome.toLowerCase());
        }
        Scanner scan = new Scanner(System.in);
        String name;
        System.out.println("Introduza o nome da equipa: ");
        name = scan.next();
        while (listName.contains(name.toLowerCase())) {
            System.out.println("Este nome de equipa ja existe! Introduza outro: ");
            name = scan.next();
        }
        return name;
    }

    //analisa se a equipa excede 12 jogadores
    public static int analisaNumber(){
        int n;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Introduza o numero de elementos: ");
            while (!scan.hasNextInt()) {
                System.out.println("Nao é um numero inteiro");
                scan.next();
            }
            n = scan.nextInt();
            if (n < 1 || n > 12){
                System.out.println("Numero fora do intervalo");
            }
        } while(n < 1 || n > 12);
        return n;
    }

    //analisa Option de escolha do menu
    public static void analisaOption(){
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Escolha a opcao: ");
            while (!scan.hasNextInt()) {
                System.out.println("Nao é um numero inteiro");
                scan.next();
            }
            option = scan.nextInt();
            if (option < 1 || option > 6){
                System.out.println("Numero fora do intervalo");
            }
        } while(option < 1 || option > 6);
    } //analisaOption

    public static void menu() {   // MENU DE OPERACOES
        System.out.println("\n***MENU***:");
        System.out.println("(1) Criar uma nova equipa ");
        System.out.println("(2) Adicionar um atleta a uma equipa existente");
        System.out.println("(3) Calcular a valia de uma equipa ");
        System.out.println("(4) Indicar qual a equipa mais valiosa e qual a menos valiosa ");
        System.out.println("(5) Indicar qual o atleta mais valioso em cada posicao ");
        System.out.println("(6) Sair do programa");
    }
}
