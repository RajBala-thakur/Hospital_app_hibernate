package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Branch;
import com.ty.dto.Items;

public class ItemsDao {
	public void saveItems(Items items) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(items);
		entityTransaction.commit();
		
	}
	public void updateItems(Items items) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(items);
		entityTransaction.commit();
		
	}
	 public Items findbyId(int id)
	 {
		 EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			       Items items= entityManager.find(Items.class, id);
			       return items;
	 }
	 public List<Items> findAll(Items items)
	 {
		 EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			Query query = entityManager.createQuery("Select i from Items i");
			List<Items> ls1 = query.getResultList();
			return ls1;
	 }
	 
	 public void deleteItems(int id)
	 {
		 
		 EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			 Items items= entityManager.find(Items.class, id);
			 if(items!=null)
			 {
				 entityManager.remove(items);
			 }

		 entityTransaction.commit();
	 }
	
	

}
