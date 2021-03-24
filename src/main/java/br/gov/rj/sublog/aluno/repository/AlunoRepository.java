package br.gov.rj.sublog.aluno.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.gov.rj.sublog.aluno.entity.Aluno;

public class AlunoRepository implements Serializable {

	private static final Logger logger = LogManager.getLogger(AlunoRepository.class);

	private static final long serialVersionUID = 4479083206522329096L;
	
	private EntityManager em;
	private EntityTransaction transaction;

	public AlunoRepository() {}

	public void setEntityManager(EntityManager em) {
		this.em = em;
		openTransaction();
	}

	public void manterAluno(Aluno aluno) {
		try {

			this.getEmEntityManager().merge(aluno);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			logger.error("Error ao executar o persist: " + e.getMessage());
		}
	}

	public Aluno buscaAluno(long id_buscado) {
		return this.getEmEntityManager().find(Aluno.class, id_buscado);
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> listarAlunos() {
		return this.getEmEntityManager().createQuery("SELECT a FROM Aluno a").getResultList();
	}

	public void apagarAluno(long alunoId) {
		//this.em.remove(aluno);
		this.getEmEntityManager().createQuery("DELETE FROM Aluno a where a.id = :alunoID").setParameter("alunoID", alunoId).executeUpdate();
	}

	public EntityManager getEmEntityManager() {
		if(!transaction.isActive())
			openTransaction();
		
		return this.em;
	}
	
	private void openTransaction() {
		transaction = this.em.getTransaction();
		transaction.begin();
	}
}
