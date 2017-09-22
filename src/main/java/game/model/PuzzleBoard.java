package game.model;

public class PuzzleBoard implements Board {
    private final int boardSize;
    private int[][] gameBoard;

    public PuzzleBoard(int boardSize, int[] vector) {
        this.boardSize = boardSize;
        gameBoard = new int[this.boardSize][];
        int counter = 0;
        for (int i = 0; i < this.boardSize; i++) {
            gameBoard[i] = new int[this.boardSize];

            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = vector[counter++];
            }
        }
    }

    @Override
    public boolean move(int x, int y) {
        Chip chip = new Chip(gameBoard, x, y);
        return chip.moveLeft() || chip.moveRight() || chip.moveUp() || chip.moveDown();
    }

    @Override
    public boolean isPuzzleSolved() {
        int rightCounter = 1;
        for (int i = 0; i < this.boardSize; i++) {
            for (int j = 0; j < this.boardSize; j++) {
                if (rightCounter == gameBoard[i][j]) {
                    rightCounter++;
                    if (rightCounter == boardSize * boardSize) rightCounter = 0;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int[][] getBoard() {
        return gameBoard;
    }
}
