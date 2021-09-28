package ua.ivan.springtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.ivan.springtask.entity.ReportRequest;
import ua.ivan.springtask.entity.User;

import java.util.List;

public interface ReportRequestRepository extends JpaRepository<ReportRequest, Long> {
    List<ReportRequest> findAllByApprovedByModeratorIsTrue();
    void deleteAllBySpeaker(User speaker);
}
