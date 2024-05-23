package edu.avada.queston_05._03;

import edu.avada.queston_05.TaskUtil;
import edu.avada.queston_05.User;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.datafaker.Faker;
import net.datafaker.service.RandomService;

public class Main {
    private static final int COPIES = 5;

    public static void main(String[] args) {
        List<User> users = TaskUtil.initUserList(10);

        RandomService faker = new Faker().random();
        for (int i = 0; i < COPIES; ++i) {
            User user = users.get(faker.nextInt(users.size()));
            users.add(user);
        }
        TaskUtil.showUserList(users);

        System.out.println("\nПреобразовать коллекцию пользователей в поток данных:");
        Stream<User> userStream = users.stream();

        System.out.println("\nНайти и убрать элементы, которые повторяются:");
        Stream<User> distincted = userStream.distinct();

        System.out.println("\nСохранить поток в новую коллекцию:");
        ArrayList<User> distinctList = distincted.collect(Collectors.toCollection(ArrayList::new));

       TaskUtil.showUserList(distinctList);
    }
}
