package ru.kravchenko.sp;

import okhttp3.*;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.sp.api.IRequestService;
import ru.kravchenko.sp.constant.Constant;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class RequestServiceTest {

    private final OkHttpClient httpClient = new OkHttpClient();

    @Autowired
    IRequestService requestService;

    @Test
    public void testGetRequest() {
        requestService.getRequest();
    }

    @Test
    public void getNumberPaginator() {
        Assert.assertSame(24, requestService.getNumberPaginator());
    }

    @Test
    public void testGetAllHtmlOnePage() {
        System.out.println(requestService.getAllHtmlOnePage(24));
        Assert.assertNotNull(requestService.getAllHtmlOnePage(24));
    }

    @Test
    public void testGetPhoneCompany() {
        Assert.assertNotNull(requestService.getPhoneCompany("11399560"));
    }

    @Test
    @Ignore
    public void testPostRequest() {
        // form parameters
        RequestBody formBody = new FormBody.Builder()
                .add("contact_id", "11399560")
                .build();

        Request request = new Request.Builder()
                .url(Constant.URL_GET_TELEPHONE)
                .addHeader("User-Agent", "OkHttp Bot")
                .post(formBody)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Get response body
            System.out.println(response.body().string());
        } catch (IOException | IllegalStateException e) {
            e.printStackTrace();
        }
    }

}


