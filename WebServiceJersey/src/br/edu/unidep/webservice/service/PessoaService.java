package br.edu.unidep.webservice.service;

import java.util.List;

import br.edu.unidep.webservice.model.dao.PessoaDAO;
import br.edu.unidep.webservice.model.dominio.Pessoa;

public class PessoaService {
	
	private PessoaDAO dao = new PessoaDAO();
	
	public List<Pessoa> listar() 
	{
		return dao.listar();
	}	
	
	public Pessoa ProcurarPorId (Long id) 
	{
		return dao.findById(id);
	}
	
	public void Inserir(Pessoa pessoa) 
	{
		dao.Inserir(pessoa);
	}
	
	public void Alterar(Pessoa pessoa) 
	{
		dao.Alterar(pessoa);
	}
	
	public void Delete(Long id) 
	{
		dao.Delete(id);
	}
	
	
	
}
