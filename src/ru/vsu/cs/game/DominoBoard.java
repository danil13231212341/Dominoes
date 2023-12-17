package ru.vsu.cs.game;

import java.util.ArrayList;
import java.util.List;

class DominoBoard {
    private List<DominoTile> tiles;

    public DominoBoard() {
        tiles = new ArrayList<>();
    }

    public List<DominoTile> getTiles() {
        return tiles;
    }

    public void addTile(DominoTile tile) {
        tiles.add(tile);
    }

    public int getLeftValue() {
        if (tiles.isEmpty()) {
            return -1;
        }
        return tiles.get(0).getLeft();
    }

    public int getRightValue() {
        if (tiles.isEmpty()) {
            return -1;
        }
        return tiles.get(tiles.size() - 1).getRight();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (DominoTile tile : tiles) {
            sb.append(tile);
        }
        return sb.toString();
    }
}
