package example;

import java.util.HashSet;
import java.util.Scanner;
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

        for (int index = 0, len = guessNumber.length(); index < len; index++) {
            int answerIndex = answer.indexOf(guessNumber.charAt(index));
            if (index == answerIndex) {
                countRightNumberRightPosition++;
            } else if (answerIndex != -1) {
                countRightNumberWrongPosition++;
            }
        }
        guessResult.append(countRightNumberRightPosition).append("A").append(countRightNumberWrongPosition).append("B");


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
                if (number > '9' || number < '0') {
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
        int times = 6;
        StringBuilder gameResult = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        for (int index = 0; (index < times) && scanner.hasNextLine(); index++) {

            String guessNumber = scanner.nextLine().replaceAll(" ", "");

            if (checkInput(guessNumber)) {
                String guessResult = guess(guessNumber);
                if (guessResult.equals(GuessNumberGameConstant.RIGHT_POSITION_RIGHT_NUMBER.getConstantValue())) {
                    gameResult.append(guessResult).append("\nCongratulations,you win!\n");
                    System.out.println(String.format("%s\nCongratulations,you win!", guessResult));
                    break;
                } else {
                    gameResult.append(guessResult).append("\n");
                    System.out.println(String.format("%s", guessResult));
                }
            } else {
                gameResult.append("Wrong Input，Input again\n");
                System.out.println("Wrong Input，Input again");
            }
            if (index == times - 1) {
                gameResult.append("GameOver\n");
                System.out.println("GameOver");
            }
        }
        return gameResult.toString();
    }
}
