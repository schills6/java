package com.prs.db;

import java.util.List;

import javax.persistence.*;

import com.prs.business.PurchaseRequestLineItem;


public class PurchaseRequestLineItemDB {
	public static PurchaseRequestLineItem getPurchaseRequestLineItem(int id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT prli FROM PurchaseRequestLineItem prli " +
				"WHERE prli.ID = :ID ";
		TypedQuery<PurchaseRequestLineItem> q = em.createQuery(qString, PurchaseRequestLineItem.class);
		q.setParameter("ID", id);
		try {
			PurchaseRequestLineItem purchaserequestlineitem = q.getSingleResult();
			return purchaserequestlineitem;
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}
	
	public static List<PurchaseRequestLineItem> getAll() {
		List<PurchaseRequestLineItem> purchaserequestlineitems = null;
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		
		try {
			TypedQuery<PurchaseRequestLineItem> q = em.createQuery("Select prli from PurchaseRequestLineItem prli", PurchaseRequestLineItem.class);
			purchaserequestlineitems = q.getResultList();
		}
		finally {
			em.close();
		}	
		return purchaserequestlineitems;
	}
	
	public static boolean add(PurchaseRequestLineItem purchaserequestlineitem) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(purchaserequestlineitem);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		} return true;
	}
	
	public static boolean update(PurchaseRequestLineItem purchaserequestlineitem) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(purchaserequestlineitem);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		} return true;
	}
	
	public static boolean delete (PurchaseRequestLineItem purchaserequestlineitem) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(purchaserequestlineitem));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		} return true;
	}
	
	
}
