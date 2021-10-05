package baseball.domain;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

import nextstep.utils.Randoms;

/**
 * computer 생성 숫자
 */
public class ComputerNumbersGenerator implements NumbersGenerator{

	private int[] ballNumbers;

	public ComputerNumbersGenerator() {
		this.ballNumbers = new int[3];
		generateNumbers();
		System.out.println(Arrays.toString(ballNumbers));
	}

	public int[] getBallNumbers() {
		return ballNumbers;
	}

	/**
	 * 1~9 까지 중복없이 3가지 숫자 생성
	 */
	@Override
	public void generateNumbers() {
		LinkedHashSet<Integer> set = new LinkedHashSet<>();
		while (set.size() != NumbersGenerator.BALL_COUNT){
			int num = Randoms.pickNumberInRange(1, 9);
			set.add(num);
		}

		toArray(set);
	}

	/**
	 * 생성된 set, array로 변경
	 * @param set
	 */
	private void toArray(LinkedHashSet<Integer> set){
		Iterator<Integer> iter = set.iterator();
		int i = 0;
		while (iter.hasNext()) {
			this.ballNumbers[i] = iter.next();
			i++;
		}
	}


}
