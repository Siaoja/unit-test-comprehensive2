package example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

public class GuessNumberGameTest {

    private Generator mockedAnswerGenerator;
    private GuessNumberGame guessNumberGame;

    @BeforeEach
    void init() {
        mockedAnswerGenerator = Mockito.mock(Generator.class);
        given(mockedAnswerGenerator.generate()).willReturn("1234");
        guessNumberGame = new GuessNumberGame(mockedAnswerGenerator);
    }

    @AfterEach
    void endOption() {
        mockedAnswerGenerator = null;
        guessNumberGame = null;
    }

    @Test
    void should_given_answer_1234_guess_5678_when_call_guess_then_return_0A0B() {
        //given
        String guessNumber = "5678";

        //when
        String guessResult = guessNumberGame.guess(guessNumber);

        //then
        assertEquals("0A0B", guessResult);
    }

    @Test
    void should_given_answer_1234_guess_1234_when_call_guess_then_return_4A0B() {
        //given
        String guessNumber = "1234";

        //when
        String guessResult = guessNumberGame.guess(guessNumber);

        //then
        assertEquals("4A0B", guessResult);
    }

    @Test
    void should_given_answer_1234_guess_4321_when_call_guess_then_return_4A0B() {
        //given
        String guessNumber = "4321";

        //when
        String guessResult = guessNumberGame.guess(guessNumber);

        //then
        assertEquals("0A4B", guessResult);
    }

    @Test
    void should_given_answer_1234_guess_5643_when_guess_then_return_0A2B() {
        //given
        String guessNumber = "5643";

        //when
        String guessResult = guessNumberGame.guess(guessNumber);

        //then
        assertEquals("0A2B", guessResult);

    }

    @Test
    void should_given_answer_1234_guess_1243_when_guess_then_return_2A2B() {
        //given
        String guessNumber = "1243";

        //when
        String guessResult = guessNumberGame.guess(guessNumber);

        //then
        assertEquals("2A2B", guessResult);
    }

    @Test
    void should_given_answer_1234_guess_1245_when_guess_then_return_2A1B() {
        //given
        String guessNumber = "1245";

        //when
        String guessResult = guessNumberGame.guess(guessNumber);

        //then
        assertEquals("2A1B", guessResult);
    }


    @Test
    void should_given_11_when_check_input_then_return_false() {
        //given
        String wrongInput = "11";

        //when
        Boolean checkResult = guessNumberGame.checkInput(wrongInput);

        //then
        assertEquals(false, checkResult);
    }

    @Test
    void should_given_1123_when_check_input_then_return_false() {
        //given
        String wrongInput = "1123";

        //when
        Boolean checkResult = guessNumberGame.checkInput(wrongInput);

        //then
        assertEquals(false, checkResult);
    }

    @Test
    void should_given_1234_when_check_input_then_return_true() {
        //given
        String rightInput = "1234";

        //when
        Boolean checkResult = guessNumberGame.checkInput(rightInput);

        //then
        assertEquals(true, checkResult);
    }

    @Test
    void should_given_guess_numbers_when_call_play_then_return_win_info() {
        //given
        String data = "1 0 2 4\n2 1 0 5\n4 3 2 1\n1 1 2 4\n1 2\n1 2 3 4\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        //when

        String guessResult = guessNumberGame.play();

        //then
        assertEquals("2A1B\n0A2B\n0A4B\nWrong Input，Input again\nWrong Input，Input again\n4A0B\nCongratulations,you win!\n", guessResult);
    }

    @Test
    void should_given_guess_numbers_when_call_play_then_return_lose_info() {
        //given
        String data = "1 0 2 4\n2 1 0 5\n4 3 2 1\n1 1 2 4\n1 2\n5 6 7 8\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        //when
        String guessResult = guessNumberGame.play();

        //then
        assertEquals("2A1B\n0A2B\n0A4B\nWrong Input，Input again\nWrong Input，Input again\n0A0B\nGameOver\n", guessResult);
    }
}
