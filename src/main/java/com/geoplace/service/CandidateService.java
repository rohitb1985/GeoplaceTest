package com.geoplace.service;

import com.geoplace.db.beans.Candidate;

/**
 * Service Interface for Controller operations
 * @author Rohit
 *
 */
public interface CandidateService {

	public String getCandidateDetails(String name);
	public String getAllCandidateDetails();
	public String createCandidate(Candidate candidate);
	public String updateCandidateDetails(Candidate candidate);
	public String deleteCandidateDetails(String candidateName);
}
