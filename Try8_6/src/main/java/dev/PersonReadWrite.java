package dev;


import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.*;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Stateless
public class PersonReadWrite {

    @PersistenceContext(unitName = "person")
    private EntityManager entityManager;

    public void addPerson (Person person){
        entityManager.persist(person);
    }

    public List<Person> getAllPersons(){
        CriteriaQuery<Person> cq = entityManager.getCriteriaBuilder().createQuery(Person.class);
        cq.select(cq.from(Person.class));
        return entityManager.createQuery(cq).getResultList();
    }

    public void clear(){
        Query removeAll = entityManager.createQuery("delete from Person");
        removeAll.executeUpdate();
    }




}
