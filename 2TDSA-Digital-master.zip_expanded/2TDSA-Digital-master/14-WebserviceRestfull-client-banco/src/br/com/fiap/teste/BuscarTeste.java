package br.com.fiap.teste;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.PerfumeRepository;
import br.com.fiap.to.Perfume;

public class BuscarTeste {

	public static void main(String[] args) {
		PerfumeRepository rep = new PerfumeRepository();
		try {
			Perfume perfume = rep.buscar(2);
			System.out.println(perfume.getNome());
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}
	
}
