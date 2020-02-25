package ru.kravchenko.sp.api;

import ru.kravchenko.sp.entity.User;

import java.util.List;

public interface IUserRepository {

    void showAllUser();

    List<User> getAllUser();

    User findUserById(String id);

    void delUserById(String id);

    void insertUser(User user);

    void addUsers(List<User> users);

}
