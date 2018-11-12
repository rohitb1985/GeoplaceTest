package com.geoplace.db.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Database bean class for the candidate information
 * @author Rohit
 *
 */
@Entity
@Table(name="Candidate")
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;
	private String qualification;
	private String interests;
	private String linkedInProfileUrl;
	
	protected Candidate(){
	}
	
	public Candidate(String name, String qualification, String interests,
			String linkedInProfileUrl) {
		super();
		this.name = name;
		this.qualification = qualification;
		this.interests = interests;
		this.linkedInProfileUrl = linkedInProfileUrl;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getInterests() {
		return interests;
	}
	public void setInterests(String interests) {
		this.interests = interests;
	}
	public String getLinkedInProfileUrl() {
		return linkedInProfileUrl;
	}
	public void setLinkedInProfileUrl(String linkedInProfileUrl) {
		this.linkedInProfileUrl = linkedInProfileUrl;
	}
	
	
}
