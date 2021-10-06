package baseball.domain;

import static baseball.domain.NumbersGenerator.*;

import baseball.util.TextMessage;

public class BaseballStatus {
	private int[] computerBalls;
	private int[] userBalls;
	private int strike;
	private int ball;

	public BaseballStatus(int[] computerBalls, int[] userBalls) {
		this.strike = 0;
		this.ball = 0;
		this.computerBalls = computerBalls;
		this.userBalls = userBalls;

		compareThreeNumber();
	}


	/**
	 * 게임 종료
	 * @return
	 */
	public boolean isOver(){
		if (strike == BALL_COUNT){
			TextMessage.printGameOver();
			return true;
		}
		return false;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	/**
	 * computer 숫자와 user 숫자 비교
	 */
	private void compareThreeNumber(){
		int strike = 0;
		int ball = 0;
		for (int i = 0; i < computerBalls.length; i++) {
			 strike += findStrike(computerBalls[i], i, userBalls);
			 ball += findBall(computerBalls[i], i, userBalls);
		}
		this.strike = strike;
		this.ball = ball;
	}

	private int findStrike(int comValue, int comIndex, int[] userBalls){
		int count = 0;
		for(int i = 0; i < BALL_COUNT; i++){
			count += countStrike(comValue, comIndex, userBalls[i], i);
		}
		return count;
	}

	private int findBall(int comValue, int comIndex, int[] userBalls){
		int count = 0;
		for (int i = 0; i < BALL_COUNT; i++) {
			count += countBall(comValue, comIndex, userBalls[i], i);
		}
		return count;
	}

	private int countStrike(int comValue, int comIndex, int userValue, int userIndex){
		return comValue == userValue && comIndex == userIndex ? 1 : 0;
	}

	private int countBall(int comValue, int comIndex, int userValue, int userIndex){
		return comValue == userValue && comIndex != userIndex ? 1 : 0;
	}

}
