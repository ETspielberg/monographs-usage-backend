package unidue.ub.services.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import unidue.ub.media.analysis.EbookCounter;

@RepositoryRestResource(collectionResourceRel = "ebookcounter", path = "ebookcounter")
public interface EbookCounterRepository extends PagingAndSortingRepository<EbookCounter, String>{
	
}
