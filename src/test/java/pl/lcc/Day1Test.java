package pl.lcc;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class Day1Test {
    @ParameterizedTest
    @CsvSource(value = {
            "1abc2,12",
            "pqr3stu8vwx,38",
            "a1b2c3d4e5f,15",
            "treb7uchet,77"}
    )
    void testProcessLineP1(String line, String answer) {
        System.out.println(line + " : " + answer);
        assertThat(new Day1().decipherP1(line)).isEqualTo(Integer.parseInt(answer));
    }
}