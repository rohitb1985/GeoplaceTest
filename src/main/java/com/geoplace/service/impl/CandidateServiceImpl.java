package com.geoplace.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geoplace.candidate.dao.CandidateDao;
import com.geoplace.db.beans.Candidate;
import com.geoplace.service.CandidateService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * The implementation class for the Candidate Service interface 
 * @author Rohit
 *
 */
@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	CandidateDao candidateDao;
	
	/**
	 * Get the candidate details based on the username ignoring the case 
	 * i.e. Rohit & rohit both will be returned in the response if name is Rohit
	 */
	public String getCandidateDetails(String name) {
		Gson gson = new GsonBuilder().enableComplexMapKeySerialization().disableHtmlEscaping()
				.setPrettyPrinting().create();
		
		List<Candidate> candidateList = candidateDao.getCandidateDetailsIgnoreCase(name);
		if(candidateList.isEmpty())
			return "Candidate not found";
		else
			return gson.toJson(candidateList);
	}

	/**
	 * Store the candidate information the database aafter checking the same candidate doesn't exist.
	 * If same name candidates exist, linkedin profile url are matched.
	 */
	public String createCandidate(Candidate candidate) {
		List<Candidate> candidateList = candidateDao.getCandidateDetailsIgnoreCase(candidate.getName());
		if(candidateList.isEmpty()){
			candidateDao.saveCandidateInformation(candidate);
			return "Candidate Details saved successfully";
		}else{
			List<Candidate> filteredCandidateList = candidateList.stream().
					filter(c->c.getLinkedInProfileUrl().equalsIgnoreCase(candidate.getLinkedInProfileUrl())).
					collect(Collectors.toList());
			if(filteredCandidateList.isEmpty()){
				candidateDao.saveCandidateInformation(candidate);
				return "Candidate Details saved successfully";
			}else{
				return "Candidate Information already exists.";
			}
		}
	}

	/**
	 * Returns a list of all candidates
	 */
	public String getAllCandidateDetails() {
		Gson gson = new GsonBuilder().enableComplexMapKeySerialization().disableHtmlEscaping()
				.setPrettyPrinting().create();
		
		List<Candidate> candidateList = candidateDao.getAllCandidateDetails();
		return gson.toJson(candidateList);
	}

	/**
	 * Update the candidate details if exist
	 */
	public String updateCandidateDetails(Candidate candidate) {
		List<Candidate> candidateList = candidateDao.getCandidateDetails(candidate.getName());
		if(candidateList.isEmpty()){
			return "Candidate details not found";
		}else{
			int result = candidateDao.updateCandidateInformation(candidate);
			if(result == 1)
				return "Candidate Details updated successfully.";
			else
				return "Candidate Details could not be updated";
		}
	}

	/**
	 * Delete the candidate information if exists. 
	 */
	public String deleteCandidateDetails(String candidateName) {
		int result = candidateDao.deleteCandidateDetails(candidateName);
		if(result == 1)
			return "Candidate Details deleted successfully.";
		else
			return "Candidate Details could not be deleted.";
	}

}
