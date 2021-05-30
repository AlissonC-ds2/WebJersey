package br.edu.unidep.webservice.service;

import java.util.List;

import br.edu.unidep.webservice.model.dao.VendaDAO;
import br.edu.unidep.webservice.model.dominio.Venda;

public class VendaService {
	
	private VendaDAO dao = new VendaDAO();
	
	public List<Venda> listar() 
	{
		return dao.listar();
	}	
	
	public void Inserir(Venda venda) 
	{
		dao.Inserir(venda);
	}
	
	public void Alterar(Venda venda) 
	{
		dao.Alterar(venda);
	}
	
}
