package com.edunexus.controller;

import com.edunexus.entity.Report;
import com.edunexus.repository.ReportRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportRepository reportRepository;

    public ReportController(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @PostMapping("/submit")
    public Report submitReport(@RequestBody Report report) {
        return reportRepository.save(report);
    }

    @GetMapping("/all")
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }
}
