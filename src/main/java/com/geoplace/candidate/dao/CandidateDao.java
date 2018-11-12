package com.geoplace.candidate.dao;

import java.util.List;

import com.geoplace.db.beans.Candidate;

/**
 * Interface for Database operations
 * @author Rohit
 *
 */
public interface CandidateDao {

	List<Candidate> getCandidateDetailsIgnoreCase(String name);
	List<Candidate> getCandidateDetails(String name);
	List<Candidate> getAllCandidateDetails();
	void saveCandidateInformation(Candidate candidate);
	int updateCandidateInformation(Candidate candidate);
	int deleteCandidateDetails(String name);
}
