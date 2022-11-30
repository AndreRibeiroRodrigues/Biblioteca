package entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        var path = "C:\\GitHub\\Biblioteca-main\\CSV";

        List<ItensEmprestimo> ItensEmprestimos = new ArrayList<>();
        try (BufferedReader lineReader = new BufferedReader(new FileReader(path + "\\ItensEmprestimo.csv"))) {
            String line = lineReader.readLine();
            while (line != null) {
                line = lineReader.readLine();
                if (line != null) {
                    String[] vect = line.replaceAll("\"", "").split(";");
                    ItensEmprestimo aluno = new ItensEmprestimo(Integer.parseInt(vect[0]), Integer.parseInt(vect[1]),
                            Integer.parseInt(vect[2]), vect[3]);
                    ItensEmprestimos.add(aluno);
                } else {
                    break;
                }
            }
            return ItensEmprestimos;
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