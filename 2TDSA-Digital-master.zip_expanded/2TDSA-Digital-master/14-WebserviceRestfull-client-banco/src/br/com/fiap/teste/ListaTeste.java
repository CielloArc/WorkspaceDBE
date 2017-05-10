package br.com.fiap.teste;

import java.util.List;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.PerfumeRepository;
import br.com.fiap.to.Perfume;

public class ListaTeste {

	public static void main(String[] args) {
		PerfumeRepository rep = new PerfumeRepository();
		
		try {
			List<Perfume> lista = rep.listar();
			for (Perfume perfume : lista) {
				System.out.println(perfume.getNome());
			}
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
		
	}
	
}
