package com.haaris.swe645.hw5.utils;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
	
	public List getStudents (String firstname) {
		
	}
	

}
