package unidue.ub.services.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import unidue.ub.media.analysis.DatabaseCounter;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "databasecounter", path = "databasecounter")
public interface DatabaseCounterRepository extends PagingAndSortingRepository<DatabaseCounter, String>{

    List<DatabaseCounter> getAllByTitle(String title);
	
}
