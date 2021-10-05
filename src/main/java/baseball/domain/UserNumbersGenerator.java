package baseball.domain;

import java.util.HashSet;

import nextstep.utils.Console;

/**
 * user 입력 숫자
 */
public class UserNumbersGenerator implements NumbersGenerator{

	private int[] ballNumbers;

	public UserNumbersGenerator() {
		ballNumbers = new int[3];
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
			userInput = inputNumByUser();
			isBreak = checkValidate(userInput);
		}while (!isBreak);
		return userInput;
	}

	/**
	 * user input
	 * @return
	 */
	private String inputNumByUser(){
		System.out.print("숫자를 입력해주세요 : ");
		return Console.readLine();
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
			System.out.println("[ERROR] 잘못 입력하셨습니다. 다시 입력해주세요.");
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
		return userInput.length() == NumbersGenerator.BALL_COUNT;
	}

	/**
	 * 숫자인지 체크
	 * @param userInput
	 * @return
	 */
	private boolean checkDigit(String userInput) {
		boolean isVaild = true;
		for(int i = 0 ; i < userInput.length() ; i++) {
			char tmp = userInput.charAt(i);
			isVaild = Character.isDigit(tmp);
		}
		return isVaild;
	}

	/**
	 * 입력한 숫자에 0 불가능
	 * @param userInput
	 * @return
	 */
	private boolean checkRange(String userInput) {
		return !userInput.contains("0");
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
		return tmp.size() == NumbersGenerator.BALL_COUNT;
	}


}
