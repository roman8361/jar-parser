package ru.kravchenko.sp.service;

import org.springframework.stereotype.Service;
import ru.kravchenko.sp.api.ICreateFileService;
import ru.kravchenko.sp.entity.User;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class CreateFileService implements ICreateFileService {

    private PrintWriter writer = new PrintWriter("file.txt", "UTF-8");

    public CreateFileService() throws FileNotFoundException, UnsupportedEncodingException {
    }

    @Override
    public void creatAndWriteFile() throws FileNotFoundException, UnsupportedEncodingException {
        writer.println("The first line");
        writer.println("The second line");
        writer.println("Третья строка будет по русски %))) ");
        writer.println("Четвертая тоже ))) строка будет по русски %))) ");
        writer.close();
    }

    @Override
    public void writeToFile(String text) throws FileNotFoundException, UnsupportedEncodingException {
        writer.println(text);
        writer.close();
    }

    @Override
    public void writeToFileAnyUserList(List<User> userList) {
        for (User u: userList) {
            writer.println(u);
        }
        writer.close();
    }

}
