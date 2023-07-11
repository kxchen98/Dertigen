import javax.swing.*;

public class main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rape Kai");
        frame.setContentPane(new DertigenGUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
