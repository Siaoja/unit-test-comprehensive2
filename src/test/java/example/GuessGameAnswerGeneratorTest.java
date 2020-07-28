package example;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class GuessGameAnswerGeneratorTest {
    @Test
    void should_given_none_when_generate_then_return_right_answer() {
        //given

        //when
        Generator answerGenerator = new GuessNumberAnswerGenerator();
        String answer = answerGenerator.generate();

        //then
        Set<Character> answerSet = new HashSet<>();
        assertNotNull(answer);
        for (int index = 0, length = answer.length(); index < length; index++) {
            char number = answer.charAt(index);
            answerSet.add(number);
            assertTrue(number <= '9');
            assertTrue(number >= '0');
        }
        assertEquals(4, answerSet.size());
    }
}
