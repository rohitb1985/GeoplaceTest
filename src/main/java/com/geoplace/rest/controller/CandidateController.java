package com.geoplace.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.geoplace.db.beans.Candidate;
import com.geoplace.service.CandidateService;

/**
 * Controller class for the rest operations
 * @author Rohit
 *
 */
@RestController
@RequestMapping("/v1/api")
public class CandidateController {

	@Autowired
	CandidateService service;
	
	/**
	 * Rest operation to get candidate details based on username
	 * @param username
	 * @return
	 */
	@RequestMapping(value="/getCandidateDetails/{username}", method=RequestMethod.GET)
	public String getCandidateDetails(@PathVariable("username") String username){
		return service.getCandidateDetails(username);
	}
	
	/**
	 * Rest operation to return all candidate information
	 * @return
	 */
	@RequestMapping(value="/getAllCandidateDetails", method=RequestMethod.GET)
	public String getAllCandidates(){
		return service.getAllCandidateDetails();
	}
	
	/**
	 * Rest operation to create a new candidate
	 * @param candidate
	 * @return
	 */
	@RequestMapping(value="/createCandidate", method=RequestMethod.POST)
	public String createCandidate(@RequestBody Candidate candidate){
		return service.createCandidate(candidate);
	}
	
	/**
	 * Rest operation to update an existing user
	 * @param candidate
	 * @return
	 */
	@RequestMapping(value="/updateCandidate", method=RequestMethod.PUT)
	public String updateCandidateDetails(@RequestBody Candidate candidate){
		return service.updateCandidateDetails(candidate);
	}
	
	/**
	 * Rest operation to delete an existing user
	 * @param candidateName
	 * @return
	 */
	@RequestMapping(value="/deleteCandidate/{candidateName}", method=RequestMethod.DELETE)
	public String deleteCandidateDetails(@PathVariable String candidateName){
		return service.deleteCandidateDetails(candidateName);
	}
}
