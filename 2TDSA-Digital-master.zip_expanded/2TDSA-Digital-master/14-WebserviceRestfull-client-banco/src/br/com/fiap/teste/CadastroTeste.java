package br.com.fiap.teste;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.PerfumeRepository;
import br.com.fiap.to.Perfume;

public class CadastroTeste {

	public static void main(String[] args) {
		PerfumeRepository rep = new PerfumeRepository();
		Perfume perfume = new Perfume();
		perfume.setNome("EKOS");
		perfume.setAroma("Café");
		perfume.setMl(100);
		
		try {
			rep.cadastrar(perfume);
			System.out.println("Sucesso!");
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}
	
}
