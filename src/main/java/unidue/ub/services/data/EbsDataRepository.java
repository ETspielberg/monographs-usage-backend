package unidue.ub.services.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import unidue.ub.media.analysis.EbsData;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "ebsData", path = "ebsData")
public interface EbsDataRepository extends PagingAndSortingRepository<EbsData, String> {

    List<EbsData> getAllByEbsModel(@Param("ebsModel") String ebsModel);
}
