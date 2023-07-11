import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Player> players = new ArrayList<>();
    private Player currentPlayer;

    public Game() {
    }

    public void addPlayer(String playerName) {
        players.add(new Player(playerName));
    }

    public Player getPlayerByName(String playerName) {
        for (Player p : players) {
            if (playerName.equals(p.getName())) {
                return p;
            }
        }
        System.out.println("Could not get player!");
        return null;
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public boolean endOfTurn() {
        for (Dice d : currentPlayer.getDices()) {
            if (!d.getLockStatus()) {
                return false;
            }
        }
        return true;
    }

    public void playGame() {

    }

    public void handoutSips() {

    }

    public void secondThrow() {
        System.out.printf("Congratulations! You can throw again for %d!", currentPlayer.getSum() - 30);
        currentPlayer.resetDices();
    }

    public String getCurrentPlayer() {
        return currentPlayer.getName();
    }

    public void setFirstPlayer() {
        currentPlayer = players.get(0);
    }

}
