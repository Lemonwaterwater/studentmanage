package com.studentsystem.studentmanage.Dao;


import com.studentsystem.studentmanage.Domain.Student;
import com.studentsystem.studentmanage.Domain.User;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class IndexDao {
    @PersistenceContext
    private EntityManager entityManager;

    public Session getSession(){
        return entityManager.unwrap(Session.class);
    }

    public void save(User user){
        this.getSession().save(user);
    }

    public void save(Student student){
        this.getSession().save(student);
    }

    public void delete(Student student){
        this.getSession().delete(student);

    }
}
