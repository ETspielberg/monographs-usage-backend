package unidue.ub.services.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import unidue.ub.media.analysis.Eventanalysis;

@RepositoryRestResource(collectionResourceRel = "eventanalysis", path = "eventanalysis")
public interface EventanalysisRepository extends PagingAndSortingRepository<Eventanalysis, String> {
	
	List<Eventanalysis> findByStockcontrolId(@Param("stockcontrolId") String stockcontrolId);

	List<Eventanalysis> findByStockcontrolIdAndProposedDeletionGreaterThanEqual(@Param("stockcontrolId") String stockcontrolId, @Param("proposedDeletion") long proposedDeletion);

	@Query(value = "UPDATE eventanalysis SET status=:status WHERE stockcontrol_id=:identifier", nativeQuery = true)
	public void setEventanalysisStatusForStockcontrolIds(@Param("identifier") String identifier,@Param("status") String status);
}
