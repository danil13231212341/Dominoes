package ru.vsu.cs.game;
import java.util.Scanner;

public class DominoGame {
    private DominoDeck deck;
    private DominoBoard board;
    private DominoBot bot1;
    private DominoBot bot2;

    public DominoGame() {
        deck = new DominoDeck();
        board = new DominoBoard();
        bot1 = new DominoBot("Bot1");
        bot2 = new DominoBot("Bot2");
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        while (deck.size() > 0) {
            printGameStatus();

            System.out.println("Press Enter for Bot1's turn");
            scanner.nextLine();
            DominoTile bot1Tile = bot1.play(board, deck);
            if (bot1Tile != null) {
                board.place(bot1Tile, true);
            } else {
                break;
            }

            printGameStatus();

            System.out.println("Press Enter for Bot2's turn");
            scanner.nextLine();
            DominoTile bot2Tile = bot2.play(board, deck);
            if (bot2Tile != null) {
                board.place(bot2Tile, false);
            } else {
                break;
            }
        }

        System.out.println("Game over!");
        System.out.println("Final board: " + board.toString());
    }

    private void printGameStatus() {
        System.out.println("Current board: " + board.toString());
        System.out.println("Remaining tiles in deck: " + deck.size());
    }
}

