package br.edu.unidep.webservice.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.edu.unidep.webservice.model.dominio.Pessoa;
import br.edu.unidep.webservice.service.PessoaService;

@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Path("/pessoa")
public class PessoaREST {

	private PessoaService service = new PessoaService();

	@GET
	@Path("/getall")
	public List<Pessoa> listar() 
	{
		return service.listar();
	}
	
	@GET
	@Path("{id}")
	public Response getPessoa(@PathParam("id") Long id) 
	{
		Pessoa pessoa = service.ProcurarPorId(id);
		
		return Response.ok(pessoa).build();
	}
	
	@POST
	public Response Inserir(Pessoa pessoa) 
	{		
		service.Inserir(pessoa);
		return Response.ok().build();
	}
	
	
	@PUT
	public Response Alterar(Pessoa pessoa) 
	{
		service.Alterar(pessoa);
		return Response.ok().build();
	}
	
	
	@DELETE
	@Path("{id}")
	public Response Deletar(@PathParam("id") Long id) 
	{
		service.Delete(id);
		return Response.ok().build();
	}
	
	
}
