package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BallsTest {

    @Test
    void play(){
        Balls answers = new Balls(Arrays.asList(1,2,3));
        PlayResult result = answers.play(Arrays.asList(4,5,6));
        Assertions.assertThat(result.getStrike()).isEqualTo(0);
        Assertions.assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void play_1strike_1ball(){
        Balls answers = new Balls(Arrays.asList(1,2,3));
        PlayResult result = answers.play(Arrays.asList(1,4,2));
        Assertions.assertThat(result.getStrike()).isEqualTo(1);
        Assertions.assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void play_13trike(){
        Balls answers = new Balls(Arrays.asList(1,2,3));
        PlayResult result = answers.play(Arrays.asList(1,2,3));
        Assertions.assertThat(result.getStrike()).isEqualTo(3);
        Assertions.assertThat(result.isGameEnd()).isTrue();
    }

    @Test
    void strike(){
        Balls answers = new Balls(Arrays.asList(1,2,3));
        BallStatus ballStatus = answers.play(new Ball(1,1));
        Assertions.assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball(){
        Balls answers = new Balls(Arrays.asList(1,2,3));
        BallStatus ballStatus = answers.play(new Ball(1,2));
        Assertions.assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void nothing(){
        Balls answers = new Balls(Arrays.asList(1,2,3));
        BallStatus ballStatus = answers.play(new Ball(1,4));
        Assertions.assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }
}
