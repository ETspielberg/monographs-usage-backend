package unidue.ub.services.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import unidue.ub.media.analysis.Documentanalysis;

@RepositoryRestResource(collectionResourceRel = "documentanalysis", path = "documentanalysis")
public interface DocumentanalysisRepository extends PagingAndSortingRepository<Documentanalysis, Long> {
	
}
