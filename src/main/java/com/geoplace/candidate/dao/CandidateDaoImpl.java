package com.geoplace.candidate.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.geoplace.db.beans.Candidate;
import com.geoplace.db.repository.CandidateRepository;

/**
 * Implementation class for CandidateDao interface
 * @author Rohit
 *
 */
@Repository
public class CandidateDaoImpl implements CandidateDao {

	@Autowired
	CandidateRepository candidateRepository;
	
	/**
	 * Method to return the candidate details based on candidate name ignoring the case
	 */
	public List<Candidate> getCandidateDetailsIgnoreCase(String name) {
		List<Candidate> candidateList = candidateRepository.findCandidateByNameIgnoreCase(name);
		return candidateList;
	}
	
	/**
	 * Method to return the candidate details matching the exact candidate name
	 */
	public List<Candidate> getCandidateDetails(String name) {
		List<Candidate> candidateList = candidateRepository.findCandidateByName(name);
		return candidateList;
	}

	/**
	 * Method to save the candidate information
	 */
	public void saveCandidateInformation(Candidate candidate) {
		candidateRepository.save(candidate);
	}

	/**
	 * Method to return the list of all candidates
	 */
	public List<Candidate> getAllCandidateDetails() {
		Iterable<Candidate> candidateListItr = candidateRepository.findAll();
		List<Candidate> candidateList = new ArrayList<Candidate>();
		candidateListItr.forEach(candidateList::add);
		return candidateList;
	}

	/**
	 * Method to delete a candidate information
	 */
	public int deleteCandidateDetails(String name) {
		int result = candidateRepository.deleteCandidateDetails(name);
		return result;
	}

	/**
	 * Method to update the candidate information
	 */
	public int updateCandidateInformation(Candidate candidate) {
		int result = candidateRepository.updateCandidateDetails(candidate.getInterests(), candidate.getQualification(), 
				candidate.getLinkedInProfileUrl(), candidate.getName());
		return result;
	}

}
