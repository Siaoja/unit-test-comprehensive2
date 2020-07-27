package example;

public enum GuessNumberGameConstant {
    RIGHT_POSITION_RIGHT_NUMBER("4A0B"),
    WIN_INFO("Congratulations,you win!");
    String constantValue;
    GuessNumberGameConstant(String constantValue){
        this.constantValue = constantValue;
    }
}
