package ru.kravchenko.sp.api;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public interface ICreateFile {

    void creatAndWriteFile() throws FileNotFoundException, UnsupportedEncodingException;

}
