package ru.vsu.cs.game;

class DominoTile {
    private int leftValue;
    private int rightValue;

    public DominoTile(int leftValue, int rightValue) {
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    public int getLeftValue() {
        return leftValue;
    }

    public int getRightValue() {
        return rightValue;
    }

    @Override
    public String toString() {
        return "[" + leftValue + "|" + rightValue + "]";
    }
}