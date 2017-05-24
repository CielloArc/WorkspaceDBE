package br.com.fiap.repository;

import java.util.Arrays;
import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.to.ProdutoTO;

public class ProdutoRepository {

	private static final String URL = "http://localhost:8080/CorrecaoNacServer/rest/produto/";
	private Client client = Client.create();

	public void cadastrar(ProdutoTO produto) throws Exception {
		WebResource resource = client.resource(URL);
		ClientResponse response = resource.type("application/json").post(ClientResponse.class, produto);
			
		if(response.getStatus() != 201){
			System.err.println("Erro: HTTP error code : " + response.getStatus());
			throw new Exception("ERRO AO CADASTRAR!");
		}
		
	}
	
	public void atualizar(ProdutoTO produto) throws Exception{
		WebResource resource = client.resource(URL + produto.getCodigo());
		ClientResponse response = resource.type("application/json").put(ClientResponse.class, produto);
		
		if(response.getStatus() != 200){
			System.err.println("Erro: HTTP error code : " + response.getStatus());
			throw new Exception("ERRO AO ATUALIZAR!");
		}
	}
	
	
	public void remover(int codigo) throws Exception{
		WebResource resource = client.resource(URL + codigo);		
		ClientResponse response = resource.delete(ClientResponse.class);
		
		if(response.getStatus() != 204){
			System.err.println("Erro: HTTP error code : " + response.getStatus());
			throw new Exception("ERRO AO REMOVER!");
		}
	}
	
	public List<ProdutoTO> listar(){
		WebResource resource = client.resource(URL);
		ClientResponse response = resource.type("application/json").get(ClientResponse.class);
		ProdutoTO[] array = response.getEntity(ProdutoTO[].class);
		return Arrays.asList(array);
	}
	
}
