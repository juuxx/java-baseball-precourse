package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ComputerNumbersGeneratorTest {

	@Test
	void generateNumbersTest(){
		ComputerNumbersGenerator computerNumbersGenerator = new ComputerNumbersGenerator();
		System.out.println(computerNumbersGenerator.toString());
	}
}