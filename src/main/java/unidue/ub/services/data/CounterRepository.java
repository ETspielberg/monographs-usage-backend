package unidue.ub.services.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import unidue.ub.media.analysis.Counter;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "counter", path = "counter")
public interface CounterRepository extends PagingAndSortingRepository<Counter, Long>{
	
}
