package ru.kravchenko.sp.repository;

import org.springframework.stereotype.Repository;
import ru.kravchenko.sp.api.IUserRepository;
import ru.kravchenko.sp.entity.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    private List<User> userList = new ArrayList<>();

    @Override
    public void showAllUser() {
        userList.forEach(System.out::println);
    }

    @Override
    public List<User> getAllUser() {
        return userList;
    }

    @Override
    public User findUserById(String id) {
        return null;
    }

    @Override
    public void delUserById(String id) {

    }

    @Override
    public void insertUser(User user) {
        if (user == null) return;
        userList.add(user);
        System.out.println("User id = " + user.getId() + " add to repository");
    }

    @Override
    public void addUsers(List<User> users) {
        userList.addAll(users);
    }

}
