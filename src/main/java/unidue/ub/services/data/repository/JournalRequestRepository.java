package unidue.ub.services.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import unidue.ub.media.analysis.JournalRequest;

@RepositoryRestResource(collectionResourceRel = "journalrequest", path = "journalrequest")
public interface JournalRequestRepository  extends PagingAndSortingRepository<JournalRequest, Long> {
	

}
