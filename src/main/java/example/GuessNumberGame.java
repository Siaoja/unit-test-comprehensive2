package example;

public class GuessNumberGame {
    private final int size = 4;
    private String answer;

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
        return null;
    }
}
