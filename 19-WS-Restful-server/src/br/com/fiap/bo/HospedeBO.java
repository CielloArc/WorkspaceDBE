package br.com.fiap.bo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.HospedeDAO;
import br.com.fiap.dao.impl.HospedeDAOImpl;
import br.com.fiap.entity.Hospede;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class HospedeBO {

	private EntityManagerFactory fabrica = 
			EntityManagerFactorySingleton.getInstance();
	
	public List<Hospede> listar(){
		EntityManager em = fabrica.createEntityManager();
		HospedeDAO dao = new HospedeDAOImpl(em);
		List<Hospede> lista = dao.listar();
		em.close();
		return lista;
	}
	
	public Hospede buscar(int codigo) {
		EntityManager em = fabrica.createEntityManager();
		HospedeDAO dao = new HospedeDAOImpl(em);
		Hospede Hospede = dao.pesquisar(codigo);
		em.close();
		return Hospede;
	}

	public void cadastrar(Hospede Hospede) throws DBException {
		EntityManager em = fabrica.createEntityManager();
		HospedeDAO dao = new HospedeDAOImpl(em);
		dao.cadastrar(Hospede);
		try {
			dao.salvar();
		} catch (DBException e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}finally {
			em.close();
		}
	}

	public void atualizar(Hospede Hospede) throws DBException {
		EntityManager em = fabrica.createEntityManager();
		HospedeDAO dao = new HospedeDAOImpl(em);
		dao.alterar(Hospede);
		try {
			dao.salvar();
		} catch (DBException e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}finally {
			em.close();
		}
	}

	public void remover(int codigo) throws DBException {
		EntityManager em = fabrica.createEntityManager();
		HospedeDAO dao = new HospedeDAOImpl(em);
		try {
			dao.remover(codigo);
			dao.salvar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		} finally {
			em.close();
		}
	}
	
	
	
}
