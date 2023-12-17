package ru.vsu.cs.game;

import java.util.ArrayList;
import java.util.List;

class DominoBoard {
    private List<DominoTile> tiles;

    public DominoBoard() {
        tiles = new ArrayList<>();
    }

    public boolean canPlace(DominoTile tile) {
        if (tiles.isEmpty()) {
            return true;
        } else {
            int firstValue = tiles.get(0).getLeftValue();
            int lastValue = tiles.get(tiles.size() - 1).getRightValue();
            return tile.getLeftValue() == firstValue || tile.getRightValue() == firstValue ||
                    tile.getLeftValue() == lastValue || tile.getRightValue() == lastValue;
        }
    }

    public void place(DominoTile tile, boolean atBeginning) {
        if (atBeginning) {
            if (tiles.isEmpty()) {
                tiles.add(tile);
            } else {
                if (tile.getRightValue() == tiles.get(0).getLeftValue()) {
                    tiles.add(0, tile);
                } else {
                    tiles.add(0, new DominoTile(tile.getRightValue(), tile.getLeftValue()));
                }
            }
        } else {
            if (tiles.isEmpty()) {
                tiles.add(tile);
            } else {
                if (tile.getLeftValue() == tiles.get(tiles.size() - 1).getRightValue()) {
                    tiles.add(tile);
                } else {
                    tiles.add(new DominoTile(tile.getRightValue(), tile.getLeftValue()));
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (DominoTile tile : tiles) {
            sb.append(tile.toString());
        }
        return sb.toString();
    }
}


