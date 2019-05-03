package com.haaris.swe645.hw5.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.haaris.swe645.hw5.pojos.Student;

/**
 * Business logic class for doing the following:
 * 
 * - storing student results in a database
 * - calculating standard deviation and mean
 * @author haaris
 *
 */
public class StudentService 
{
	
	public StudentService() {}

	/**
	 * Calculate the average of the raffle values passed in by the user
	 * 
	 * @param numbersArray
	 * @return
	 */
	public double getMean(String[] numbersArray)
	{
		double[] intnumbers = new double[numbersArray.length];
		for (int i = 0; i < numbersArray.length; i++)
		{
			intnumbers[i] = Double.parseDouble(numbersArray[i]);
		}
		
		double count = 0.00;
		for (int i = 0; i < intnumbers.length; i++)
		{
			count += intnumbers[i];
		}
		return (count / intnumbers.length);
	}
	
	/**
	 * Calculate the standard deviation of the raffle numbers passed in by
	 * the user
	 * 
	 * @param meanArg
	 * @param numbersArray
	 * @return
	 */
	public double getStdDev (double meanArg, String[] numbersArray)
	{
		double mean = meanArg;
		
		double[] intnumbers = new double[numbersArray.length];
		for (int i = 0; i < numbersArray.length; i++)
		{
			intnumbers[i] = Double.parseDouble(numbersArray[i]);
		}
		
		double minusMeanSum = 0.00;
		double operand;
		for (int i = 0; i < intnumbers.length; i++)
		{
			operand = intnumbers[i] - mean;
			minusMeanSum += Math.pow(operand, 2);
		}
		
		double toBeRoot = (minusMeanSum / (double)intnumbers.length);
		return Math.sqrt(toBeRoot);
	}
	
	/**
	 * Use the string representation of the Student that comes from its toStringCSV method
	 * and write that information to a text file
	 * 
	 * @param s
	 */
	public void writeStudentDataToFile(Student s)
	{
		String filePath = System.getProperty("user.dir")+"students.txt";
		File studentsFile = new File(filePath);
		String studentInfo = s.toStringCSV();
		
		try {
			studentsFile.createNewFile(); 		
			FileOutputStream studentFileStream = new FileOutputStream(studentsFile, true);
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(studentFileStream));
			bufferedWriter.write(studentInfo);
			bufferedWriter.newLine();
			bufferedWriter.close();
			studentFileStream.close();
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Read the file that holds student survey data, and
	 * return the results as an ArrayList of students,
	 * which will then be iterated through in a dataTable in the
	 * ListSurvey page
	 * @return
	 * @throws ParseException 
	 */
	public List<Student> getAllStudentsSoFar() throws ParseException {
		List<Student> studentsList = new ArrayList<Student>();
		String filePath = System.getProperty("user.dir")+"students.txt";
		File studentsFile = new File(filePath);
		try {
			FileInputStream studentFileStream = new FileInputStream (studentsFile);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(studentFileStream));
			String line;
			//read through each line, split it by comma, and remake a Student object from it
			while ((line = bufferedReader.readLine()) != null)
			{
				Student s = new Student();
				String[] lineSplit = line.split(",");
				String[] mostLiked = lineSplit[lineSplit.length-1].replace("[", "")
										.replace("]","").split(";");
				
				System.out.println("Current line: " + line);
				
				s.setFirstname(lineSplit[0]);
				s.setLastname(lineSplit[1]);
				s.setStreetaddress(lineSplit[2]);
				s.setZipcode(lineSplit[3]);
				s.setPhonenumber(lineSplit[4]);
				SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH);				
				Date date = sdf.parse(lineSplit[5]);
				s.setSurveydate(date);
				s.setEmailaddress(lineSplit[6]);
				s.setHowFoundOut(lineSplit[7]);
				s.setRecommendation(lineSplit[8]);
				s.setCity(lineSplit[9]);
				s.setState(lineSplit[10]);
				s.setThingsMostLiked(mostLiked);
				studentsList.add(s);
			}
			bufferedReader.close();
			studentFileStream.close();
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return studentsList;

	}

}
