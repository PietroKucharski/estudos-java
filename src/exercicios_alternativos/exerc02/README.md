## Exercício 2 — O que este código imprime?

**Nível:** Fácil

**Assuntos praticados:**

* divisão inteira e casting;
* Scanner (`next`, `nextInt`, `nextLine`);
* escopo de variáveis;
* `do-while` e `switch`.
  **Objetivo:**
  Verificar se você entende o comportamento exato da linguagem sem precisar executar o código. Vários trechos têm relação direta com erros encontrados no seu repositório.

**Enunciado:**
Para cada trecho, **sem executar o código**, escreva a saída exata e explique em uma ou duas frases por que ela acontece. Só depois de responder, execute para conferir, mas envie a resposta que você escreveu antes de executar.

### Trecho A

```java
int a = 7, b = 2;
double r1 = a / b;
double r2 = (double) a / b;
double r3 = (double) (a / b);
int r4 = a % b;
 
System.out.println(r1);
System.out.println(r2);
System.out.println(r3);
System.out.println(r4);
```

### Trecho B

Entrada digitada pelo usuário:

```text
25
Maria Silva
```

```java
Scanner sc = new Scanner(System.in);
int idade = sc.nextInt();
String nome = sc.nextLine();
 
System.out.println("Idade: " + idade);
System.out.println("Nome: [" + nome + "]");
```

Além da saída, responda: o que aconteceu com o texto `Maria Silva`?

### Trecho C

Entrada digitada pelo usuário:

```text
Maria Silva
```

```java
Scanner sc = new Scanner(System.in);
String nome = sc.next();
String resto = sc.nextLine();
 
System.out.println("[" + nome + "]");
System.out.println("[" + resto + "]");
```

Atenção aos colchetes: eles mostram exatamente onde cada texto começa e termina.

### Trecho D

```java
double preco = 150.0;
 
if (preco > 100.0) {
    double desconto = preco * 0.1;
}
 
System.out.println(desconto);
```

Este código compila? Se não compilar, explique o motivo e diga como corrigir.

### Trecho E

```java
int x = 10;
do {
    System.out.println(x);
    x += 5;
} while (x < 10);
 
int y = 10;
while (y < 10) {
    System.out.println(y);
    y += 5;
}
```

Qual a saída completa? Qual é a diferença de comportamento entre os dois laços?

### Trecho F

```java
int opcao = 2;
 
switch (opcao) {
    case 1:
        System.out.println("Um");
    case 2:
        System.out.println("Dois");
    case 3:
        System.out.println("Tres");
        break;
    default:
        System.out.println("Outro");
}
```

**Formato da resposta:**

```text
Trecho A:
Saída: ...
Explicação: ...
 
Trecho B:
...
```
 
