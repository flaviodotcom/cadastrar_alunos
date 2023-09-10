package br.catolica.dominio;

//-----------------------------------------------------
/** Classe que armazena os dados de um aluno */
//-----------------------------------------------------
public class Aluno {
	//----------------------------------------------
	// Dados armazenados na classe
	//----------------------------------------------
	private Long id ;
	private String nome ;
	private String sexo ;	
	private String semestre ;
	
	//----------------------------------------------
	// Métodos get/set
	//----------------------------------------------	
	public String getNome() {
		return nome;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
}
