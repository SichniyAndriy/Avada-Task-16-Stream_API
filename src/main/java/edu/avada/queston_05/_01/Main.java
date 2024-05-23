package edu.avada.queston_05._01;

import edu.avada.queston_05.TaskUtil;
import edu.avada.queston_05.User;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<User> users = TaskUtil.initUserList(25);
        System.out.println(users);

        System.out.println("\nОтсортировать пользователей по именам в алфавитном порядке:");
        users.stream()
                .sorted(Comparator.comparing(User::getFirstName))
                .forEach(user -> System.out.println(user.getFirstName()));

        System.out.println("\nОтфильтровать пользователей по возрасту, не младше 25 лет:");
        users.stream()
                .filter(user -> user.getAge() > 24)
                .forEach(
                        user -> System.out.println(user.getFirstName() + " " + user.getLastName() + " - " + user.getAge())
                );

        System.out.println("\nВыбрать первых 3-х пользователей:");
        users.stream()
                .limit(3)
                .forEach(System.out::println);

        System.out.println("\nПреобразовать в поток имена пользователей:");
        Stream<String> firstNameStream = users.stream().map(User::getFirstName);
        System.out.println(firstNameStream.toList());
    }
}
