# Exercício 1 — Monitor da Câmara Fria

**Nível:** Fácil

**Assuntos praticados:**

* vetores de `double`;
* estruturas repetitivas;
* estruturas condicionais;
* formatação com `printf` e `Locale`.

## Objetivo

Consolidar a busca de maior e menor valor em vetores, **funcionando com valores negativos**, e treinar o cumprimento exato do formato de saída.

## Enunciado

Uma distribuidora de alimentos congelados registra a temperatura de uma câmara fria uma vez por hora. As horas são numeradas a partir de 0. Pela norma sanitária, alimentos congelados devem ficar a **-18.0 °C ou menos**. Qualquer leitura **acima** de -18.0 é um alerta.

Faça um programa que leia as leituras de um período e gere o relatório do turno.

## Entrada

* um inteiro **N** (1 ≤ N ≤ 24), a quantidade de leituras;
* **N** números reais, as temperaturas, cada uma podendo ser negativa, zero ou positiva.

## Processamento

* armazene as leituras em um vetor;
* encontre a **menor** e a **maior** temperatura e a hora de cada uma; em caso de empate, vale a **primeira** ocorrência;
* calcule a **média** das temperaturas;
* conte as leituras em alerta, isto é, estritamente maiores que -18.0 (exatamente -18.0 **não** é alerta);
* o programa deve funcionar corretamente mesmo que **todas** as leituras sejam negativas.

## Saída esperada

* menor e maior temperatura com 1 casa decimal e a hora;
* média com 2 casas decimais;
* quantidade de alertas e, para cada um, a hora e a temperatura com 1 casa decimal;
* se não houver alertas, a mensagem `NENHUM ALERTA` no lugar da lista.

## Exemplo 1

```text
Entrada:
6
-20.5 -19.0 -17.2 -21.8 -18.0 -16.5

Saída:
MENOR TEMPERATURA = -21.8 (hora 3)
MAIOR TEMPERATURA = -16.5 (hora 5)
MEDIA = -18.83
ALERTAS: 2
Hora 2: -17.2
Hora 5: -16.5
```

## Exemplo 2

```text
Entrada:
3
-19.0 -22.5 -20.0

Saída:
MENOR TEMPERATURA = -22.5 (hora 1)
MAIOR TEMPERATURA = -19.0 (hora 0)
MEDIA = -20.50
NENHUM ALERTA
```

## Observações

* Use apenas vetores, sem `ArrayList`.
* Antes de enviar, teste com os dois exemplos.