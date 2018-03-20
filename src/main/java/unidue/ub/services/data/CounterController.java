package unidue.ub.services.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import unidue.ub.media.analysis.DatabaseCounter;
import unidue.ub.media.analysis.EbookCounter;
import unidue.ub.media.analysis.JournalCounter;

import java.util.List;

@Controller
public class CounterController {

    @Autowired
    private JournalCounterRepository journalCounterRepository;

    @Autowired
    private EbookCounterRepository ebookCounterRepository;

    @Autowired
    private DatabaseCounterRepository databaseCounterRepository;

    @GetMapping("/journalcounter/getForIssn")
    public ResponseEntity<?> getAlJournalCountersForIssn(@Param("issn") String issn) {
        List<JournalCounter> list = journalCounterRepository.findAllByOnlineIssn(issn);
        if (list.size() == 0)
            list = journalCounterRepository.findAllByPrintIssn(issn);
        if (list.size() == 0)
            list = journalCounterRepository.findAllByDoi(issn);
        if (list.size() == 0)
            list = journalCounterRepository.findAllByProprietary(issn);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/ebookcounter/getForIsbn")
    public ResponseEntity<?> getAlEbookCountersForIsbn(@Param("isbn") String isbn) {
        List<EbookCounter> list = ebookCounterRepository.findAllByOnlineIsbn(isbn);
        if (list.size() == 0)
            list = ebookCounterRepository.findAllByPrintIsbn(isbn);
        if (list.size() == 0)
            list = ebookCounterRepository.findAllByDoi(isbn);
        if (list.size() == 0)
            list = ebookCounterRepository.findAllByProprietaryIdentifier(isbn);
        return ResponseEntity.ok(list);
    }

    @GetMapping("databasecounter/getForId")
    public ResponseEntity<?> getAllDatabaseCounterForId(@Param("title") String title) {
        List<DatabaseCounter> list = databaseCounterRepository.getAllByTitle(title);
        return ResponseEntity.ok(list);
    }
}
