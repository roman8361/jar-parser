package ru.kravchenko.sp;

import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.sp.api.ICreateFileService;
import ru.kravchenko.sp.api.IUserRepository;
import ru.kravchenko.sp.entity.User;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class CreateFileServiceTest {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    ICreateFileService createFileService;

    @Test
    public void testSaveAnyUserToFile() {
        userRepository.addUsers(getUserList());
        List<User> allUsers = userRepository.getAllUser();
        createFileService.writeToFileAnyUserList(allUsers);
    }

    @Test
    @SneakyThrows
    public void testSaveToFile() {
        createFileService.creatAndWriteFile();
    }

    private List<User> getUserList() {
        List<User> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(new User());
        }
        return result;
    }

}
