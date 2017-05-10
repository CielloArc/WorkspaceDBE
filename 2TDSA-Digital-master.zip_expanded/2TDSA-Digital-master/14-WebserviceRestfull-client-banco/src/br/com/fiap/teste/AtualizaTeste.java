package br.com.fiap.teste;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.PerfumeRepository;
import br.com.fiap.to.Perfume;

public class AtualizaTeste {

	public static void main(String[] args) {
		PerfumeRepository rep = new PerfumeRepository();
		try {
			Perfume perfume = rep.buscar(2);
			perfume.setNome("Teste Atualização");
			rep.atualizar(perfume);
			System.out.println("Sucesso!");
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}
	
}
