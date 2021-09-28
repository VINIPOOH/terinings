package ua.ivan.springtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.ivan.springtask.entity.Report;
import ua.ivan.springtask.entity.User;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    Report findReportById(Long id);
    List<Report> findAllBySpeaker(User speaker);
    void deleteAllBySpeaker(User speaker);
}
