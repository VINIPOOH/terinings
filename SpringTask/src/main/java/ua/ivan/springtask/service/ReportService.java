package ua.ivan.springtask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ivan.springtask.dto.ReportDTO;
import ua.ivan.springtask.entity.Report;
import ua.ivan.springtask.repository.ReportRepository;

import java.util.List;
import java.util.Objects;

@Service
public class ReportService {
    private ReportRepository reportRepository;
    private UserService userService;

    @Autowired
    public ReportService(ReportRepository reportRepository, UserService userService) {
        this.reportRepository = reportRepository;
        this.userService = userService;
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public List<Report> getAllReportsByCurrentUser() {
        return reportRepository.findAllBySpeaker(userService.getCurrentUser());
    }

    public Report getReportById(Long id) {
        return reportRepository.findReportById(id);
    }

    public void saveReport(Report report) {
        reportRepository.save(report);
    }

    public void updateReport(ReportDTO reportDTO) {
        Report report = reportRepository.findReportById(reportDTO.getId());

        report.setTopic(reportDTO.getTopic());

        reportRepository.save(report);
    }

    public void deleteReport(Report report) {

        if (!Objects.isNull(report.getConference())) {
            report.getConference().getReports().remove(report);
        }

        reportRepository.delete(report);
    }
}
