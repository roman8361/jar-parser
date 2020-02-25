package ru.kravchenko.sp.api;

import ru.kravchenko.sp.entity.User;

import java.io.IOException;
import java.util.List;

public interface ICreateExcelFileService {

    void createExcelFile(String fileName) throws IOException;

    void createExcelFile(String fileName, List<User> users) throws IOException;


}
