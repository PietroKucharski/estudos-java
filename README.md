# estudos-java

Repositório de estudos de **Java e Programação Orientada a Objetos**, criado para acompanhar um curso completo de Java (do zero ao avançado). Aqui ficam as aulas comentadas, os exercícios resolvidos do curso, uma lista de exercícios extras e projetos práticos.

As explicações são escritas direto no código, em comentários, para que cada arquivo sirva também como material de consulta rápida. Em várias aulas, a versão "antes" (sem o conceito novo) fica comentada ao lado da versão "depois", mostrando a evolução do código.

## Tecnologias

- Java 21 (nível de linguagem do projeto; compilado com OpenJDK 24)
- IntelliJ IDEA
- Git / GitHub

O projeto não usa Maven nem Gradle por enquanto: é um módulo simples do IntelliJ, com todo o código em `src/`.

## Estrutura do projeto

```text
estudos-java/
├── src/
│   ├── estrutura_sequencial/      # Aulas 01–04 + exercícios 01–06
│   ├── estrutura_condicional/     # Aulas 01–05 + exercícios 01–08
│   ├── estrutura_repetitiva/      # Aulas 01–03 + exercícios 01–10
│   ├── introd_poo/                # Aulas 01–06 + exercícios 01–04
│   ├── encapsulamento/            # Aulas 01–03 + exercício 01
│   ├── comportamento_memoria/     # Aulas 01–05 + exercícios 01–14
│   ├── exercicios_alternativos/   # Lista extra com 12 exercícios (cada um com README)
│   └── projetos_alternativos/
│       └── carteira/              # Projeto 1: controle financeiro pessoal
├── .gitignore
├── estudos-java.iml
└── README.md
```

Os pacotes seguem a ordem do curso. A partir de Introdução à POO, cada aula e exercício é separado em dois subpacotes:

- `application/`: classe com o método `main` (entrada, processamento e saída)
- `entities/`: classes de domínio (`Product`, `Triangle`, `Employee`, `Account`...)

## Conteúdo

### Fundamentos

| Pacote | O que é praticado |
|---|---|
| [`estrutura_sequencial`](src/estrutura_sequencial) | Saída com `println` e `printf`, `Locale`, variáveis e tipos, operadores, entrada com `Scanner`, funções da classe `Math` |
| [`estrutura_condicional`](src/estrutura_condicional) | `if`/`else` encadeado, operadores de atribuição acumulativa, `switch`, expressão ternária, escopo e inicialização de variáveis |
| [`estrutura_repetitiva`](src/estrutura_repetitiva) | `while`, `for` e `do-while` |

### Orientação a objetos

| Pacote | O que é praticado |
|---|---|
| [`introd_poo`](src/introd_poo) | Classes, atributos e métodos, `toString`, membros estáticos e constantes (`static final`), comparação entre solução com e sem POO |
| [`encapsulamento`](src/encapsulamento) | Construtores, palavra `this`, sobrecarga de construtores, modificadores de acesso, getters e setters |
| [`comportamento_memoria`](src/comportamento_memoria) | Vetores de tipos primitivos e de objetos, boxing/unboxing, laço *foreach*, `ArrayList` (inclusive `removeIf` e `stream().filter`), matrizes |

### Exercícios alternativos

Lista extra de exercícios, fora do curso, para revisar e aprofundar os temas acima. Cada pasta tem um README com enunciado, nível e assuntos praticados.

| # | Exercício | Nível | Assuntos principais |
|---|---|---|---|
| 01 | [Monitor da Câmara Fria](src/exercicios_alternativos/exerc01) | Fácil | Vetores, laços, condicionais, `printf` |
| 02 | [O que este código imprime?](src/exercicios_alternativos/exerc02) | Fácil | Casting, `Scanner`, escopo, `do-while`, `switch` |
| 03 | [Sala de Cinema](src/exercicios_alternativos/exerc03) | Básico | Matrizes, laços aninhados, validação de índices |
| 04 | [Planilha de Notas (revisão)](src/exercicios_alternativos/exerc04) | Básico+ | Vetores e matriz juntos, leitura de nomes com espaços |
| 05 | [Refatorando o Relatório de Vendas](src/exercicios_alternativos/exerc05) | Básico | Métodos estáticos, constantes, eliminação de duplicação |
| 06 | [Cartão de Transporte](src/exercicios_alternativos/exerc06) | Intermediário | Construtores, encapsulamento, atributo `final` |
| 07 | [Guarda-Volumes da Academia](src/exercicios_alternativos/exerc07) | Intermediário | Vetor de objetos, `null` como posição vazia |
| 08 | [Carrinho de Compras](src/exercicios_alternativos/exerc08) | Intermediário | `ArrayList` de objetos, busca e remoção |
| 09 | [Estoque da Farmácia (revisão)](src/exercicios_alternativos/exerc09) | Intermediário+ | `ArrayList`, regras que recusam operações, busca do máximo |
| 10 | [Onde está o problema?](src/exercicios_alternativos/exerc10) | Intermediário+ | Análise de projeto, imutabilidade, validação no objeto |
| 11 | [Empréstimos da Biblioteca](src/exercicios_alternativos/exerc11) | Difícil | Lambdas, `removeIf`, `stream().filter(...).findFirst()` |
| 12 | [Estacionamento](src/exercicios_alternativos/exerc12) | Difícil | Matriz de objetos, busca por atributo, regras de cobrança |

### Projetos

**[Carteira: controle financeiro pessoal](src/projetos_alternativos/carteira)** — sistema de linha de comando, com menu interativo, para registrar receitas e despesas ao longo do ano, definir limites mensais de gasto por categoria e gerar relatórios. Reúne tudo o que foi estudado até aqui: classe imutável (`Lancamento`) com identificador gerado por contador `static`, classe que protege a própria lista (`Carteira`), sobrecarga de métodos, matriz para relatório, streams e `removeIf`.

## Progresso

### Fundamentos
- [x] Lógica de programação e algoritmos
- [x] Sintaxe da linguagem Java
- [x] Estrutura sequencial
- [x] Estrutura condicional
- [x] Estrutura repetitiva

### Orientação a objetos
- [x] Classes, atributos e métodos
- [x] Membros estáticos
- [x] Construtores, sobrecarga e encapsulamento
- [x] Vetores, listas e matrizes
- [ ] Datas e horas
- [ ] Enumerações e composição
- [ ] Herança, polimorfismo e interfaces
- [ ] Tratamento de exceções
- [ ] Generics, `Set` e `Map`
- [ ] Programação funcional, expressões lambda e Stream API
- [ ] Manipulação de arquivos

### Ferramentas e frameworks
- [ ] JDBC (acesso a dados com SQL)
- [ ] JavaFX (interface gráfica)
- [ ] Spring Boot (web services)
- [ ] JPA / Hibernate (ORM)
- [ ] Spring Data JPA
- [ ] Spring Data MongoDB (NoSQL)

## Como executar

Clone o repositório:

```bash
git clone https://github.com/PietroKucharski/estudos-java.git
cd estudos-java
```

**Pela IDE:** abra a pasta no IntelliJ IDEA (ou outra IDE) e execute o método `main` da classe desejada.

**Pelo terminal** (a partir da raiz do projeto), compile tudo para a pasta `out/` e rode a classe pelo nome completo do pacote:

```bash
# compilar todas as classes
javac -d out $(find src -name "*.java")

# exemplos de execução
java -cp out estrutura_sequencial.Aula01
java -cp out introd_poo.aula06.application.ProgAula06
java -cp out projetos_alternativos.carteira.application.Program
```

> A pasta `out/` está no `.gitignore`, então os arquivos compilados não vão para o repositório.

## Objetivos

- Construir uma base sólida, teórica e prática, em orientação a objetos
- Criar soluções flexíveis, extensíveis e testáveis
- Compreender diagramas de classe UML
- Desenvolver aplicações desktop e web services com boas práticas
- Acessar bancos de dados relacionais e NoSQL

---

Repositório pessoal de estudos, atualizado conforme o andamento do curso.