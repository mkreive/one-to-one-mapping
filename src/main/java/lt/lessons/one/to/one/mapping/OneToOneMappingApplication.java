package lt.lessons.one.to.one.mapping;

import lt.lessons.one.to.one.mapping.dao.AppDAO;
import lt.lessons.one.to.one.mapping.entity.Instructor;
import lt.lessons.one.to.one.mapping.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OneToOneMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneMappingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// CRUD
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);

//			finsInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 3;
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

	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Deleting instructor by id: " + id);
		appDAO.deleteInstructorById(id);
		System.out.println("Deleted!");
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding instructor id: " + id);
		Instructor tempInstructor = appDAO.findInstructorById(id);
		System.out.println("Temp instructor: " + tempInstructor);
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Candy", "Candy", "candy@mail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("http//www.youtube.com/candy", "guitar");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done!");
	}
}
