package ru.kravchenko.sp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.sp.api.IRequestService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class RequestServiceTest {

    @Autowired
    IRequestService requestService;

    @Test
    public void testGetRequest() {
        requestService.getRequest();
    }

}
