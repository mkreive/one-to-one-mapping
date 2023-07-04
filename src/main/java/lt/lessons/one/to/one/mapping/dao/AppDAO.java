package lt.lessons.one.to.one.mapping.dao;

import lt.lessons.one.to.one.mapping.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);
}
