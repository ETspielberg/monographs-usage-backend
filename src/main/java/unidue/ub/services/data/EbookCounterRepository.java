package unidue.ub.services.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import unidue.ub.media.analysis.EbookCounter;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "ebookcounter", path = "ebookcounter")
public interface EbookCounterRepository extends PagingAndSortingRepository<EbookCounter, String>{
	
}
