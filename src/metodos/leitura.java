package metodos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Alunos;

public class leitura {
	public static void main(String[] args) {
		String path = "C:\\GitHub\\Biblioteca\\CSV\\Aluno.txt";
		
		List<Alunos> list = new ArrayList<Alunos>();
		

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			/* vai ler linha a linha */
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				String[] vect = line.split(",");
				int mat = Integer.parseInt(vect[0]);
				String nome = vect[1];
				String endereco = vect[2];
				String curso = vect[3];
				String data = vect[4];
				Double multa = Double.parseDouble(vect[5]);
				 
				
				Alunos prod = new Alunos(mat, nome, endereco, curso, data, multa);
				list.add(prod);
				
				line = br.readLine();
			}
			System.out.println("PRODUCTS:");
			System.out.println("Matricula,nome,endereco,curso,data,multa");
			for(Alunos p : list) {
				System.out.println(p);
			}
		} catch (IOException e) {
			System.out.println("error:" + e.getMessage());
		}
	}
}
