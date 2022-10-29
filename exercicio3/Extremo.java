package exercicio3;

public class Extremo {
    public String name;
    public String nameTeam;
    public double points;
    public double lose;
    public double bumps;
    public double assists;
    public double time;
    public double value;

    public Extremo(String nameTeam, String name, double points, double lose, double bumps, double assists, double time) {
        this.nameTeam = nameTeam;
        this.name = name;
        this.assists = assists;
        this.points = points;
        this.lose = lose;
        this.bumps = bumps;
        this.value = 4* points + 2* assists + 2* bumps - 3*lose;
        this.time = time;
    }


    public double getValue () {
        return value;
    }

    public void setValue(int points, int lose, int bumps, int assists) {
        this.value = 4* points + 2* assists + 2* bumps - 3*lose;
    }

    public void setPoints (int points) {
        this.points = points;
    }

    public void setLose (int lose) {
        this.lose = lose;
    }
    public void setAssists (double assists) {
        this.assists = assists;
    }
    public void setBumps (int bumps) {
        this.bumps = bumps;
    }

    public void setTime (int time) {
        this.time = time;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setNameTeam (String nameTeam) {
        this.nameTeam = nameTeam;
    }

    public String getName () {return name;}
    public String getNameTeam () {return nameTeam;}

    public double getPoints () { return points; }
    public double getLose () { return lose; }
    public double getBumps () { return bumps; }
    public double getAssists () { return assists; }
    public double getTime () {return time; }
}

