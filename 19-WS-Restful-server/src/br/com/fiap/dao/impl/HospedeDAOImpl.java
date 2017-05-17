package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.HospedeDAO;
import br.com.fiap.entity.Hospede;

public class HospedeDAOImpl extends GenericDAOImpl<Hospede, Integer> implements HospedeDAO{

	public HospedeDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
