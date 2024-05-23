package edu.avada.queston_05;

import edu.avada.queston_05.User.Sex;
import java.util.ArrayList;
import java.util.List;
import net.datafaker.Faker;

public class TaskUtil {

    public static List<User> initUserList(int n) {
        List<User> userList = new ArrayList<>();
        Faker faker = new Faker();

        for (int i = 0; i < n; i++) {
            boolean flag = faker.random().nextBoolean();
            Sex sex =  flag ? Sex.MALE : Sex.FEMALE;
            String f_name = flag ? faker.name().malefirstName() : faker.name().femaleFirstName();
            String l_name = faker.name().lastName();
            int age = faker.random().nextInt(10, 90);
            userList.add(User.of(f_name, l_name, age, sex));
        }

        return userList;
    }

    public static void showUserList(List<User> users) {
        users.stream()
                .forEach(user -> System.out.println(
                                user.getFirstName() + " " +
                                user.getLastName() + ", " +
                                user.getAge() + ", " +
                                user.getSex()
                        )
                );
    }
}
