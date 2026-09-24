## Exercício 3 — Sala de Cinema

**Nível:** Básico

**Assuntos praticados:**

* matrizes;
* laços aninhados;
* validação de índices;
* contadores e percentuais.
  **Objetivo:**
  Praticar matrizes além do exercício único do repositório: leitura, alteração, validação de posições e relatórios por linha.

**Enunciado:**
Um cinema representa a sala como uma matriz de **M fileiras** por **N cadeiras**. Cada posição vale `0` (livre) ou `1` (ocupada). O sistema recebe pedidos de reserva e, ao final, gera um relatório da sala.

**Entrada:**

* dois inteiros **M** e **N** (dimensões da sala);
* a matriz M × N com valores `0` ou `1`;
* um inteiro **K**, a quantidade de pedidos de reserva;
* **K** pares de inteiros `fileira cadeira`.
  **Processamento:**

* para cada pedido:
    * se a posição não existir na sala (índice negativo ou além do limite), imprima `INVALIDO`;
    * se a cadeira já estiver ocupada, imprima `OCUPADO`;
    * caso contrário, marque a cadeira como ocupada e imprima `RESERVADO`;
* depois de todos os pedidos, gere o relatório:
    * o mapa da sala, usando `X` para ocupada e `.` para livre, com um espaço entre as cadeiras;
    * a quantidade de cadeiras ocupadas em cada fileira;
    * o percentual de ocupação da sala, com 1 casa decimal;
    * a fileira com **mais cadeiras livres** (em caso de empate, a primeira).
      **Saída esperada:**
      Uma linha por pedido no formato `Fileira F cadeira C: RESULTADO`, seguida do relatório.

**Exemplo:**

```text
Entrada:
3 4
0 1 0 0
1 1 0 1
0 0 0 0
4
0 2
1 1
3 0
2 3
 
Saída:
Fileira 0 cadeira 2: RESERVADO
Fileira 1 cadeira 1: OCUPADO
Fileira 3 cadeira 0: INVALIDO
Fileira 2 cadeira 3: RESERVADO
MAPA:
. X X .
X X . X
. . . X
OCUPADAS POR FILEIRA:
Fileira 0: 2
Fileira 1: 3
Fileira 2: 1
OCUPACAO: 50.0%
FILEIRA MAIS LIVRE: 2
```