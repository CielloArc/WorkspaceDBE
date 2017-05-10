package br.com.fiap.bo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.PedidoDAO;
import br.com.fiap.dao.impl.PedidoDAOImpl;
import br.com.fiap.entity.Pedido;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class PedidoBO {

	private EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();

	public void cadastrar(Pedido pedido) throws DBException{
		EntityManager em = factory.createEntityManager();
		PedidoDAO dao = new PedidoDAOImpl(em);
		try {
			dao.cadastrar(pedido);
			dao.salvar();
		} catch (DBException e) {
			e.printStackTrace();
			throw new DBException(e);
		}finally {
			em.close();
		}
	}

	public List<Pedido> listar() {
		return null;
	}
	
}
