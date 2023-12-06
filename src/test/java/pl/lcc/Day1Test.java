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
    void shouldDecipherNumbers(String line, String answer) {
        //when
        var result = new Day1().decipherLinePart1(line);

        //then
        assertThat(result).isEqualTo(Integer.parseInt(answer));
    }

    @Test
    void shouldSolveTestInput() {
        //given
        var input = Stream.of("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet");

        //when
        int answer = new Day1().sumOfCalibrationValues(input);

        //Then
        assertThat(answer).isEqualTo(142);
    }

}