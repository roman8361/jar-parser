package ru.kravchenko.sp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.sp.api.IRequestService;
import ru.kravchenko.sp.constant.Constant;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class RequestServiceTest {

    @Autowired
    IRequestService requestService;

    @Test
    public void testGetRequest() {
        requestService.getRequest();
    }

    @Test
    public void getNumberPaginator() {
        Assert.assertSame(24, requestService.getNumberPaginator(Constant.URL));
    }

    @Test
    public void testGetAllHtmlOnePage() {
        System.out.println(requestService.getAllHtmlOnePage(1));
    }

}
