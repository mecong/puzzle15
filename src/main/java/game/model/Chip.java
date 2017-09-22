package game.model;

public class Chip {

    private int[][] gameBoard;
    private int x;
    private int y;

    public Chip(int[][] gameBoard, int x, int y) {
        this.gameBoard = gameBoard;
        this.x = x;
        this.y = y;
    }

    private void swap(int x1, int y1, int x2, int y2) {
        gameBoard[x1][y1] = gameBoard[x1][y1] + gameBoard[x2][y2];
        gameBoard[x2][y2] = gameBoard[x1][y1] - gameBoard[x2][y2];
        gameBoard[x1][y1] = gameBoard[x1][y1] - gameBoard[x2][y2];
    }

    public boolean moveLeft() {
        int newX = x - 1;
        if (newX >= 0 && this.gameBoard[newX][y] == Board.EMPTY_CELL) {
            swap(x, y, newX, y);
            return true;
        } else {
            return false;
        }
    }

    public boolean moveRight() {
        int newX = x + 1;
        if (newX < this.gameBoard.length && this.gameBoard[newX][y] == Board.EMPTY_CELL) {
            swap(x, y, newX, y);
            return true;
        } else {
            return false;
        }
    }

    public boolean moveUp() {
        int newY = y - 1;
        if (newY >= 0 && this.gameBoard[x][newY] == Board.EMPTY_CELL) {
            swap(x, y, x, newY);
            return true;
        } else {
            return false;
        }
    }

    public boolean moveDown() {
        int newY = y + 1;
        if (newY < this.gameBoard.length && this.gameBoard[x][newY] == Board.EMPTY_CELL) {
            swap(x, y, x, newY);
            return true;
        } else {
            return false;
        }
    }

}
