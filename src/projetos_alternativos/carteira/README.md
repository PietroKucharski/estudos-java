## Projeto 1 — Carteira: controle financeiro pessoal

**Nível:** Projeto (várias sessões de estudo)

**Assuntos praticados:** tudo o que foi visto até aqui, com destaque para:

* classe imutável (Exercício 13) com identificador gerado por um contador `static`;
* classe que protege a própria lista (Exercício 14);
* sobrecarga de métodos;
* matriz para relatório (linhas × colunas somadas separadamente);
* `stream().filter(...)`, `count()` e `removeIf`;
* menu interativo com `do-while` e `switch`;
* leitura de textos com espaços depois de números (a armadilha do `nextLine`).
  **Objetivo:**
  Até agora cada exercício era um programa de "entrada → processamento → saída". Um projeto é diferente: é um sistema que o usuário usa por um tempo, com várias funcionalidades que dependem umas das outras. O foco aqui é **organização**: cada classe com uma responsabilidade clara, e o código crescendo em etapas sem virar um `main` gigante.

### Descrição

Um sistema de linha de comando para registrar receitas e despesas ao longo de um ano, controlar limites de gasto por categoria e gerar relatórios.

* Cada **lançamento** tem: um número de identificação (gerado automaticamente, sequencial, começando em 1, nunca reaproveitado), descrição, valor, mês (1 a 12) e tipo (receita ou despesa).
* **Despesas** têm uma categoria. As categorias são fixas: `Moradia`, `Alimentacao`, `Transporte`, `Lazer` e `Outros`. Receitas não têm categoria.
* Cada categoria pode ter um **limite mensal** de gasto. Limite 0 significa "sem limite".
* Um lançamento, depois de criado, **não muda**. Para corrigir um erro, o usuário remove e registra de novo.
### Estrutura sugerida

```text
src/projetos/carteira/
├── application/
│   └── Programa.java      # menu, leitura e impressão
└── entities/
    ├── Lancamento.java    # um registro, imutável
    └── Carteira.java      # guarda os lançamentos e aplica as regras
```

### Modelagem

```text
┌────────────────────────────────────────────────────────────┐
│                        Lancamento                          │
├────────────────────────────────────────────────────────────┤
│ - proximoId: int = 1 {static}                              │
│ - id: int {final}                                          │
│ - descricao: String {final}                                │
│ - valor: double {final}                                    │
│ - mes: int {final}                                         │
│ - receita: boolean {final}                                 │
│ - categoria: int {final}                                   │
├────────────────────────────────────────────────────────────┤
│ + Lancamento(String descricao, double valor, int mes)      │
│ + Lancamento(String descricao, double valor, int mes,      │
│              int categoria)                                │
│ + getters                                                  │
│ + isReceita(): boolean                                     │
│ + toString(): String                                       │
└────────────────────────────────────────────────────────────┘
```

O construtor de três parâmetros cria uma receita; o de quatro cria uma despesa. Decida como representar "sem categoria" nas receitas e justifique em um comentário.

```text
┌────────────────────────────────────────────────────────────┐
│                         Carteira                           │
├────────────────────────────────────────────────────────────┤
│ + CATEGORIAS: String[] {static final}                      │
│ - titular: String                                          │
│ - lancamentos: List<Lancamento> {final}                    │
│ - limites: double[] {final}                                │
├────────────────────────────────────────────────────────────┤
│ + Carteira(String titular)                                 │
│ + registrarReceita(String, double, int mes): Lancamento    │
│ + registrarDespesa(String, double, int mes,                │
│                    int categoria): Lancamento              │
│ + remover(int id): boolean                                 │
│ + saldo(): double                                          │
│ + saldo(int mes): double                                   │
│ + totalDespesas(int mes, int categoria): double            │
│ + definirLimite(int categoria, double limite): boolean     │
│ + getLimite(int categoria): double                         │
│ + ultrapassouLimite(int mes, int categoria): boolean       │
│ + lancamentosDoMes(int mes): List<Lancamento>              │
│ + getLancamentos(): List<Lancamento>                       │
│ + despesasPorCategoriaEMes(): double[][]                   │
└────────────────────────────────────────────────────────────┘
```

### Regras

* `registrarReceita` e `registrarDespesa` devolvem o lançamento criado, ou `null` se algum dado for inválido: valor menor ou igual a zero, mês fora de 1 a 12, categoria inexistente ou descrição vazia. Nesse caso **nenhum** lançamento é criado (e o contador de id não avança).
* Como exceções ainda não foram estudadas, a validação fica na `Carteira`, antes de criar o `Lancamento`. Deixe um comentário `// TODO` para voltar aqui quando estudar tratamento de exceções.
* `remover` devolve `false` se o id não existir. Use `removeIf`.
* `definirLimite` recusa valores negativos e categorias inexistentes.
* Nenhuma lista ou matriz interna da `Carteira` pode ser alterada por fora: tudo o que sai é cópia.
* `despesasPorCategoriaEMes` devolve uma matriz **nova** de 5 linhas (categorias) por 12 colunas (meses), com o total de despesas em cada posição.
* Só `Programa` imprime.
### Menu

```text
=== CARTEIRA DE <titular> ===
1 - Registrar receita
2 - Registrar despesa
3 - Remover lancamento
4 - Extrato do mes
5 - Definir limite de categoria
6 - Relatorio anual
0 - Sair
Opcao:
```

O menu repete (com `do-while`) até a opção 0. Opção inexistente mostra `OPCAO INVALIDA` e volta ao menu. No registro de despesa, mostre as categorias numeradas para o usuário escolher.

### Saídas dos relatórios

Considere esta carteira, com limite de Alimentacao definido em 600.00:

```text
#1  receita  Salario           3500.00  mes 3
#2  despesa  Aluguel           1200.00  mes 3  Moradia
#3  despesa  Mercado            420.50  mes 3  Alimentacao
#4  despesa  Ifood              210.00  mes 3  Alimentacao
#5  despesa  Uber                85.90  mes 3  Transporte
#6  receita  Salario           3500.00  mes 4
#7  receita  Freela site        800.00  mes 4
#8  despesa  Aluguel           1200.00  mes 4  Moradia
#9  despesa  Mercado            390.00  mes 4  Alimentacao
#10 despesa  Show               250.00  mes 4  Lazer
```

**Extrato do mês 3** (opção 4):

```text
EXTRATO - MES 3
#1 RECEITA Salario + R$ 3500.00
#2 DESPESA Aluguel (Moradia) - R$ 1200.00
#3 DESPESA Mercado (Alimentacao) - R$ 420.50
#4 DESPESA Ifood (Alimentacao) - R$ 210.00
#5 DESPESA Uber (Transporte) - R$ 85.90
RECEITAS: R$ 3500.00
DESPESAS: R$ 1916.40
SALDO DO MES: R$ 1583.60
LIMITE ULTRAPASSADO: Alimentacao (R$ 630.50 de R$ 600.00)
```

Mês sem lançamentos mostra `NENHUM LANCAMENTO NO MES X`. Se nenhum limite foi ultrapassado, a última linha não aparece.

**Relatório anual** (opção 6), feito a partir da matriz de `despesasPorCategoriaEMes`:

```text
RELATORIO ANUAL
DESPESAS POR CATEGORIA:
Moradia: R$ 2400.00
Alimentacao: R$ 1020.50
Transporte: R$ 85.90
Lazer: R$ 250.00
Outros: R$ 0.00
MES COM MAIOR DESPESA: 3 (R$ 1916.40)
SALDO DO ANO: R$ 4043.60
```

O total por categoria é a soma de cada **linha** da matriz; o mês com maior despesa sai da soma de cada **coluna**. Sem nenhuma despesa no ano, mostre `MES COM MAIOR DESPESA: NENHUM`.

### Etapas (um commit por etapa)

Não comece pelo menu. Cada etapa deve funcionar antes de passar para a próxima.

1. **`Lancamento`** — Crie a classe e teste no `main` criando alguns objetos à mão e imprimindo. Confira que os ids saem 1, 2, 3...
2. **`Carteira` básica** — Registrar, remover, `saldo()` e `saldo(mes)`. No `main`, cadastre os 10 lançamentos da tabela acima direto no código (sem `Scanner`) e confira os números. Teste também registros inválidos e verifique que o id seguinte não "pula".
3. **Limites e extrato** — `definirLimite`, `totalDespesas`, `ultrapassouLimite`, `lancamentosDoMes`. Reproduza o extrato do mês 3 exatamente.
4. **Relatório anual** — `despesasPorCategoriaEMes` e a impressão do relatório. Reproduza o relatório acima.
5. **Menu** — Só agora troque os dados fixos pela interação com o usuário. Cuidado ao ler a descrição depois de ler um número.
   Sugestão de mensagens de commit, no padrão que você já usa: `feat: projeto carteira - etapa 1 classe Lancamento`, e assim por diante.

### Critérios de conclusão

* [ ] Os dados de exemplo reproduzem exatamente o extrato do mês 3 e o relatório anual.
* [ ] Nenhuma classe além de `Programa` tem `System.out`.
* [ ] `Lancamento` não tem nenhum setter e todos os atributos de instância são `final`.
* [ ] Um trecho como `carteira.getLancamentos().clear()` no `main` **não** apaga os lançamentos da carteira.
* [ ] Alterar a matriz devolvida por `despesasPorCategoriaEMes` não afeta relatórios seguintes.
* [ ] Registros inválidos são recusados com mensagem e não consomem id.
* [ ] Descrições com espaços (`Freela site`) são lidas corretamente pelo menu.
* [ ] O menu nunca quebra com opção inexistente (opções numéricas).