package baseball.controller;

import baseball.domain.BaseballStatus;
import baseball.domain.ComputerNumbersGenerator;
import baseball.domain.UserNumbersGenerator;
import nextstep.utils.Console;

public class GameController {

	public void playGame(){
		do {
			ComputerNumbersGenerator comNumbers = new ComputerNumbersGenerator();
			tryAnswer(comNumbers.getBallNumbers());

		} while (isContinue());
	}

	public void tryAnswer(int[] comNumbers){
		boolean isOver;
		do {
			UserNumbersGenerator userNumbers = new UserNumbersGenerator();
			BaseballStatus status = new BaseballStatus(comNumbers, userNumbers.getBallNumbers());
			status.printHint();
			isOver = status.isOver();
		} while (!isOver);
	}

	private boolean isContinue(){
		return choiceOption() == 1;
	}

	private int choiceOption(){
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String userInput = Console.readLine();
		if (checkValidation(userInput)){
			return choiceOption();
		}
		return  Integer.parseInt(userInput);
	}

	private boolean checkValidation(String userInput) {
		return userInput.length() != 1 || !checkNum(userInput);
	}

	private boolean checkNum(String userInput) {
		int num = Integer.parseInt(userInput);
		return num == 1 || num == 2;
	}

}
