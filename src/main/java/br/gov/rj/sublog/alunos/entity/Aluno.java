package br.gov.rj.sublog.alunos.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "alunos")
public class Aluno implements Serializable {

	private static final long serialVersionUID = -2166068925524035229L;

	@Id // constraint primary key
	@GeneratedValue(strategy = GenerationType.AUTO) // auto_increment
	@Column(name = "id_aluno")
	private Long id;
	@Column(unique = true, nullable = false)
	private String matricula;
	@Column(nullable = false)
	private String nome;
	@Column(unique = true, nullable = false, length = 150)
	private String email;
	@Column(nullable = false, length = 15)
	private String telefone;
	
	// 1 - 1 
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;

	public Aluno() {}

	// (alt + shift + S) + O
	public Aluno(String matricula, String nome, String email, String telefone) {
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public Aluno(Long id, String matricula, String nome, String email, String telefone) {
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	// (alt + shift + S) + R
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	// (alt + shift + S) + H
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	// (alt + shift + S) + S
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Aluno [id=");
		builder.append(id);
		builder.append(", matricula=");
		builder.append(matricula);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", email=");
		builder.append(email);
		builder.append(", telefone=");
		builder.append(telefone);
		builder.append(endereco);
		builder.append("]");
		return builder.toString();
	}
}