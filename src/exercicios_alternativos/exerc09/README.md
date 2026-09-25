## Exercício 9 — Estoque da Farmácia (revisão)

**Nível:** Intermediário+

**Assuntos praticados:**

* `ArrayList` de objetos;
* métodos estáticos auxiliares;
* encapsulamento e regras que recusam operações;
* busca do máximo com índice;
* constantes.
  **Objetivo:**
  Juntar o que a Lista 1 treinou (métodos com responsabilidade única, classe que protege as próprias regras) com coleções. É o exercício de revisão da lista.

**Enunciado:**
Uma farmácia controla o estoque de produtos. Cada produto tem código, nome, preço, quantidade em estoque e um estoque mínimo, abaixo do qual precisa ser reposto.

**Requisitos de modelagem:**

* a quantidade nunca pode ficar negativa: uma saída maior que o estoque deve ser **recusada** e informar isso a quem chamou;
* entrada e saída só aceitam quantidades positivas;
* o valor em estoque (preço × quantidade) e a verificação de estoque abaixo do mínimo são métodos da classe;
* no programa principal, crie **métodos estáticos** para: calcular o valor total do estoque, encontrar o produto de maior valor em estoque e localizar um produto pelo código;
* nenhuma classe imprime nada; quem imprime é o `main`.
  **Diagrama da classe:**

```text
┌──────────────────────────────────────────────────┐
│                     Produto                      │
├──────────────────────────────────────────────────┤
│ - codigo: int {final}                            │
│ - nome: String                                   │
│ - preco: double                                  │
│ - quantidade: int                                │
│ - estoqueMinimo: int                             │
├──────────────────────────────────────────────────┤
│ + Produto(int, String, double, int, int)         │
│ + getCodigo(): int                               │
│ + getNome(): String                              │
│ + getPreco(): double                             │
│ + getQuantidade(): int                           │
│ + getEstoqueMinimo(): int                        │
│ + entrada(int): boolean                          │
│ + saida(int): boolean                            │
│ + valorEmEstoque(): double                       │
│ + abaixoDoMinimo(): boolean                      │
└──────────────────────────────────────────────────┘
```

**Métodos estáticos do programa principal:**

```text
┌──────────────────────────────────────────────────────────┐
│                     ProgExerc09                          │
├──────────────────────────────────────────────────────────┤
│ + main(String[]): void                                   │
│ + buscarPorCodigo(List<Produto>, int): Produto           │
│ + valorTotalDoEstoque(List<Produto>): double             │
│ + produtoDeMaiorValor(List<Produto>): Produto            │
└──────────────────────────────────────────────────────────┘
```

`buscarPorCodigo` e `produtoDeMaiorValor` devolvem `null` quando não há resposta. Pense em quem trata esse `null` e onde.

**Entrada:**

* um inteiro **N**, a quantidade de produtos;
* **N** linhas no formato `codigo preco quantidade estoqueMinimo nome`;
* um inteiro **M**, a quantidade de movimentações;
* **M** linhas no formato `E codigo quantidade` (entrada) ou `S codigo quantidade` (saída).
  **Processamento:**

* movimentação com código inexistente → mensagem de produto não encontrado;
* saída maior que o estoque → recusada, com mensagem;
* ao final, gere o relatório: a lista do estoque, o valor total, os produtos abaixo do mínimo (ou `NENHUM`) e o produto de maior valor em estoque.
  **Saída esperada:**
  Siga o formato do exemplo. Em caso de empate no maior valor, vale o primeiro.

**Exemplo:**

```text
Entrada:
3
101 8.50 10 5 Dipirona 500mg
202 24.90 3 5 Vitamina C
303 15.00 0 2 Protetor solar
5
S 101 4
S 303 1
E 202 10
S 999 1
E 303 1
 
Saída:
SAIDA OK: Dipirona 500mg (6)
ESTOQUE INSUFICIENTE: Protetor solar
ENTRADA OK: Vitamina C (13)
PRODUTO NAO ENCONTRADO: 999
ENTRADA OK: Protetor solar (1)
ESTOQUE:
101 - Dipirona 500mg - 6 un x 8.50 = 51.00
202 - Vitamina C - 13 un x 24.90 = 323.70
303 - Protetor solar - 1 un x 15.00 = 15.00
VALOR TOTAL: 389.70
ABAIXO DO MINIMO:
303 - Protetor solar (1/2)
MAIOR VALOR EM ESTOQUE: 202 - Vitamina C - 323.70
```