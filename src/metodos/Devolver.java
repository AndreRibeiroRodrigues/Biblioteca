package metodos;

import java.util.List;
import java.util.Scanner;

import entities.Alunos;
import entities.Emprestimo;
import entities.ItensEmprestimo;

public class Devolver {
    Scanner sc = new Scanner(System.in);

    public void devolucao(List<Emprestimo> emprestimos, List<ItensEmprestimo> itensEmprestimos, List<Alunos> alunos) {
        String nome;

        System.out.println("Quem deseja devolver:");
        nome = sc.nextLine();

        
    }
}
