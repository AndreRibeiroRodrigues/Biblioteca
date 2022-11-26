package entities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import metodos.Biblioteca;

public class Alunos {
    private int matricula;
    private String nome, endereco, curso, data;
    private double multa;

    public static void cadastroAluno() {
        // Matricula,Nome,Endereco,Curso,DataIngresso,Multa
        String path = "C:\\GitHub\\Biblioteca\\CSV\\Aluno.csv";
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

            try {
                FileWriter local = new FileWriter(path, true);
                PrintWriter pw = new PrintWriter(local);
                pw.println(aluno.toString());
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
    public double getMulta(){
        return multa;
    }
    public void setMulta(double multa){
        this.multa = multa;
    }
    @Override
    public String toString() {
        return  matricula + "," + nome + "," + endereco + "," + curso
                + "," + data + ","+ multa;
    }
}
