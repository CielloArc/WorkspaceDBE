package br.com.fiap.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CalculadoraBean {

	private int numero1, numero2, resultado;
	
	public void calcular(){
		resultado = numero1 + numero2;
	}

	public int getNumero1() {
		return numero1;
	}

	public void setNumero1(int numero1) {
		this.numero1 = numero1;
	}

	public int getNumero2() {
		return numero2;
	}

	public void setNumero2(int numero2) {
		this.numero2 = numero2;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
}
