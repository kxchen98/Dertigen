import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class DertigenGUI {
    JPanel mainPanel;
    private JPanel gameGUI;
    private JPanel playersPanel;
    private JButton playersButton;
    private JButton gameButton;
    private JButton debtsButton;
    private JPanel menuPanel;
    private JPanel gamePanel;
    private JPanel debtPanel;
    private JTextField mainPlayerNameTextField;
    private JButton mainAddButton;
    private JList<Object> mainPlayerList;
    private JButton mainDoneButton;
    private JLabel mainPlayerNameLabel;
    private JButton gameRollButton;
    private JButton gameDice1LockButton;
    private JButton gameDice3LockButton;
    private JButton gameDice2LockButton;
    private JButton gameDice4LockButton;
    private JButton gameDice5LockButton;
    private JButton gameDice6LockButton;
    private JButton gameFinishButton;
    private JLabel gameDice1Label;
    private JLabel gameDice2Label;
    private JLabel gameDice3Label;
    private JLabel gameDice4Label;
    private JLabel gameDice5Label;
    private JLabel gameDice6Label;
    private JLabel gameTotalLabel;
    private JLabel gameDice1ValueLabel;
    private JLabel gameDice2ValueLabel;
    private JLabel gameDice3ValueLabel;
    private JLabel gameDice4ValueLabel;
    private JLabel gameDice5ValueLabel;
    private JLabel gameDice6ValueLabel;
    private JLabel gameTotalValueLabel;
    private JButton debtAddButton;
    private JButton debtMinusButton;
    private JButton debtPayOffButton;
    private JList debtList;
    private JLabel debtAmountSipsLabel;
    private JLabel debtsAmountSipsToBeLabel;
    private JButton mainRemoveButton;
    private JLabel gamePlayerLabel;
    private JLabel gameCurrentPlayerLabel;
    boolean isStarted;
    Game game = new Game();

    public DertigenGUI() {
        isStarted = false;
        DefaultListModel<Object> model = new DefaultListModel<>();

        playersButton.addActionListener(e -> changePanels(playersPanel));

        gameButton.addActionListener(e -> changePanels(gamePanel));

        debtsButton.addActionListener(e -> changePanels(debtPanel));

        mainAddButton.addActionListener(e -> addPlayer(model));

        mainDoneButton.addActionListener(e -> {
            game.setFirstPlayer();
            gameCurrentPlayerLabel.setText(game.getCurrentPlayer());
        });

        mainRemoveButton.addActionListener(e -> removePlayer(model));
        gameRollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void changePanels(Component panel) {
        gameGUI.removeAll();
        gameGUI.add(panel);
        gameGUI.repaint();
        gameGUI.revalidate();
    }

    public void addPlayer(DefaultListModel<Object> model) {
        mainPlayerList.setModel(model);
        String name = mainPlayerNameTextField.getText();
        if (!checkEmptyName(name) && !checkDuplicateName(getPlayerNames(mainPlayerList), name)) {
            game.addPlayer(name);
            model.addElement(name);
        }
    }

    public void removePlayer(DefaultListModel<Object> model) {
        mainPlayerList.setModel(model);
        String playerName = mainPlayerList.getSelectedValue().toString();
        game.removePlayer(game.getPlayerByName(playerName));
        model.removeElement(playerName);
    }

    public boolean checkDuplicateName(ArrayList<String> names, String textField) {
        if (names.contains(textField)) {
            JOptionPane.showMessageDialog(null, "Name is already taken, choose another one!",
                    "Error:", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        return false;
    }

    public boolean checkEmptyName(String textField) {
        if (textField.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid name!",
                    "Error:", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        return false;
    }

    public ArrayList<String> getPlayerNames(JList list) {
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < list.getModel().getSize(); i++) {
            names.add((String) list.getModel().getElementAt(i));
        }
        return names;
    }

}
