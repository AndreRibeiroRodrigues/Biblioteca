package trabalho_final_do_professor;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
	private Scanner lerTeclado = new Scanner(System.in);
	private ProfessorVet professores;
	
	
	public Menu(ProfessorVet profs) {
		professores = profs;
	}
	
	public void menuPrincipal()throws IOException{
		String entrada = "";
		int continuar = 1;
		int valorMenu = 0;

		while (continuar != 0) {

			System.out.println("Escolha uma opção");
			System.out.println("1 - Cadastros");
			System.out.println("2 - Empréstimo");
			System.out.println("3 - Relatórios");
			System.out.println("0 - Finalizar");
			entrada = lerTeclado.next();

			try{
				valorMenu = Integer.parseInt(entrada);
			} catch (NumberFormatException e) {
				continue;
			}

			switch(valorMenu) {
			case 0:
				System.out.println("Programa Encerrado!");
				continuar = 0;
				break;
			case 1:
				menuCadastros();
				break;
			case 2:
				menuEmprestimo();
				break;
			case 3:
				menuRelatorios();
			default:
				System.out.println("Opção Inválida!" );
			}
		}


	}

	private void menuCadastros() throws IOException{
		String entrada = "";
		int valorMenu = 1;
		while (valorMenu != 0) {

			System.out.println("Escolha um Cadastro");
			System.out.println("1 - Professor");
			System.out.println("2 - Alunos");
			System.out.println("3 - Funcionário");
			System.out.println("4 - Livro");
			System.out.println("5 - Periódico");
			System.out.println("0 - Voltar para menu principal");
			entrada = lerTeclado.next();

			try{
				valorMenu = Integer.parseInt(entrada);
			} catch (NumberFormatException e) {
				continue;
			}

			switch(valorMenu) {
			case 0:
				break;
			case 1:
				professores.cadastrarProfessores();			
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				System.out.println("Opção Inválida!" );
			}
		}

	}

	private void menuEmprestimo() {
		int continuar = 1;
		String entrada = "";
		int valorMenu = 0;

		while (continuar != 0) {

			System.out.println("XXXXXXXX");
			System.out.println("1 - YYYYYYY");
			System.out.println("2 - TTTTTTTT");
			System.out.println("0 - Voltar para menu principal");
			entrada = lerTeclado.next();

			try{
				valorMenu = Integer.parseInt(entrada);
			} catch (NumberFormatException e) {
				continue;
			}

			switch(valorMenu) {
			case 0:
				continuar = 0;
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
			default:
				System.out.println("Opção Inválida!" );
			}
		}


	}

	private void menuRelatorios() {
		int continuar = 1;
		String entrada = "";
		int valorMenu = 0;

		while (continuar != 0) {

			System.out.println("Escolha o Relatório desejado");
			System.out.println("1 - Livros cadastrados");
			System.out.println("2 - Empréstimos realizados");
			System.out.println("3 - Funcionários cadastrados");
			System.out.println("4 - Alunos cadastrados");
			System.out.println("5 - Imprimir multa individual");
			System.out.println("0 - Voltar para menu principal");
			entrada = lerTeclado.next();

			try{
				valorMenu = Integer.parseInt(entrada);
			} catch (NumberFormatException e) {
				continue;
			}

			switch(valorMenu) {
			case 0:
				continuar = 0;
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				System.out.println("Opção Inválida!" );
			}
		}
	}
}
