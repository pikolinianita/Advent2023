package pl.lcc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Day1 {

    private final static String PATH_TO_INPUT = "data\\day01.txt";
    private final Pattern oneDigitPattern = Pattern.compile("\\d");

    public static void main(String[] args) {
        try (var scanner = new Scanner(new File(PATH_TO_INPUT))) {
            Day1 day1 = new Day1();
            var result = day1.sumOfCalibrationValues(scanner.tokens());
            printResult(result);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Scanner Failed: No File" + PATH_TO_INPUT);
        }
    }

    int sumOfCalibrationValues(Stream<String> inputLines) {
        return inputLines.mapToInt(this::decipherLinePart1).sum();
    }

    int decipherLinePart1(String line) {
        var result = extractDigits(line);
        return makeNumberFromFirstAndLast(result);
    }

    private List<String> extractDigits(String line) {
        return oneDigitPattern.matcher(line).results().map(matchResult -> matchResult.group(0)).toList();
    }

    private int makeNumberFromFirstAndLast(List<String> digitsList) {
        return Integer.parseInt(digitsList.getFirst() + digitsList.getLast());
    }

    private static void printResult(int result) {
        System.out.println("P1 Result is:");
        System.out.println(result);

    }

}
