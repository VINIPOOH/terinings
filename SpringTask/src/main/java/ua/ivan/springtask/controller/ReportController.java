package ua.ivan.springtask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.ivan.springtask.dto.ReportDTO;
import ua.ivan.springtask.entity.Report;
import ua.ivan.springtask.service.ReportService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    private ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public List<ReportDTO> getAllReports(){
        return reportService.getAllReports().stream()
                .map(ReportDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/me")
    public List<ReportDTO> getAllReportsOfCurrentUser() {
        return reportService.getAllReportsByCurrentUser().stream()
                .map(ReportDTO::new).collect(Collectors.toList());
    }

    @PutMapping
    public void updateReport(@RequestBody ReportDTO reportDTO) {
        reportService.updateReport(reportDTO);
    }

    @DeleteMapping(value = "/{report}")
    public void deleteReport(@PathVariable Report report) {
        reportService.deleteReport(report);
    }
}
