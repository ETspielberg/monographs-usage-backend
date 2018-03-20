package unidue.ub.services.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import unidue.ub.media.analysis.JournalCounter;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "journalcounter", path = "journalcounter")
public interface JournalCounterRepository extends PagingAndSortingRepository<JournalCounter, String>{

    public List<JournalCounter> findByOnlineIssn(@Param("onlineIssn") String onlineIssn);

    public List<JournalCounter> findByPrintIssn(@Param("printIssn") String printIssn);

    public List<JournalCounter> findByDoi(@Param("doi") String doi);

    public List<JournalCounter> findByProprietary(@Param("proprietary") String proprietary);
}
