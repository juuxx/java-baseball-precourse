package baseball.domain;

import static baseball.domain.NumbersGenerator.*;

import java.util.HashSet;
import java.util.Set;

import baseball.util.TextMessage;

public class BaseballStatus {
	private final int[] computerBalls;
	private final int[] userBalls;
	private int strike;
	private int ball;

	public BaseballStatus(int[] computerBalls, int[] userBalls) {
		this.strike = 0;
		this.ball = 0;
		this.computerBalls = computerBalls;
		this.userBalls = userBalls;

		compareNumbers(computerBalls, userBalls);
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

	private void compareNumbers(int[] comp, int[] user) {
		Set<Integer> answerSet = getAnswerSet(comp);
		int strike = 0;
		int hit = 0;
		for (int i = 0; i < user.length; i++) {
			int x = user[i];
			strike += isStrike(x, i, comp) ? 1 : 0;
			hit += isHit(x, answerSet) ? 1 : 0;
		}

		this.strike = strike;
		this.ball = user.length - strike - hit;

	}

	private Set<Integer> getAnswerSet(int[] answer) {
		Set<Integer> answerSet = new HashSet<>();
		for (int i = 0; i < answer.length; i++) {
			answerSet.add(answer[i]);
		}
		return answerSet;
	}

	public Boolean isHit(int x, Set<Integer> answerSet) {
		return !answerSet.contains(x);
	}

	public Boolean isStrike(int x, int pos, int[] answer) {
		return answer[pos] == x;
	}
}