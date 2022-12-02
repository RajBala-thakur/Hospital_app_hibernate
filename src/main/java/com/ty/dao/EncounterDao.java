package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Encounter;



public class EncounterDao {
	public void saveEncounter(Encounter encounter) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(encounter);
		entityTransaction.commit();
		
	}
	public void updateEncounter(Encounter encounter) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(encounter);
		entityTransaction.commit();
		
	}
	 public Encounter findbyId(int id)
	 {
		 EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			       Encounter encounter= entityManager.find(Encounter.class, id);
			       return encounter;
	 }
	 public List<Encounter> findAll(Encounter encounter)
	 {
		 EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			Query query = entityManager.createQuery("Select e from Encounter e");
			List<Encounter> ls3 = query.getResultList();
			return ls3;
	 }
	 
	 public void deleteBranch(int id)
	 {
		 
		 EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			 Encounter encounter= entityManager.find(Encounter.class, id);
			 if(encounter!=null)
			 {
				 entityManager.remove(encounter);
			 }

		 entityTransaction.commit();
	 }
	
	



}
