package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.fiap.bo.PedidoBO;
import br.com.fiap.entity.Pedido;

@ManagedBean
public class ListaPedidoBean {

	private List<Pedido> lista;
	private PedidoBO bo;

	@PostConstruct
	private void init(){
		bo = new PedidoBO();
		lista = bo.listar();
	}
	
	public List<Pedido> getLista() {
		return lista;
	}

	public void setLista(List<Pedido> lista) {
		this.lista = lista;
	}
	
}
