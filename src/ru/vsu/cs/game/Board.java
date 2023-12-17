package ru.vsu.cs.game;

import java.util.ArrayList;
import java.util.List;

class Board {
    private List<Domino> chain;

    public Board() {
        chain = new ArrayList<>();
    }

    public boolean add(Domino domino) {
        if (chain.isEmpty()) {
            chain.add(domino);
            return true;
        } else {
            Domino first = chain.get(0);
            if (domino.canConnect(first)) {
                chain.add(0, domino);
                return true;
            }
            Domino last = chain.get(chain.size() - 1);
            if (last.canConnect(domino)) {
                chain.add(domino);
                return true;
            }
        }
        return false;
    }

    public void display() {
        for (Domino domino : chain) {
            System.out.print(domino);
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return chain.isEmpty();
    }

    public int size() {
        return chain.size();
    }
}