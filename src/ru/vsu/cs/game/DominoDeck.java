package ru.vsu.cs.game;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// Класс доски
class DominoDeck {
    private List<DominoTile> tiles;

    public DominoDeck() {
        tiles = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                tiles.add(new DominoTile(i, j));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(tiles, new Random());
    }

    public List<DominoTile> getTiles() {
        return tiles;
    }
}
