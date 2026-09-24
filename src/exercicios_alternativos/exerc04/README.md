## Exercício 4 — Planilha de Notas (revisão)

**Nível:** Básico+

**Assuntos praticados:**

* vetores e matriz no mesmo programa;
* estruturas condicionais em faixas;
* `do-while`;
* leitura de nomes com espaços.
  **Objetivo:**
  Revisar tudo o que foi visto até aqui em um único problema, incluindo os dois pontos que já causaram erros no seu repositório: leitura de nomes completos e seguir o formato de saída.

**Enunciado:**
Um professor precisa de uma planilha para uma turma. Cada aluno faz **P provas**. O programa deve mostrar a situação de cada aluno, a média de cada prova e depois permitir consultas individuais.

**Entrada:**

* dois inteiros **N** (alunos) e **P** (provas);
* para cada aluno:
    * o nome completo em uma linha (pode ter espaços);
    * as **P** notas na linha seguinte;
* uma sequência de números de consulta (de 1 a N), terminada por `0`.
  **Processamento:**

* guarde os nomes em um vetor e as notas em uma matriz N × P;
* calcule a média de cada aluno e classifique:
    * média ≥ 7.0 → `APROVADO`;
    * média ≥ 5.0 → `RECUPERACAO`;
    * abaixo de 5.0 → `REPROVADO`;
* calcule a média de cada prova (média de cada **coluna** da matriz);
* o laço de consultas deve ser feito com **`do-while`**:
    * número entre 1 e N: mostre o nome e as notas do aluno com 1 casa decimal;
    * número fora da faixa (exceto 0): mostre `ALUNO INEXISTENTE`;
    * `0`: encerra sem imprimir nada.
      **Saída esperada:**
      Médias com 2 casas decimais. Siga exatamente o formato do exemplo.

**Exemplo:**

```text
Entrada:
3 3
Ana Paula Souza
8.0 7.5 9.0
Bruno Lima
5.0 4.0 6.5
Carlos Eduardo
3.0 4.5 2.0
2
5
0
 
Saída:
RELATORIO
Ana Paula Souza: 8.17 APROVADO
Bruno Lima: 5.17 RECUPERACAO
Carlos Eduardo: 3.17 REPROVADO
MEDIA POR PROVA
Prova 1: 5.33
Prova 2: 5.33
Prova 3: 5.83
CONSULTA 2: Bruno Lima -> 5.0 4.0 6.5
CONSULTA 5: ALUNO INEXISTENTE
```