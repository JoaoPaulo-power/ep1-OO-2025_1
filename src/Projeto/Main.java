package Projeto;

import java.io.File;
import java.io.BufferedReader; 
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    private static AlunoGerencia alunoGerencia = new AlunoGerencia();
    private static MateriaGerencia materiaGerencia = new MateriaGerencia();
    private static ProfGerencia profGerencia = new ProfGerencia();
    private static TurmaGerencia utilTurma = TurmaGerencia.getInstance();

    public static void main(String[] args) {
        int opcao;
        do {
            menu();
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite um número.");
                opcao = -1;
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    cadastrarProfessor();
                    break;
                case 3:
                    cadastrarMateria();
                    break;
                case 4:
                    cadastrarTurma();
                    break;
                case 5:
                    adicionarNota();
                    break;
                case 6:
                    listaAlunos();
                    break;
                case 7:
                    listarProfessores();
                    break;
                case 8:
                    listarMateria();
                    break;
                case 9:
                    listarTurmas();
                    break;
                case 10:
                    gerarCSV();
                    sair();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 10);
        scanner.close();
    }

    private static void cadastrarAluno() {
        System.out.println("-- CADASTRO ALUNO --");
        System.out.println("Nome:");
        String nome = scanner.nextLine().trim();
        if (nome.isEmpty()) {
            System.out.println("Nome invalido");
            return;
        }
        System.out.println("Data de nascimento (dia/mês/ano):");
        String dataNascimento = scanner.nextLine().trim();
        System.out.println("Telefone:");
        String telefone = scanner.nextLine().trim();
        System.out.println("Endereço:");
        String endereco = scanner.nextLine().trim();
        System.out.println("Matricula:");
        String matricula = scanner.nextLine().trim();
        if (matricula.isEmpty()) {
            System.out.println("Matricula invalida!");
            return;
        }
        System.out.println("Ano de ingresso:");
        String anoIngresso = scanner.nextLine().trim();

        Aluno aluno = new Aluno(nome, dataNascimento, telefone, endereco, matricula, anoIngresso);
        alunoGerencia.cadastrarAluno(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    private static void cadastrarProfessor() {
        System.out.println("-- CADASTRO PROFESSOR --");
        System.out.println("Nome:");
        String nome = scanner.nextLine().trim();
        if (nome.isEmpty()) {
            System.out.println("Nome invalido!");
            return;
        }
        System.out.println("Data de nascimento (dd/mm/aaaa):");
        String dataNascimento = scanner.nextLine().trim();
        System.out.println("Telefone:");
        String telefone = scanner.nextLine().trim();
        System.out.println("Endereço:");
        String endereco = scanner.nextLine().trim();
        System.out.println("Área de Formação:");
        String areaDeFormacao = scanner.nextLine().trim();
        System.out.println("Ano de Admissão:");
        String anoDeAdmissao = scanner.nextLine().trim();
        System.out.println("E-mail:");
        String email = scanner.nextLine().trim();

        Professor professor = new Professor(nome, dataNascimento, telefone, endereco, areaDeFormacao);
        professor.setAnoDeAdmissao(anoDeAdmissao);
        professor.setEmail(email);
        profGerencia.cadastrarProfessor(professor);
        System.out.println("Professor cadastrado com sucesso!");
    }

    private static void cadastrarMateria() {
        System.out.println("-- CADASTRO MATÉRIA --");
        System.out.println("Nome:");
        String nome = scanner.nextLine().trim();
        if (nome.isEmpty()) {
            System.out.println("Nome invalido");
            return;
        }
        System.out.println("Carga Horária:");
        String cargaHoraria = scanner.nextLine().trim();
        System.out.println("Código:");
        String codigo = scanner.nextLine().trim();
        if (codigo.isEmpty()) {
            System.out.println("Código invalido!");
            return;
        }

        Materia materia = new Materia(nome, cargaHoraria, codigo);
        materiaGerencia.cadastrarDisciplina(materia);
        System.out.println("Matéria cadastrada com sucesso!");
    }

    private static void cadastrarTurma() {
        System.out.println("-- CADASTRAR NOVA TURMA --");
        System.out.println("Escolha um professor:");
        profGerencia.listarProfessores();
        System.out.println("Nome do Professor(a):");
        String nomeProfessor = scanner.nextLine().trim();
        Professor professor = profGerencia.buscarProfessor(nomeProfessor);

        if (professor == null) {
            System.out.println("Professor não encontrado. Tente novamente.");
            return;
        }

        System.out.println("Escolha uma matéria:");
        materiaGerencia.listarDisciplinas();
        System.out.print("Nome da matéria: ");
        String nomeMateria = scanner.nextLine().trim();
        Materia materia = materiaGerencia.buscarDisciplina(nomeMateria);

        if (materia == null) {
            System.out.println("Matéria não encontrada. Tente novamente.");
            return;
        }

        System.out.println("Ano Letivo:");
        int anoLetivo;
        try {
            anoLetivo = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Ano inválido. Tente novamente.");
            return;
        }

        System.out.println("Código:");
        int codigo;
        try {
            codigo = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Código inválido. Tente novamente.");
            return;
        }

        System.out.println("Deseja adicionar alunos à turma? (s/n):");
        String resposta = scanner.nextLine().trim().toLowerCase();
        Turma turma = new Turma(codigo, materia, professor);
        turma.setAnoLetivo(anoLetivo);
        if (resposta.equals("s")) {
            System.out.println("Lista de alunos disponíveis:");
            alunoGerencia.listarAlunos();
            System.out.println("Digite os nomes dos alunos:");
            while (true) {
                String nomeAluno = scanner.nextLine().trim();
                if (nomeAluno.isEmpty()) break;
                Aluno aluno = alunoGerencia.buscarAluno(nomeAluno);
                if (aluno != null) {
                    turma.addAluno(aluno);
                    System.out.println("Aluno " + nomeAluno + " adicionado à turma.");
                } else {
                    System.out.println("Aluno " + nomeAluno + " não encontrado.");
                }
            }
        }

        professor.addDisciplina(materia);
        materia.addProfessor(professor);
        utilTurma.cadastrarTurma(turma);
        System.out.println("Turma cadastrada com sucesso!");
    }

    private static void adicionarNota() {
        System.out.println("-- ADICIONANDO NOTA --");
        System.out.println("Escolha uma matéria:");
        materiaGerencia.listarDisciplinas();
        System.out.print("Nome da matéria: ");
        String nomeMateria = scanner.nextLine().trim();
        Materia materia = materiaGerencia.buscarDisciplina(nomeMateria);

        if (materia == null) {
            System.out.println("Matéria não encontrada. Tente novamente.");
            return;
        }

        System.out.println("Escolha aluno:");
        alunoGerencia.listarAlunos();
        System.out.print("Nome do aluno: ");
        String nomeAluno = scanner.nextLine().trim();
        Aluno aluno = alunoGerencia.buscarAluno(nomeAluno);

        if (aluno == null) {
            System.out.println("Aluno não encontrado. Tente novamente.");
            return;
        }

        System.out.print("Informe a Nota: ");
        double valorNota;
        try {
            valorNota = Double.parseDouble(scanner.nextLine().trim());
            if (valorNota < 0 || valorNota > 10) {
                System.out.println("Nota deve estar entre 0 e 10. Tente novamente.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Nota Invalida.");
            return;
        }

        System.out.print("Informe a data da nota (dia/mês/ano): ");
        String dataNota = scanner.nextLine().trim();
        if (!dataNota.matches("\\d{2}/\\d{2}/\\d{4}")) {
            System.out.println("Formato de data inválido. Use dia/mês/ano.");
            return;
        }

        Nota novaNota = new Nota(valorNota, dataNota, aluno, materia);
        aluno.addNota(novaNota);
        System.out.println("Nota adicionada com sucesso!");
    }

    private static void listaAlunos() {
        System.out.println("-- LISTA ALUNOS --");
        alunoGerencia.listarAlunos();
    }

    private static void listarProfessores() {
        System.out.println("-- LISTA DE PROFESSORES --");
        profGerencia.listarProfessores();
    }

    private static void listarMateria() {
        System.out.println("-- LISTA DE MATÉRIAS --");
        materiaGerencia.listarDisciplinas();
    }

    private static void listarTurmas() {
        System.out.println("-- LISTA DE TURMAS --");
        TurmaGerencia.listarTurmas(); //se mudar o system print ou o codigo quebra??????
    }

    private static String escapeCSV(String field) {
        if (field == null) return "";
        if (field.contains("\"") || field.contains(",") || field.contains("\n")) {
            return "\"" + field.replace("\"", "\"\"") + "\"";
        }
        return field;
    }

    private static void gerarCSV() {
        System.out.println("| | SALVANDO... | |");

        File outputDir = new File("output");
        if (!outputDir.exists() && !outputDir.mkdirs()) {
            System.out.println("Erro ao criar diretório 'output'. Tentando diretório Desktop...");
            outputDir = new File(System.getProperty("user.home") + "/Desktop/output");
            if (!outputDir.exists() && !outputDir.mkdirs()) {
                System.err.println("Erro ao salvar!");
                return;
            }
        }


        boolean hasData = false;
        if (!alunoGerencia.getAlunos().isEmpty() || !profGerencia.getProfessores().isEmpty() ||
            !materiaGerencia.getDisciplinas().isEmpty() || !utilTurma.getTurmas().isEmpty()) {
            hasData = true;
        }

        if (!hasData) {
            System.out.println("Nenhum dado cadastrado. Os arquivos CSV conterão apenas cabeçalhos.");
        }

        try (FileWriter writer = new FileWriter(new File(outputDir, "alunos.csv"), StandardCharsets.UTF_8)) {
            writer.write("\uFEFF"); //meu deus
            writer.write("Nome,DataNascimento,Telefone,Endereco,Matricula,AnoIngresso\n");
            for (Aluno aluno : alunoGerencia.getAlunos()) {
                writer.write(String.format("%s,%s,%s,%s,%s,%s\n",
                        escapeCSV(aluno.getNome()),
                        escapeCSV(aluno.getDataNascimento()),
                        escapeCSV(aluno.getTelefone()),
                        escapeCSV(aluno.getEndereco()),
                        escapeCSV(aluno.getMatricula()),
                        escapeCSV(aluno.getAnoIngresso())));
            }
            System.out.println("Arquivo output/alunos.csv gerado com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao gerar output/alunos.csv: " + e.getMessage());
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(new File(outputDir, "professores.csv"), StandardCharsets.UTF_8)) {
            writer.write("\uFEFF");
            writer.write("Nome,DataNascimento,Telefone,Endereco,AreaFormacao,AnoAdmissao,Email\n");
            for (Professor professor : profGerencia.getProfessores()) {
                writer.write(String.format("%s,%s,%s,%s,%s,%s,%s\n",
                        escapeCSV(professor.getNome()),
                        escapeCSV(professor.getDataNascimento()),
                        escapeCSV(professor.getTelefone()),
                        escapeCSV(professor.getEndereco()),
                        escapeCSV(professor.getAreaDeFormacao()),
                        escapeCSV(professor.getAnoDeAdmissao()),
                        escapeCSV(professor.getEmail())));
            }
            System.out.println("Arquivo output/professores.csv gerado com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao gerar output/professores.csv: " + e.getMessage());
            e.printStackTrace();
        }
        
        try (FileWriter writer = new FileWriter(new File(outputDir, "materias.csv"), StandardCharsets.UTF_8)) {
            writer.write("\uFEFF");
            writer.write("Nome,CargaHoraria,Codigo\n");
            for (Materia materia : materiaGerencia.getDisciplinas()) {
                writer.write(String.format("%s,%s,%s\n",
                        escapeCSV(materia.getNome()),
                        escapeCSV(materia.getCargaHoraria()),
                        escapeCSV(materia.getCodigo())));
            }
            System.out.println("Arquivo output/materias.csv gerado com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao gerar output/materias.csv: " + e.getMessage());
            e.printStackTrace();
        }
        
        try (FileWriter writer = new FileWriter(new File(outputDir, "turmas.csv"), StandardCharsets.UTF_8)) {
            writer.write("\uFEFF");
            writer.write("Codigo,Materia,Professor,AnoLetivo,QuantidadeAlunos\n");
            for (Turma turma : utilTurma.getTurmas()) {
                String materiaNome = turma.getDisciplina() != null ? turma.getDisciplina().getNome() : "";
                String professorNome = turma.getProfessor() != null ? turma.getProfessor().getNome() : "";
                int alunoCount = turma.getAlunos() != null ? turma.getAlunos().size() : 0;
                writer.write(String.format("%d,%s,%s,%d,%d\n",
                        turma.getCodigo(),
                        escapeCSV(materiaNome),
                        escapeCSV(professorNome),
                        turma.getAnoLetivo(),
                        alunoCount));
            }
            System.out.println("Arquivo output/turmas.csv gerado com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao gerar output/turmas.csv: " + e.getMessage());
            e.printStackTrace();
        }
        try (FileWriter writer = new FileWriter(new File(outputDir, "notas.csv"), StandardCharsets.UTF_8)) {
            writer.write("\uFEFF");
            writer.write("Aluno,Materia,Nota,Data\n");
            for (Aluno aluno : alunoGerencia.getAlunos()) {
                for (Nota nota : aluno.getNotas()) {
                    String materiaNome = nota.getMateria() != null ? nota.getMateria().getNome() : "";
                    writer.write(String.format("%s,%s,%.2f,%s\n",
                            escapeCSV(aluno.getNome()),
                            escapeCSV(materiaNome),
                            nota.getValor(),
                            escapeCSV(nota.getData())));
                }
            }
            System.out.println("Arquivo output/notas.csv gerado com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao gerar output/notas.csv: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void sair() {
        System.out.println("==============================================");
        System.out.println("=================== Salvando... ================");
        System.out.println("==============================================");
    }

    private static void menu() {
        System.out.println("--Menu Principal--");
        System.out.println("Acesse:");
        System.out.println(" 1 - Cadastro de Aluno");
        System.out.println(" 2 - Cadastro de Professor");
        System.out.println(" 3 - Cadastro de Matéria");
        System.out.println(" 4 - Cadastro de Turma");
        System.out.println(" 5 - Notas");
        System.out.println(" 6 - Alunos Cadastrados");
        System.out.println(" 7 - Professores Cadastrados");
        System.out.println(" 8 - Matérias");
        System.out.println(" 9 - Turmas");
        System.out.println(" 10 - Salvar e Sair");
        System.out.println("\nEscolha uma opção:");
    }
}