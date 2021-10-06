package baseball.controller;

import baseball.domain.BaseballStatus;
import baseball.domain.ComputerNumbersGenerator;
import baseball.domain.UserNumbersGenerator;
import baseball.util.TextMessage;

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
			TextMessage.printHint(status);
			isOver = status.isOver();
		} while (!isOver);
	}

	private boolean isContinue(){
		return choiceOption() == 1;
	}

	private int choiceOption(){
		String userInput = TextMessage.isRestart();
		if (TextMessage.checkValidation(userInput)){
			return choiceOption();
		}
		return  Integer.parseInt(userInput);
	}

}
