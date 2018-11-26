package unidue.ub.services.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import unidue.ub.services.data.model.Service;

@RepositoryRestResource(collectionResourceRel = "service", path = "service")
public interface ServiceRepository extends PagingAndSortingRepository<Service, String> {
}
