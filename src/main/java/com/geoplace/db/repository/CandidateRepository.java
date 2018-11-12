package com.geoplace.db.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.geoplace.db.beans.Candidate;
 
/**
 * JPA repository interface for database operations.
 * The implementation class is created by spring boot at runtime for the CRUD operations
 * @author Rohit
 *
 */
@Repository
public interface CandidateRepository extends CrudRepository<Candidate, Long>{

	List<Candidate> findCandidateByNameIgnoreCase(String name);
	List<Candidate> findCandidateByName(String name);
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Candidate c set c.interests = :interests, c.qualification = :qualifications, c.linkedInProfileUrl = :linkedInProfileUrl where c.name = :name")
	int updateCandidateDetails(@Param("interests") String interests, @Param("qualifications") String qualifications, 
			@Param("linkedInProfileUrl") String linkedInProfileUrl, @Param("name") String name);

	@Modifying
	@Transactional
	@Query("delete from Candidate c where c.name = :name")
	int deleteCandidateDetails(@Param("name") String name);
}
