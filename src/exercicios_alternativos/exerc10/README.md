## Exercício 10 — Onde está o problema?

**Nível:** Intermediário+

**Assuntos praticados:**

* encapsulamento;
* responsabilidade das classes;
* atributos imutáveis;
* validação dentro do objeto.
  **Objetivo:**
  Treinar o olho para problemas de projeto em código que **funciona**. Este é o ponto que voltou atrás na Lista 1, quando os setters gerados pela IDE passaram batido.

**Enunciado:**
O código abaixo compila e roda. Analise a classe e o programa e responda:

1. liste os problemas de encapsulamento e de responsabilidade que você encontrar, explicando **o que cada um permite de errado** (não basta dizer "o atributo deveria ser privado", mostre o estrago que isso possibilita);
2. reescreva **apenas a classe** `ContaPoupanca`, corrigindo o que você apontou;
3. diga quais linhas do `main` deixariam de compilar depois da sua correção, e como elas deveriam ficar.
```java
public class ContaPoupanca {
    public int numero;
    public String titular;
    public double saldo;
    public double taxaJuros;
    public int totalDepositos;
 
    public ContaPoupanca(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }
 
    public void setNumero(int numero) {
        this.numero = numero;
    }
 
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
 
    public void setTotalDepositos(int totalDepositos) {
        this.totalDepositos = totalDepositos;
    }
 
    public void depositar(double valor) {
        saldo = saldo + valor;
        totalDepositos++;
        System.out.println("Deposito realizado. Saldo: " + saldo);
    }
 
    public void sacar(double valor) {
        saldo = saldo - valor;
        System.out.println("Saque realizado. Saldo: " + saldo);
    }
 
    public void aplicarJuros() {
        saldo = saldo + saldo * taxaJuros;
    }
}
```

```java
public class Programa {
    public static void main(String[] args) {
        ContaPoupanca conta = new ContaPoupanca(1001, "Ana Clara");
 
        conta.taxaJuros = 0.005;
        conta.depositar(500.0);
        conta.sacar(800.0);
 
        conta.saldo = 1000000.0;
        conta.numero = 2002;
        conta.setTotalDepositos(50);
 
        if (conta.saldo > 0) {
            conta.aplicarJuros();
        }
 
        System.out.println(conta.titular + ": " + conta.saldo);
    }
}
```

**Saída esperada deste exercício:** um texto, não um programa. Algo entre 8 e 15 linhas para o item 1, mais a classe reescrita.

**Dica de direcionamento:** existem pelo menos cinco problemas distintos. Um deles é do mesmo tipo do que discutimos no `Card`; outro é do mesmo tipo do que discutimos no Exercício 5; e há pelo menos um bug de regra de negócio que nenhum setter causa.