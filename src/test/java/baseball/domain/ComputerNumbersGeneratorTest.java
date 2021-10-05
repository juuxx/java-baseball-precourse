package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerNumbersGeneratorTest {

	@Test
	@DisplayName("0~9 까지 중복 없는 세자리 수 return")
	void generateNumbersTest(){
		//given
		ComputerNumbersGenerator computerNumbersGenerator = new ComputerNumbersGenerator();

		//when
		int[] comNumbers = computerNumbersGenerator.getBallNumbers();

		//then
		for (int comNumber : comNumbers) {
			assertThat(comNumber).isBetween(1, 9);
		}

	}
}