package ru.vsu.cs.game;

// Класс для представления костей домино
class DominoTile {
    private final int left;
    private final int right;

    public DominoTile(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "[" + left + "|" + right + "]";
    }
}
