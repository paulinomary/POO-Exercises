package exercicio3;

public class Player extends Equipa {
    protected String name, pos;
    protected double points;
    protected double lose;
    protected double assist;
    protected double bumps;
    protected double time;

    public Player(String name, String namePlayer, String pos, double points, double lose, double assist, double bumps, double time) {
        super(name);
        this.name = namePlayer;
        this.pos = pos;
        this.points = points;
        this.lose = lose;
        this.assist = assist;
        this.bumps = bumps;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public double getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public double getAssist() {
        return assist;
    }

    public void setAssist(double assist) {
        this.assist = assist;
    }

    public double getBumps() {
        return bumps;
    }

    public void setBumps(int bumps) {
        this.bumps = bumps;
    }

    public double getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Player " + name + '\'' +
                ", position:'" + pos + '\'' +
                ", average points per game:" + points +
                ", average loses per game:" + lose +
                ", average assists per game:" + assist +
                ", average bumps per game:" + bumps +
                ", average time played:" + time;
    }
}
