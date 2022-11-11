package biblioteca;

public class Alunos {
    private int matricula;
    private String nome, endereco, curso, data, multa;

    public Alunos(int matricula, String nome, String endereco, String curso, String data, String multa) {
        super();
        this.matricula = 0;
        this.nome = nome;
        this.endereco = endereco;
        this.curso = curso;
        this.data = data;
        this.multa = multa;

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
    public String getMulta(){
        return multa;
    }
    public void setMulta(String multa){
        this.multa = multa;
    }
    @Override
    public String toString() {
        return  matricula + "," + nome + "," + endereco + "," + curso
                + "," + data + ","+ multa;
    }
}
