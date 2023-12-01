package pl.lcc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Day1Test {
    @ParameterizedTest
    @CsvSource(value = {
            "1abc2,12",
            "pqr3stu8vwx,38",
            "a1b2c3d4e5f,15",
            "treb7uchet,77",
            "12345,15",
            "42xccx35, 45"}
    )
    void processLineP1Test(String line, String answer) {
        assertThat(new Day1().decipherLinePart1(line)).isEqualTo(Integer.parseInt(answer));
    }

    @Test
    void answerP1Test() {
        var input = Stream.of("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet");
        int answer = new Day1().solveTask1(input);
        assertThat(answer).isEqualTo(142);

    }
}