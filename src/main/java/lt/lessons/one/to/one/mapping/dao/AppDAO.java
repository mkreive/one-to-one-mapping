package lt.lessons.one.to.one.mapping.dao;

import lt.lessons.one.to.one.mapping.entity.Instructor;
import lt.lessons.one.to.one.mapping.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
