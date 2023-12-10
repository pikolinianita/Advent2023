package pl.lcc.day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day9 {

    List<Differentiator> histories;

    private final static String PATH_TO_INPUT = "data\\day09.txt";
    public static void main(String[] args) {
        try (var scanner = new Scanner(new File(PATH_TO_INPUT)).useDelimiter("\\n")) {
            var inputList = scanner.tokens().toList();
            Day9 day9 = new Day9(inputList);
            var nextValue = day9.calculateQuest1();
            var prevValue = day9.calculateQuest2();
            printResult(nextValue, prevValue);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Scanner Failed: No File" + PATH_TO_INPUT);
        }
    }

    public Day9(List<String> inputList) {
        histories = inputList.stream().map(Differentiator::new).toList();
    }

     long calculateQuest2() {
        return histories.stream()
                .mapToLong(Differentiator::valueExtrapolatedBackward)
                .peek(System.out::println)
                .sum();
    }

    public long calculateQuest1() {
        return histories.stream()
                .mapToLong(Differentiator::valueExtrapolatedForward)
                .sum();
    }
    private static void printResult(long q1, long q2) {
        System.out.println("P1 Result is:");
        System.out.println(q1);
        System.out.println("P2 Result is:");
        System.out.println(q2);

    }

    static class Differentiator {

        private List<long[]> diffs;

        Differentiator(String line){
            var history = Arrays.stream(line.split(" "))
                    .mapToLong(Integer::parseInt)
                    .toArray();
            diffs = new ArrayList<>();
            diffs.add(history);
            differentiate();
        }

        private void differentiate(){
            var notFinished = true;
            int level = 0;
            while (notFinished){
                notFinished = false;
                var prevDiff = diffs.get(level);
                int size = prevDiff.length-1;
                var nextDiff = new long[size];
                for(int i =0; i<size; i++){
                    nextDiff[i]= prevDiff[i+1]-prevDiff[i];
                    if(nextDiff[i]!=0) {
                        notFinished = true;
                    }
                }
                diffs.add(nextDiff);
                level++;
            }
        }

         @Override
         public String toString() {
             return "Differentiator{" +
                     "extrapolations=" + diffs.stream()
                            .map(Arrays::toString)
                            .collect(Collectors.joining(" : ")) +
                     '}';
         }

         long valueExtrapolatedForward() {
            return diffs.stream()
                    .mapToLong(a -> a[a.length-1])
                    .sum();
         }

          long valueExtrapolatedBackward() {
            var valuesAtTimeZero = diffs.stream()
                    .mapToLong(a -> a[0])
                    .toArray();
            long result = 0;
            for (int i = valuesAtTimeZero.length-1; i>=0; i--){
                result = valuesAtTimeZero[i] - result;
            }
            return result;
         }
     }
}
