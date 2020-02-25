package ru.kravchenko.sp.service;

import org.springframework.stereotype.Service;
import ru.kravchenko.sp.api.ICreateFile;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

@Service
public class CreateFileService implements ICreateFile {

    @Override
    public void creatAndWriteFile() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("file.txt", "UTF-8");
        writer.println("The first line");
        writer.println("The second line");
        writer.println("Третья строка будет по русски %))) ");
        writer.close();
    }

}
