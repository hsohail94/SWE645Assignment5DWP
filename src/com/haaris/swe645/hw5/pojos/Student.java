package com.haaris.swe645.hw5.pojos;

import java.util.Arrays;
import java.util.Date;

/**
 * POJO representing the Student data that is
 * filled out in the form
 * @author haaris
 *
 */


public class Student {
	
	private String firstname;
	private String lastname;
	private String streetaddress;
	private String city;
	private String state;
	private String zipcode;
	private String phonenumber;
	private Date surveydate;
	private Date startdate;
	private String emailaddress;
	private String[] thingsMostLiked;
	private String howFoundOut;
	private String recommendation;
	private String raffle;
	
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
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public String[] getThingsMostLiked() {
		return thingsMostLiked;
	}
	public String getThingsMostLikedString() {
		return Arrays.toString(thingsMostLiked);
	}
	public void setThingsMostLiked(String[] thingsMostLiked) {
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
	public String getRaffle() {
		return raffle;
	}
	public void setRaffle(String raffle) {
		this.raffle = raffle;
	}
	
	
	/**
	 * Same as toString above, but in a more text file friendly format
	 * @return
	 */
	public String toStringCSV() {
		return firstname + "," + lastname + "," + streetaddress
				+ "," + zipcode + "," + phonenumber + "," + surveydate
				+ "," + emailaddress 
				+ "," + howFoundOut + "," + recommendation
				+ "," + city + "," + state
				+ "," + Arrays.toString(thingsMostLiked).replace(',', ';');
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
	@Override
	public String toString() {
		return "Student [firstname=" + firstname + ", lastname=" + lastname + ", streetaddress=" + streetaddress
				+ ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + ", phonenumber=" + phonenumber
				+ ", surveydate=" + surveydate + ", emailaddress=" + emailaddress + ", thingsMostLiked="
				+ Arrays.toString(thingsMostLiked) + ", howFoundOut=" + howFoundOut + ", recommendation="
				+ recommendation + ", raffle=" + raffle + "]";
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
}
