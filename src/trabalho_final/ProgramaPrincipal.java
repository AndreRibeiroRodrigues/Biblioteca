package trabalho_final;
import java.io.IOException;
import java.util.Scanner;

public class ProgramaPrincipal {
	static Scanner ler = new Scanner(System.in);

	public static void main(String[] args) throws IOException{
		ProfessorVet professores = new ProfessorVet();
		//Inicializa o vetor de professores com os dados aramzenados no arquivo professores.csv
		professores.setProfessores(professores.getProfessores(), ManipulaArquivo.leitor("C:\\Users\\WizeComp\\Documents\\Faesa\\LP II\\workspace\\LPII\\professores.csv"));
		//Imprime na tela os dados do vetor professores
		System.out.println(professores);
		
		Menu menu = new Menu(professores);
		menu.menuPrincipal();
	}
}