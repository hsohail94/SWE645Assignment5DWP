package com.haaris.swe645.hw5.utils;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity manager for the Student POJO, which corresponds to the STUDENT table in MySQL
 * @author haaris
 *
 */

@Entity
@Table(name="STUDENT")
public class StudentEntity {
	
	public StudentEntity () {}
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="FIRSTNAME")
	private String firstname;
	
	@Column(name="LASTNAME")
	private String lastname;
	
	@Column(name="STREETADDRESS")
	private String streetaddress;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="ZIPCODE")
	private String zipcode;
	
	@Column(name="PHONENUMBER")
	private String phonenumber;
	
	@Column(name="SURVEYDATE")
	private Date surveydate;
	
	@Column(name="STARTDATE")
	private Date startdate;
	
	@Column(name="EMAILADDRESS")
	private String emailaddress;
	
	@Column(name="THINGSMOSTLIKED")
	private String thingsMostLiked;
	
	@Column(name="HOWFOUNDOUT")
	private String howFoundOut;
	
	@Column(name="RECOMMENDATION")
	private String recommendation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getStreetaddress() {
		return streetaddress;
	}

	public void setStreetaddress(String streetaddress) {
		this.streetaddress = streetaddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Date getSurveydate() {
		return surveydate;
	}

	public void setSurveydate(Date surveydate) {
		this.surveydate = surveydate;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public String getThingsMostLiked() {
		return thingsMostLiked;
	}

	public void setThingsMostLiked(String thingsMostLiked) {
		this.thingsMostLiked = thingsMostLiked;
	}

	public String getHowFoundOut() {
		return howFoundOut;
	}

	public void setHowFoundOut(String howFoundOut) {
		this.howFoundOut = howFoundOut;
	}

	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

}
