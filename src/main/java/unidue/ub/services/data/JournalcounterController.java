package unidue.ub.services.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import unidue.ub.media.analysis.JournalCounter;

import java.util.List;

@Controller
public class JournalcounterController {

    @Autowired
    private JournalCounterRepository journalCounterRepository;

    @GetMapping("/journalcounter/getForIssn")
    public ResponseEntity<?> getAlJournalCountersForIssn(@Param("issn") String issn) {
        List<JournalCounter> journalCounters = journalCounterRepository.findByOnlineIssn(issn);
        if (journalCounters.size() == 0)
            journalCounters = journalCounterRepository.findByPrintIssn(issn);
        if (journalCounters.size() == 0)
            journalCounters = journalCounterRepository.findByDoi(issn);
        if (journalCounters.size() == 0)
            journalCounters = journalCounterRepository.findByProprietary(issn);
        return ResponseEntity.ok(journalCounters);
    }
}
