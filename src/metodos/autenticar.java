package metodos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Auth;

public class autenticar {
	static void Altenticar(String user, String senha) {
		List<String> funcio = new ArrayList<>();
		List<String> senh = new ArrayList<>();

		Auth at = new Auth();

		String path = "Biblioteca\\CSV\\Funcionarios.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			line = br.readLine();

			while (line != null) {

				String[] vect = line.split(",");
				at.setUsuario(vect[6]);
				at.setSenha(vect[5]);
				
				funcio.add(at.getUsuario());
				senh.add(at.getSenha());

				line = br.readLine();
			}

			if (funcio.contains(user)) {
				if (senh.contains(senha)) {
					at.setStatus(true);
				}
			} else {
				at.setStatus(false);

			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
}
