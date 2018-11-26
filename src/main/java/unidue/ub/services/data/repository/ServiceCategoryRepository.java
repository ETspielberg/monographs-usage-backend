package unidue.ub.services.data.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import unidue.ub.services.data.model.Servicecategory;

@RepositoryRestResource(collectionResourceRel = "servicecategory", path = "servicecategory")
public interface ServiceCategoryRepository extends PagingAndSortingRepository<Servicecategory,String> {

}
