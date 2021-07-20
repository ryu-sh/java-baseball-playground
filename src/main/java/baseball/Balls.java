package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Integer> answers) {
        this.balls = mapBall(answers);
    }

    //인스턴스 변수에 의존하지 않으면 static으로 만들어도 상관없다.
    private static List<Ball> mapBall(List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for(int i = 0; i< answers.size(); i++){
            balls.add(new Ball(i+1, answers.get(i)));
        }
        return balls;
    }

    public PlayResult play(List<Integer> inputBalls) {
        Balls userBalls = new Balls(inputBalls);
        PlayResult playResult = new PlayResult();
        for (Ball ball : balls) {
            BallStatus ballStatus = userBalls.play(ball);
            playResult.report(ballStatus);
        }
        return playResult;
    }

    public BallStatus play(Ball userBall) {
       return balls.stream().map(answer -> answer.play(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
