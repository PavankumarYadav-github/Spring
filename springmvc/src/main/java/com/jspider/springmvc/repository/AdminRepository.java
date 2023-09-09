package com.jspider.springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspider.springmvc.pojo.AdminPOJO;

@Repository
public class AdminRepository {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	private static String jpql;
	
	private static void openConnection() {
		factory=Persistence.createEntityManagerFactory("mvc");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
		
	}
	private static void closeConnection() {
		if(factory!=null) {
			factory.close();
		}
		if(manager!=null) {
			manager.close();
		}
		if(transaction!=null) {
			if(transaction.isActive()) {
				transaction.rollback();
			}
		}
	}
	
	public AdminPOJO addAdmin(String username,String password) {
		
		openConnection();
		transaction.begin();
		AdminPOJO adminPOJO=new AdminPOJO();
		adminPOJO.setUsername(username);
		adminPOJO.setPassword(password);
		manager.persist(adminPOJO);
		transaction.commit();
		closeConnection();
		return adminPOJO;
		
	}
	public List<AdminPOJO> getAdmin(){
		openConnection();
		transaction.begin();
		jpql="from AdminPOJO";
		query=manager.createQuery(jpql);
		List<AdminPOJO> adminPOJOs=query.getResultList();
		transaction.commit();
		closeConnection();
		return adminPOJOs;
		
	}
	public AdminPOJO login(String username,String password) {
		openConnection();
		transaction.begin();
		jpql="from AdminPOJO where username = '"+username+"' and password ='"+password+"'";
		query=manager.createQuery(jpql);
		AdminPOJO adminPOJO=(AdminPOJO)query.getSingleResult();
		if(adminPOJO!=null) {
			transaction.commit();
			closeConnection();
			return adminPOJO;
		}
		
		transaction.commit();
		closeConnection();
		return null;
		
		
	}
	

}
