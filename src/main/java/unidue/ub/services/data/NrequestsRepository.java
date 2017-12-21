package unidue.ub.services.data;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import unidue.ub.media.analysis.Nrequests;

import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "nrequests", path = "nrequests")
public interface NrequestsRepository  extends PagingAndSortingRepository<Nrequests, String> {

    @Query(value = "SELECT p.* FROM Nrequests p WHERE SUBSTRING(p.shelfmark,1,3) BETWEEN :startNotation AND :endNotation", nativeQuery = true)
    public List<Nrequests> getNrequestsForNotationgroup(@Param("startNotation") String startNotation, @Param("endNotation") String endNotation);

    @Query(value = "SELECT p.* FROM Nrequests p WHERE SUBSTRING(p.shelfmark,1,3) BETWEEN :startNotation AND :endNotation AND ratio >= :ratio AND n_requests >= :nrequests AND total_duration >= :duration AND date >= :startDate" +
            "", nativeQuery = true)
    public List<Nrequests> getFilteredNrequestsForNotationgroup(@Param("startNotation") String startNotation, @Param("endNotation") String endNotation, @Param("ratio") Double ratio, @Param("duration") Integer duration, @Param(value="nrequests") Integer thresholdNrequests, @Param("startDate") @Temporal(TemporalType.TIMESTAMP) Date startDate);
}
