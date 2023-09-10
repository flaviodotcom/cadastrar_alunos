package br.catolica.dao;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import br.catolica.dominio.Aluno;

//---------------------------------------------------------------------------------
/** Classe responsavel por lidar com a persistência de alunos 
 *  A anotacao @Component indica que essa classe será gerenciada pelo Spring 
 */
//---------------------------------------------------------------------------------
@Component
public class AlunoDAO {

	//------------------------------------------
	/** Sessao do usuario */
	//------------------------------------------
	private HttpSession session ;
	
	//-----------------------------------------------------------------
	/** Construtor do DAO. A sessao do usuario é automaticamente 
	 *  passada ao construtor pelo Spring ao usar @Autowired 
	 */
	//---------------------------------------------	
	public AlunoDAO(HttpSession session) {
		this.session = session ;
	}
	
	
	//---------------------------------------------
	/** Método chamado para excluir um aluno */
	//---------------------------------------------
	public void excluirAluno(String idAluno) {
		// Recupera a lista de alunos já cadastrados
		List<Aluno> listaAlunos = (List<Aluno>) session.getAttribute("listaAlunos") ;
				
		// Exclui o aluno que tem o id informado
		listaAlunos.removeIf(aluno -> aluno.getId().equals(Long.valueOf(idAluno)));
	}
	
	//---------------------------------------------
	/** Método chamado para persistir um aluno */
	//---------------------------------------------
	public void persistirAluno(Aluno aluno) {
		// Recupera a lista de alunos já cadastrados
		List<Aluno> listaAlunos = (List<Aluno>) session.getAttribute("listaAlunos") ;
				
		// Se a lista ainda nao existe na sessao, salva agora
		if(listaAlunos == null) {
			listaAlunos = new ArrayList<>();
			session.setAttribute("listaAlunos", listaAlunos);
		}
				
		// Adiciona o novo aluno na lista de alunos cadastrados
		aluno.setId(listaAlunos.size()+1L);
		listaAlunos.add(aluno) ;
	}	
	
	//-----------------------------------------------------
	/** Método que retorna todos os alunos cadastrados */
	//-----------------------------------------------------
	public List<Aluno> pesquisarTodosAlunos() {
		// Recupera a lista de alunos já cadastrados
		List<Aluno> listaAlunos = (List<Aluno>) session.getAttribute("listaAlunos") ;
		
		// Retorna a lista
		return listaAlunos ;
	}
	
}
