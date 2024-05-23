package edu.avada.queston_04;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<Object> empty = Optional.empty();

        Optional<Integer> optionalInteger = Optional.of(25);

        optionalInteger.ifPresent(System.out::println);
        optionalInteger
                .map(x -> x * 2)
                .ifPresentOrElse(System.out::println, () -> System.out.println("Empty value"));

        empty.orElseGet(() -> (int) (Math.random() * 10));
        try {
            empty.orElseThrow(NoSuchElementException::new);
        } catch (NoSuchElementException e) {
            System.out.println("При пустому елементі в Optional викинулось виключення");
        }
        empty.ifPresentOrElse(System.out::println, () -> System.out.println("Empty value"));


        Optional<String> someLine = Optional.of("some line");
        someLine.or(() -> Optional.of(""));
    }
}
