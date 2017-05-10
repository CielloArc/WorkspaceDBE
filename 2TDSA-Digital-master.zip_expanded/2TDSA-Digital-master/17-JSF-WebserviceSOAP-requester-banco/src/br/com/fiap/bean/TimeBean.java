package br.com.fiap.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.TimeBOStub;
import br.com.fiap.bo.TimeBOStub.Cadastrar;
import br.com.fiap.bo.TimeBOStub.Time;

@ManagedBean
public class TimeBean {

	private Time time;
	
	@PostConstruct //Método de inicialização
	private void inicializacao(){
		time = new Time();
	}
	
	public String cadastrar(){
		try {
			TimeBOStub stub = new TimeBOStub();
			Cadastrar params = new Cadastrar();
			params.setTime(time);
			stub.cadastrar(params);
		} catch (Exception e) {
			e.printStackTrace();
			return "cadastro-time";
		}
		return "busca-time";
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
}
