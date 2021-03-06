package br.com.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.jpautil.JPAUtil;
import oracle.net.aso.t;

public class DaoGeneric<E> implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public void salvar(E entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
			
		entityManager.persist(entidade);
			
		entityTransaction.commit();
		entityManager.close();
		
	}

	public E merge(E entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
			
		E retorno = (E) entityManager.merge(entidade);
			
		entityTransaction.commit();
		entityManager.close();
		
		return retorno;
	}

	public void delete(E entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
			
		entityManager.remove(entidade);
			
		entityTransaction.commit();
		entityManager.close();
		
	}

	public void deletePorId(E entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		Object id = JPAUtil.getPrimaryKey(entidade);
		
		String entidadeSplit[] = entidade.getClass().getCanonicalName().split("br.com.entidades.");
		String entidadePura = entidadeSplit[1];
		entityManager.createQuery("delete from " + entidadePura + " where id = " + id).executeUpdate();
			
		entityTransaction.commit();
		entityManager.close();
	}
	
	public List<E> getListEntity(Class<E> entidade){
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();	
		
		String entidadeSplit[] = entidade.getName().split("br.com.entidades.");
		String entidadePura = entidadeSplit[1];		
		@SuppressWarnings("unchecked")
		List<E> retorno = entityManager.createQuery("from " + entidadePura + " e " ).getResultList();
		
		entityTransaction.commit();
		entityManager.close();
		
		return retorno;
	}
	
	public E consultar(Class<E> entidade, String codigo) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		E objeto = (E) entityManager.find(entidade, Long.parseLong(codigo));
		entityTransaction.commit();
		return objeto;
		
	}
	
}














