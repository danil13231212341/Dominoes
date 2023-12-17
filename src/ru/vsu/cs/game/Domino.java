package ru.vsu.cs.game;
// Класс для представления костяшки
class Domino {
    private int left;
    private int right;

    public Domino(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public boolean canConnect(Domino other) {
        return right == other.getLeft();
    }

    @Override
    public String toString() {
        return "[" + left + "|" + right + "]";
    }
}

