package Projeto;


import java.util.ArrayList;
import java.util.List;

public class TurmaGerencia {
    private static volatile TurmaGerencia instance;
    private static List<Turma> turmas;

    private TurmaGerencia() {
        this.turmas = new ArrayList<>();
    }

    public static TurmaGerencia getInstance() {
        if (instance == null) {
            synchronized (TurmaGerencia.class) {
                if (instance == null) {
                    instance = new TurmaGerencia();
                }
            }
        }
        return instance;
    }

    public void cadastrarTurma(Turma turma) {
        if (turma.getProfessor() == null) {
            System.out.println("Erro: A turma deve estar associada a um professor.");
            return;
        }
        if (turma.getDisciplina() == null) {
            System.out.println("Erro: A turma deve estar associada a uma disciplina.");
            return;
        }
        turmas.add(turma);
        System.out.println("Turma cadastrada com sucesso!");
    }

    public static void listarTurmas() {
        try {
			if (turmas.isEmpty()) {
			    System.out.println("Nenhuma turma cadastrada.");
			} else {
			    for (Turma turma : turmas) {
			        System.out.println(turma.toString());
			    }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }//meu deus 2

    public List<Turma> getTurmas() {
        return new ArrayList<>(turmas);
    }
}