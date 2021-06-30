package calculator;

import java.util.Scanner;

public class CalculatorApplication {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        System.out.println(stringCalculator.calculator(value));
    }
}
