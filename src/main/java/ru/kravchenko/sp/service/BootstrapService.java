package ru.kravchenko.sp.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kravchenko.sp.api.*;
import ru.kravchenko.sp.util.StringUtil;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

@Service
public class BootstrapService implements IBootstrapService {

    @Autowired
    ICreateFileService createFile;

    @Autowired
    IRequestService requestService;

    @Autowired
    ICreateExcelFileService createExcelFileService;

    @Autowired
    IParserService parserService;

    @Override
    @SneakyThrows
    public void init() {
        Integer countPaginator = requestService.getNumberPaginator();
        for (int i = 1; i < countPaginator + 1; i++) {
            String onePageHtml = requestService.getAllHtmlOnePage(1);
            parserService.fillUserRepository(onePageHtml);
        }
    }

    @SneakyThrows
    private void creatExcelFile() {
        createExcelFileService.createExcelFile("test.xls");
    }

    private void creatFileMethod() {
        try {
            createFile.creatAndWriteFile();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    private void creatRequest() {
        String body = requestService.getRequest();
        createFile.writeToFile(body);
    }

}
