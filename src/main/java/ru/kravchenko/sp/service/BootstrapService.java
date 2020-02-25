package ru.kravchenko.sp.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kravchenko.sp.api.IBootstrapService;
import ru.kravchenko.sp.api.ICreateFileService;
import ru.kravchenko.sp.api.IRequestService;
import ru.kravchenko.sp.api.IUserRepository;
import ru.kravchenko.sp.entity.User;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

@Service
public class BootstrapService implements IBootstrapService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    ICreateFileService createFile;

    @Autowired
    IRequestService requestService;

    @Override
    @SneakyThrows
    public void init() {
        String body = requestService.getRequest();
        createFile.writeToFile(body);
    }

    private User getAnyUser() {
        return new User();
    }

    private void anyMethodUserRepository() {
        System.out.println("Hello this is init in BootstrapService");
        for (int i = 0; i < 5; i++) {
            User user = getAnyUser();
            System.out.println("Get user, id = " + user.getId());
            userRepository.insertUser(user);
        }
        System.out.println("Show all user");
        userRepository.showAllUser();
    }

    private void creatFileMethod() {
        try {
            createFile.creatAndWriteFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
