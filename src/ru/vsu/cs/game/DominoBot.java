package ru.vsu.cs.game;
class DominoBot {
    private String name;

    public DominoBot(String name) {
        this.name = name;
    }

    public DominoTile play(DominoBoard board, DominoDeck deck) {
        for (int i = 0; i < deck.size(); i++) {
            DominoTile tile = deck.draw();
            if (board.canPlace(tile)) {
                return tile;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
}


