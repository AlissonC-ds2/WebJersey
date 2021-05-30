package br.edu.unidep.webservice.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unidep.webservice.model.dominio.Produto;

public class ProdutoDAO {

	public static EntityManager em = JPAUtil.getEntityManager();
	
	public List<Produto> listar() 
	{	
		return em.createQuery("select p from Produto p", Produto.class).getResultList();
	}
	
	
	public void Inserir(Produto produto) 
	{
		if(!em.getTransaction().isActive())
	        em.getTransaction().begin();
		
		em.persist(produto);
		em.getTransaction().commit();
	}
	
	
	public Produto findById(Long id) 
	{
	    return em.find(Produto.class, id);
	}
	
	
	public void Alterar(Produto produto) 
	{
		em.getTransaction().begin();
		em.merge(produto);
		em.getTransaction().commit();
	}
	
	public void Delete(Long id) 
	{
		Produto produto = em.find(Produto.class, id);
	
		em.getTransaction().begin();
		em.remove(produto);
		em.getTransaction().commit();
	}
	
	
	
}