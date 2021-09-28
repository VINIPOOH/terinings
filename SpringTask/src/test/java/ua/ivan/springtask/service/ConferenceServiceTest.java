package ua.ivan.springtask.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ua.ivan.springtask.entity.Conference;
import ua.ivan.springtask.entity.User;
import ua.ivan.springtask.exception.ConferenceNotValidException;
import ua.ivan.springtask.repository.ConferenceRepository;

import java.util.HashSet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConferenceServiceTest {
    @Autowired
    ConferenceService conferenceService;

    @MockBean
    UserService userService;

    @MockBean
    ConferenceRepository conferenceRepository;

    @Test
    public void changeRegistration() {
        Conference conference = Conference.builder()
                .id(1L)
                .registeredGuests(new HashSet<>())
                .approved(true)
                .finished(false)
                .build();
        User user = User.builder()
                .id(1L)
                .build();

        Mockito.doReturn(user)
                .when(userService)
                .getCurrentUser();

        Mockito.doReturn(conference)
                .when(conferenceRepository)
                .findConferenceById(conference.getId());

        conferenceService.changeRegistration(conference.getId());

        conference.getRegisteredGuests().forEach(guest -> {System.out.println(guest.getId());});

        Assert.assertTrue(conference.getRegisteredGuests().contains(user));

        conferenceService.changeRegistration(conference.getId());

        conference.getRegisteredGuests().forEach(guest -> {System.out.println(guest.getId());});

        Assert.assertFalse(conference.getRegisteredGuests().contains(user));


    }

    @Test(expected = ConferenceNotValidException.class)
    public void changeRegistrationException() {
        Conference conference = Conference.builder()
                .id(1L)
                .registeredGuests(new HashSet<>())
                .approved(false)
                .finished(false)
                .build();

        User user = User.builder()
                .id(1L)
                .build();

        Mockito.doReturn(user)
                .when(userService)
                .getCurrentUser();

        Mockito.doReturn(conference)
                .when(conferenceRepository)
                .findConferenceById(conference.getId());

        conferenceService.changeRegistration(conference.getId());
    }
}