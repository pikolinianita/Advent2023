package pl.lcc.day9;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day9Test {

    @Test
    void shouldCalculateQuest1(){
        //Given
         List<String> exampleList = List.of("0 3 6 9 12 15", "1 3 6 10 15 21", "10 13 16 21 30 45");

        //When
        long result = new Day9(exampleList).calculateQuest1();

        //Then
        assertThat(result).isEqualTo(114);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0 3 6 9 12 15, 18",
            "1 3 6 10 15 21, 28",
            "10 13 16 21 30 45, 68"}
    )
    void shouldCalculateLineForQuest1(String line, String resultString){
        //Given
        int answer = Integer.parseInt(resultString);

        //When
        long result = new Day9.Differentiator(line).valueExtrapolatedForward();
        //Then
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void shouldCalculateQuest2(){
        //Given
        List<String> exampleList = List.of("0 3 6 9 12 15", "1 3 6 10 15 21", "10 13 16 21 30 45");

        //When
        long result = new Day9(exampleList).calculateQuest2();

        //Then
        assertThat(result).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0 3 6 9 12 15, -3",
            "1 3 6 10 15 21, 0",
            "10 13 16 21 30 45, 5"}
    )
    void shouldCalculateLineForQuest2(String line, String resultString){
        //Given
        int answer = Integer.parseInt(resultString);

        //When
        long result = new Day9.Differentiator(line).valueExtrapolatedBackward();
        //Then
        assertThat(result).isEqualTo(answer);
    }
}