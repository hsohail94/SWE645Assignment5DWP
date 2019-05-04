package com.haaris.swe645.hw5.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.haaris.swe645.hw5.pojos.Student;

/**
 * This class creates the entity manager unit, and has methods for interacting with the database
 * @author haaris
 *
 */
public class StudentDataLayer {
	
	private final String PERSISTANCE_UNIT_NAME = "StudentUnit";
	private EntityManagerFactory studentEntityFactory;
	
	//Entity factory creation is handled in the default constructor
	public StudentDataLayer () {
		studentEntityFactory = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
	}
	
	/**
	 * Return all students from the database based on args passed in by the user
	 * 
	 * To support being able to query with multiple combinations, I am using a hashmap as the set of parameters
	 * This hashmap will have key-value pairs, corresponding to columns in the Student table
	 * 
	 * @param args
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<StudentEntity> getStudents (HashMap<String,String> args) {
		String queryArgs = "";
		
		Iterator it = args.entrySet().iterator();
		
		while (it.hasNext()) {
			Map.Entry<String, String> queryArg = (Map.Entry<String, String>)it.next();
			queryArgs += queryArg.getKey() + "=" + queryArg.getValue();
			if (it.hasNext())
				queryArgs += " AND ";
		}
		
		EntityManager studentEM = studentEntityFactory.createEntityManager();
		Query getQuery = studentEM.createQuery("SELECT * FROM STUDENT WHERE " + queryArgs);
		List<StudentEntity> resultStudents = getQuery.getResultList();
		
		studentEM.close();
		
		return resultStudents;
		
	}
	
	/**
	 * This method will take the input given by the student in the survey form,
	 * and create a corresponding row for it in the database
	 * @param s
	 */
	public void createStudent (Student student) {
		EntityManager studentEM = studentEntityFactory.createEntityManager();
		studentEM.getTransaction().begin();
		
		//create student entity object using Student POJO data
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setFirstname(student.getFirstname());
		studentEntity.setLastname(student.getLastname());
		studentEntity.setCity(student.getCity());
		studentEntity.setZipcode(student.getZipcode());
		studentEntity.setState(student.getState());
		studentEntity.setEmailaddress(student.getEmailaddress());
		studentEntity.setThingsMostLiked(Arrays.toString(student.getThingsMostLiked()));
		studentEntity.setHowFoundOut(student.getHowFoundOut());
		studentEntity.setRecommendation(student.getRecommendation());
		java.sql.Date sqlStartdate = new java.sql.Date(student.getStartdate().getTime());
		studentEntity.setStartdate(sqlStartdate);
		java.sql.Date sqlSurveydate = new java.sql.Date(student.getSurveydate().getTime());
		studentEntity.setSurveydate(sqlSurveydate);
		
		studentEM.persist(studentEntity);
		studentEM.getTransaction().commit();
		studentEM.close();
	}
	
	/**
	 * Delete the student with the corresponding auto-generated ID from the database
	 * @param id
	 */
	public void deleteStudent (int id) {
		EntityManager studentEM = studentEntityFactory.createEntityManager();
		studentEM.getTransaction().begin();
		
		StudentEntity studentDeleted = studentEM.find(StudentEntity.class, id);
		studentEM.remove(studentDeleted);
		studentEM.getTransaction().commit();
		studentEM.close();
	}
	

}
