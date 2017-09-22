package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomBoardGenerator implements  BoardGenerator{

    @Override
    public int[] generateVector(int boardSize) {

        List<Integer> list = new ArrayList<>(boardSize * boardSize);
        for (int i = 0; i < boardSize * boardSize; i++) {
            list.add(i);
        }

        Collections.shuffle(list);

        return list.stream().mapToInt(i -> i).toArray();
    }
}
