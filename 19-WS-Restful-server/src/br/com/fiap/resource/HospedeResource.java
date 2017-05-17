package br.com.fiap.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.dao.HospedeDAO;
import br.com.fiap.dao.impl.HospedeDAOImpl;
import br.com.fiap.entity.Hospede;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

@Path("/hospede")
public class HospedeResource {
	private EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
	
	
	//BUSCAR TUDO
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hospede> listar(){
		EntityManager em = fabrica.createEntityManager();
		HospedeDAO dao = new HospedeDAOImpl(em);
		List<Hospede> lista = dao.listar();
		em.close();
		return lista;
		
	}	
	
	//BUSCAR POR CODIGO
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Hospede buscarPorID(@PathParam("id") int codigo){
		EntityManager em = fabrica.createEntityManager();
		HospedeDAO dao = new HospedeDAOImpl(em);
		Hospede h = dao.pesquisar(codigo);
		em.close();
		return h;	
	}
	
	//CADASTRAR
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Hospede h, @Context UriInfo uriInfo){
		EntityManager em = fabrica.createEntityManager();
		HospedeDAO dao = new HospedeDAOImpl(em);		
		try {
			dao.cadastrar(h);
			dao.salvar();
		} catch (DBException e) {
			e.printStackTrace();
		}finally {
			em.close();
		}		
		UriBuilder url = UriBuilder.fromPath(uriInfo.getPath());
		url.path(String.valueOf(h.getCodigo()));
		return Response.created(url.build()).build();
	}
	
	//ALTERAR
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") int codigo, Hospede hospede){
		EntityManager em = fabrica.createEntityManager();
		HospedeDAO dao = new HospedeDAOImpl(em);
		hospede.setCodigo(codigo);
		dao.alterar(hospede);
		
		try {
			dao.salvar();
		} catch (DBException e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return Response.ok().build();
	}	
	
	//REMOVER
	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id") int codigo){
		EntityManager em = fabrica.createEntityManager();
		HospedeDAO dao = new HospedeDAOImpl(em);		
		try {
			dao.remover(codigo);
			dao.salvar();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}		
	}
	
}
