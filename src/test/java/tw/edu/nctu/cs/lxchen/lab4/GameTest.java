package tw.edu.nctu.cs.lxchen.lab4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private static Stream<Arguments> getCases() {
        return Stream.of(
                // all win case for player 1
                // a.k.a all lose case for player 2
                Arguments.of(Game.INPUT_PAPER, Game.INPUT_ROCK, Game.GameResult.PLAYER_1_WIN),
                Arguments.of(Game.INPUT_SCISSORS, Game.INPUT_PAPER, Game.GameResult.PLAYER_1_WIN),
                Arguments.of(Game.INPUT_ROCK, Game.INPUT_SCISSORS, Game.GameResult.PLAYER_1_WIN),

                // all win case for player 2
                // a.k.a all lose case for player 1
                Arguments.of(Game.INPUT_ROCK, Game.INPUT_PAPER, Game.GameResult.PLAYER_2_WIN),
                Arguments.of(Game.INPUT_PAPER, Game.INPUT_SCISSORS, Game.GameResult.PLAYER_2_WIN),
                Arguments.of(Game.INPUT_SCISSORS, Game.INPUT_ROCK, Game.GameResult.PLAYER_2_WIN),

                // all draw cases
                Arguments.of(Game.INPUT_PAPER, Game.INPUT_PAPER, Game.GameResult.DRAW),
                Arguments.of(Game.INPUT_SCISSORS, Game.INPUT_SCISSORS, Game.GameResult.DRAW),
                Arguments.of(Game.INPUT_ROCK, Game.INPUT_ROCK, Game.GameResult.DRAW)
        );
    }

    /**
     * Test the return value of Game.getResult()
     * This method is used to fulfill requirement (a) (b) (c) of part 2.
     * */
    @ParameterizedTest
    @MethodSource("getCases")
    void testGetResult(String player1Input, String player2Input, Game.GameResult expected) {
        assertEquals(expected, Game.getResult(player1Input, player2Input));
    }

    /**
     * Check if Game.result() throws correct exception when receiving invalid value.
     * This method is used to fulfill requirement of (d) part 2.
     * */
    @Test
    void testGetResultException() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
            Game.getResult("ABC", "DEF");
        });
        assertEquals("Invalid input value!", exception.getMessage());
    }

    /**
     * Check if Game.checkingInput() throws correct exception when receiving invalid value.
     * This method is used to fulfill requirement of (d) part 2.
     * */
    @Test
    void testCheckingInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
            Game.checkingInput("ABC");
        });
        assertEquals("Invalid input value!", exception.getMessage());
    }
}