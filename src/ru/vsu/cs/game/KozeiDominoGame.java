package ru.vsu.cs.game;

import java.util.Scanner;

public class KozeiDominoGame {
    private static final int INITIAL_DRAW = 7;

    static void playGame(Bot bot1, Bot bot2, Board board, Deck deck) {
        bot1.drawDomino(deck, INITIAL_DRAW);
        bot2.drawDomino(deck, INITIAL_DRAW);

        boolean botTurn = true;
        while (true) {
            if (botTurn) {
                System.out.println("Bot 1's turn (press Enter to continue):");
                waitForEnter();

                if (bot1.playDomino(board)) {
                    bot1.displayHand();
                    board.display();
                } else {
                    System.out.println("Bot 1 cannot play. Drawing a domino.");
                    waitForEnter();
                    Domino domino = deck.draw();
                    bot1.getHand().add(domino);
                    board.add(domino);
                    bot1.displayHand();
                    board.display();
                }

                if (bot1.getHand().size() == 0) {
                    System.out.println("Bot 1 wins!");
                    break;
                }
            } else {
                System.out.println("Bot 2's turn (press Enter to continue):");
                waitForEnter();

                if (bot2.playDomino(board)) {
                    bot2.displayHand();
                    board.display();
                } else {
                    System.out.println("Bot 2 cannot play. Drawing a domino.");
                    waitForEnter();
                    Domino domino = deck.draw();
                    bot2.getHand().add(domino);
                    board.add(domino);
                    bot2.displayHand();
                    board.display();
                }

                if (bot2.getHand().size() == 0) {
                    System.out.println("Bot 2 wins!");
                    break;
                }
            }

            botTurn = !botTurn;
        }
    }

    private static void waitForEnter() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}

