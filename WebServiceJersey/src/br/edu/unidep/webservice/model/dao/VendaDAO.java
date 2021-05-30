package br.edu.unidep.webservice.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unidep.webservice.model.dominio.Venda;

public class VendaDAO {

	public static EntityManager em = JPAUtil.getEntityManager();
	
	public List<Venda> listar() 
	{	
		return em.createQuery("select v from Venda v", Venda.class).getResultList();
	}
	
	public void Inserir(Venda venda) 
	{
		if(!em.getTransaction().isActive())
	        em.getTransaction().begin();
		
		em.persist(venda);
		em.getTransaction().commit(); 
	}
	
	
	public void Alterar(Venda venda) 
	{
		em.getTransaction().begin();
		em.merge(venda);
		em.getTransaction().commit();
	}
	
	
}
