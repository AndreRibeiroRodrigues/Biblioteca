// package metodos;

// import java.util.List;
// import java.util.Scanner;

// import entities.Aluno;
// import entities.Emprestimo;
// import entities.ItensEmprestimo;

// public class Devolver {
//     Scanner sc = new Scanner(System.in);

//     public void devolucao(List<Emprestimo> emprestimos, List<ItensEmprestimo> itensEmprestimos, List<Aluno> alunos) {
        

//         System.out.println("Quem deseja devolver:");
//         int matricula = sc.nextInt();
//         if(getAluno(alunos,matricula) != null){
            
//         getAluno(alunos,matricula);
//         int codigoemprestigo = getEmprestimo(emprestimos, matricula).getCodigo();
//         getitensEmprestimo(itensEmprestimos, codigoemprestigo);

        

//         }else{
//             System.out.println("Usuario invalido");
//         }
//     }

//     public Aluno getAluno(List<Aluno> alunos, int matricula) {
// 		for (int i = 0; i < alunos.size(); i++) {
// 			if (alunos.get(i).getMatricula() == matricula){
// 				return alunos.get(i);
//             }
// 		}

// 		return null;
// 	}
    
//     public Emprestimo getEmprestimo(List<Emprestimo> emprestimos, int matricula) {
// 		for (int i = 0; i < emprestimos.size(); i++) {
// 			if (emprestimos.get(i).getCodigoCliente() == matricula){
// 				return emprestimos.get(i);
//             }
// 		}

// 		return null;
// 	}

//     public Emprestimo getitensEmprestimo(List<ItensEmprestimo> itensEmprestimos, int matricula) {
// 		for (int i = 0; i < itensEmprestimos.size(); i++) {
// 			if (itensEmprestimos.get(i).getCodigoemprestimo() == matricula){
// 				return emprestimos.get(i);
//             }
// 		}

// 		return null;
// 	}

// }
