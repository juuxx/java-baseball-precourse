package baseball.domain;

import java.util.Arrays;

import nextstep.utils.Console;

public class UserNumbersGenerator implements NumbersGenerator{

	private int[] ballNumbers;

	public UserNumbersGenerator() {
		ballNumbers = new int[3];
		generateNumbers();
	}

	@Override
	public void generateNumbers() {
		boolean isBreak = false;
		String userInput = "";
		do {
			System.out.print("숫자를 입력해주세요 : ");
			userInput = Console.readLine();
			isBreak = checkValidate(userInput);
		}while (!isBreak);

		toArray(userInput);
	}

	private void toArray(String userInput) {
		String[] array = userInput.split("");
		for (int i = 0; i < array.length; i++) {
			this.ballNumbers[i] = Integer.parseInt(array[i]);
		}
	}

	private boolean checkValidate(String userInput){
		if (!checkLength(userInput) || !checkDigit(userInput) || !checkRange(userInput)) {
			System.out.println("[ERROR] 잘못 입력하셨습니다. 다시 입력해주세요.");
			return false;
		}
		return true;
	}

	private boolean checkLength(String userInput) {
		boolean isVaild = true;
		if(userInput.length() != 3){
			isVaild = false;
		}
		return isVaild;
	}

	private boolean checkDigit(String userInput) {
		boolean isVaild = true;
		for(int i = 0 ; i < userInput.length() ; i++) {
			char tmp = userInput.charAt(i);
			isVaild = Character.isDigit(tmp);
		}
		return isVaild;
	}

	private boolean checkRange(String userInput) {
		boolean isVaild = true;
		if (userInput.contains("0")){
			isVaild = false;
		}
		return isVaild;
	}

	@Override
	public String toString() {
		return "UserNumbersGenerator{" +
			"ballNumbers=" + Arrays.toString(ballNumbers) +
			'}';
	}

	public int[] getBallNumbers() {
		return ballNumbers;
	}
}
