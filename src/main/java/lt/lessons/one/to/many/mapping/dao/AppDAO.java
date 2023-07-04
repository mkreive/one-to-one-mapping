package lt.lessons.one.to.many.mapping.dao;

import lt.lessons.one.to.many.mapping.entity.Course;
import lt.lessons.one.to.many.mapping.entity.Instructor;
import lt.lessons.one.to.many.mapping.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    // Instructor CRUD
    void save(Instructor instructor);

    void update(Instructor instructor);

    Instructor findInstructorById(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void deleteInstructorById(int id);


    // Details CRUD
    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);


    // Courses CRUD
    Course findCourseById(int id);

    List<Course> findCoursesByInstructorId(int id);

    void update(Course course);

    void deleteCourseById(int id);


}
