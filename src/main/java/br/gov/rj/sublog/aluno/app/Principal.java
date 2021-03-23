package br.gov.rj.sublog.aluno.app;

import br.gov.rj.sublog.aluno.entity.Aluno;
import br.gov.rj.sublog.aluno.entity.Endereco;
import br.gov.rj.sublog.aluno.repository.AlunoRepository;
import br.gov.rj.sublog.aluno.util.HibernateUtil;

public class Principal {
	public static void main(String[] args) {
		AlunoRepository repository;
		repository = new AlunoRepository();
		repository.setEntityManager(HibernateUtil.getEntitymanager());
		
		Aluno aluno = new Aluno();
		Endereco endereco = new Endereco();
		// dados básicos
		aluno.setNome("Luis");
		aluno.setMatricula("123456");
		aluno.setEmail("luispaulojr@gmail.com");
		aluno.setTelefone("(21) 1234-5678");
		// dados de endereço
		endereco.setLogradouro("Rua 1");
		endereco.setBairro("Centro");
		endereco.setCidade("Rio de Janeiro");
		endereco.setEstado("RJ");
		// relação aluno x endereço
		aluno.setEndereco(endereco);
		
		repository.manterAluno(aluno);
	}
}
