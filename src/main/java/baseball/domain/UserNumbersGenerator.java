package baseball.domain;

import java.util.HashSet;

import baseball.util.TextMessage;

/**
 * user 입력 숫자
 */
public class UserNumbersGenerator implements NumbersGenerator{

	private final int[] ballNumbers;

	public UserNumbersGenerator() {
		ballNumbers = new int[BALL_COUNT];
		generateNumbers();
	}

	public int[] getBallNumbers() {
		return ballNumbers;
	}

	@Override
	public void generateNumbers() {
		toArray(getUserInputNumber());
	}

	/**
	 * user가 입력한 유효한 숫자를 가져온다.
	 * @return
	 */
	private String getUserInputNumber() {
		String userInput;
		boolean isBreak;
		do {
			userInput = TextMessage.inputNumByUser();
			isBreak = checkValidate(userInput);
		}while (!isBreak);
		return userInput;
	}


	/**
	 * String to array
	 * @param userInput
	 */
	private void toArray(String userInput) {
		String[] array = userInput.split("");
		for (int i = 0; i < array.length; i++) {
			this.ballNumbers[i] = Integer.parseInt(array[i]);
		}
	}

	/**
	 * user 입력 값 유효성 체크
	 * @param userInput
	 * @return
	 */
	private boolean checkValidate(String userInput){
		if (!checkLength(userInput) || !checkDigit(userInput) || !checkRange(userInput)
			||!checkDupl(userInput)) {
			TextMessage.printError();
			return false;
		}
		return true;
	}


	/**
	 * 길이 체크
	 * @param userInput
	 * @return
	 */
	private boolean checkLength(String userInput) {
		return userInput.length() == BALL_COUNT;
	}

	/**
	 * 숫자인지 체크
	 * @param userInput
	 * @return
	 */
	private boolean checkDigit(String userInput) {
		boolean isValid = true;
		for(int i = 0 ; i < userInput.length() ; i++) {
			char tmp = userInput.charAt(i);
			isValid = Character.isDigit(tmp);
		}
		return isValid;
	}

	/**
	 * 입력한 숫자에 0 불가능
	 * @param userInput
	 * @return
	 */
	private boolean checkRange(String userInput) {

		String[] arrays = userInput.split("");
		for (String str : arrays) {
			if (checkBetweenNum(str)) return false;
		}
		return true;
	}

	private boolean checkBetweenNum(String str) {
		int num = Integer.parseInt(str);
		return num < RANDOM_MIN_NUM || num > RANDOM_MAX_NUM;
	}

	/**
	 * 중복체크
	 * @param userInput
	 * @return
	 */
	private boolean checkDupl(String userInput) {
		HashSet<Integer> tmp = new HashSet<>();
		for(int i = 0 ; i < userInput.length() ; i++) {
			tmp.add(Character.getNumericValue(userInput.charAt(i)));
		}
		return tmp.size() == BALL_COUNT;
	}


}