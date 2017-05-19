package unidue.ub.services.data;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "eventanalysis", path = "eventanalysis")
public interface EventAnalysisRepository  extends PagingAndSortingRepository<Eventanalysis, Long> {
	
	List<Eventanalysis> findByStockControlAndAuthor(@Param("stockControl") String stockControl, @Param("author") String author);
}
