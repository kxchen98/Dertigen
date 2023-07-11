public class Player {

    private final String name;
    private final Dice[] dices = new Dice[6];
    private int sips;

    public Player(String name) {
        this.name = name;
        this.sips = 0;
        for (int i = 0; i < this.dices.length; i++) {
            this.dices[i] = new Dice();
        }
    }

    public String getName() {
        return this.name;
    }

    public Dice[] getDices() {
        return dices;
    }

    public void rollDices(String toLock) {

    }

    public void resetDices() {

    }

    public int getSum() {
        int sum = 0;
        for (Dice d : dices) {
            sum += d.getValue();
        }
        return sum;
    }

    public int getSips() {
        return sips;
    }

    public void addSips(int amount) {
        this.sips += amount;
    }

}
