package lt.lessons.one.to.many.mapping;

import lt.lessons.one.to.many.mapping.dao.AppDAO;
import lt.lessons.one.to.many.mapping.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class OneToManyMapping {

	public static void main(String[] args) {
		SpringApplication.run(OneToManyMapping.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createCourseAndStudents(appDAO);
//			findCourseAndStudents(appDAO);
//			findStudentAndCourses(appDAO);
//			addCoursesToStudent(appDAO);

//			deleteCourse(appDAO);
//			deleteStudent(appDAO);


		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int id = 1;
		System.out.println("Deleting student by id: " + id);
		appDAO.deleteStudentById(id);
		System.out.println("Deleted!");
	}

	private void addCoursesToStudent(AppDAO appDAO) {
		int id = 1;
		Student student = appDAO.findStudentAndCoursesByStudentId(id);
		Course newCourse1 = new Course("How to speed rubic's cube");
		Course newCourse2 = new Course("Game development");

		student.addCourse(newCourse1);
		student.addCourse(newCourse2);

		System.out.println("Updating student: " + student);
		System.out.println("Courses: " + student.getCourses());

		appDAO.update(student);
		System.out.println("Done!");
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding student with id: " + id);
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(id);
		System.out.println("Found student: " + tempStudent);
		System.out.println("Courses: " + tempStudent.getCourses());
		System.out.println("Done!");
	}


	// Instructor Methods
	private void createInstructor(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Candy", "Candy", "candy@mail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("http//www.youtube.com/candy", "guitar");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Candy", "Candy", "candy@mail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("http//www.youtube.com/candy", "guitar");
		Course tempCourse1 = new Course("Air Guitar");
		Course tempCourse2 = new Course("Pinball Masterclass");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		appDAO.save(tempInstructor);
		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("Courses : " + tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor with id: " + id);

		Instructor tempInstructor = appDAO.findInstructorById(id);
		System.out.println("Temp Instructor: " + tempInstructor);

		System.out.println("Updating instructor with id: " + id);
		tempInstructor.setLastName("TESTER");

		appDAO.update(tempInstructor);
		System.out.println("DONE!");

	}

	private void findInstructor(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding instructor id: " + id);
		Instructor tempInstructor = appDAO.findInstructorById(id);
		System.out.println("Temp instructor: " + tempInstructor);
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor with id: " + id);
		Instructor tempInstructor = appDAO.findInstructorById(id);
		System.out.println("Temp Instructor: " + tempInstructor);
		System.out.println("Courses: " + tempInstructor.getCourses());
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor with id: " + id);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(id);
		System.out.println("Temp Instructor: " + tempInstructor);
		System.out.println("Courses: " + tempInstructor.getCourses());
		System.out.println("DONE!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Deleting instructor by id: " + id);
		appDAO.deleteInstructorById(id);
		System.out.println("Deleted!");
	}


	// Courses Methods
	private void createCourseAndReviews(AppDAO appDAO) {
		Course course = new Course("Pacman - How to score one million points");
		course.addReview(new Review("Great course...loved it!"));
		course.addReview(new Review("Cool course, job well done!"));
		course.addReview(new Review("What a dumb course, you are an idiot!"));

		System.out.println("Saving the course");
		System.out.println(course);
		System.out.println(course.getReviews());

		appDAO.save(course);
		System.out.println("Done");
	}

	private void findCourseAndReviews(AppDAO appDAO) {
		int id = 10;
		System.out.println("Finding course with id: " + id);

		Course tempCourse = appDAO.findCourseAndReviewsByCOurseId(id);
		System.out.println("Temp Course: " + tempCourse);
		System.out.println(tempCourse.getReviews());
		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO) {
		int id = 10;
		System.out.println("Finding course with id: " + id);

		Course tempCourse = appDAO.findCourseById(id);
		System.out.println("Temp Course: " + tempCourse);

		System.out.println("Updating course with id: " + id);
		tempCourse.setTitle("Enjoy the simple things");

		appDAO.update(tempCourse);
		System.out.println("DONE!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		// with lazy loading
		int id = 1;
		System.out.println("Finding instructor with id: " + id);
		Instructor tempInstructor = appDAO.findInstructorById(id);
		System.out.println("Temp Instructor: " + tempInstructor);
		System.out.println("Finding courses for instructor with id: " + id);
		List<Course> courses = appDAO.findCoursesByInstructorId(id);
		tempInstructor.setCourses(courses);
		System.out.println("Courses: " + tempInstructor.getCourses());
		System.out.println("DONE!");
	}

	private void findCourseAndStudents(AppDAO appDAO) {

		int id = 10;
		Course course = appDAO.findCourseAndStudentByCOurseId(id);
		System.out.println("Loaded course: " + course);
		System.out.println("Students: " + course.getStudents());
		System.out.println("Done!");
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		Course tempCourse = new Course("Pacman - How to score one million points");
		Student tempStudent1 = new Student("John", "Doe", "johndoe@mail.com");
		Student tempStudent2 = new Student("Mary", "Pubic", "marypubic@mail.com");

		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		System.out.println("Saving course: " + tempCourse + " and students: " + tempStudent1 + ", " +  tempStudent2 );
		appDAO.save(tempCourse);
		System.out.println("Done!");
	}

	private void deleteCourse(AppDAO appDAO) {
		int id = 10;
		System.out.println("Deleting course by id: " + id);
		appDAO.deleteCourseById(id);
		System.out.println("Deleted!");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int id = 10;
		System.out.println("Finding course with id: " + id);

		appDAO.deleteCourseById(id);
		System.out.println("done!");

	}


	// Details Methods
	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 2;
		System.out.println("Deleting instructor detail by id: " + id);
		appDAO.deleteInstructorDetailById(id);
		System.out.println("Deleted!");
	}

	private void finsInstructorDetail(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor Detail with id: " + id);
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(id);
		System.out.println("Temp instructor detail: " + tempInstructorDetail);
		System.out.println("An associated instructor: " +  tempInstructorDetail.getInstructor());
	}


}
