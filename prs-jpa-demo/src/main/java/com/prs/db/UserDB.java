package com.prs.db;


import java.util.List;

import javax.persistence.*;

import com.prs.business.User;

public class UserDB {

	public static User getUser(String email) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT u FROM User u " +
				"WHERE u.email = :email";
		TypedQuery<User> q = em.createQuery(qString, User.class);
		q.setParameter("email", email);
		try {
			User user = q.getSingleResult();
			return user;
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}
	
	public static List<User> getAll() {
		List<User> users = null;
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		
		try {
			TypedQuery<User> q = em.createQuery("Select u from User u", User.class);
			users = q.getResultList();
		}
		finally {
			em.close();
		}	
		return users;
	}
	
	public static boolean add(User user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(user);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		} return true;
	}
	
	public static boolean update(User user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		} return true;
	}
	
	public static boolean delete (User user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(user));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		} return true;
	}
	
	
	public static boolean emailExists(String email) {
		User u = getUser(email);
		return u != null;
	}
}
