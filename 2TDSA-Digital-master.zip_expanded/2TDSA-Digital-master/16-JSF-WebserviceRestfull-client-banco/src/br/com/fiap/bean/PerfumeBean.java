package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.PerfumeRepository;
import br.com.fiap.to.Perfume;

@ManagedBean
public class PerfumeBean {

	private Perfume perfume;
	
	private List<Perfume> lista;
	
	private PerfumeRepository rep;
	
	//Método executado depois da instanciação do MB
	@PostConstruct
	private void init(){
		perfume = new Perfume();
		rep = new PerfumeRepository();
		try {
			lista = rep.listar();
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}
	
	//Método para o clique do botão
	public void cadastrar(){
		//Mensagem para exibir na tela
		FacesMessage msg;
		try {
			//Chamar o webservice
			rep.cadastrar(perfume);
			msg = new FacesMessage("Perfume cadastrado!");
			lista = rep.listar();
			perfume = new Perfume();
		} catch (WebServiceException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao cadastrar");
		}
		//adicionar a mensagem para a tela
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Perfume getPerfume() {
		return perfume;
	}

	public void setPerfume(Perfume perfume) {
		this.perfume = perfume;
	}

	public List<Perfume> getLista() {
		return lista;
	}

	public void setLista(List<Perfume> lista) {
		this.lista = lista;
	}


}
