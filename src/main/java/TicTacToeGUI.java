
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

