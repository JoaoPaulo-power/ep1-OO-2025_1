package Projeto;
public class Nota {
    private double valor;
    private String data;
    private Aluno aluno;
    private Materia disciplina;

    public Nota(double valor, String data, Aluno aluno, Materia disciplina) {
        this.valor = valor;
        this.data = data;
        this.aluno = aluno;
        this.disciplina = disciplina;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Materia getMateria() {
        return disciplina;
    }

    @Override
    public String toString() {
        return "Nota: " + valor +
               ", Data: " + data +
               ", Aluno: " + aluno.getNome() +
               ", Disciplina: " + disciplina.getNome();
    }
}

