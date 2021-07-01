package calculator;

import java.util.Scanner;

public class StringCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("계산할 값 입력 : ");
        String value = scanner.nextLine();

        String[] values = value.split(" ");
        int first = Integer.parseInt(values[0]);
        int result = first;
        for(int i=1; i< values.length; i+=2){
            String symbol = values[i];
            int second = Integer.parseInt(values[i+1]);
            result = calculate(first,second,symbol);
            i = i+2;
        }
        System.out.println("결과 : " + result);
    }

    public static int calculate(int result, int number, String sign) {
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

    private static int divide(int result, int number) {
        return result/number;
    }

    private static int minus(int result, int number) {
        return result-number;
    }

    private static int multiply(int result, int number) {
        return result*number;
    }

    private static int add(int result, int number) {
        return result+number;
    }

    public String[] split(String s) {
        if(s == null){
            return new String[]{};
        }
        return s.split(",|\n");
    }

    public int[] toInt(String[] strings) {
        if(strings == null){
            return new int[]{};
        }
        int[] numbers = new int[strings.length];
        for(int i=0; i< strings.length; i++){
            numbers[i] = Integer.parseInt(strings[i]);
        }
        return numbers;
    }
}
