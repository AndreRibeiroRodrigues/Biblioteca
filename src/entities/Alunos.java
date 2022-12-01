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

public class Alunos {
    private int matricula;
    private String nome, endereco, curso, data;
    private double multa;

    public Alunos(int matricula, String nome, String endereco, String curso, String data, double multa) {
        this.matricula = matricula;
        this.nome = nome;
        this.endereco = endereco;
        this.curso = curso;
        this.data = data;
        this.multa = multa;
    }

    public Alunos() {
    }

    public void valores(List<Alunos> alunos) throws FileNotFoundException, IOException {
        var path = "C:\\GitHub\\Biblioteca\\CSV";

       
        try (BufferedReader lineReader = new BufferedReader(new FileReader(path + "\\Alunos.csv"))) {
            String line = lineReader.readLine();
            while (line != null) {
                line = lineReader.readLine();
                if (line == null || line.isEmpty()) {
                    break;
                }
                String[] vect = line.replaceAll("\"", "").split(",");
                Alunos aluno = new Alunos(Integer.parseInt(vect[0]), vect[1], vect[2], vect[3], vect[4],
                        Double.parseDouble(vect[5]));
                alunos.add(aluno);

            }
        }
    }

    public void persisteDados(List<Alunos> alunos) {
        var path = "C:\\GitHub\\Biblioteca\\CSV";

        try {
            FileWriter local = new FileWriter(path + "\\Alunos.csv");
            PrintWriter pw = new PrintWriter(local);

            for (int i = 0; i < alunos.size(); i++) {
                pw.println(alunos.get(i).toString());
                pw.flush();
            }

            pw.close();

        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static void cadastroAluno(List<Livro> livros, List<ItensEmprestimo> itensEmprestimos,
            List<Funcionario> funcionarios,
            List<Alunos> alunos, List<Emprestimo> emprestimos) {
        // Matricula,Nome,Endereco,Curso,DataIngresso,Multa

        Scanner sc = new Scanner(System.in);

        Alunos aluno = new Alunos();
        String es;

        System.out.println("voce inicou o cadastro de alunos");

        do {
            System.out.println("Digite a matricula do aluno:");
            aluno.setMatricula(sc.nextInt());
            while (aluno.getMatricula() > 99999999 || aluno.getMatricula() < 10000000) {
                System.out.println("Valor invalido");
                System.out.println("Digite novamente");
                aluno.setMatricula(sc.nextInt());
            }

            sc.nextLine();
            System.out.println("Digite o nome do aluno:");
            aluno.setNome(sc.nextLine());

            System.out.println("Digite o endereço do aluno:");
            aluno.setEndereco(sc.nextLine());
            System.out.println("Informe a data de ingresso:");

            System.out.println("Digite o dia:");
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
            aluno.setData(dia + "/" + mes + "/" + ano);
            alunos.add(aluno);

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
        sc.close();
        Biblioteca.inicio(livros, itensEmprestimos, funcionarios, alunos, emprestimos);
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

    public String getcurso() {
        return curso;
    }

    public void setSetor(String setor) {
        this.curso = setor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    @Override
    public String toString() {
        return matricula + "," + nome + "," + endereco + "," + curso
                + "," + data + "," + multa;
    }
}
