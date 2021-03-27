package tw.edu.nctu.cs.lxchen.lab4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String choice = String.format("%s, %s, %s", Game.INPUT_ROCK, Game.INPUT_PAPER, Game.INPUT_SCISSORS);

        System.out.println("=== Welcome to Rock-Paper-Scissors game ===");

        System.out.printf("Enter Player 1 choice (%s): ", choice);
        String player1Input = scanner.nextLine();
        Game.checkingInput(player1Input);

        System.out.printf("Enter Player 2 choice (%s): ", choice);
        String player2Input = scanner.nextLine();
        Game.checkingInput(player2Input);

        switch (Game.getResult(player1Input, player2Input)) {
            case DRAW:
                System.out.println("Draw!");
                break;
            case PLAYER_1_WIN:
                System.out.println("Player 1 win!");
                break;
            case PLAYER_2_WIN:
                System.out.println("Player 2 win!");
                break;
        }
    }
}
