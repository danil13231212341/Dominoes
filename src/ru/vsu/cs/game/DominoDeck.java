package ru.vsu.cs.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DominoDeck {
    private List<DominoTile> tiles;

    public DominoDeck() {
        tiles = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                tiles.add(new DominoTile(i, j));
            }
        }
        Collections.shuffle(tiles);
    }

    public DominoTile draw() {
        return tiles.remove(0);
    }

    public int size() {
        return tiles.size();
    }
}
