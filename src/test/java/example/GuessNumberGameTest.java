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

    @Test
    void should_given_answer_1234_guess_1234_when_call_guess_then_return_4A0B() {
        //given
        String answer = "1234";
        String guessNumber = "1234";

        //when
        GuessNumberGame guessNumberGame = new GuessNumberGame(answer);
        String guessResult = guessNumberGame.guess(guessNumber);

        //then
        assertEquals("4A0B",guessResult);
    }

    @Test
    void should_given_answer_1234_guess_4321_when_call_guess_then_return_4A0B() {
        //given
        String answer = "1234";
        String guessNumber = "4321";

        //when
        GuessNumberGame guessNumberGame = new GuessNumberGame(answer);
        String guessResult = guessNumberGame.guess(guessNumber);

        //then
        assertEquals("0A4B",guessResult);
    }

    @Test
    void should_given_answer_1234_guess_5643_when_guess_then_return_0A2B() {
        //given
        String answer = "1234";
        String guessNumber = "5643";

        //when
        GuessNumberGame guessNumberGame = new GuessNumberGame(answer);
        String guessResult = guessNumberGame.guess(guessNumber);

        //then
        assertEquals("0A2B",guessResult);

    }

    @Test
    void should_given_answer_1234_guess_1243_when_guess_then_return_2A2B() {
        //given
        String answer = "1234";
        String guessNumber = "1243";

        //when
        GuessNumberGame guessNumberGame = new GuessNumberGame(answer);
        String guessResult = guessNumberGame.guess(guessNumber);

        //then
        assertEquals("2A2B",guessResult);

    }
    
}
