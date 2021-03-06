
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//JPanel is a parent class and TicTacToe is a subclass.
// This way it is possible to use JPanel methods for creating GUI

public class TicTacToeGUI extends JPanel {

    char playerSymbol = 'X';

    //Array of 9 buttons
    JButton[] buttons = new JButton[9];

    public TicTacToeGUI() {

        // With each loop a new button is created, totally created 9 buttons
        // set the text, add action listeners
        // and add them to the screen

        setLayout(new GridLayout(3,3));

        for(int i = 0; i <= 8; i++) {
            buttons[i] = new JButton();
            buttons[i].setText(" ");
            buttons[i].setBackground(Color.white);
            buttons[i].setOpaque(true);
            buttons[i].setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
            buttons[i].setFont(new Font(Font.SERIF, Font.BOLD, 100));
            //implement an action listener to define what should be done when a user performs certain operation.
            buttons[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    //get the button that was clicked
                    JButton buttonClicked = (JButton) e.getSource();
                    //when the button  is clicked, X or O is displayed
                    buttonClicked.setText(String.valueOf(playerSymbol));


                    if(playerSymbol == 'X') {
                        playerSymbol = 'O';
                        buttonClicked.setBackground(Color.GRAY);
                    } else {
                        playerSymbol ='X';
                        buttonClicked.setBackground(Color.PINK);
                    }
                    showWinner();

                }
            });
//adds clicked button to JPanel
            add(buttons[i]);
        }
    }

    // display the winner and the game stops when there is a winner
    public void showWinner() {

        if(checkWinner() == true) {

            // switch the player symbols
            // because after we put X and we win, the games withes it to X
            // but x is the winner and X should be kept

            if(playerSymbol == 'X') playerSymbol = 'O';
            else playerSymbol ='X';

            //create option pane

            JOptionPane pane = new JOptionPane();
            int dialogResult = JOptionPane.showConfirmDialog(pane, playerSymbol + " has won. Play again?","Game over!",
                    JOptionPane.YES_NO_OPTION);

            if(dialogResult == JOptionPane.YES_OPTION) resetGame();
            else System.exit(0);
        }

        else if(checkDraw()) {
            JOptionPane pane = new JOptionPane();
            int dialogResult = JOptionPane.showConfirmDialog(pane, "It's a draw! Play again?","Game over!", JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION)  resetGame();
            else System.exit(0);
        }
    }


    public boolean checkDraw() {
        boolean full = true;
        for(int i = 0 ; i<9;i++) {
            if(buttons[i].getText().charAt(0) == ' ') {
                full = false;
            }
        }
        return full;
    }


    public boolean checkWinner() {
        return (checkRows() == true || checkColumns() == true || checkDiagonals() == true);
    }

   public boolean checkRows() {

        int i = 0;
        for(int j = 0;j<3;j++) {
            if( buttons[i].getText().equals(buttons[i+1].getText()) && buttons[i].getText().equals(buttons[i+2].getText())
                    && buttons[i].getText().charAt(0) != ' ') {
                return true;
            }
            i = i+3;
        }
        return false;
    }

    public boolean checkColumns() {

        int i = 0;
        for(int j = 0;j<3;j++) {
            if( buttons[i].getText().equals(buttons[i+3].getText()) && buttons[i].getText().equals(buttons[i+6].getText())
                    && buttons[i].getText().charAt(0) != ' ')
            {
                return true;
            }
            i++;
        } return false;
    }
    public boolean checkDiagonals() {
        if(buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText())
                && buttons[0].getText().charAt(0) !=' ')
            return true;
        else return (buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText())
                && buttons[2].getText().charAt(0) !=' ');
    }
    //method for reset

    private void resetGame() {
        playerSymbol = 'X';
        for(int i =0;i<9;i++) {
            buttons[i].setText(" ");
            buttons[i].setBackground(Color.white);
        }
    }
}
