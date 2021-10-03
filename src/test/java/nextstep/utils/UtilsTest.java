package nextstep.utils;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

class UtilsTest {

	ByteArrayInputStream bindData;

	private void provideInput(String data) {
		bindData = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));
		System.setIn(bindData);
	}

	@Test
	void pickNumberInRangeTest(){
		int num = Randoms.pickNumberInRange(1, 9);
		System.out.println("num = " + num);
		assertThat(num).isBetween(1, 9);
	}

	@Test
	void readLineTest(){
		String expected = "123";
		provideInput(expected);
		String s = Console.readLine();
		assertThat(s).isEqualTo("123");
	}
}