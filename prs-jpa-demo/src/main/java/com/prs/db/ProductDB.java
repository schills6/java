package com.prs.db;

import java.util.List;

import javax.persistence.*;

import com.prs.business.Product;


public class ProductDB {
	public static Product getProduct(int vendorID, String partNumber) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT p FROM Product p " +
				"WHERE p.vendorID = :vendorID AND p.partNumber = :partNumber ";
		TypedQuery<Product> q = em.createQuery(qString, Product.class);
		q.setParameter("vendorID", vendorID);
		q.setParameter("partNumber", partNumber);
		try {
			Product product = q.getSingleResult();
			return product;
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}
	
	public static List<Product> getAll() {
		List<Product> products = null;
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		
		try {
			TypedQuery<Product> q = em.createQuery("Select p from Product p", Product.class);
			products = q.getResultList();
		}
		finally {
			em.close();
		}	
		return products;
	}
	
	public static boolean add(Product product) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(product);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		} return true;
	}
	
	public static boolean update(Product product) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(product);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		} return true;
	}
	
	public static boolean delete (Product product) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(product));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		} return true;
	}
	
	
	public static boolean productComboExists(int vendorID, String partNumber) {
		Product p = getProduct (vendorID, partNumber);
		return p != null;
	}
}
