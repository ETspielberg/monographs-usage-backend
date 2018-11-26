package unidue.ub.services.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import unidue.ub.media.analysis.DeletionList;

@RepositoryRestResource(collectionResourceRel = "deletionlist", path = "deletionlist")
public interface DeletionListRepository extends PagingAndSortingRepository<DeletionList, String> {
}
