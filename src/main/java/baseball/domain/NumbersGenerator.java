package baseball.domain;

public interface NumbersGenerator {
	public static final int BALL_COUNT = 3;
	public static final int RANDOM_MIN_NUM = 1;
	public static final int RANDOM_MAX_NUM = 9;
	public void generateNumbers();
}
