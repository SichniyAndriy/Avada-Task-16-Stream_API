package edu.avada.question_02_03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // --- Stream Object ---
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        Stream<String> stringStream = Stream.of("1", "2", "3", "4", "5");

        Stream<Object> stream = Stream.builder().add(1.0).add(2.0).add(3.0).add(4.0).add(5.0).build();

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> integerStream1 = integers.stream();
        Set<String> strings = Set.of("1", "2", "3", "4", "5");
        Stream<String> stringStream1 = strings.stream();

        Stream<Double> generated = Stream.generate(Math::random);

        // --- Primitive Streams ---
        IntStream concatedIntStream = IntStream.concat(
                IntStream.range(1, 11),
                IntStream.rangeClosed(1, 10)
        );
        long count = concatedIntStream.
                filter(x -> x % 2 == 0)
                .distinct().map(x -> x * 10)
                .count();

        LongStream concatedLongStream = LongStream.concat(
                LongStream.range(1_000, 10_001),
                LongStream.rangeClosed(1_000, 10_000)
        );

        var min_and_max = concatedLongStream
                .dropWhile(x -> x < 5000)
                .limit(1000)
                .map(x -> x / 10)
                .boxed()
                .collect(Collectors.teeing(
                        Collectors.minBy(Long::compare),
                        Collectors.maxBy(Long::compare),
                        (x, y) ->  "Min: " + x.orElse(0L) + ", " + "Max: " + y.orElse(0L)
                        )
                );
        System.out.println(min_and_max);

        DoubleStream.generate(Math::random);

        // --- Stream from file ---
        try {
            Stream<String> lines = Files.lines(Path.of("task14.log"));
            System.out.println(lines.count());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
