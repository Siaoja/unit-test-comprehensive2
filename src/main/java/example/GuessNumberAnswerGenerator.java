package example;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GuessNumberAnswerGenerator implements Generator{
    @Override
    public String generate() {
        Random random = new Random();
        Set<Integer> numbersSet = new HashSet<>();
        StringBuilder guessNumber = new StringBuilder();

        while (numbersSet.size() != 4){
            numbersSet.add(random.nextInt(10));
        }
        for(Integer number : numbersSet){
            guessNumber.append(number);
        }

        return guessNumber.toString();
    }
}
