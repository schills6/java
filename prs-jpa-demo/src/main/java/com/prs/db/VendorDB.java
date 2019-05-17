package com.prs.db;


import java.util.List;

import javax.persistence.*;

import com.prs.business.Vendor;

public class VendorDB {

	public static Vendor getVendor(String code) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT v FROM Vendor v " +
				"WHERE v.code = :code";
		TypedQuery<Vendor> q = em.createQuery(qString, Vendor.class);
		q.setParameter("code", code);
		try {
			Vendor vendor = q.getSingleResult();
			return vendor;
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}
	
	public static List<Vendor> getAll() {
		List<Vendor> vendors = null;
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		
		try {
			TypedQuery<Vendor> q = em.createQuery("Select v from Vendor v", Vendor.class);
			vendors = q.getResultList();
		}
		finally {
			em.close();
		}	
		return vendors;
	}
	
	public static boolean add(Vendor vendor) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(vendor);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		} return true;
	}
	
	public static boolean update(Vendor vendor) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(vendor);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		} return true;
	}
	
	public static boolean delete (Vendor vendor) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(vendor));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		} return true;
	}
	
	
	public static boolean emailExists(String email) {
		Vendor v = getVendor(email);
		return v != null;
	}
}

