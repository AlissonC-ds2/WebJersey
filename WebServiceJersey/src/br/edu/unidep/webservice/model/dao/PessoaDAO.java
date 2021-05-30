package br.edu.unidep.webservice.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unidep.webservice.model.dominio.Pessoa;

public class PessoaDAO {
	
	public static EntityManager em = JPAUtil.getEntityManager();
	
	public List<Pessoa> listar() 
	{	
		return em.createQuery("select p from Pessoa p", Pessoa.class).getResultList();
	}
	
	public void Inserir(Pessoa pessoa) 
	{
		if(!em.getTransaction().isActive())
	        em.getTransaction().begin();
		
		em.persist(pessoa);
		em.getTransaction().commit(); 
	}
	
	
	public Pessoa findById(Long id) 
	{
	    return em.find(Pessoa.class, id);
	}
	
	
	public void Alterar(Pessoa pessoa) 
	{
		em.getTransaction().begin();
		em.merge(pessoa);
		em.getTransaction().commit();
	}
	
	public void Delete(Long id) 
	{
		Pessoa pessoa = em.find(Pessoa.class, id);
	
		em.getTransaction().begin();
		em.remove(pessoa);
		em.getTransaction().commit();
	}
	
	
}
