package unidue.ub.services.data;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "shelfanalysis", path = "shelfanalysis")
public interface ShelfAnalysisRepository  extends PagingAndSortingRepository<Shelfanalysis, Long> {
	
}
