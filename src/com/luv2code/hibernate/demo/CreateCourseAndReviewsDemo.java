package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			
			// create a course
			/*
			Course tempCourse = new Course("Pacman - How To Score One Million Points");
			Student tempStudent = new Student("Sandeepan", "Nath","sandeepan@luv2code.com");
			
			tempCourse.addStudent(tempStudent);
			
			session.save(tempCourse);
			
			session.save(tempStudent);
			*/
			
			int studentId = 3;
			Student student = session.get(Student.class, studentId);
			
			System.out.println("Courses of student "+student.getCourses());
			
			
			System.out.println("removing course "+student.getCourses().get(0)+" from student "+studentId);
			
			//student.removeCourse(student.getCourses().get(0));
			session.delete(student.getCourses().get(0));
			
			/*
			int reviewId = 1;
			
			Review review = session.get(Review.class, reviewId);
			System.out.println("course of review "+review.getCourse());
			
			*/
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}





