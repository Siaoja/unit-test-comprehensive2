package example;

public enum GuessNumberGameConstant {
    RIGHT_POSITION_RIGHT_NUMBER("4A0B");
    String constantValue;
    GuessNumberGameConstant(String constantValue){
        this.constantValue = constantValue;
    }
    public String getConstantValue(){
        return constantValue;
    }
}