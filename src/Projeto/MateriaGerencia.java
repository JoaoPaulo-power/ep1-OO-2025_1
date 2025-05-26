package Projeto;


import java.util.ArrayList;
import java.util.List;

public class MateriaGerencia {
    private List<Materia> disciplinas;

    public MateriaGerencia() {
        this.disciplinas = new ArrayList<>();
    }

    public void cadastrarDisciplina(Materia disciplina) {
        disciplinas.add(disciplina);
    }

    public Materia buscarDisciplina(String nome) {
        for (Materia disciplina : disciplinas) {
            if (disciplina.getNome().equalsIgnoreCase(nome)) {
                return disciplina;
            }
        }
        return null;
    }

    public void listarDisciplinas() {
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
        } else {
            for (Materia disciplina : disciplinas) {
                System.out.println("- Nome: " + disciplina.getNome() + ", Código: " + disciplina.getCodigo() + ", Carga Horária: " + disciplina.getCargaHoraria());
            }
        }
    }

    public List<Materia> getDisciplinas() {
        return new ArrayList<>(disciplinas);
    }
}