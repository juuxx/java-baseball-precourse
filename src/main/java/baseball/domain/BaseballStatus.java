package baseball.domain;

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
	 * 결과 print
	 */
	public void printHint(){
		String printStr = "";

		printStr += printStrike();
		printStr += printBall();
		printStr += printNothing();

		System.out.println(printStr);
	}

	/**
	 * 게임 종료
	 * @return
	 */
	public boolean isOver(){
		if (strike == NumbersGenerator.BALL_COUNT){
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
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
		for(int i = 0; i < NumbersGenerator.BALL_COUNT; i++){
			count += countStrike(comValue, comIndex, userBalls[i], i);
		}
		return count;
	}

	private int findBall(int comValue, int comIndex, int[] userBalls){
		int count = 0;
		for (int i = 0; i < NumbersGenerator.BALL_COUNT; i++) {
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

	private String printStrike(){
		return strike > 0 ? strike + "스트라이크 " : "";
	}

	private String printBall(){
		return ball > 0 ? ball + "볼" : "";
	}

	private String printNothing(){
		return ball == 0 && strike == 0 ? "낫싱" : "";
	}

}
