## 🟢 Nível 1 — Reconhecimento

> Objetivo: provar que entendi os **conceitos** antes de escrever código.

### Exercício 1.1 — Local, global ou duração?

Classifique cada informação como **data local**, **data-hora local**, **data-hora global** ou **duração**, e justifique em uma frase:

1. Data de nascimento de um cliente. Resposta: data local apenas o dia em que a pessoa nasceu
2. Horário de início de uma live assistida por pessoas de vários países. Resposta: data-hora global instante em que a live começou é o mesmo para todos
3. Tempo que um download levou para terminar. Resposta: duração quanto tempo uma atividade levou
4. Data de vencimento de um boleto em um sistema usado só no Brasil. Resposta: data local vencimento representa uma data do calendário brasileiro
5. Momento em que um usuário fez login, registrado no log de um servidor na nuvem. Resposta: data-hora global aconteceu em um instante específico e precisa ser comparável independentemente do fuso
6. Data de um feriado nacional. Resposta: data-local feriado representa um dia específico do calendário
7. Horário de um comentário exibido como "há 17 minutos". Resposta: data-hora global precisa conhecer o instante em que o comentário foi publicado para calcular corretamente o tempo relativo exibido.
8. Horário de abertura de uma loja física ("abre às 09:00"). Resposta: data-hora local horário depende do local da loja e deve ser interpretado de acordo com o fuso
<details>
<summary>Dica 1</summary>
Pergunte-se: *"Se uma pessoa em outro país olhar essa informação, ela precisa enxergar um horário diferente?"*
</details>
<details>
<summary>Dica 2</summary>
O item 8 é uma pegadinha: "09:00" é o horário na parede da loja. Ele muda de significado se o dono se mudar de fuso? E o item 7: para calcular "há 17 minutos", o que o sistema precisa ter armazenado?
</details>
---

### Exercício 1.2 — Lendo ISO 8601

Para cada texto, diga: **é local ou global?** Qual tipo Java você usaria para lê-lo?

```text
a) 2022-07-21 local LocalDate
b) 2022-07-21T14:52 local LocalDateTime
c) 2022-07-22T14:52:09.4073 local LocalDateTime
d) 2022-07-23T14:52:09Z global Instant
e) 2022-07-23T14:52:09-03:00 global Instant
```

Depois responda:

- O que significa o `Z` no final? Significa Zulu time e é o mesmo que o horário UTC
- Os textos **d** e **e** representam o **mesmo instante**? Se não, qual a diferença em horas entre eles? O texto d representa o formato UTC, enquanto o texto e representa o formato UTC−3, que corresponde a horários diferentes UTC. Portanto, os instantes diferem em 3 horas
---

### Exercício 1.3 — Fuso horário na cabeça (sem código)

Uma live está armazenada no banco como `2022-07-23T14:30:00Z`.

Calcule **à mão** o horário local em:

| Cidade | Fuso (segundo o slide) | Horário local |
|--------|------------------------|---------------|
| São Paulo | GMT-3 | 11:30:00 |
| Manaus | GMT-4 | 10:30:00 |
| Lisboa | GMT+1 | 15:30:00 |
| Londres | GMT | 14:30:00 |

> ⚠️ Guarde essa tabela. Você vai conferi-la com código no **Exercício 3.1** — e talvez tenha uma surpresa.
 
---

### Exercício 1.4 — Prever sem rodar

Sem executar, diga o que acontece em cada linha: **imprime algo** (o quê?) ou **lança exceção**?

```java
LocalDate d1 = LocalDate.parse("2022-07-20"); // 2022-07-20
LocalDate d2 = LocalDate.parse("2022-07-20T01:30:26"); // 2022-07-20T01:30:26
LocalDateTime d3 = LocalDateTime.of(2022, 7, 20, 1, 30, 0); // 2022-07-20T01:30:00
Instant d4 = Instant.parse("2022-07-20T01:30:26");
LocalDate d5 = LocalDate.of(2022, 2, 30);
```

Depois rode linha por linha e registre em quais você errou a previsão.

<details>
<summary>Dica 1</summary>
Cada tipo aceita **exatamente** o formato que representa. Um `LocalDate` sabe o que fazer com hora? Um `Instant` sabe o que fazer sem fuso?
</details>
<details>
<summary>Dica 2</summary>
Em `d3`, observe como o `toString()` trata segundos iguais a zero.
</details>