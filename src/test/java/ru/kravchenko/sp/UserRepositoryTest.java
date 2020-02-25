package ru.kravchenko.sp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.sp.entity.User;
import ru.kravchenko.sp.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testInsertUserRepository() {
        userRepository.insertUser(new User());
        List<User> userList = userRepository.getAllUser();
        Assert.assertFalse(userList.isEmpty());
    }

    @Test
    public void testShowAllUser() {
        userRepository.addUsers(getUserList());
        userRepository.showAllUser();
    }

    @Test
    public void testUsersToRepository() {
        List<User> users = getUserList();
        userRepository.addUsers(users);
        Assert.assertTrue(userRepository.getAllUser().size() > 1);
    }

    private List<User> getUserList() {
        List<User> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(new User());
        }
        return result;
    }

}
