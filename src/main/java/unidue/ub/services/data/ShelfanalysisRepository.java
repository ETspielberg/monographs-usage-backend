package unidue.ub.services.data;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import unidue.ub.media.analysis.Shelfanalysis;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "shelfanalysis", path = "shelfanalysis")
public interface ShelfanalysisRepository extends PagingAndSortingRepository<Shelfanalysis, Long> {
	
}
