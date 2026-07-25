package ui;

import java.util.Scanner;

import service.GameService;

public class ConsoleUI {

    public ConsoleUI(GameService game) {
        game.startGame();
        game.getBoard();

        Scanner scanner = new Scanner(System.in);

        //System.out.println();
        int move = 0;
        while (move < 5) {
            System.out.println("Faça uma jogada: digite uma linha e coluna em seguida o valor");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            Integer value = scanner.nextInt();

            game.makeMove(row, col, value);
            game.getBoard();            
            move++;
        }

        scanner.close();
    }
}
