package unidue.ub.services.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import unidue.ub.media.analysis.JournalRequest;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "journalrequest", path = "journalrequest")
public interface JournalRequestRepository  extends PagingAndSortingRepository<JournalRequest, Long> {
	

}