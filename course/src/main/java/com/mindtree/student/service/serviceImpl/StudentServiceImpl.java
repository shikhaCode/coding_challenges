package com.mindtree.student.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.student.entity.Course;
import com.mindtree.student.entity.Duration;
import com.mindtree.student.entity.Student;
import com.mindtree.student.exception.StudentIdDoesntExistException;
import com.mindtree.student.repository.CourseRepository;
import com.mindtree.student.repository.DurationRepository;
import com.mindtree.student.repository.StudentRepository;
import com.mindtree.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	CourseRepository repoC;
	@Autowired
	StudentRepository repoS;
	
	@Autowired
	DurationRepository repoD;
	
	Map<Integer,Integer > mapping=new HashMap<Integer,Integer>();
	

	@Override
	public Course addCourse(Course course) {
		course = repoC.save(course);
		return course;
	}
	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		student = repoS.save(student);
	return student;
	}
	@Override
	public List<Course> getCourse() {
		List<Course> cou = new ArrayList<Course>();
		return repoC.findAll();
	}
	@Override
	public List<Course> getCourseList(String courseInstructor) {
		// TODO Auto-generated method stub
		return repoC.findByInstructor(courseInstructor);
	}

	@Override
	public Student getOne(int studentId) {
		return repoS.findById(studentId).get();
	}

	@Override
	public Course getOneCourse(int courseId) {
		// TODO Auto-generated method stub

		return repoC.findById(courseId).get();
	}

	@Override
	public Course getOneCourseName(String courseName) {
		// TODO Auto-generated method stub

		return repoC.findbyName(courseName);

	}

	/*
	 * @Override public List<Course> getCoursesByRating(int rating) { return
	 * repoC.findByRating(rating);
	 * }
	 */
	@Override
	public List<Course> getCoursesByRatings() {
		// TODO Auto-generated method stub
		
		return repoC.findByRating();
	}
	@Override
	public Course getAllRating(int rating) {
		// TODO Auto-generated method stub
		
		return repoC.findByRating(rating);
	}

	@Override
	public List<Student> getFemales() {
		// TODO Auto-generated method stub
		
	return  repoS. findbyNameFemale("female");
		
	}
	
	@Override
	public List<String> getStudentsEnrolled() {

		 return  repoC.findallCourse();
	}
	@Override
	public Student mappingIdwithName(List<Course> courseName, int studentId) throws StudentIdDoesntExistException {
		Student student =repoS.findById(studentId).orElseThrow(()->new StudentIdDoesntExistException("student id doesnt exist"));
		int duration=0;
		duration=courseName.stream().map(x->x.getDuration()).reduce(0, (x,y)->x+y);
	for(int i=0;i<courseName.size();i++) {
		duration=duration+courseName.get(i).getDuration();
	}
		mapping.put(studentId, duration);
		student.getCourse().addAll(courseName);
		repoS.save(student);
		int totalDuration=mapping.get(studentId);
		Duration duration1=new Duration(studentId,totalDuration);
		repoD.save(duration1);
		return student;
	}
	
	
	

}
