package ru.kravchenko.sp.service;

import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import ru.kravchenko.sp.api.IRequestService;
import ru.kravchenko.sp.constant.Constant;
import ru.kravchenko.sp.util.StringUtil;

import java.io.IOException;

@Service
public class RequestService implements IRequestService {

    private final OkHttpClient httpClient = new OkHttpClient();

    @Override
    public String getRequest() {

        Request request = new Request.Builder()
                .url("https://postb.in/1582633153071-6389286571647?hello=world")
                .addHeader("custom-key", "mkyong")  // add request headers
                .addHeader("User-Agent", "OkHttp Bot")
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            // Get response body
            String body = response.body().string();
            System.out.println(body);
            return body;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void postRequest() {

    }

    @Override
    @SneakyThrows
    public Integer getNumberPaginator() {
        Document doc = Jsoup.connect(Constant.URL_PAGE_1).get();
        String rowPaginator = doc.getElementsByClass("ui_last_page").toString(); // получить пагинацию
        return StringUtil.getLastPaginatorNumber(rowPaginator);
    }

    @Override
    @SneakyThrows
    public String getAllHtmlOnePage(Integer page) {
        String updateUrl = Constant.URL + page;
        Document document = Jsoup.connect(updateUrl).get();
        return document.toString();
    }

}
