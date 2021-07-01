package baseball;

import java.util.Random;

public class NumberBaseball {
    final String computerNumber = createNumberString();

    public String play(String myNumberString) {
        isNumber(myNumberString);
        return getResult(computerNumber,myNumberString);
    }

    public String createNumberString(){
        int numberString = createNumber();
        while(!isCorrect(numberString)){
            numberString = createNumber();
        }
        System.out.println("정답 : "+numberString);
        return Integer.toString(numberString);
    }

    private int createNumber() {
        Random random = new Random();
        int first = (random.nextInt(10 - 1) + 1) * 100;
        int middle = (random.nextInt(10 - 1) + 1) * 10;
        int last = random.nextInt(10 - 1) + 1;

        return first + middle + last;
    }

    public boolean isCorrect(int input) {
        String inputStr = Integer.toString(input);
        if(inputStr.charAt(0) == inputStr.charAt(1))
            return false;
        if(inputStr.charAt(1) == inputStr.charAt(2))
            return false;
        if(inputStr.charAt(0) == inputStr.charAt(2))
            return false;
        return true;
    }

    public boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        return true;
    }

    public String getResult(String computerNumberString, String myNumberString) {
        int strike = 0;
        int ball = 0;

        for(int i=0; i<computerNumberString.length(); i++){

            int isStrike = strikeCheck(computerNumberString.charAt(i) + "", myNumberString.charAt(i) + "");
            strike += isStrike;
            int isBall = ballCheck(computerNumberString, myNumberString.charAt(i) + "");
            ball += ballCount(isStrike,isBall);
        }
        return makeResultString(strike, ball);
    }

    private int ballCount(int isStrike, int isBall) {
        if(isStrike != 0)
            return 0;
        return isBall;
    }

    private String makeResultString(int strike, int ball) {
        String strikeStr = "";
        String ballStr = "";
        if(strike != 0)
            strikeStr = strike + "스트라이크";
        if(ball != 0)
            ballStr = ball + "볼 ";
        if(strike == 0 && ball == 0)
            return "낫싱";
        if(strikeStr.equals(""))
            return ballStr.trim();

        return ballStr + strikeStr;
    }

    private int ballCheck(String computerNumberString, String myNumberStringChar) {
        if(computerNumberString.contains(myNumberStringChar))
            return 1;
        return 0;
    }

    private int strikeCheck(String computerNumberStringChar, String myNumberStringChar) {
        if(computerNumberStringChar.equals(myNumberStringChar))
            return 1;
        return 0;
    }
}
