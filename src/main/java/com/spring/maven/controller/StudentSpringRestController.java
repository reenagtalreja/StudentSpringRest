package com.spring.maven.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.maven.bean.Student;

@RestController
public class StudentSpringRestController {
	//private static final Logger logger = LoggerFactory.getLogger(StudentRestServiceController.class);
	private static Map<String,Student> studentsData = new HashMap<String,Student>();
	 
    @RequestMapping("/students")
    public @ResponseBody List<Student> getAllStudents()
    {
      Set<String> set = studentsData.keySet();
      Iterator<String> it = set.iterator();
      List<Student> students = new ArrayList<Student>();
      //Added just to test if json is working with get request or not
      //This works fine
      Student s1 = new Student("1001","Teena","Roy","UTD");
      Student s2 = new Student("1002","Beena","Roy","UTD");
      students.add(s1);
      students.add(s2);
      while(it.hasNext())
        {
         String id = it.next();
         students.add(studentsData.get(id));
        } 
      return students;
    }
    @RequestMapping("/student/{studentId}")
    public @ResponseBody Student getStudent(@PathVariable("studentId") String id)
    {
      return studentsData.get(id); 
    }
   @RequestMapping(value ="/student/delete/{studentId}" ,method=RequestMethod.DELETE)
   public @ResponseBody Student deleteStudent(@PathVariable("studentId") String id)
   {
     return studentsData.remove(id);
   }
   //After adding produces and consumes no response is returned from soapui
   /*@RequestMapping(value ="/student/add",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},method=RequestMethod.POST)*/
   //This throws HTTP Status 415 – Unsupported Media Type from soapui and postman
   @RequestMapping(value ="/student/add",method=RequestMethod.POST)
   public @ResponseBody Student  addStudent(@RequestBody Student student)
   {
	 //Some problem with logging dependencies as after adding logging dependencies static data bind error is thrown while deployment
     //Has to figure out that 	   
	//   logger.info("Start createEmployee.");
	//   System.out.println("Begin");
      studentsData.put(student.getStudentId(), student);
      return student;
   }
}
