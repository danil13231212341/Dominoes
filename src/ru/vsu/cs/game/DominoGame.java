package ru.vsu.cs.game;

class DominoGame {
    private DominoDeck deck;
    private DominoBoard board;
    private DominoPlayer player1;
    private DominoPlayer player2;

    public DominoGame() {
        deck = new DominoDeck();
        board = new DominoBoard();
        player1 = new DominoPlayer();
        player2 = new DominoPlayer();

        player1.draw(deck, 7);
        player2.draw(deck, 7);
    }

    public void play() {
        while (true) {
            // Ход первого игрока
            System.out.println("Игрок 1:");
            System.out.println("Доска: " + board);
            System.out.println("Ваши кости: " + player1.getHand());
            System.out.println("Нажмите Enter для сделать ход");
            waitForEnter();

            if (player1.hasValidMove(board)) {
                DominoTile move = player1.makeMove(board);
                System.out.println("Игрок 1 сыграл " + move);
                board.place(move, true);
                player1.removeTile(move);
            } else if (deck.size() > 0) {
                player1.draw(deck, 1);
                System.out.println("Игрок 1 берет кость из колоды");
            } else {
                break;
            }

            // Ход второго игрока
            System.out.println("Игрок 2:");
            System.out.println("Доска: " + board);
            System.out.println("Ваши кости: " + player2.getHand());
            System.out.println("Нажмите Enter для сделать ход");
            waitForEnter();

            if (player2.hasValidMove(board)) {
                DominoTile move = player2.makeMove(board);
                System.out.println("Игрок 2 сыграл " + move);
                board.place(move, true);
                player2.removeTile(move);
            } else if (deck.size() > 0) {
                player2.draw(deck, 1);
                System.out.println("Игрок 2 берет кость из колоды");
            } else {
                break;
            }
        }

        // Определение победителя
        int score1 = player1.calculateScore();
        int score2 = player2.calculateScore();

        if (player1.getHand().isEmpty()) {
            System.out.println("Игрок 1 победил!");
        } else if (player2.getHand().isEmpty()) {
            System.out.println("Игрок 2 победил!");
        } else if (score1 < score2) {
            System.out.println("Игрок 1 победил по очкам!");
        } else if (score2 < score1) {
            System.out.println("Игрок 2 победил по очкам!");
        } else {
            System.out.println("Ничья!");
        }
    }

    private void waitForEnter() {
        try {System.in.read();} catch(Exception e){}
    }
}

