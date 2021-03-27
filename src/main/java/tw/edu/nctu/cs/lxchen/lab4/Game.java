package tw.edu.nctu.cs.lxchen.lab4;

public class Game {

    static final String INPUT_PAPER = "paper";
    static final String INPUT_ROCK = "rock";
    static final String INPUT_SCISSORS = "scissors";

    enum GameResult {
        PLAYER_1_WIN,
        PLAYER_2_WIN,
        DRAW
    }

    public static GameResult getResult(String player1Input, String player2Input) {
        checkingInput(player1Input);
        checkingInput(player2Input);

        if (player1Input.equals(INPUT_PAPER)) {
            // Note: switch case for String only works in Java version SE 7 and above.
            switch (player2Input) {
                case INPUT_PAPER:
                    return GameResult.DRAW;
                case INPUT_ROCK:
                    return GameResult.PLAYER_1_WIN;
                case INPUT_SCISSORS:
                    return GameResult.PLAYER_2_WIN;
            }
        } else if (player1Input.equals(INPUT_ROCK)) {
            switch (player2Input) {
                case INPUT_PAPER:
                    return GameResult.PLAYER_2_WIN;
                case INPUT_ROCK:
                    return GameResult.DRAW;
                case INPUT_SCISSORS:
                    return GameResult.PLAYER_1_WIN;
            }
        } else if (player1Input.equals(INPUT_SCISSORS)) {
            switch (player2Input) {
                case INPUT_PAPER:
                    return GameResult.PLAYER_1_WIN;
                case INPUT_ROCK:
                    return GameResult.PLAYER_2_WIN;
                case INPUT_SCISSORS:
                    return GameResult.DRAW;
            }
        }
        throw new IllegalArgumentException("Invalid input value!");
    }

    public static void checkingInput(String input) {
        if (!input.equals(INPUT_PAPER) && !input.equals(INPUT_ROCK) && !input.equals(INPUT_SCISSORS)) {
            throw new IllegalArgumentException("Invalid input value!");
        }
    }
}
