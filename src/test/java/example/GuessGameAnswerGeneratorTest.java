package example;

import org.junit.jupiter.api.Test;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        for(int index = 0, len = answer.length(); index < len; index++){
            char number = answer.charAt(index);
            answerSet.add(number);
            assertTrue(number<= '9');
            assertTrue(number>='0');
        }
        assertTrue(answerSet.size() == 4);
    }
}
