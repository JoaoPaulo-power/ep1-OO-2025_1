package Projeto;


import java.util.ArrayList;
import java.util.List;

public class ProfGerencia{
    private List<Professor> professores;

    public ProfGerencia() {
        this.professores = new ArrayList<>();
    }

    public void cadastrarProfessor(Professor professor) {
        professores.add(professor);
    }

    public Professor buscarProfessor(String nome) {
        for (Professor professor : professores) {
            if (professor.getNome().equalsIgnoreCase(nome)) {
                return professor;
            }
        }
        return null;
    }

    public void listarProfessores() {
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
        } else {
            for (Professor professor : professores) {
                System.out.println("- Nome: " + professor.getNome() + ", Área: " + professor.getAreaDeFormacao() + ", Email: " + professor.getEmail());
            }
        }
    }

    public List<Professor> getProfessores() {
        return new ArrayList<>(professores);
    }
}