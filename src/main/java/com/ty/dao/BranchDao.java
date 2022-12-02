package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Branch;
import com.ty.dto.Hospital;


public class BranchDao {
	public void saveBranch(Branch branch) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(branch);
		entityTransaction.commit();
		
	}
	public void updateBranch(Branch branch) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(branch);
		entityTransaction.commit();
		
	}
	 public Branch findbyId(int branch_id)
	 {
		 EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			       Branch branch= entityManager.find(Branch.class, branch_id);
			       return branch;
	 }
	 public List<Branch> findAll(Branch branch)
	 {
		 EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			Query query = entityManager.createQuery("Select b from Branch b");
			List<Branch> ls1 = query.getResultList();
			return ls1;
	 }
	 
	 public void deleteBranch(int branch_id)
	 {
		 
		 EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			 Branch branch= entityManager.find(Branch.class, branch_id);
			 if(branch!=null)
			 {
				 entityManager.remove(branch);
			 }

		 entityTransaction.commit();
	 }
	
	

}
