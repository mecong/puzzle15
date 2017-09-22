import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import game.BoardGenerator;
import game.model.PuzzleBoard;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PuzzleBoardTest {

    @Test
    public void testIsPuzzleSolved() throws Exception {
        int boardSize=3;
        PuzzleBoard puzzleBoard = new PuzzleBoard(boardSize, new SolvedBoardGenerator().generateVector(boardSize));

        assertTrue(puzzleBoard.isPuzzleSolved());
    }

    @Test
    public void testMove() throws Exception {
        int boardSize=3;
        PuzzleBoard puzzleBoard = new PuzzleBoard(boardSize, new SolvedBoardGenerator().generateVector(boardSize));
        puzzleBoard.move(1,2);

        assertEquals(puzzleBoard.getBoard()[2][2], 6);
    }

    private class SolvedBoardGenerator implements BoardGenerator {

        @Override
        public int[] generateVector(int boardSize) {
            List<Integer> list = new ArrayList<>(boardSize * boardSize);
            for (int i = 1; i < boardSize * boardSize; i++) {
                list.add(i);
            }
            list.add(0);

            return list.stream().mapToInt(i -> i).toArray();
        }
    }

}