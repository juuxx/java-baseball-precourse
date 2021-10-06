package baseball.util;

import java.util.HashMap;
import java.util.Map;

import baseball.domain.BaseballStatus;
import nextstep.utils.Console;

public class TextMessage {
	public static final String MSG_STRIKE = "%s스트라이크";
	public static final String MSG_BALL = "%s볼";
	public static final String MSG_NOTHING = "낫싱";
	public static final String MSG_END = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
	public static final String MSG_START = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	public static final String STRART_YES = "1";
	public static final String STRART_NO = "2";

	/**
	 * 게임 restart 여부
	 * @return
	 */
	public static String isRestart(){
		System.out.println(MSG_START);
		return Console.readLine();
	}

	/**
	 * print 정답
	 */
	public static void printGameOver(){
		System.out.println(MSG_END);
	}

	/**
	 * print hint
	 * @param status
	 */
	public static void printHint(BaseballStatus status) {
		StringBuilder sb = new StringBuilder();

		Map<String, Integer> map = new HashMap<>();
		map.put(MSG_STRIKE, status.getStrike());
		map.put(MSG_BALL, status.getBall());
		map.put(MSG_NOTHING, status.getStrike() + status.getBall());

		for (String key : map.keySet()) {
			appendResult(sb, map.get(key), key);
		}

		System.out.println(sb.toString());
	}

	private static void appendResult(StringBuilder sb, int count, String msg) {
		String space = sb.length() != 0 ? " " : "";
		sb.append(space);

		// ball & strike 일 때
		if(!MSG_NOTHING.equals(msg) && count > 0){
			sb.append(String.format(msg, count));
			return;
		}

		// nothing  일때
		if(MSG_NOTHING.equals(msg) && count == 0){
			sb.append(msg);
		}
	}

	public static boolean checkValidation(String userInput) {
		return userInput.length() != 1 || !checkNum(userInput);
	}

	private static boolean checkNum(String userInput) {
		return userInput.equals(STRART_YES) || userInput.equals(STRART_NO);
	}
}
