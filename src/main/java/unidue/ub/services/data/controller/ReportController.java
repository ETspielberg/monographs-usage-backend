package unidue.ub.services.data.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import unidue.ub.services.data.model.JournalUsageReport;

import java.util.ArrayList;
import java.util.List;

@Controller
@RefreshScope
public class ReportController {

    private final
    JdbcTemplate jdbcTemplate;

    private final String getJournalUsageReport = "SELECT platform, year, SUM(total_requests) AS totalrequests, COUNT(full_name) AS items FROM public.journal_counter where year=? group by platform,year;";

    private static final Logger log = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    public ReportController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("reports/journalusage")
    ResponseEntity<?> getJournalUsageReport(int year) {
        List<JournalUsageReport> journalUsageReportList = new ArrayList<>();
        journalUsageReportList.addAll(jdbcTemplate.query(getJournalUsageReport, new Object[]{year},(rs, rowNum) -> new JournalUsageReport(rs.getString("platform"),rs.getInt("year"),rs.getLong("totalrequests"),rs.getLong("items"))));
        return ResponseEntity.ok(journalUsageReportList);
    }
}
