## Exercício 6 — Cartão de Transporte

**Nível:** Intermediário

**Assuntos praticados:**

* construtores e sobrecarga;
* encapsulamento (`private`, getters, sem setters indevidos);
* atributo `final`;
* constantes;
* métodos que retornam `boolean`;
* `switch` dentro de laço.
  **Objetivo:**
  Modelar uma classe que **protege suas próprias regras**. Diferente da `Account` do repositório, aqui o objeto deve **recusar** operações inválidas.

**Enunciado:**
Uma empresa de ônibus emite cartões pré-pagos. Regras do cartão:

* o **número** do cartão nunca pode mudar depois de criado;
* o **nome do titular** pode ser alterado;
* o **saldo** só muda por recarga ou pagamento de passagem;
* a **tarifa** é de R$ 5.00;
* uma recarga só é aceita se o valor for maior que zero e no máximo R$ 200.00;
* uma passagem só é liberada se o saldo for suficiente; nesse caso, o saldo diminui e a quantidade de viagens aumenta;
* a quantidade de viagens pode ser consultada, mas não alterada livremente;
* o cartão pode ser criado **com ou sem** crédito inicial (sem crédito, o saldo começa em zero). Assuma que o crédito inicial informado é sempre válido.
  **Requisitos de modelagem:**

* a classe **não** deve imprimir nada; quem imprime é o programa principal;
* os métodos de recarga e passagem devem retornar `boolean` indicando se a operação foi feita;
* os dados do cartão devem ser mostrados via `toString`.
  **Entrada:**

* número do cartão;
* nome do titular (linha inteira);
* `s` ou `n` indicando se há crédito inicial; se `s`, o valor;
* um inteiro **K**, a quantidade de operações;
* **K** operações, uma por linha:
    * `P` → pagar passagem;
    * `R valor` → recarregar;
    * `N novo nome` → alterar o nome do titular (o nome pode ter espaços).
      **Processamento:**
      Mostre os dados do cartão, execute cada operação imprimindo o resultado e, ao final, mostre os dados novamente.

**Saída esperada:**

* `PASSAGEM LIBERADA` ou `SALDO INSUFICIENTE`;
* `RECARGA EFETUADA` ou `RECARGA RECUSADA`;
* `NOME ALTERADO`;
* dados do cartão no formato do exemplo.
  **Exemplo:**

```text
Entrada:
1001
Joao Pedro
s
12.00
6
P
P
P
R 250.00
R 30.00
N Joao Pedro Alves
 
Saída:
Cartao 1001, Titular: Joao Pedro, Saldo: R$ 12.00, Viagens: 0
PASSAGEM LIBERADA
PASSAGEM LIBERADA
SALDO INSUFICIENTE
RECARGA RECUSADA
RECARGA EFETUADA
NOME ALTERADO
Cartao 1001, Titular: Joao Pedro Alves, Saldo: R$ 32.00, Viagens: 2
```2