package example;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class GuessNumberGame {
    private final int size = 4;
    private String answer;

    public GuessNumberGame(String answer) {
        this.answer = answer;
    }

    public String guess(String guessNumber) {
        StringBuilder guessResult = new StringBuilder();
        int countRightNumberWrongPosition = 0;

        if(answer.equals(guessNumber)){
            guessResult.append("4A0B");
        }else{
            for (int index = 0, len = guessNumber.length(); index < len; index++) {
                if (answer.indexOf(guessNumber.charAt(index)) != -1) {
                    countRightNumberWrongPosition++;
                }
            }
            guessResult.append("0A").append(countRightNumberWrongPosition).append("B");
        }

        return guessResult.toString();
    }
}
