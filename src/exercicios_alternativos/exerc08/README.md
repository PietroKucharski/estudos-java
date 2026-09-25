## Exercício 8 — Carrinho de Compras

**Nível:** Intermediário

**Assuntos praticados:**

* `ArrayList` de objetos;
* busca por atributo;
* remoção de elementos;
* encapsulamento com regra de negócio.
  **Objetivo:**
  Sair do `ArrayList` como "lista de coisas" e usá-lo como coleção de objetos que precisam ser localizados, alterados e removidos.

**Enunciado:**
Um e-commerce mantém o carrinho do cliente. Cada item tem código, nome, preço unitário e quantidade. O mesmo código nunca aparece duas vezes no carrinho: se o cliente adicionar um produto que já está lá, a quantidade é somada.

**Requisitos de modelagem:**

* crie uma classe para o item do carrinho;
* o código nunca muda depois de criado;
* a quantidade só muda pelos métodos de negócio, nunca por um setter livre;
* o subtotal (preço × quantidade) é um método da classe;
* a classe não imprime nada.
  **Entrada:**

* um inteiro **K**, a quantidade de operações;
* **K** operações, uma por linha:
    * `A codigo preco quantidade nome` → adicionar;
    * `R codigo` → remover o item do carrinho;
    * `Q codigo novaQuantidade` → alterar a quantidade.
      **Processamento:**

* `A` com código novo → adiciona ao fim da lista;
* `A` com código existente → soma a quantidade ao item que já está lá;
* `R` com código inexistente → mensagem de não encontrado;
* `Q` com quantidade menor ou igual a zero → recusa a operação;
* ao final, liste o carrinho na ordem de inserção, com o total a pagar e a soma das quantidades. Se o carrinho estiver vazio, imprima `CARRINHO VAZIO` no lugar da listagem.
  **Saída esperada:**
  Valores com 2 casas decimais. Siga o formato do exemplo.

**Exemplo:**

```text
Entrada:
5
A 101 4.50 3 Pao de forma
A 202 12.90 1 Cafe torrado
A 101 4.50 2 Pao de forma
R 303
Q 202 2
 
Saída:
ADICIONADO: Pao de forma x3
ADICIONADO: Cafe torrado x1
QUANTIDADE ATUALIZADA: Pao de forma x5
ITEM NAO ENCONTRADO: 303
QUANTIDADE ALTERADA: Cafe torrado x2
CARRINHO:
101 - Pao de forma - 5 x 4.50 = 22.50
202 - Cafe torrado - 2 x 12.90 = 25.80
TOTAL: 48.30
ITENS: 7
```

Outras mensagens previstas: `QUANTIDADE INVALIDA` para o `Q` com valor inválido, e `REMOVIDO: nome` para uma remoção bem-sucedida.