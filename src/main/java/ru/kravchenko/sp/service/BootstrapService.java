package ru.kravchenko.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kravchenko.sp.api.IBootstrapService;
import ru.kravchenko.sp.api.IUserRepository;
import ru.kravchenko.sp.entity.User;

@Service
public class BootstrapService implements IBootstrapService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public void init() {
        System.out.println("Hello this is init in BootstrapService");
        for (int i = 0; i < 5; i++) {
            User user = getAnyUser();
            System.out.println("Get user, id = " + user.getId());
            userRepository.insertUser(user);
        }
        System.out.println("Show all user");
        userRepository.showAllUser();
    }

    private User getAnyUser() {
        return new User();
    }

}
