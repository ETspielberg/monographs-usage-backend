package unidue.ub.services.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import unidue.ub.media.analysis.Journaldata;


@RepositoryRestResource(collectionResourceRel = "journaldata", path = "journaldata")
public interface JournaldataInterface extends PagingAndSortingRepository<Journaldata,String> {
}
