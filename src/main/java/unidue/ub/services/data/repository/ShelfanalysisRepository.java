package unidue.ub.services.data.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import unidue.ub.media.analysis.Shelfanalysis;

@RepositoryRestResource(collectionResourceRel = "shelfanalysis", path = "shelfanalysis")
public interface ShelfanalysisRepository extends PagingAndSortingRepository<Shelfanalysis, Long> {
	
}
