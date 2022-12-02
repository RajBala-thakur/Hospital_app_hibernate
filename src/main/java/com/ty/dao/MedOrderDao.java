package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.MedOrder;



public class MedOrderDao {
	public void saveMedOrder(MedOrder medorder) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(medorder);
		entityTransaction.commit();
		
	}
	public void updateMedOrder(MedOrder medorder) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(medorder);
		entityTransaction.commit();
		
	}
	 public MedOrder findbyId(int id)
	 {
		 EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			       MedOrder medorder= entityManager.find(MedOrder.class, id);
			       return medorder;
	 }
	 public List<MedOrder> findAll(MedOrder medorder)
	 {
		 EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			Query query = entityManager.createQuery("Select m from MedOrder m");
			List<MedOrder> ls1 = query.getResultList();
			return ls1;
	 }
	 
	 public void deleteMedOrder(int id)
	 {
		 
		 EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			 MedOrder medorder= entityManager.find(MedOrder.class, id);
			 if(medorder!=null)
			 {
				 entityManager.remove(medorder);
			 }

		 entityTransaction.commit();
	 }
	
	

}
