package ru.vsu.cs.game;

import java.util.ArrayList;
import java.util.List;

class DominoPlayer {
    private List<DominoTile> hand;

    public DominoPlayer() {
        hand = new ArrayList<>();
    }

    public void draw(DominoDeck deck, int count) {
        for (int i = 0; i < count; i++) {
            hand.add(deck.draw());
        }
    }

    public List<DominoTile> getHand() {
        return hand;
    }

    public void removeTile(DominoTile tile) {
        hand.remove(tile);
    }

    public boolean hasValidMove(DominoBoard board) {
        for (DominoTile tile : hand) {
            if (board.canPlace(tile)) {
                return true;
            }
        }
        return false;
    }

    public DominoTile makeMove(DominoBoard board) {
        for (DominoTile tile : hand) {
            if (board.canPlace(tile)) {
                hand.remove(tile);
                return tile;
            }
        }
        return null;
    }

    public int calculateScore() {
        int score = 0;
        for (DominoTile tile : hand) {
            score += tile.getLeftValue() + tile.getRightValue();
        }
        return score;
    }
}