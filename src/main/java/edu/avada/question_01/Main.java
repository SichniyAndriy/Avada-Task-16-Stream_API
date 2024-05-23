package edu.avada.question_01;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("one", "two", "three", "four", "five");
        strings.sort((a, b) -> Integer.compare(b.length(), a.length()));

        Optional<String> lineFromList = strings.stream().reduce((line, l) -> line + l);
        String s = lineFromList.orElse("");
        System.out.println(s);

        Function<String, String> toUpper = a -> a.toUpperCase();
        System.out.println(toUpper.apply(s));
        Function<String, Integer> length = a -> a.length();
        System.out.println(length.apply(s));


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.sort((a, b) -> b - a);
        System.out.println(numbers);


    }
}
