package unidue.ub.services.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import unidue.ub.services.data.model.Contactperson;

@RepositoryRestResource(collectionResourceRel = "contactperson", path = "contactperson")
public interface ContactPersonRepository extends PagingAndSortingRepository<Contactperson, String> {
}
