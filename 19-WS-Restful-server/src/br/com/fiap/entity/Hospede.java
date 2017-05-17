package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name="seqHospede",sequenceName="SQ_HOSPEDE",allocationSize=1)
public class Hospede {

	@Id
	@GeneratedValue(generator="seqHospede",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="NM_HOSPEDE")
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_NASCIMENTO")
	private Calendar dataNascimento;
	
	@Column(name="NR_NOTA")
	private int qualificacao;

	
	public Hospede(){ super();}	
	
	public Hospede(String nome, Calendar dataNascimento, int qualificacao) {
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
