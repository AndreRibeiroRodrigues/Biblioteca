package Pesquisa;
import java.util.ArrayList;

public class Turma {
	ArrayList<Professor> professores;

	public Turma() {
		professores = new ArrayList<Professor>();
	}
	
	public void adicionarProfessor(Professor professor) {
		professores.add(professor);
	}
	
	public int quantidadeProfessores() {
		return professores.size();
	}
	
	public void excluirProfessor(Professor professor) {
		professores.remove(professor);
	}
	
	public Professor getProfessor(int pos) {
		return professores.get(pos);
	}
	
	public boolean atualizaProfessor(Professor professorAtual, Professor professorNovo) {
		int i;
		for(i =0; i<quantidadeProfessores();i++) {
			if(professorAtual.getMatricula()==getProfessor(i).getMatricula()) {
				professores.set(i, professorNovo);
				return true;
			}
		}
		return false;			
	}

	@Override
	public String toString() {
		return "Turma [professores=" + professores + "]";
	}
}
