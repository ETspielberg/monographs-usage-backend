package unidue.ub.services.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import unidue.ub.media.analysis.CounterLog;

@RepositoryRestResource(collectionResourceRel = "counterlog", path = "counterlog")
public interface CounterLogRepository extends PagingAndSortingRepository<CounterLog, String> {
}
