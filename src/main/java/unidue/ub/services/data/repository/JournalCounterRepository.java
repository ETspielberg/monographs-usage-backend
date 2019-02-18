package unidue.ub.services.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import unidue.ub.media.analysis.JournalCounter;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "journalcounter", path = "journalcounter")
public interface JournalCounterRepository extends PagingAndSortingRepository<JournalCounter, String>{

    List<JournalCounter> findAllByOnlineIssn(@Param("onlineIssn") String onlineIssn);

    List<JournalCounter> findAllByPrintIssn(@Param("printIssn") String printIssn);

    List<JournalCounter> findAllByDoi(@Param("doi") String doi);

    List<JournalCounter> findAllByProprietary(@Param("proprietary") String proprietary);

    List<JournalCounter> findAllByOnlineIssnAndYear(@Param("onlineIssn") String onlineIssn, @Param("year") int year);

    List<JournalCounter> findAllByPrintIssnAndYear(@Param("printIssn") String printIssn, @Param("year") int year);

    List<JournalCounter> findAllByDoiAndYear(@Param("doi") String doi, @Param("year") int year);

    List<JournalCounter> findAllByProprietaryAndYear(@Param("proprietary") String proprietary, @Param("year") int year);
}
