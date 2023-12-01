package pl.lcc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
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

    public static void main(String[] args) {
        try(var sc =new Scanner(new File("data\\day01.txt"))){
            Day1 day1 = new Day1();
            var result = day1.solveP1(sc.tokens());
            System.out.println(result);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Scanner Failed No File");
        }
    }
}
