package ru.vsu.cs.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Deck {
    private List<Domino> dominos;

    public Deck() {
        dominos = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                dominos.add(new Domino(i, j));
            }
        }
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < dominos.size() - 1; i++) {
            int j = random.nextInt(dominos.size() - i) + i;
            Domino temp = dominos.get(i);
            dominos.set(i, dominos.get(j));
            dominos.set(j, temp);
        }
    }

    public Domino draw() {
        if (dominos.isEmpty()) {
            return null;
        }
        return dominos.remove(0);
    }

    public int size() {
        return dominos.size();
    }
}