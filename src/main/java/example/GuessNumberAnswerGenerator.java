package example;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GuessNumberAnswerGenerator implements Generator{

    private static final int ANSWER_LENGTH = 4;
    private static final int SCOPE = 10;

    @Override
    public String generate() {
        Random random = new Random();
        Set<Integer> numbersSet = new HashSet<>();
        StringBuilder guessNumber = new StringBuilder();

        while (numbersSet.size() != ANSWER_LENGTH){
            numbersSet.add(random.nextInt(SCOPE));
        }
        for(Integer number : numbersSet){
            guessNumber.append(number);
        }

        return guessNumber.toString();
    }
}
