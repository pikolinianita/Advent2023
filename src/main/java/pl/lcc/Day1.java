package pl.lcc;

import java.util.Arrays;
import java.util.stream.Stream;

public class Day1 {

    public int decipherP1(String line) {
        String[] splittedLine = line.split("[a-z]+", 0);
        var firstNumber = splittedLine[0].isEmpty()? splittedLine[1] : splittedLine[0];
        return Integer.parseInt(firstNumber + splittedLine[splittedLine.length-1]);
    }

    public int solveP1(Stream<String> stream) {
       return stream
                .mapToInt(this::decipherP1)
                .sum();
    }
}
