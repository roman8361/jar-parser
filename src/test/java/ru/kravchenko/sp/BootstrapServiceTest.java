package ru.kravchenko.sp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.sp.api.IBootstrapService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class BootstrapServiceTest {

    @Autowired
    IBootstrapService bootstrapService;

    @Test
    public void testInitBootstrapService() {
        bootstrapService.init();
    }

}
