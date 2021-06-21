package br.com.codenation.model;

import java.time.LocalDate;

public class Time {
	
	// criar propriedades (atributos) do método
	private Long id;
	private String nome;
	private LocalDate dataCriacao;
	private String corUniformePrincipal;
	private String corUniformeSecundario;

	// criar construtor (boa prática). Instanciá-los para que não sejam mais modificados;
	public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
			String corUniformeSecundario) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataCriacao = dataCriacao;
		this.corUniformePrincipal = corUniformePrincipal;
		this.corUniformeSecundario = corUniformeSecundario;
	}

	// dar acesso aos atributos (get - deixo ele ser acessado e set - deixo ser atribuido, para poder ser modificado (mas não quero qe ele seja modificado, portanto não vou cirar o set)
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public String getCorUniformePrincipal() {
		return corUniformePrincipal;
	}

	public String getCorUniformeSecundario() {
		return corUniformeSecundario;
	}

}
