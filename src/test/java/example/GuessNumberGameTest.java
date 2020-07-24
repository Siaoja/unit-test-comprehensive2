package example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessNumberGameTest {
    @Test
    void should_given_answer_1234_guess_5678_when_call_guess_then_return_0A0B() {
        //given
        String answer = "1234";
        String guessNumber = "5678";

        //when
        GuessNumberGame guessNumberGame = new GuessNumberGame(answer);
        String guessResult = guessNumberGame.guess(guessNumber);

        //then
        assertEquals("0A0B",guessResult);
    }
}
