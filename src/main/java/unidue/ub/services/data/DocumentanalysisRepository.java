package unidue.ub.services.data;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import unidue.ub.media.analysis.Documentanalysis;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "documentanalysis", path = "documentanalysis")
public interface DocumentanalysisRepository extends PagingAndSortingRepository<Documentanalysis, Long> {
	
}
