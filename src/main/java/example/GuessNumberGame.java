package example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GuessNumberGame {
    private final String answer;

    public GuessNumberGame(Generator generator) {
        this.answer = generator.generate();
    }

    public String guess(String guessNumber) {
        StringBuilder guessResult = new StringBuilder();
        int countRightNumberWrongPosition = 0;
        int countRightNumberRightPosition = 0;

        if (answer.equals(guessNumber)) {
            guessResult.append("4A0B");
        } else {
            for (int index = 0, len = guessNumber.length(); index < len; index++) {
                if (index == answer.indexOf(guessNumber.charAt(index))) {
                    countRightNumberRightPosition++;
                } else if (answer.indexOf(guessNumber.charAt(index)) != -1) {
                    countRightNumberWrongPosition++;
                }
            }
            guessResult.append(countRightNumberRightPosition).append("A").append(countRightNumberWrongPosition).append("B");
        }

        return guessResult.toString();
    }

    public Boolean checkInput(String wrongInput) {
        boolean checkResult = true;
        int size = 4;
        if (wrongInput == null || wrongInput.length() != size) {
            checkResult = false;
        } else {
            Set<Character> answerSet = new HashSet<>();
            for (int index = 0, len = wrongInput.length(); index < len; index++) {
                char number = wrongInput.charAt(index);
                answerSet.add(number);
                if (number >= '9' || number <= '0') {
                    checkResult = false;
                    break;
                }
            }
            if (checkResult && answerSet.size() != size) {
                checkResult = false;
            }
        }

        return checkResult;
    }


    public String play() {
        return null;
    }
}
