package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Sinhvien;

public class SinhvienDAO {
	
	private EntityManager em ;
	
	public SinhvienDAO() {
		em = MyEntityManager.getInstance().getEntityManager();
	}
	
	public boolean addSinhvien(Sinhvien sv) throws Exception {
		
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(sv);
			tr.commit();
			return true;
		}catch (Exception e) {
			tr.rollback();
			throw new Exception(e);
		}
		
	}
	public boolean updateSinhvien(Sinhvien sv) throws Exception {
		
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(sv);
			tr.commit();
			return true;
		}catch (Exception e) {
			tr.rollback();
			throw new Exception(e);
		}
		
	}
	public boolean deleteSinhvien(Sinhvien sv) throws Exception {
		
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(Sinhvien.class, sv.getMasv()));
			tr.commit();
			return true;
		}catch (Exception e) {
			tr.rollback();
			throw new Exception(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Sinhvien> getStudents() {
		return em.createQuery("select sv from Sinhvien sv").getResultList();
	}
	
	public Sinhvien getSinhvien(String masv) {
		return em.find(Sinhvien.class, masv);
	}
	
}
