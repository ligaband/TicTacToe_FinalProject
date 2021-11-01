import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame board = new JFrame("TIC TAC TOE");
        board.getContentPane().add(new TicTacToeGUI());
        board.setBounds(550, 550, 550, 550);
        board.setResizable(false);
        board.setVisible(true);
        board.setLocationRelativeTo(null);
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
