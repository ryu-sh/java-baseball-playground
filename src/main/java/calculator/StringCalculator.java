package calculator;


public class StringCalculator {

    public int calculator(String value){
        String[] values = value.split(" ");
        return excute(values);
    }

    public int excute(String[] values){
        int result = Integer.parseInt(values[0]);
        Integer number = null;
        String sign = null;
        for(int index=1; index<values.length; index++){
            if(isEven(index)){
                number = Integer.parseInt(values[index]);
            }
            if(!isEven(index)){
                sign = values[index];
                continue;
            }
            result = calculate(result,number,sign);
        }
        return result;
    }

    public int calculate(int result, int number, String sign) {
        if(sign.equals("+"))
            return add(result,number);
        if(sign.equals("*"))
            return multiply(result,number);
        if(sign.equals("-"))
            return minus(result,number);
        if(sign.equals("/"))
            return divide(result,number);

        throw new IllegalArgumentException();
    }

    private int divide(int result, int number) {
        return result/number;
    }

    private int minus(int result, int number) {
        return result-number;
    }

    private int multiply(int result, int number) {
        return result*number;
    }

    private int add(int result, int number) {
        return result+number;
    }

    private boolean isEven(int index){
        if(index % 2 == 0)
            return true;
        return false;
    }
}
