package baseball;

public class BallNumber {
    public static final int MAX_NO = 9;
    public static final int MIN_NO = 0;

    private int no;


    //생성자를 통해 생성되면 유효한 값을 가진 객체라는게 보장됨.
    public BallNumber(int no) {
        if(no < MIN_NO || no > MAX_NO){
            throw new IllegalArgumentException("볼 숫자는 1~9 값이어야 한다.");
        }
        this.no = no;
    }
}
