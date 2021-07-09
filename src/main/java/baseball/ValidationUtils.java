package baseball;

public class ValidationUtils {

    public static final int MAX_NO = 9;
    public static final int MIN_NO = 0;

    public static boolean vaildNo(int number) {
        return number<= MAX_NO && number>MIN_NO ;
    }
}
