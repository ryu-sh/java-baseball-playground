package baseball;

import java.util.Scanner;

public class NumberBaseballApplication {
    public static void main(String[] args) {
        int isEnd = 1;
        while(isEnd == 1){
            isEnd = playTheGame();
        }
    }

    public static int playTheGame(){
        NumberBaseball numberBaseball = new NumberBaseball();
        String result = "";
        Scanner scanner = new Scanner(System.in);
        while(!result.equals("3스트라이크")){
            System.out.println("숫자를 입력해 주세요 :");
            String mynumberString = scanner.next();
            result = numberBaseball.play(mynumberString);
            System.out.println(result);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int signal = scanner.nextInt();
        return signal;
    }
}
