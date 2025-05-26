package Projeto;


public class Pessoa {


    //atributos
    private String nome;
    private String dataNascimento;
    private String telefone;
    private String endereco;

    //construtores
    public Pessoa (String nome, String dataNascimento, String telefone, String endereco ){
        this.nome =  nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Pessoa(String nome) {

    }

    public Pessoa() {

    }

    //get e set
    public String getEndereco() {

        return endereco;
    }

    public void setEndereco(String endereco) {

        this.endereco = endereco;
    }

    public String getTelefone() {

        return telefone;
    }

    public void setTelefone(String telefone) {

        this.telefone = telefone;
    }

    public String getDataNascimento() {

        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {

        this.dataNascimento = dataNascimento;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }






}