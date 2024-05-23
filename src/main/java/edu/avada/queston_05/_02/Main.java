package edu.avada.queston_05._02;

import edu.avada.queston_05.TaskUtil;
import edu.avada.queston_05.User;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<User> users = TaskUtil.initUserList(50);
        System.out.println(users);

        System.out.println("\nПроверить есть ли в коллекции хотя бы один пользователь младше 18 лет");
        Optional<User> optionalUser = users.stream()
                .filter(user -> user.getAge() < 18)
                .findFirst();
        System.out.println(optionalUser.isPresent());

        System.out.println("\nПроверить что имена всех пользователей больше 1 символа:");
        boolean allMatch = users.stream()
                .mapToInt(user -> user.getFirstName().length())
                .allMatch(n -> n > 1);
        System.out.println(allMatch);

        System.out.println("\nПроверить нет ли в коллекции пользователя с возрастом больше 80 лет:");
        long count = users.stream()
                .mapToInt(User::getAge)
                .filter(x -> x > 80)
                .count();
        System.out.println(count > 0);

        System.out.println("\nВернуть самого молодого пользователя из потока и вывести его имя и возраст:");
        Optional<User> minAgeUser = users.stream()
                .min(Comparator.comparingInt(User::getAge));
        minAgeUser.ifPresentOrElse(System.out::println, () -> System.out.println("Stream was empty"));

        System.out.println("\nВернуть самого пожилого пользователя из потока и вывести его имя и возраст: ");
        Optional<User> maxAgeUser = users.stream()
                .max(Comparator.comparingInt(User::getAge));
        minAgeUser.ifPresentOrElse(System.out::println, () -> System.out.println("Stream was empty"));

        System.out.println("\nПосчитать, сколько раз пользователей с возвратом 18 встречается в коллекции:");
        long counted = users.stream()
                .mapToInt(User::getAge)
                .filter(x -> x == 18)
                .count();
        System.out.println(counted);

        System.out.println("\nСгруппировать пользователей на несовершеннолетних и совершеннолетних в виде коллекции Map:");
        Map<Boolean, List<User>> map = users.stream()
                .collect(Collectors.groupingBy(user -> user.getAge() < 18));

        System.out.println("Неповнолітні:");
        System.out.println(map.get(true));
        System.out.println("Повнолітні:");
        System.out.println(map.get(false));
    }
}
