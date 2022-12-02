package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Person;



public class PersonDao {
	public void savePerson(Person person) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
		
	}
	public void updatePerson(Person person) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(person);
		entityTransaction.commit();
		
	}
	 public Person findbyId(int uhid)
	 {
		 EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			       Person person= entityManager.find(Person.class, uhid);
			       return person;
	 }
	 public List<Person> findAll(Person person)
	 {
		 EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			Query query = entityManager.createQuery("Select p from Person p");
			List<Person> ls2 = query.getResultList();
			return ls2;
	 }
	 
	 public void deleteBranch(int uhid)
	 {
		 
		 EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			 Person person= entityManager.find(Person.class, uhid);
			 if(person!=null)
			 {
				 entityManager.remove(person);
			 }

		 entityTransaction.commit();
	 }
	
	


}
