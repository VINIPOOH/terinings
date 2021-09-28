package ua.ivan.springtask.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ua.ivan.springtask.entity.Conference;
import ua.ivan.springtask.entity.ReportRequest;
import ua.ivan.springtask.entity.Role;
import ua.ivan.springtask.entity.User;
import ua.ivan.springtask.repository.NotificationRepository;
import ua.ivan.springtask.repository.ReportRepository;
import ua.ivan.springtask.repository.ReportRequestRepository;

import java.util.Collections;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportRequestServiceTest {

    @Autowired
    ReportRequestService reportRequestService;

    @MockBean
    ReportRepository reportRepository;

    @MockBean
    NotificationRepository notificationRepository;

    @MockBean
    ReportRequestRepository reportRequestRepository;

    @MockBean
    UserService userService;

    @MockBean
    Conference conference;

    @Test
    public void approve() {

        User speaker = User.builder()
                .roles(Collections.singleton(Role.MODER))
                .build();

        ReportRequest reportRequest = ReportRequest.builder()
                .id(1L)
                .topic("Testing report request")
                .conference(conference)
                .speaker(speaker)
                .approvedBySpeaker(false)
                .approvedByModerator(false)
                .build();

        Mockito.doReturn(speaker)
                .when(userService)
                .getCurrentUser();

        reportRequestService.approve(reportRequest);

        Assert.assertTrue(reportRequest.isApprovedBySpeaker());
        Assert.assertTrue(reportRequest.isApprovedByModerator());

        Mockito.verify(reportRepository, Mockito.times(1)).save(ArgumentMatchers.any());
        Mockito.verify(notificationRepository, Mockito.times(1)).save(ArgumentMatchers.any());
        Mockito.verify(reportRequestRepository, Mockito.times(1)).delete(reportRequest);
    }

    @Test
    public void reject() {
        User speaker = User.builder()
                .roles(Collections.singleton(Role.MODER))
                .build();

        ReportRequest reportRequest = ReportRequest.builder()
                .id(1L)
                .topic("Testing report request")
                .conference(conference)
                .speaker(speaker)
                .approvedBySpeaker(false)
                .approvedByModerator(false)
                .build();

        reportRequestService.reject(reportRequest);

        Mockito.verify(reportRepository, Mockito.times(0)).save(ArgumentMatchers.any());
        Mockito.verify(notificationRepository, Mockito.times(1)).save(ArgumentMatchers.any());
        Mockito.verify(reportRequestRepository, Mockito.times(1)).delete(reportRequest);
    }
}