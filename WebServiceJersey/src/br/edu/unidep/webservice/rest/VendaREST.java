package br.edu.unidep.webservice.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.edu.unidep.webservice.model.dominio.Venda;
import br.edu.unidep.webservice.service.VendaService;

@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Path("/venda")
public class VendaREST {
	
	private VendaService service = new VendaService();
	
	
	//FAZER FUNCIONAR O ALTERAR E MUDAR O VALOR GENERICO DO ENUM,
	
	
	@GET
	@Path("/getall")
	public List<Venda> listar() 
	{
		return service.listar();
	}
	
	
	@POST
	public Response Inserir(Venda venda) 
	{		
		service.Inserir(venda);
		return Response.ok().build();
	}
	
	
	@PUT
	public Response Alterar(Venda venda) 
	{
		service.Alterar(venda);
		return Response.ok().build();
	}
		
}
