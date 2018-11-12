package com.geoplace.test;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.geoplace.db.beans.Candidate;
import com.geoplace.db.repository.CandidateRepository;

/**
 * Test Class to test the database operations
 * @author Rohit
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class CandidateJpaTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	CandidateRepository repository;
	
	@Test
	public void test_getCandidateDetails_No_Candidate_found(){
		String candidateName = "Rohit1";
		List<Candidate> candidateList = repository.findCandidateByName(candidateName);
		Assert.assertTrue(candidateList.isEmpty());;
 	}
	
	@Test
	public void test_createCandidate(){
		Candidate candidate = new Candidate("Rohit", "B.Tech", "Reading", "http://linkedin.com");
		Candidate savedCandidate = repository.save(candidate);
		Assert.assertNotNull(savedCandidate);
	}
	
	@Test
	public void test_getCandidateDetails_Candidate_found(){
		Candidate candidate = new Candidate("Rohit", "B.Tech", "Reading", "http://linkedin.com");
		entityManager.persist(candidate);
		String candidateName = "Rohit";
		List<Candidate> candidateList = repository.findCandidateByName(candidateName);
		Assert.assertFalse(candidateList.isEmpty());
 	}
	
	@Test
	public void test_updateCandidateDetails(){
		Candidate candidate = new Candidate("Rohit", "B.Tech", "Reading", "http://linkedin.com");
		entityManager.persist(candidate);
		
		Candidate updatedCandidate = new Candidate("Rohit", "B.Tech", "Reading & Playing", "http://linkedin.com");
		repository.updateCandidateDetails(updatedCandidate.getInterests(), updatedCandidate.getQualification(), 
				updatedCandidate.getLinkedInProfileUrl(), updatedCandidate.getName());
		String candidateName = "Rohit";
		List<Candidate> candidateList = repository.findCandidateByName(candidateName);
		Assert.assertEquals("Reading & Playing", candidateList.get(0).getInterests());
	}
	
	@Test
	public void test_deleteCandidateDetails(){
		Candidate candidate = new Candidate("Rohit", "B.Tech", "Reading", "http://linkedin.com");
		entityManager.persist(candidate);
		String candidateName = "Rohit";
		repository.deleteCandidateDetails(candidateName);
		List<Candidate> candidateList = repository.findCandidateByName(candidateName);
		Assert.assertTrue(candidateList.isEmpty());
	}
	
	
}
