package entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ItensEmprestimo {
    private int codigoitem, codigoemprestimo, codigolivro;
    private String datadevolucao;

    public ItensEmprestimo(int codigoitem, int codigoemprestimo, int codigolivro, String datadevolucao) {
        super();
        this.codigoitem = codigoitem;
        this.codigoemprestimo = codigoemprestimo;
        this.codigolivro = codigolivro;
        this.datadevolucao = datadevolucao;
    }

    public ItensEmprestimo() {
    }

    public List<ItensEmprestimo> valores() throws FileNotFoundException, IOException {
        var path = "C:\\GitHub\\Biblioteca\\CSV";

        List<ItensEmprestimo> ItensEmprestimos = new ArrayList<>();
        try (BufferedReader lineReader = new BufferedReader(new FileReader(path + "\\ItensEmprestimos.csv"))) {
            String line = lineReader.readLine();
            while (line != null) {
                line = lineReader.readLine();
                if (line == null || line.isEmpty()) {
                    break;
                }
                String[] vect = line.replaceAll("\"", "").split(";");
                ItensEmprestimo aluno = new ItensEmprestimo(Integer.parseInt(vect[0]), Integer.parseInt(vect[1]),
                        Integer.parseInt(vect[2]), vect[3]);
                ItensEmprestimos.add(aluno);

            }
            return ItensEmprestimos;
        }
    }

    public void persisteDados(List<ItensEmprestimo> itensEmprestimos) {
		var path = "C:\\GitHub\\Biblioteca\\CSV";

		try {
			FileWriter local = new FileWriter(path + "\\ItensEmprestimos.csv");
			PrintWriter pw = new PrintWriter(local);

			for (int i = 0; i < itensEmprestimos.size(); i++) {
				pw.println(itensEmprestimos.get(i).toString());
				pw.flush();
			}

			pw.close();
		} catch (IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}

    public int getCodigoitem() {
        return codigoitem;
    }

    public void setCodigoitem(int codigoitem) {
        this.codigoitem = codigoitem;
    }

    public int getCodigoemprestimo() {
        return codigoemprestimo;
    }

    public void setCodigoemprestimo(int codigoemprestimo) {
        this.codigoemprestimo = codigoemprestimo;
    }

    public int getCodigolivro() {
        return codigolivro;
    }

    public void setCodigolivro(int codigolivro) {
        this.codigolivro = codigolivro;
    }

    public String getDatadevolucao() {
        return datadevolucao;
    }

    public void setDatadevolucao(String datadevolucao) {
        this.datadevolucao = datadevolucao;
    }

    @Override
    public String toString() {
        return codigoitem + "," + codigoemprestimo + "," + codigolivro + "," + datadevolucao;
    }
}