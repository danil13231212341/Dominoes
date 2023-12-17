package ru.vsu.cs.game;

import java.util.ArrayList;
import java.util.List;

// Класс для представления бота
class Bot {
    private List<Domino> hand;

    public Bot() {
        hand = new ArrayList<>();
    }

    public List<Domino> getHand() {
        return hand;
    }

    public void drawDomino(Deck deck, int count) {
        for (int i = 0; i < count; i++) {
            Domino domino = deck.draw();
            if (domino != null) {
                hand.add(domino);
            }
        }
    }

    public boolean playDomino(Board board) {
        for (Domino domino : hand) {
            if (board.add(domino)) {
                hand.remove(domino);
                return true;
            }
        }
        return false;
    }

    public void displayHand() {
        System.out.println("Bot's hand:");
        for (Domino domino : hand) {
            System.out.print(domino);
        }
        System.out.println();
    }
}

