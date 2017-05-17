package br.com.fiap.repository;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.to.HospedeTO;

public class HospedeRepository {
	private Client cliente = Client.create();
	private static final String URL = "http://localhost:8080/19-WS-Restful-server/rest/hospede/";
	
	//BUSCAR
	public HospedeTO buscar(int codigo) throws WebServiceException{
		WebResource resource = cliente.resource(URL + codigo);
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if(response.getStatus() != 200){
			throw new WebServiceException("Http Status: " + response.getStatus() );
		}
		
		HospedeTO hospede = response.getEntity(HospedeTO.class);
		return hospede;		
	}
	
	//LISTAR
	public List<HospedeTO> listar() throws WebServiceException{
		WebResource resource = cliente.resource(URL);
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if(response.getStatus() != 200){
			throw new WebServiceException("Http Status: " + response.getStatus() );
		}
		
		HospedeTO[] lista = response.getEntity(HospedeTO[].class);
		return Arrays.asList(lista);		
	}
	
	//CADASTRAR
	public void cadastrar(HospedeTO hospede) throws WebServiceException{
		WebResource resource = cliente.resource(URL);
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, hospede);
		
		if(response.getStatus() != 201){
			throw new WebServiceException("Http Status: " + response.getStatus() );
		}
	}
	
	//ATUALIZAR
	public void atualizar(HospedeTO  hospede) throws WebServiceException{
		WebResource resource = cliente.resource(URL + hospede.getCodigo());
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).put(ClientResponse.class, hospede);
		
		if(response.getStatus() != 200){
			throw new WebServiceException("Http Status: " + response.getStatus() );
		}
	} 
	
	
	
	

}
