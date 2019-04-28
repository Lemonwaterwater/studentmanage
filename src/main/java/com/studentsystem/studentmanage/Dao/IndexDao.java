package com.studentsystem.studentmanage.Dao;


import com.studentsystem.studentmanage.Domain.Student;
import com.studentsystem.studentmanage.Domain.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional
public class IndexDao {
    @PersistenceContext
    private EntityManager entityManager;


  User user = new User();


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

    public void  update(User user){
        this.getSession().update(user);
    }

    public void  update(Student student){
        this.getSession().update(student);
    }

    public User findById(int id) {
        User user = (User)getSession().get(User.class, id);
        return user;
    }

    public Student findByNo(String stuNo){
        Student student = (Student)getSession().get(Student.class,stuNo);
        return student;
    }

    public User findByUsename(String username){										//查询数据库某字段数据
        DetachedCriteria dc = DetachedCriteria.forClass(User.class);
        dc.add(Restrictions.eq("username",username));
        Criteria b = dc.getExecutableCriteria(getSession());
        List<User>list=b.list();
        if(list != null && list.size()>0) {
            return list.get(0);
        }else{
            return null ;
        }

    }
}
