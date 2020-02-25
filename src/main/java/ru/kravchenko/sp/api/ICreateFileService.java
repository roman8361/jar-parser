package ru.kravchenko.sp.api;

import ru.kravchenko.sp.entity.User;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface ICreateFileService {

    void creatAndWriteFile() throws FileNotFoundException, UnsupportedEncodingException;

    void writeToFile(String text) throws FileNotFoundException, UnsupportedEncodingException;

    void writeToFileAnyUserList(List<User> userList);

}
