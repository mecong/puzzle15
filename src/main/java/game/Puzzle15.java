package game;

import game.model.Board;
import game.model.PuzzleBoard;
import game.view.Gui;
import game.view.PuzzleView;

public class Puzzle15 {
    private static final int BOARD_SIZE = 4;
    private BoardGenerator boardGenerator;
    private Board board;
    private PuzzleView gui;
    private int moves;

    private int boardSize;

    public Puzzle15(int boardSize, BoardGenerator generator) {
        this.boardSize = boardSize;
        boardGenerator = generator;
        gui = new Gui(this);
    }

    private static int getBoardSizeArgument(String[] args) {
        int boardSize = BOARD_SIZE;
        if (args.length > 0) {
            try {
                boardSize = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Cannot parse board size argument");
            }

            if (boardSize < 3 || boardSize > 7) {
                System.out.println("Please let Board Size be in the range [3,7] ");
                System.exit(1);
            }
        }
        return boardSize;
    }

    public static void main(String[] args) {
        int boardSize = getBoardSizeArgument(args);

        Puzzle15 puzzle15 = new Puzzle15(boardSize, new RandomBoardGenerator());
        puzzle15.startNewGame();
    }

    public int getBoardSize() {
        return boardSize;
    }

    private void startNewGame() {
        board = new PuzzleBoard(boardSize, boardGenerator.generateVector(boardSize));
        moves = 0;
        gui.repaintGame(moves);
    }

    public int[][] getGameBoard() {
        return board.getBoard();
    }

    public void move(int x, int y) {
        if (board.move(x, y)) {

            gui.repaintGame(++moves);

            if (board.isPuzzleSolved()) {
                gui.congratulateTheWinner();
                startNewGame();
            }
        }
    }
}
