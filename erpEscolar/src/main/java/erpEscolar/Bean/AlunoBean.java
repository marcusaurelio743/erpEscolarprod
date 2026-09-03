package erpEscolar.Bean;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import erpEscolar.enums.Sexo;
import erpEscolar.model.Aluno;
import erpEscolar.repository.AlunoRepository;
import erpEscolar.util.ComumBean;

@Named("alunoBean")
@ViewScoped
public class AlunoBean extends ComumBean {
	
	private static final long serialVersionUID = 1L;
	private Aluno aluno = new Aluno();
	@Inject
	private AlunoRepository alunoRepository;
	
	public String salvar() {
		aluno = alunoRepository.merge(aluno);
		info("Aluno Salvo com Sucesso!!!!");
		novo();
		return "";
	}
	public Sexo[] getSexo() {
		return Sexo.values();
	}
	
	public String novo() {
		aluno = new Aluno();
		return "";
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public AlunoRepository getAlunoRepository() {
		return alunoRepository;
	}

	public void setAlunoRepository(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}
	
	
}
