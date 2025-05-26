package Projeto;


import java.util.ArrayList;
import java.util.List;

public class AlunoGerencia {
    private List<Aluno> alunos;

    public AlunoGerencia() {
        this.alunos = new ArrayList<>();
    }

    public void cadastrarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public Aluno buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return null;
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Aluno aluno : alunos) {
                System.out.println("- Nome: " + aluno.getNome() + ", MatrÃ­cula: " + aluno.getMatricula() + ", Ano de Ingresso: " + aluno.getAnoIngresso());
            }
        }
    }

    public int quantidadeAlunos() {
        return alunos.size();
    }

    public void listarAlunosPorDisciplina(String nomeDisciplina) {
        boolean found = false;
        for (Turma turma : TurmaGerencia.getInstance().getTurmas()) {
            if (turma.getDisciplina().getNome().equalsIgnoreCase(nomeDisciplina)) {
                for (Aluno aluno : turma.getAlunos()) {
                    System.out.println("- " + aluno.getNome());
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Nenhum aluno encontrado para a disciplina: " + nomeDisciplina);
        }
    }

    public void listarAlunosPorProfessor(String nomeProfessor) {
        boolean found = false;
        for (Turma turma : TurmaGerencia.getInstance().getTurmas()) {
            if (turma.getProfessor().getNome().equalsIgnoreCase(nomeProfessor)) {
                for (Aluno aluno : turma.getAlunos()) {
                    System.out.println("- " + aluno.getNome());
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Nenhum aluno encontrado para o professor: " + nomeProfessor);
        }
    }

    public List<Aluno> getAlunos() {
        return new ArrayList<>(alunos);
    }
}