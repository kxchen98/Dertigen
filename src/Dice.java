import java.util.Random;

public class Dice {

    private int value;
    private boolean isLocked;
    private final Random r = new Random();

    public Dice() {
        value = r.nextInt(6) + 1;
        isLocked = false;
    }

    public void roll() {
        value = r.nextInt(6) + 1;
    }

    public void lock() {
        isLocked = true;
    }

    public void unlock() {
        isLocked = false;
    }

    public int getValue() {
        return value;
    }

    public boolean getLockStatus() {
        return isLocked;
    }

}
