package example;

public class GuessNumberGame {
    private String answer;

    public GuessNumberGame(String answer) {
        this.answer = answer;
    }

    public String guess(String guessNumber) {
        if(answer.equals(guessNumber)){
            return "4A0B";
        }
        return "0A0B";
    }
}
