package trabalho_final_do_professor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProfessorVet {
	private ArrayList<Professor> professores = new ArrayList<Professor>();
	Scanner ler= new Scanner(System.in);

	public ArrayList<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(ArrayList<Professor> professores, List<String> linhas) {
		int numLinhas=linhas.size();
		String linha, valorComSplit[];

		for(int i=0; i <numLinhas; i++)
		{
			linha = linhas.get(i);
			valorComSplit = linha.split(";");
			professores.add(new Professor(
					Integer.parseInt(valorComSplit[0]),
					valorComSplit[1],
					valorComSplit[2],
					valorComSplit[3],
					valorComSplit[4]
					));
		}
		this.professores = professores;
	}

	public void cadastrarProfessores()throws IOException{
		String entrada, linha="";
		Professor professor = new Professor();
		System.out.printf("Informe a matrícula do professor:\n");
		entrada = ler.nextLine();
		linha += entrada+";";
		professor.setMatricula(Integer.parseInt(entrada));
		System.out.printf("Informe o nome do professor:\n");
		entrada = ler.nextLine();
		linha += entrada+";";
		professor.setNome(entrada);
		System.out.printf("Informe o endereço do professor:\n");
		entrada = ler.nextLine();
		linha += entrada+";";
		professor.setEndereco(entrada);
		System.out.printf("\nInforme a data de ingresso do professor: ");
		entrada = ler.nextLine();
		linha += entrada+";";
		professor.setDataIngresso(entrada);
		System.out.printf("Informe o setor do professor: ");
		entrada = ler.nextLine();
		linha += entrada;
		professor.setSetor(entrada);

		//Inseri um professor no array list
		professores.add(professor);

		//Grava dados de um professor no arquivo
		ManipulaArquivo.escritor("professor.csv", linha);
	}

	@Override
	public String toString() {
		String resposta = "";
		int tam = professores.size();
		for(int i=0;i<tam;i++){
			resposta += (i+1) +"."+ this.professores.get(i).toString()+"\n";
		}
		return resposta;	
	}

}
