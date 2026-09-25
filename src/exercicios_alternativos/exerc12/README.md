## Exercício 12 — Estacionamento

**Nível:** Difícil

**Assuntos praticados:**

* matriz de objetos;
* `null` como posição vazia;
* busca em matriz por atributo;
* regras de cobrança na classe.
  **Objetivo:**
  Unir a matriz do Exercício 3 com o vetor de objetos do Exercício 7, acrescentando duas dificuldades novas: o sistema escolhe a vaga sozinho, e a busca é por um atributo do objeto, não por índice.

**Enunciado:**
Um estacionamento tem **F fileiras** por **V vagas**. O motorista não escolhe a vaga: o sistema aloca a **primeira vaga livre**, varrendo fileira por fileira, da vaga 0 em diante. Cada vaga ocupada guarda a placa do veículo e a hora de entrada.

A cobrança é de **R$ 5.00 pela primeira hora** e **R$ 3.00 por hora adicional**, contando horas inteiras, no mesmo dia. Uma permanência de zero hora paga a primeira hora mesmo assim.

**Requisitos de modelagem:**

* crie uma classe para o veículo estacionado (placa e hora de entrada), com o cálculo do valor como método;
* as constantes de cobrança ficam na classe;
* a classe não imprime nada;
* a busca pela placa percorre a matriz e devolve a posição encontrada, ou indica que não achou.
  **Diagrama da classe:**

```text
┌────────────────────────────────────────────────────┐
│                      Veiculo                       │
├────────────────────────────────────────────────────┤
│ - PRIMEIRA_HORA: double = 5.00 {static final}      │
│ - HORA_ADICIONAL: double = 3.00 {static final}     │
│ - placa: String {final}                            │
│ - horaEntrada: int {final}                         │
├────────────────────────────────────────────────────┤
│ + Veiculo(String, int)                             │
│ + getPlaca(): String                               │
│ + getHoraEntrada(): int                            │
│ + valorAPagar(int horaSaida): double               │
└────────────────────────────────────────────────────┘
```

Os dois atributos são `final`: uma vez estacionado, o veículo não muda de placa nem de hora de entrada. Se algo mudar, é outra ocupação. Compare com a `Cabinet` do Exercício 7, onde os setters não tinham uso legítimo.

A matriz do estacionamento é `Veiculo[][]`, e a busca pela placa precisa devolver **duas** informações (fileira e vaga). Pense em como fazer isso, já que um método só devolve um valor. Há mais de um caminho razoável.

**Entrada:**

* dois inteiros **F** e **V**;
* um inteiro **K**, a quantidade de operações;
* **K** operações, uma por linha:
    * `E placa hora` → entrada;
    * `S placa hora` → saída.
      **Processamento:**

* `E` com uma placa que já está estacionada → recusa;
* `E` sem nenhuma vaga livre → `ESTACIONAMENTO LOTADO`;
* `S` com placa que não está no estacionamento → mensagem;
* `S` válida → calcula o valor, informa a vaga e libera a posição;
* ao final, liste as vagas ocupadas em ordem (fileira, depois vaga) e a quantidade de vagas livres.
  **Saída esperada:**
  As vagas são identificadas como `fileira-vaga`. Valores com 2 casas decimais.

**Exemplo:**

```text
Entrada:
3 4
6
E ABC1234 8
E XYZ5678 9
E ABC1234 10
S XYZ5678 12
S QQQ0000 13
E DEF4321 11
 
Saída:
ESTACIONADO: ABC1234 na vaga 0-0
ESTACIONADO: XYZ5678 na vaga 0-1
VEICULO JA ESTACIONADO: ABC1234
SAIDA: XYZ5678 - vaga 0-1 - 3h - R$ 11.00
VEICULO NAO ENCONTRADO: QQQ0000
ESTACIONADO: DEF4321 na vaga 0-1
OCUPADAS:
0-0: ABC1234 (entrada 8h)
0-1: DEF4321 (entrada 11h)
LIVRES: 10
```