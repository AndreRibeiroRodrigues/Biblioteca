package metodos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Biblioteca {
	
	static Scanner sc = new Scanner(System.in);
	public boolean status;
	public static void main(String[] args) {
		
		login();
	}

	public static void inicio() {
		int escolha;

		

		Cadastrar cr = new Cadastrar();
		Emprestimo em = new Emprestimo();
		Relatório re = new Relatório();

		System.out.println("BIBLIOTECA");
		System.out.println("------------------");
		System.out.println("[1] Cadastro de itens " + "[2] Cadastro de usuarios " + "[3] Emprestico de itens "
				+ "[4] Emitir Relaório " + "[5] sair");
		escolha = sc.nextInt();

		switch (escolha) {

		case 1:
			cr.cadastroItem();
		case 2:
			cr.cadastroUsuario();
		case 3:
			em.EmprestimoLivro();
		case 4:
			re.Relatorio();
		case 5:
			System.out.println("Voce saiu");
		}
		System.out.println("erro");
		sc.close();
		
	}
	
	static void login() {
		String user;
		String senha;
		
		System.out.println("Digite seu usuario:");
		user = sc.next();
		System.out.println("Digite a sua senha:");
		senha = sc.next();
		Altenticar(user, senha);
		
	}
	static void Altenticar(String user, String senha){
		Map<String,String> auth = new HashMap<>();
		
		String path = "C:\\GitHub\\Biblioteca\\CSV\\Funcionarios.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while(line!= null) {
				
				
				line.split(",");
				System.out.println(line);
				line = br.readLine();
			}
		}catch(IOException e) {
			System.out.println("Error:" + e.getMessage());
		}
		
	}
	
}