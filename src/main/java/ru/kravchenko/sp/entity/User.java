package ru.kravchenko.sp.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends AbstractEntity {

    private String name;

    private int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                "age='" + age + '\'' +
                ", id=" + this.getId() +
                '}';
    }

}
