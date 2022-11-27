package entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import metodos.Biblioteca;

public class Funcionario {

	private int matricula;
	private String nome, endereco, dataingrasso, setor, senha, login;
	
	
	public Funcionario(int matricula, String nome, String endereco, String dataingrasso, String setor, String senha,
			String login) {
		this.matricula = matricula;
		this.nome = nome;
		this.endereco = endereco;
		this.dataingrasso = dataingrasso;
		this.setor = setor;
		this.senha = senha;
		this.login = login;
	}
	
	public Funcionario() {
	}

	public  List<Funcionario> valores() throws FileNotFoundException, IOException{
		var path = "C:\\Users\\talli\\Downloads\\Biblioteca-main\\Biblioteca-main\\";
		
        List<Funcionario> funcionarios = new ArrayList<>();
		try(BufferedReader lineReader = new BufferedReader(new FileReader(path + "Funcionarios.csv"))){
			String line = lineReader.readLine();	
			while(line != null){
					line = lineReader.readLine();
					String[] vect = line.replaceAll("\"", "").split(";");
					Funcionario aluno = new Funcionario(Integer.parseInt(vect[0]), vect[1], vect[2], vect[3], vect[4], vect[5], vect[6]);
                    funcionarios.add(aluno);
                }
                return funcionarios;
			}
	}
	static public void cadastroFuncionario() {
		// matrícula,nome,endereço,data-ingresso,setor,senha,login
		var path = "C:\\Users\\talli\\Downloads\\Biblioteca-main\\Biblioteca-main";
		//String path = "C:\\GitHub\\Biblioteca\\CSV\\Funcionarios.csv";
		Scanner sc = new Scanner(System.in);

		Funcionario funcionario = new Funcionario();
		String es;

		System.out.println("Voce iniciou o cadastro de usuarios. \n");

		do {
			System.out.println("Digite a matricula do usuario:");
			funcionario.setMatricula(sc.nextInt());
			sc.nextLine();
			System.out.println("Digite o nome do funcionario:");
			funcionario.setNome(sc.nextLine());

			System.out.println("Digite  endereco do usuario:");
			funcionario.setEndereco(sc.nextLine());

			System.out.println("Informe a data de ingresso do aluno:");

			System.out.println("digite o dia:");
			int dia = sc.nextInt();
			while (dia > 31 || dia < 01) {
				System.out.println("Valor digitado invalido \nDigite novamente");
				dia = sc.nextInt();
			}

			System.out.println("Digite o mes:");
			int mes = sc.nextInt();
			while (mes > 12 || mes < 01) {
				System.out.println("Valor digitado invalido \nDigite novamente");
				mes = sc.nextInt();
			}

			System.out.println("Digite o ano:");
			int ano = sc.nextInt();
			while (ano < 1900 || ano > 2030) {
				System.out.println("Valor digitado invalido \nDigite novamente");
				ano = sc.nextInt();
			}
			funcionario.setDataingrasso(dia + "/" + mes + "/" + ano);
			sc.nextLine();
			System.out.println("Digite o setor do funcionario:");
			funcionario.setSetor(sc.nextLine());

			System.out.println("Digite o login do funcionario:");
			funcionario.setLogin(sc.nextLine());

			System.out.println("Digite a senha do funcionario:");
			funcionario.setSenha(sc.nextLine());
			

			try {
				FileWriter local = new FileWriter(path + "\\CSV\\Funcionarios.csv", true);
				PrintWriter pw = new PrintWriter(local);
				pw.println(funcionario.toString());
				pw.flush();
				pw.close();
			} catch (IOException e) {
				System.out.println("ERROR: " + e.getMessage());
			}
			// escolha de cadastrar novamente;
			System.out.println("Deseja cadastrar mais um professor?");
			System.out.println("[S] Sim [N] Não");
			es = sc.next();
			while (!es.equalsIgnoreCase("s") && !es.equalsIgnoreCase("n")) {
				System.out.println("valor Invalido");
				System.out.println("Digite novamente");
				es = sc.next();
			}
		} while (es.equalsIgnoreCase("s"));
		Biblioteca.inicio();
		sc.close();
	}


	public int getMatricula() {
		return matricula;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getDataingrasso() {
		return dataingrasso;
	}
	
	public void setDataingrasso(String dataingrasso) {
		this.dataingrasso = dataingrasso;
	}
	
	public String getSetor() {
		return setor;
	}
	
	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return matricula + ";" + nome + ";" + endereco + ";" + dataingrasso + ";" + setor + ";" + senha + ";" + login;
	}
	
	
	
}
