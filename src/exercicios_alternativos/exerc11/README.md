## Exercício 11 — Empréstimos da Biblioteca

**Nível:** Difícil

**Assuntos praticados:**

* `ArrayList` de objetos;
* expressões lambda;
* `removeIf`;
* `stream().filter(...)` e `findFirst()`;
* cálculo com regras de negócio.
  **Objetivo:**
  Usar lambda de forma autônoma, e não apenas copiada da aula. A busca por atributo, que no Exercício 8 você fez com laço, aqui deve ser feita com `stream`.

**Enunciado:**
Uma biblioteca controla empréstimos. Cada empréstimo guarda o código do livro, o nome do aluno e o dia previsto para devolução (um número inteiro de dia, para simplificar). Um livro emprestado não pode ser emprestado de novo antes da devolução.

Na devolução, se houver atraso, cobra-se **R$ 1.50 por dia de atraso**. Empréstimos com mais de **10 dias** de atraso são cancelados automaticamente quando a biblioteca roda a limpeza.

**Requisitos de modelagem:**

* crie uma classe para o empréstimo, com um método que calcule a multa a partir do dia da devolução;
* o código do livro não muda depois de criado;
* use `stream().filter(...).findFirst()` para localizar um empréstimo pelo código;
* use `removeIf` na limpeza;
* a classe não imprime nada.
  **Diagrama da classe:**

```text
┌────────────────────────────────────────────────────┐
│                    Emprestimo                      │
├────────────────────────────────────────────────────┤
│ - MULTA_POR_DIA: double = 1.50 {static final}      │
│ - codigoLivro: int {final}                         │
│ - nomeAluno: String                                │
│ - diaPrevisto: int                                 │
├────────────────────────────────────────────────────┤
│ + Emprestimo(int, String, int)                     │
│ + getCodigoLivro(): int                            │
│ + getNomeAluno(): String                           │
│ + getDiaPrevisto(): int                            │
│ + diasDeAtraso(int diaAtual): int                  │
│ + estaAtrasado(int diaAtual): boolean              │
│ + multa(int diaDevolucao): double                  │
└────────────────────────────────────────────────────┘
```

`diasDeAtraso` devolve zero quando não há atraso, e os outros dois métodos se apoiam nele. Vale pensar em quais dos três podem ser escritos reaproveitando os outros, em vez de repetir a subtração.

**Entrada:**

* um inteiro **K**, a quantidade de operações;
* **K** operações, uma por linha:
    * `N codigo diaPrevisto aluno` → novo empréstimo;
    * `D codigo diaAtual` → devolução;
    * `A diaAtual` → relatório de atrasados;
    * `X diaAtual` → limpeza dos atrasos acima do limite.
      **Processamento:**

* `N` com um código já emprestado → recusa;
* `D` com código inexistente → mensagem;
* `D` válida → calcula a multa, informa e remove o empréstimo da lista;
* `A` → lista os empréstimos cujo dia previsto já passou, com a quantidade de dias de atraso de cada um, e a contagem no cabeçalho;
* `X` → remove os empréstimos com mais de 10 dias de atraso e informa quantos foram cancelados;
* ao final, liste os empréstimos ativos, ou `NENHUM EMPRESTIMO ATIVO`.
  **Conceito novo sinalizado:** para o cabeçalho de `A` você vai precisar contar quantos elementos passam por um filtro. O método `count()` de Stream faz isso e devolve um `long`; ele não apareceu no seu repositório, mas é o passo natural depois do `filter` que você já viu.

**Saída esperada:**
Multas com 2 casas decimais.

**Exemplo:**

```text
Entrada:
8
N 101 15 Ana Clara
N 202 20 Bruno Dias
N 303 5 Carla Mendes
N 101 18 Diego Rocha
D 404 22
D 101 18
A 25
X 25
 
Saída:
EMPRESTIMO REGISTRADO: 101 para Ana Clara (previsto dia 15)
EMPRESTIMO REGISTRADO: 202 para Bruno Dias (previsto dia 20)
EMPRESTIMO REGISTRADO: 303 para Carla Mendes (previsto dia 5)
LIVRO JA EMPRESTADO: 101
EMPRESTIMO NAO ENCONTRADO: 404
DEVOLVIDO: 101 - Ana Clara - ATRASO 3 dias - MULTA R$ 4.50
ATRASADOS (2):
202 - Bruno Dias - 5 dias
303 - Carla Mendes - 20 dias
CANCELADOS: 1
EMPRESTIMOS ATIVOS:
202 - Bruno Dias - previsto dia 20
```

Uma devolução sem atraso deve sair como `DEVOLVIDO: codigo - aluno - SEM ATRASO`.