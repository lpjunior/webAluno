package br.gov.rj.sublog.aluno.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import br.gov.rj.sublog.aluno.entity.Aluno;

public class AlunoRepository implements Serializable {

	private static final long serialVersionUID = 4479083206522329096L;

	private EntityManager em;

	public AlunoRepository() {}
	
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public void manterAluno(Aluno aluno) {
		this.em.getTransaction().begin();
		this.em.persist(aluno);
		this.em.getTransaction().commit();
	}
	
	public Aluno buscaAluno(long id_buscado) {
		return this.em.find(Aluno.class, id_buscado);
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> listarAlunos() {
		return this.em.createNativeQuery("select * from aluno").getResultList();
	}

	public void apagarAluno(Aluno aluno) {
		this.em.getTransaction().begin();
		this.em.remove(aluno);
		this.em.getTransaction().commit();
	}
}
