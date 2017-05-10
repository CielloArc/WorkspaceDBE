package br.com.fiap.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.TimeBOStub;
import br.com.fiap.bo.TimeBOStub.Buscar;
import br.com.fiap.bo.TimeBOStub.BuscarResponse;
import br.com.fiap.bo.TimeBOStub.Time;

@ManagedBean
public class BuscaTimeBean {

	private int codigo;
	
	private Time time;
	
	@PostConstruct
	private void init(){
		time = new Time();
	}

	public void buscar(){
		try {
			TimeBOStub stub = new TimeBOStub();
			Buscar params = new Buscar();
			params.setCodigo(codigo);
			BuscarResponse response = stub.buscar(params);
			time = response.get_return();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
}
