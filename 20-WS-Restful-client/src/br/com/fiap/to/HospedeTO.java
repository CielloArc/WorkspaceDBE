package br.com.fiap.to;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HospedeTO {
	
	private int codigo;
	
	private String nome;
	
	private Calendar dataNascimento;
	
	private int qualificacao;
	
	public HospedeTO(){ super();}	

	public HospedeTO(String nome, Calendar dataNascimento, int qualificacao) {
		super();
		setNome(nome);
		setDataNascimento(dataNascimento);
		setQualificacao(qualificacao);
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getQualificacao() {
		return qualificacao;
	}

	public void setQualificacao(int qualificacao) {
		this.qualificacao = qualificacao;
	}
}
