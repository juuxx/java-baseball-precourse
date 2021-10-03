package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("유저 입력 생성기")
class UserNumbersGeneratorTest {

	ByteArrayInputStream bindData;

	//Scanner를 테스트 하기위한 method
	private void provideInput(String data) {
		bindData = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));
		System.setIn(bindData);
	}

	@Test
	@DisplayName("유저가 입력한 숫자 배열로 리턴")
	void generateNumbers() {
		//given
		String expected = "123";
		provideInput(expected);

		//when
		UserNumbersGenerator userGenerator = new UserNumbersGenerator();

		//then
		int[] ballNumbers = userGenerator.getBallNumbers();
		assertThat(ballNumbers).isEqualTo(new int[] {1, 2, 3});
	}
}