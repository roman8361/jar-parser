package ru.kravchenko.sp.api;

public interface IRequestService {

    String getRequest();

    void postRequest();

    Integer getNumberPaginator(String currentUrl);

    String getAllHtmlOnePage(Integer page);

}
