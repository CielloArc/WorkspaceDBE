package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.bo.ConsultorBO;
import br.com.fiap.entity.Consultor;
import br.com.fiap.exception.DBException;

@ManagedBean
public class ListaConsultorBean {

	private ConsultorBO bo;
	
	private List<Consultor> lista;
	private String nomeBusca;
	
	@PostConstruct
	private void init(){
		bo = new ConsultorBO();
		lista = bo.listar();
	}
	
	public void buscar(){
		lista = bo.buscarPorNome(nomeBusca);
	}
	
	public String excluir(int codigo){
		FacesMessage msg;
		try {
			bo.remover(codigo);
			msg = new FacesMessage("Consultor excluido!");
		} catch (DBException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		//Manter a mensagem após o redirect
		FacesContext.getCurrentInstance().getExternalContext()
										.getFlash().setKeepMessages(true);
		//nome do arquivo ? redirect
		return "lista-consultor?faces-redirect=true";
	}

	public List<Consultor> getLista() {
		return lista;
	}

	public void setLista(List<Consultor> lista) {
		this.lista = lista;
	}

	public String getNomeBusca() {
		return nomeBusca;
	}

	public void setNomeBusca(String nomeBusca) {
		this.nomeBusca = nomeBusca;
	}
	
}
