package game.view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import game.Puzzle15;

public class Gui extends MouseAdapter implements PuzzleView {

    private static JFrame window = new JFrame();
    private final int boardSize;
    private JPanel[][] grid;

    private JLabel statusPanel = new JLabel();
    private Puzzle15 game;

    public Gui(Puzzle15 game) {
        this.boardSize = game.getBoardSize();
        this.game = game;
        window.setMinimumSize(new Dimension(300, 330));
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("Puzzle 15 game");

        window.setLayout(new BorderLayout());

        window.add(generateBoard(), BorderLayout.CENTER);

        window.add(statusPanel, BorderLayout.NORTH);

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    private JPanel generateBoard() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(boardSize, boardSize));

        grid = new JPanel[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++) {
            grid[i] = new JPanel[boardSize];
            for (int j = 0; j < boardSize; j++) {
                JPanel pan = new JPanel();
                pan.setLayout(new BorderLayout());
                grid[i][j] = pan;

                panel.add(grid[i][j]);
            }
        }

        return panel;
    }

    @Override
    public void repaintGame(int movesCount) {
        int[][] gameBoard = game.getGameBoard();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                JPanel panel = grid[i][j];
                if (gameBoard[i][j] == 0) {// gap
                    panel.removeAll();
                } else if (panel.getComponentCount() == 0) {
                    JButton button = new MyJButton(String.valueOf(gameBoard[i][j]), i, j);
                    button.addMouseListener(this);
                    panel.add(button);
                } else {
                    ((JButton) panel.getComponent(0)).setText(String.valueOf(gameBoard[i][j]));
                }
            }
        }

        statusPanel.setText("Moves: " + movesCount);
        window.repaint();
        window.revalidate();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        MyJButton button = (MyJButton) e.getComponent();
        game.move(button.getX(), button.getY());
    }

    @Override
    public void congratulateTheWinner() {
        JOptionPane.showMessageDialog(window, "You solved the puzzle! A new game will start.");
    }
}
