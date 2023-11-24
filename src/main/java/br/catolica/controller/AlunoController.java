package br.catolica.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.catolica.dao.AlunoDAO;
import br.catolica.dominio.Aluno;

//---------------------------------------------------------------------------------
/** Classe que trata as requisições HTTP enviadas pelo navegador */
//---------------------------------------------------------------------------------
@Controller
public class AlunoController {
	//------------------------------------------------------------------------------
	/** Aqui o Spring cria, automaticamente, uma instancia de AlunoDAO */
	//------------------------------------------------------------------------------
	@Autowired
	private AlunoDAO dao ;

	//------------------------------------------------------------------------------------
	/** Quando nenhuma url é informada (http://localhost:8080/), exibe a pagina index */
	//------------------------------------------------------------------------------------
	@RequestMapping("/")
	public String exibirPaginaIndex() {
		return "index" ;
	}

	//----------------------------------------------------------------------
	/** Quando a url /cadastrarAluno é chamada, executa esse método */
	//----------------------------------------------------------------------
	@GetMapping("/cadastrarAluno")
	public String cadastrarAluno(HttpServletRequest request) {

		// Recupera os dados que foram informados no formulario de cadastro
		String nome = request.getParameter("nome") ;
		String sexo = request.getParameter("sexo") ;
		String semestre = request.getParameter("semestre") ;

		// Guarda os dados recuperados em um novo objeto do tipo Aluno
		Aluno novoAluno = new Aluno() ;
		novoAluno.setNome(nome);
		novoAluno.setSexo(sexo);
		novoAluno.setSemestre(semestre);

		// Adiciona o novo aluno na lista de alunos cadastrados
		dao.persistirAluno(novoAluno) ;

		// Adiciona o aluno cadastrado no request, para exibir na pagina
		request.setAttribute("alunoCadastrado", novoAluno);

		// Exibe pagina index.jsp
		return "index" ;
	}


	//----------------------------------------------------------------------
	/** Quando a url /excluirAluno é chamada, executa esse método */
	//----------------------------------------------------------------------
	@GetMapping("/excluirAluno")
	public String excluirAluno(@RequestParam("id") String idAluno) {

		// Exclui o aluno da lista de alunos já cadastrados
		dao.excluirAluno(idAluno) ;

		// Exibe pagina index.jsp
		return "index" ;
	}


	//-------------------------------------------------------------------------
	/** Webservice que retorna um JSON contendo todos os alunos cadastrados */
	//-------------------------------------------------------------------------
	@ResponseBody
	@GetMapping("/pesquisarTodosAlunos")
	public List<Aluno> pesquisarAlunos() {
		return dao.pesquisarTodosAlunos() ;
	}

}
