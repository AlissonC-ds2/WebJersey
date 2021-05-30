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

import br.edu.unidep.webservice.model.dominio.Produto;
import br.edu.unidep.webservice.service.ProdutoService;


@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Path("/produtos")
public class ProdutoREST {

	private ProdutoService service = new ProdutoService();

	@GET
	@Path("/getall")
	public List<Produto> listar() 
	{
		return service.listar();
	}
	
	@GET
	@Path("{id}")
	public Response getProduto(@PathParam("id") Long id) 
	{
		Produto produto = service.ProcurarPorId(id);
		
		return Response.ok(produto).build();
	}
	
	@POST
	public Response Inserir(Produto produto) 
	{		
		service.Inserir(produto);
		return Response.ok().build();
	}
	
	
	@PUT
	public Response Alterar(Produto produto) 
	{
		service.Alterar(produto);
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
