package br.com.fiap.bean;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.fiap.bo.ConsultorBO;
import br.com.fiap.entity.Consultor;
import br.com.fiap.exception.DBException;

//Classe para controlar a p�gina, como a serlvet
@ManagedBean
public class ConsultorBean {

	private Consultor consultor;
	private ConsultorBO bo;
	
	@PostConstruct
	private void inicializacao(){
		consultor = new Consultor();
		consultor.setDataAdmissao(Calendar.getInstance());
		bo = new ConsultorBO();
	}
	
	public String cadastrar(){
		FacesMessage msg;
		try {
			if (consultor.getCodigo() == 0){
				bo.cadastrar(consultor);
				msg = new FacesMessage("Consultor cadastrado");
			}else{
				bo.atualizar(consultor);
				msg = new FacesMessage("Consultor "+ consultor.getNome() +" atualizado!");
			}
		} catch (DBException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
			return "cadastro-consultor";
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		//Manter a mensagem em uma nova requisi��o
		FacesContext.getCurrentInstance().getExternalContext()
									.getFlash().setKeepMessages(true);
		return "lista-consultor?faces-redirect=true"; //nome da p�gina
	}
	
	
	public void validarCPF(FacesContext context, UIComponent component, Object value) throws ValidatorException{
		String cpf = value.toString();
		
		if(!cpf.contains(".")){
			throw new ValidatorException(new FacesMessage("CPF INV�LIDO"));
		}
	}

	public Consultor getConsultor() {
		return consultor;
	}

	public void setConsultor(Consultor consultor) {
		this.consultor = consultor;
	}
	
}
