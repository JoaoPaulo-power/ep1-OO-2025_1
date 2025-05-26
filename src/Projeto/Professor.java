package Projeto;


import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa {
    private String areaDeFormacao;
    private String anoDeAdmissao;
    private String email;
    private List<Materia> disciplinas = new ArrayList<>();

 
    public Professor(String nome, String dataNascimento, String telefone, String endereco,
                     String areaDeFormacao) {
        super(nome, dataNascimento, telefone, endereco);
        this.areaDeFormacao = areaDeFormacao;	

    }
    
    public String getAreaDeFormacao() {
        return areaDeFormacao;
    }

    public void setAreaDeFormacao(String areaDeFormacao) {
        this.areaDeFormacao = areaDeFormacao;
    }

    public String getAnoDeAdmissao() {
        return anoDeAdmissao;
    }

    public void setAnoDeAdmissao(String anoDeAdmissao) {
        this.anoDeAdmissao = anoDeAdmissao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Materia> getDisciplinas() {
        return disciplinas;
    }

    public void addDisciplina(Materia disciplina) {
        disciplinas.add(disciplina);
    }
}