## Exercício 7 — Guarda-Volumes da Academia

**Nível:** Intermediário

**Assuntos praticados:**

* vetor de objetos;
* `null` como "posição vazia";
* encapsulamento;
* regra de negócio dentro da classe;
* leitura de nomes com espaços no fim da linha.
  **Objetivo:**
  Evoluir o exercício do pensionato do repositório: agora as posições podem ser **liberadas**, as operações podem falhar e o objeto calcula um valor a pagar.

**Enunciado:**
Uma academia tem **10 armários**, numerados de 0 a 9. O cliente guarda seus pertences informando a hora de entrada e paga ao retirar:

* até 2 horas de uso: grátis;
* acima de 2 horas: R$ 3.00 por hora excedente.
  Considere horas inteiras, no mesmo dia, e que a hora de saída nunca é menor que a de entrada.

**Requisitos de modelagem:**

* crie uma classe para representar a ocupação de um armário (nome do cliente e hora de entrada);
* o cálculo do valor a pagar deve ser um método dessa classe, recebendo a hora de saída;
* os valores da regra de cobrança devem ser constantes;
* a classe não deve imprimir nada.
  **Entrada:**

* um inteiro **K**, a quantidade de operações;
* **K** operações, uma por linha:
    * `G armario horaEntrada nome` → guardar (o nome vem no fim da linha e pode ter espaços);
    * `R armario horaSaida` → retirar.
      **Processamento:**

* número de armário fora de 0 a 9: `ARMARIO INVALIDO`;
* guardar em armário ocupado: `ARMARIO X JA OCUPADO`;
* guardar em armário livre: `GUARDADO NO ARMARIO X`;
* retirar de armário vazio: `ARMARIO X VAZIO`;
* retirar de armário ocupado: mostre o nome e o valor a pagar, e libere o armário;
* ao final, liste os armários ocupados em ordem crescente e a quantidade de armários livres.
  **Saída esperada:**
  Siga exatamente o formato do exemplo. Valores com 2 casas decimais.

**Exemplo:**

```text
Entrada:
6
G 3 8 Ana Clara
G 7 9 Bruno Dias
G 3 10 Carla Mendes
R 3 13
R 5 14
G 12 9 Diego Rocha
 
Saída:
GUARDADO NO ARMARIO 3
GUARDADO NO ARMARIO 7
ARMARIO 3 JA OCUPADO
ARMARIO 3 LIBERADO - Ana Clara - R$ 9.00
ARMARIO 5 VAZIO
ARMARIO INVALIDO
OCUPADOS:
7: Bruno Dias (entrada 9h)
LIVRES: 9
```