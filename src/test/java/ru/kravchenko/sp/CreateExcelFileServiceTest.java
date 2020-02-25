package ru.kravchenko.sp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.sp.api.ICreateExcelFileService;
import ru.kravchenko.sp.entity.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class CreateExcelFileServiceTest {

    @Autowired
    ICreateExcelFileService createExcelFileService;

    @Test
    public void creatExcelFile() throws IOException {
        createExcelFileService.createExcelFile("test.xls");
    }

    @Test
    public void creatExcelFileWithUsersList() throws IOException {
        createExcelFileService.createExcelFile("userList.xls", getUserList());
    }

    private List<User> getUserList() {
        List<User> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(new User("Иваноооо", new Random().nextInt(101)));
        }
        return result;
    }

    @Test
    public void createRandomNumber() {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Random().nextInt(11));
        }
    }

}
