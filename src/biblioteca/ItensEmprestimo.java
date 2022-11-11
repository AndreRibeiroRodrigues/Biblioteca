package biblioteca;

public class ItensEmprestimo{
    private int codigoitem, codigoemprestimo, codigolivro, codigoperiodico;
    private String datadevolucao;

    public ItensEmprestimo(int codigoitem, int codigoemprestimo, int codigolivro, int codigoperiodico, String datadevolucao){
        super();
        this.codigoitem = codigoitem;
        this.codigoemprestimo = codigoemprestimo;
        this.codigolivro = codigolivro;
        this.codigoperiodico = codigoperiodico;
        this.datadevolucao = datadevolucao;
    }

    public int getCodigoitem(){ 
        return codigoitem;
    }

    public void setCodigoitem(int codigoitem){
        this.codigoitem = codigoitem;
    }

    public int getCodigoemprestimo(){
        return codigoemprestimo;
    }

    public void setCodigoemprestimo(int codigoemprestimo){
        this.codigoemprestimo = codigoemprestimo;
    }

    public int getCodigolivro(){
        return codigolivro;
    }

    public void setCodigolivro(int codigolivro){
        this.codigolivro = codigolivro;
    }

    public int getCodigoperiodico(){
        return codigoperiodico;
    }

    public void setCodigoperiodico(int codigoperiodico){
        this.codigoperiodico = codigoperiodico;
    }
    public String getDatadevolucao(){
        return datadevolucao;
    }
    public void setDatadevolucao(String datadevolucao){
        this.datadevolucao = datadevolucao;
    }
    @Override
    public String toString(){
        return codigoitem + "," + codigoemprestimo + "," + codigolivro + "," + codigoperiodico + "," + datadevolucao;
    }
}