package br.gov.rj.sublog.alunos.app;

import br.gov.rj.sublog.aluno.repository.AlunoRepository;
import br.gov.rj.sublog.aluno.util.HibernateUtil;

public class Principal {
	public static void main(String[] args) {
		AlunoRepository repository;
		repository = new AlunoRepository(HibernateUtil.getEntitymanager());
		
	}
}
