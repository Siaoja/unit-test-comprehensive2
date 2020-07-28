package example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GuessNumberGame {
    private static final String NULL_STRING = "";
    private static final String SPACE_STRING = " ";
    private static final String ENTER_STRING = "\n";
    private final String answer;
    private final int numbersSize = 4;

    public GuessNumberGame(Generator generator) {
        this.answer = generator.generate();
    }

    public String guess(String guessNumber) {

        final String ALL_RIGHT_SUFFIX = "A";
        final String NUMBER_RIGHT_SUFFIX = "B";
        StringBuilder guessResult = new StringBuilder();
        int countRightNumberWrongPosition = 0;
        int countRightNumberRightPosition = 0;

        for (int index = 0, len = guessNumber.length(); index < len; index++) {
            int answerIndex = answer.indexOf(guessNumber.charAt(index));
            if (index == answerIndex) {
                countRightNumberRightPosition++;
            } else if (answerIndex != -1) {
                countRightNumberWrongPosition++;
            }
        }

        guessResult.append(countRightNumberRightPosition).append(ALL_RIGHT_SUFFIX).append(countRightNumberWrongPosition).append(NUMBER_RIGHT_SUFFIX);


        return guessResult.toString();
    }

    public Boolean checkInput(String numbers) {
        boolean checkResult = true;

        if (isNumbersNull(numbers)) {
            checkResult = false;
        } else {
            Set<Character> answerSet = new HashSet<>();
            for (int index = 0, len = numbers.length(); index < len; index++) {
                char number = numbers.charAt(index);
                answerSet.add(number);
                if (judgeNumberScope(number)) {
                    checkResult = false;
                    break;
                }
            }
            if (checkResult && answerSet.size() != numbersSize) {
                checkResult = false;
            }
        }

        return checkResult;
    }

    public String play() {
        int times = 6;
        StringBuilder gameResult = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        for (int index = 0; (index < times) && scanner.hasNextLine(); index++) {

            String guessNumber = scanner.nextLine().replaceAll(SPACE_STRING, NULL_STRING);

            if (checkInput(guessNumber)) {
                String guessResult = guess(guessNumber);
                if (guessResult.equals(GuessNumberGameConstant.RIGHT_POSITION_RIGHT_NUMBER.constantValue)) {
                    gameResult.append(guessResult).append(ENTER_STRING).append(GuessNumberGameConstant.WIN_INFO.constantValue);
                    break;
                } else {
                    gameResult.append(guessResult).append(ENTER_STRING);
                }
            } else {
                gameResult.append(GuessNumberGameConstant.WRONG_INPUT.constantValue).append(ENTER_STRING);
            }
            if (index == times - 1) {
                gameResult.append(GuessNumberGameConstant.LOSE_INFO.constantValue);
            }
        }
        return gameResult.toString();
    }


    private boolean isNotNumberScope(char number) {
        char numberNine = '9';
        char numberZero = '0';
        return number > numberNine || number < numberZero;
    }

    private boolean isNumbersNull(String numbers) {
        return numbers == null || numbers.length() != numbersSize;
    }
}
