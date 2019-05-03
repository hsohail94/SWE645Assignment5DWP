package com.haaris.swe645.hw5.beans;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.haaris.swe645.hw5.pojos.Student;
import com.haaris.swe645.hw5.pojos.WinningResult;
import com.haaris.swe645.hw5.utils.StudentService;

/**
 * Managed bean containing a reference to both Student and WinningResult POJOs
 * Also saves the data entered by the student, and sets navigation rules based on raffle numbers
 * @author haaris
 *
 */
@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class StudentSurveyBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Student student;
	public WinningResult winningResult;
	public List<Student> allStudents;
	
	public StudentSurveyBean () 
	{
		//this is needed to avoid null pointer issues
		this.student = new Student();
		this.winningResult = new WinningResult();
		this.allStudents = new ArrayList<Student>();
	}
	
	/**
	 * Business logic: if values are valid (handled by auto validation),
	 * send user to acknowledgement page. If values are valid, and mean of
	 * raffle numbers entered by user is > 90, send user to winner page
	 */
	public String submit() {
		StudentService stuServ = new StudentService();
		String[] raffleNumbers = student.getRaffle().split(",");
		double thisMean = stuServ.getMean(raffleNumbers);
		double thisStdDev = stuServ.getStdDev(thisMean, raffleNumbers);
		
		WinningResult input = new WinningResult();
		input.setMean(thisMean);
		input.setStdDev(thisStdDev);
		setWinningResult(input);
		
		String city = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("city");
		String state = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("state");
		
		if (city != null && state != null) {
			this.student.setCity(city);
			this.student.setState(state);
		}
				
		//make sure student survey info is written to a file
		stuServ.writeStudentDataToFile(student);
		
		//this list variable will be needed in the ListSurvey page
		try {
			this.allStudents = stuServ.getAllStudentsSoFar();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//clear fields just before submitting
		clearForm();
		
		//actual page names are in faces-config.xml
		if (thisMean > 90.00) 
		{
			return "WinnerAcknowledgement";
		}
		else
		{
			return "SimpleAcknowledgement";
		}
	}
	
	/**
	 * This method is invoked when the reset/clear button is called
	 */
	public void clearForm() {
		this.student.setEmailaddress(null);
		this.student.setStreetaddress(null);
		this.student.setPhonenumber(null);
		this.student.setZipcode(null);
		this.student.setHowFoundOut(null);
		this.student.setThingsMostLiked(null);
		this.student.setRecommendation(null);
		this.student.setRaffle(null);
		this.student.setSurveydate(null);
		this.student.setCity(null);
		this.student.setStartdate(null);
		this.student.setState(null);
	}
	
	/**
	 * Used in autocomplete input for recommendation options for Student form
	 * @return
	 */
	public List<String> getRecommendationOptions ()
	{
		List<String> recommendationOptions = new ArrayList<String>();
		recommendationOptions.add("Very likely");
		recommendationOptions.add("Likely");
		recommendationOptions.add("Unlikely");
		Collections.sort(recommendationOptions);
		return recommendationOptions;
	}
	
	/**
	 * Clear all components in form, and refresh page as empty
	 * @return
	 */
	public String clearAndReload() {
		this.student.setFirstname(null);
		this.student.setLastname(null);
		clearForm();
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return null;
	}

	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public WinningResult getWinningResult() {
		return winningResult;
	}


	public void setWinningResult(WinningResult winningResult) {
		this.winningResult = winningResult;
	}


	public List<Student> getAllStudents() {
		return allStudents;
	}


	public void setAllStudents(List<Student> allStudents) {
		this.allStudents = allStudents;
	}

}
