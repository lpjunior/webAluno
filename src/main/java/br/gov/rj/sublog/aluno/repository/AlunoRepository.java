package br.gov.rj.sublog.aluno.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import br.gov.rj.sublog.aluno.entity.Aluno;

public class AlunoRepository implements Serializable {

	private static final long serialVersionUID = 4479083206522329096L;

	private EntityManager em;

	public AlunoRepository(EntityManager em) {
		this.em = em;
	}

	public void manterAluno(Aluno aluno) {
		em.persist(aluno);
	}
	
	public Aluno buscaAluno(long id_buscado) {
		return em.find(Aluno.class, id_buscado);
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> listarAlunos() {
		return em.createNativeQuery("select * from aluno").getResultList();
	}

	public void apagarAluno(Aluno aluno) {
		em.remove(aluno);
	}
}
