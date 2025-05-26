package Projeto;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
    private String matricula;
    private String anoIngresso;

    private Turma turma;


    private List<Nota> notas = new ArrayList<>();

    public Aluno(String nome, String dataNascimento, String telefone, String endereco, String matricula, String anoIngresso) {
        super(nome, dataNascimento, telefone, endereco);
        this.matricula = matricula;
        this.anoIngresso = anoIngresso;
    }

        public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(String anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void addNota(Nota nota) {
        notas.add(nota);
    }
}