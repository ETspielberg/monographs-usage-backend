package unidue.ub.services.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import unidue.ub.media.analysis.EbookCounter;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "ebookcounter", path = "ebookcounter")
public interface EbookCounterRepository extends PagingAndSortingRepository<EbookCounter, String>{

    public List<EbookCounter> findAllByOnlineIsbn(@Param("onlineIssn") String onlineIssn);

    public List<EbookCounter> findAllByPrintIsbn(@Param("printIssn") String printIssn);

    public List<EbookCounter> findAllByDoi(@Param("doi") String doi);

    public List<EbookCounter> findAllByProprietaryIdentifier(@Param("proprietaryIdentifier") String proprietaryIdentifier);
	
}
