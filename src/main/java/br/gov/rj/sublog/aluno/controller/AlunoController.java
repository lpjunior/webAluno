package br.gov.rj.sublog.aluno.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.rj.sublog.aluno.entity.Aluno;
import br.gov.rj.sublog.aluno.entity.Endereco;
import br.gov.rj.sublog.aluno.repository.AlunoRepository;
import br.gov.rj.sublog.aluno.util.HibernateUtil;

@WebServlet({ "/addaluno", "/edtaluno", "/listaluno", "/findaluno", "/delaluno" })
public class AlunoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private AlunoRepository repository;
	
	public AlunoController() {
		this.repository = new AlunoRepository();
		this.repository.setEntityManager(HibernateUtil.getEntitymanager());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getServletPath().equals("/listaluno")) {
			listar(request, response);
		} else if (request.getServletPath().equals("/findaluno")) {
			buscar(request, response);
		} else if (request.getServletPath().equals("/delaluno")) {
			excluir(request, response);
		} else {
			response.sendRedirect("error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getServletPath().equals("/addaluno")) {
			cadastrar(request, response);
		} else if (request.getServletPath().equals("/edtaluno")) {
			editar(request, response);
		} else {
			response.sendRedirect("error.jsp");
		}
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Aluno aluno = new Aluno();
		Endereco endereco = new Endereco();
		// dados básicos
		aluno.setNome(request.getParameter("inputnome"));
		aluno.setMatricula(request.getParameter("inputmatricula"));
		aluno.setEmail(request.getParameter("inputemail"));
		aluno.setTelefone(request.getParameter("inputtelefone"));
		// dados de endereço
		endereco.setLogradouro(request.getParameter("inputlogradouro"));
		endereco.setBairro(request.getParameter("inputbairro"));
		endereco.setCidade(request.getParameter("inputcidade"));
		endereco.setEstado(request.getParameter("inputestado"));
		// relação aluno x endereço
		aluno.setEndereco(endereco);
		
		repository.manterAluno(aluno);

		listar(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
