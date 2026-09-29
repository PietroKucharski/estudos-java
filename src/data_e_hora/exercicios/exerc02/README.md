## 🔵 Nível 2 — Aplicação

> Objetivo: **instanciar**, **formatar** e **extrair dados** com fluência.

### Exercício 2.1 — Instanciação básica

Crie um programa `Instanciacao.java` que crie e imprima:

1. A data de hoje (`LocalDate`).
2. A data-hora de agora (`LocalDateTime`).
3. O instante de agora (`Instant`).
4. `LocalDate` a partir do texto ISO `"2022-07-20"`.
5. `LocalDateTime` a partir do texto ISO `"2022-07-20T01:30:26"`.
6. `Instant` a partir de `"2022-07-20T01:30:26Z"`.
7. `Instant` a partir de `"2022-07-20T01:30:26-03:00"`.
8. `LocalDate` a partir de dia, mês e ano: 20/07/2022.
9. `LocalDateTime` a partir de dia, mês, ano, hora e minuto: 20/07/2022 01:30.
   **Antes de rodar:** preveja a saída do item 7. Compare a saída do item 3 com a do item 2 — por que os horários são diferentes?

---

### Exercício 2.2 — Texto em formato customizado → data

Leia estes textos (formato brasileiro) e converta para os tipos adequados:

```text
"20/07/2022"         → LocalDate
"20/07/2022 01:30"   → LocalDateTime
```

**Saída esperada:**

```text
2022-07-20
2022-07-20T01:30
```

Perguntas para responder no `anotacoes.md`:

- Por que a saída aparece no formato ISO, e não no formato em que você digitou?
- Qual a diferença entre os padrões `MM` e `mm`? E entre `HH` e `hh`?
---

### Exercício 2.3 — Data → texto customizado

Dados:

```java
LocalDate d = LocalDate.parse("2022-07-20");
LocalDateTime dt = LocalDateTime.parse("2022-07-20T01:30:26");
Instant i = Instant.parse("2022-07-20T01:30:26Z");
```

Produza:

```text
20/07/2022
20/07/2022 01:30
20/07/2022 às 01h30
```

Depois tente formatar o `Instant` `i` com `DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")`.

- O que acontece?
- **Por que** acontece? (responda com suas palavras antes de procurar a solução)
- Corrija para imprimir o instante no horário de São Paulo.
<details>
<summary>Dica 1</summary>
Para escrever "dia 20, 01h30", o formatador precisa saber *em qual relógio de parede* olhar. Um `Instant` diz isso?
</details>
<details>
<summary>Dica 2</summary>
Procure na documentação do `DateTimeFormatter` um método que começa com `with...` e recebe um `ZoneId`.
</details>
<details>
<summary>Dica 3</summary>
Revise o conceito: **data-hora global não tem "dia/mês/hora" próprios** — só passa a ter quando você escolhe um fuso.
</details>
---

### Exercício 2.4 — Extraindo dados

A partir de `LocalDateTime.parse("2022-07-20T01:30:26")`, imprima:

```text
Dia: 20
Mês: 7
Ano: 2022
Hora: 1
Minuto: 30
Dia da semana: WEDNESDAY
```

**Desafio extra:** imprima o nome do mês e do dia da semana **em português** (`julho`, `quarta-feira`).
 
---

### Exercício 2.5 — Caça aos erros de formatação

Cada linha abaixo tem um problema. Para cada uma: **qual é o erro**, **o que acontece ao rodar** e **como corrigir**.

```java
DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/mm/yyyy");
System.out.println(LocalDate.of(2022, 7, 20).format(f1));
 
DateTimeFormatter f2 = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
System.out.println(LocalDateTime.of(2022, 7, 20, 15, 30).format(f2));
 
LocalDate d = LocalDate.parse("20/07/2022");
```

> 💡 Um deles **não lança exceção**, mas imprime um valor enganoso. Esse é o mais perigoso — por quê?