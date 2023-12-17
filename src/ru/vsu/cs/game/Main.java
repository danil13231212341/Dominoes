package ru.vsu.cs.game;

import java.util.Random;
import java.util.Scanner;

import static ru.vsu.cs.game.KozeiDominoGame.playGame;

public class Main {


    public static void main(String[] args) {
        Bot bot1 = new Bot();
        Bot bot2 = new Bot();
        Board board = new Board();
        Deck deck = new Deck();

        deck.shuffle();

        playGame(bot1, bot2, board, deck);
    }
}
