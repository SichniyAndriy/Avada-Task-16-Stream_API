package edu.avada.queston_05;

import lombok.Data;
import lombok.NonNull;

@Data(staticConstructor = "of")
public class User {
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private int age;
    @NonNull
    private Sex sex;

    public enum Sex {
        MALE(1),
        FEMALE(2);

        private int value;

        Sex(int i) {
            value = i;
        }
    }
}
