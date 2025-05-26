# Sistema Acadêmico - FCTE

## Descrição do Projeto

Desenvolvimento de um sistema acadêmico para gerenciar alunos, disciplinas, professores, turmas, avaliações e frequência, utilizando os conceitos de orientação a objetos (herança, polimorfismo e encapsulamento) e persistência de dados em arquivos.

O enunciado do trabalho pode ser encontrado aqui:
- [Trabalho 1 - Sistema Acadêmico](https://github.com/lboaventura25/OO-T06_2025.1_UnB_FCTE/blob/main/trabalhos/ep1/README.md)

## Dados do Aluno

- **Nome completo:** João Paulo de Sousa Lima
- **Matrícula:** 242005338
- **Curso:** Orientação a Objetos - 2025/1
- **Turma:** 06

---

## Instruções para Compilação e Execução

1. **Compilação:**  
   [Descrever aqui como compilar o projeto. Exemplo: `javac Main.java` ou o script usado]

2. **Execução:**  
   [Descrever aqui como executar o projeto. Exemplo: `java Main` ou o script usado]

3. **Estrutura de Pastas:**  
   -Main

      -Pessoa

         -Professor
               -ProfGerencia
            -Aluno
               -AlunoGerencia
   
-Materia
      -MateriaGerencia
   
-Nota
   -Turma
       -TurmaGerencia

   -Output (Dados em CSV)

3. **Versão do JAVA utilizada:**  
   Java 21

---

## Vídeo de Demonstração

- [Inserir o link para o vídeo no YouTube/Drive aqui]

---

## Prints da Execução

1. Menu Principal:  
   ![Inserir Print 1](caminho/do/print1.png)

2. Cadastro de Aluno:  
   ![Inserir Print 2](caminho/do/print2.png)

3. Relatório de Frequência/Notas:  
   ![Inserir Print 3](caminho/do/print3.png)

---

## Principais Funcionalidades Implementadas

- [X] Cadastro, listagem, matrícula e trancamento de alunos (Normais e Especiais)
- [X] Cadastro de disciplinas e criação de turmas (presenciais e remotas)
- [X] Matrícula de alunos em turmas, respeitando vagas e pré-requisitos
- [X] Lançamento de notas e controle de presença
- [ ] Cálculo de média final e verificação de aprovação/reprovação
- [X] Relatórios de desempenho acadêmico por aluno, turma e disciplina
- [X] Persistência de dados em arquivos (.txt ou .csv)
- [ ] Tratamento de duplicidade de matrículas
- [X] Uso de herança, polimorfismo e encapsulamento

---

## Observações (Extras ou Dificuldades)

- A maior dificuldade foi implementar e salvar os dados em CSV. Além da tentativa de criação de um banco de dados utilizando o MySQL e a criação de uma interface gráfica utilizando o Jframe, que forma deixados de lado da parte final do projeto devido a complexidade da implementação de ambos no código final.

---

## Contato

- joaopaulosousalima975@gmail.com
