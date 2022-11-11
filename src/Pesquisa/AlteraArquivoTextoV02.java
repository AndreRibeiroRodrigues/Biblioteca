package Pesquisa;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class AlteraArquivoTextoV02 {
	public static void main(String[] args) throws IOException {

		Path path = Paths.get("C:\\Users\\WizeComp\\eclipse-workspace\\LPII\\src\\Arquivo\\professores.txt");
		Turma turma01 = new Turma();
		Professor professorAtual = new Professor(4,"Nome Trocado", "Rua y", "UCS", "03/02/1998");
		Professor professorNovo = new Professor(4, "Jos�", "Rua Set, 32","ENG", "10/10/2010");
		List<String> linhas = Files.readAllLines(path);
		System.out.println(linhas);
		converteListString2ListObjeto(linhas, turma01);
		System.out.println(turma01);
		if (turma01.atualizaProfessor(professorAtual, professorNovo)) {
			System.out.println("Professor atualizado com sucesso!");
		}
		else {
			System.out.println("Erro na atualiza��o do professor!");
		}
		Files.write(path, converteListObjeto2ListString(turma01));
	}

	public static void converteListString2ListObjeto(List<String> lista, Turma turma) {
		int numLinhas=lista.size(), i=0;
		String linha, valorComSplit[];

		while(i<numLinhas)
		{
			linha = lista.get(i);
			valorComSplit = linha.split("-");
			turma.adicionarProfessor(new Professor(Integer.parseInt(valorComSplit[0]), valorComSplit[1],
					valorComSplit[2], valorComSplit[3], valorComSplit[4]));
			i++;
		}
	}

	public static List<String> converteListObjeto2ListString(Turma turma) {
		List<String> linhas = new LinkedList<String>();
		
		for(int i=0; i<turma.quantidadeProfessores();i++) {
			linhas.add(turma.getProfessor(i).toString());
		}
		return linhas;
	}
}