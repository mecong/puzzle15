package game.model;

public interface Board {
    int EMPTY_CELL = 0;

    boolean move(int x, int y);

    boolean isPuzzleSolved();

    int[][] getBoard();
}
