package br.edu.unidep.webservice.service;

import java.util.List;


import br.edu.unidep.webservice.model.dao.ProdutoDAO;
import br.edu.unidep.webservice.model.dominio.Produto;

public class ProdutoService {

	private ProdutoDAO dao = new ProdutoDAO();
	
	public List<Produto> listar() 
	{
		return dao.listar();
	}	
	
	public Produto ProcurarPorId (Long id) 
	{
		return dao.findById(id);
	}
	
	
	public void Inserir(Produto produto) 
	{
		dao.Inserir(produto);
	}
	
	public void Alterar(Produto produto) 
	{
		dao.Alterar(produto);
	}
	
	public void Delete(Long id) 
	{
		dao.Delete(id);
	}
	
	
}