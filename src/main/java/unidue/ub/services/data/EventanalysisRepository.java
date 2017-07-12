package unidue.ub.services.data;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import unidue.ub.media.analysis.Eventanalysis;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "eventanalysis", path = "eventanalysis")
public interface EventanalysisRepository extends PagingAndSortingRepository<Eventanalysis, Long> {
	
	List<Eventanalysis> findByStockcontrolId(@Param("stockcontrolId") String stockcontrolId);
}
