package com.yarinnissan.springboothibernate.dao;

import com.yarinnissan.springboothibernate.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PersonDao {

    @Autowired
    private SessionFactory factory;

    public Session getSession(){
        Session session = factory.getCurrentSession();
        if(session == null){
            session = factory.openSession();
        }
        return session;
    }

    public void savePerson(Person person){
        getSession().save(person);
    }

//    @SuppressWarnings("deprecation")
//    public List<Person> getPersonList(){
////        return getSession().createCriteria(Person.class).list();
//        Query<Person> query = getSession().createQuery("FROM Person", Person.class);
//        return query.getResultList();
//    }
@SuppressWarnings("deprecation")
    public List<Person> getPersons(){
        JpaCriteriaQuery<Person> cq = getSession().getCriteriaBuilder().createQuery(Person.class);
        cq.from(Person.class);
        return getSession().createQuery(cq).getResultList();
    }
}
