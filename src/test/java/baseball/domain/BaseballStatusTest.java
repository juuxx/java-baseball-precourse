package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballStatusTest {

	@Test
	@DisplayName("베이스볼상태_strike")
	void strikeBaseballStatusTest(){
		//given
		int[] computerNumbers = {3, 4, 2};
		int[] userNumbers = {9, 4, 5};

		//when
		BaseballStatus status = new BaseballStatus(computerNumbers, userNumbers);
		int ball = status.getBall();
		int strike = status.getStrike();

		//then
		status.printHint();
		assertThat(ball).isEqualTo(0);
		assertThat(strike).isEqualTo(1);
	}

	@Test
	@DisplayName("베이스볼상태_ball")
	void ballBaseballStatusTest(){
		//given
		int[] computerNumbers = {3, 2, 4};
		int[] userNumbers = {9, 4, 3};

		//when
		BaseballStatus status = new BaseballStatus(computerNumbers, userNumbers);
		int ball = status.getBall();
		int strike = status.getStrike();

		//then
		status.printHint();
		assertThat(ball).isEqualTo(2);
		assertThat(strike).isEqualTo(0);

	}

	@Test
	@DisplayName("베이스볼상태_nothing")
	void nothingBaseballStatusTest(){
		//given
		int[] computerNumbers = {3, 2, 4};
		int[] userNumbers = {9, 7, 8};

		//when
		BaseballStatus status = new BaseballStatus(computerNumbers, userNumbers);
		int ball = status.getBall();
		int strike = status.getStrike();

		//then
		status.printHint();
		assertThat(ball).isEqualTo(0);
		assertThat(strike).isEqualTo(0);

	}

	@Test
	@DisplayName("베이스볼상태_ball&strike")
	void bothBaseballStatusTest(){
		//given
		int[] computerNumbers = {3, 2, 4};
		int[] userNumbers = {9, 2, 3};

		//when
		BaseballStatus status = new BaseballStatus(computerNumbers, userNumbers);
		int ball = status.getBall();
		int strike = status.getStrike();

		//then
		status.printHint();
		assertThat(ball).isEqualTo(1);
		assertThat(strike).isEqualTo(1);

	}

}