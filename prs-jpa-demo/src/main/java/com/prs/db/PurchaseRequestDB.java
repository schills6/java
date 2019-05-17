package com.prs.db;

import java.util.List;

import javax.persistence.*;

import com.prs.business.PurchaseRequest;


public class PurchaseRequestDB {
	
	public static PurchaseRequest getPurchaseRequest(int id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT pr FROM PurchaseRequest pr " +
				"WHERE pr.ID = :id ";
		TypedQuery<PurchaseRequest> q = em.createQuery(qString, PurchaseRequest.class);
		q.setParameter("ID", id);
		try {
			PurchaseRequest purchaserequest = q.getSingleResult();
			return purchaserequest;
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}
	
	public static List<PurchaseRequest> getAll() {
		List<PurchaseRequest> purchaserequests = null;
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		
		try {
			TypedQuery<PurchaseRequest> q = em.createQuery("Select pr from PurchaseRequest pr", PurchaseRequest.class);
			purchaserequests = q.getResultList();
		}
		finally {
			em.close();
		}	
		return purchaserequests;
	}
	
	public static boolean add(PurchaseRequest purchaserequest) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(purchaserequest);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		} return true;
	}
	
	public static boolean update(PurchaseRequest purchaserequest) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(purchaserequest);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		} return true;
	}
	
	public static boolean delete (PurchaseRequest purchaserequest) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(purchaserequest));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		} return true;
	}
	
}

