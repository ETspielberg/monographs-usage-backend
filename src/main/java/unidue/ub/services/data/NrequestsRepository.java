package unidue.ub.services.data;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import unidue.ub.media.analysis.Nrequests;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "nrequests", path = "nrequests")
public interface NrequestsRepository  extends PagingAndSortingRepository<Nrequests, Long> {

    @Query(value = "SELECT p.* FROM Nrequests p WHERE SUBSTRING(p.shelfmark,1,3) BETWEEN :startNotation AND :endNotation", nativeQuery = true)
    public List<Nrequests> getNrequestsForNotationgroup(String startNotation, String endNotation);
	
}
