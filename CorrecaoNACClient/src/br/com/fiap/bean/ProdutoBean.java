package br.com.fiap.bean;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.repository.ProdutoRepository;
import br.com.fiap.to.ProdutoTO;

@ManagedBean
public class ProdutoBean {
	private ProdutoTO produto;
	private ProdutoRepository repository;
	private List<ProdutoTO> lista;
	
	
	@PostConstruct
	private void init(){
		produto = new ProdutoTO();
		repository = new ProdutoRepository();
		lista = repository.listar();
	}
	
	public String cadastrar(){
		FacesMessage msg;
		try {
			repository.cadastrar(produto);
			msg = new FacesMessage("Hoje não, hoje não, hoje não");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Hoje sim, hoje sim...");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext()
									.getFlash().setKeepMessages(true);
		
		return "produto?faces-redirect=true"; 
	}	
	
	public ProdutoTO getProduto() {
		return produto;
	}
	public void setProduto(ProdutoTO produto) {
		this.produto = produto;
	}
	public ProdutoRepository getRepository() {
		return repository;
	}
	public void setRepository(ProdutoRepository repository) {
		this.repository = repository;
	}

	public List<ProdutoTO> getLista() {
		return lista;
	}

	public void setLista(List<ProdutoTO> lista) {
		this.lista = lista;
	}
}
