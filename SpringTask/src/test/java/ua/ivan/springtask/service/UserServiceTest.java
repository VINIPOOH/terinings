package ua.ivan.springtask.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ua.ivan.springtask.entity.User;
import ua.ivan.springtask.exception.EmptyUserListException;
import ua.ivan.springtask.exception.LoginNotUniqueException;
import ua.ivan.springtask.repository.UserRepository;

import java.sql.SQLException;
import java.util.ArrayList;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;

    @Test(expected = EmptyUserListException.class)
    public void getAllUsers() {
        Mockito.doReturn(new ArrayList<>())
                .when(userRepository)
                .findAll();

        userService.getAllUsers();
    }

    @Test(expected = LoginNotUniqueException.class)
    public void saveUser() {
        User user = new User();

        Mockito.doThrow(new RuntimeException(new SQLException( "", "", 1062)))
                .when(userRepository)
                .save(user);

        userService.saveUser(user);

        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }
}