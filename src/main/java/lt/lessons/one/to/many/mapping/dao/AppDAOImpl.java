package lt.lessons.one.to.many.mapping.dao;

import jakarta.persistence.EntityManager;
import lt.lessons.one.to.many.mapping.entity.Instructor;
import lt.lessons.one.to.many.mapping.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {

    private EntityManager entityManager;
    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional // transactional used because we do modifications in database
    public void deleteInstructorById(int id) {
        Instructor tempInstructor = entityManager.find(Instructor.class, id);
        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, id);
        // after deletion set to null, when cascadetype.remove not added
        tempInstructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(tempInstructorDetail);
    }
}
