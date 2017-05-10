package br.com.fiap.teste;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.PerfumeRepository;

public class RemoveTeste {

	public static void main(String[] args) {
		PerfumeRepository rep = new PerfumeRepository();
		try {
			rep.remover(2);
			System.out.println("Sucesso!");
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}
	
}
