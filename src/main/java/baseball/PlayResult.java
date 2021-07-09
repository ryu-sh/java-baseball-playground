package baseball;

public class PlayResult {
    private int strike = 0;
    private int ball = 0;

    public int getStrike() {
        return 0;
    }

    public int getBall() {
        return 0;
    }

    public void report(BallStatus ballStatus) {
        if(ballStatus.isStrike()){
            this.strike++;
        }
        if(ballStatus.isBall()){
            this.ball++;
        }
    }

    public boolean isGameEnd() {
        return this.strike == 3;
    }
}
