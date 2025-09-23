# Resolução de Exercícios — POO em Java

Este repositório contém a resolução de uma série de exercícios práticos em **Java** aplicando os pilares da Programação Orientada a Objetos: **Encapsulamento, Herança, Polimorfismo, Abstração, Imutabilidade e Generics**, além da utilização do **padrão Strategy**.

---

## 🚀 Exercícios

### Exercício 1 — Encapsulamento (Classe Produto)
- Implementada a classe `Produto` com atributos privados:
  - `nome`
  - `preco`
  - `quantidadeEmEstoque`
- Regras de validação:
  - `preco` e `quantidadeEmEstoque` não podem ser negativos.
  - `nome` não pode ser nulo ou vazio.
- Em caso de valores inválidos → `IllegalArgumentException`.
- Demonstração no `main`: criação de instâncias, alterações válidas e tentativas inválidas.

---

### Exercício 2 — Encapsulamento com Validação de Regra (Desconto)
- Método `aplicarDesconto(double porcentagem)` na classe `Produto`.
- Regras:
  - Só aceita valores entre **0% e 50%**.
  - Caso contrário → `IllegalArgumentException` ou `DescontoInvalidoException`.
- Demonstração:
  - Exibição do preço **antes e depois** do desconto.
  - Teste de entrada inválida lançando exceção.

---

### Exercício 3 — Herança (Hierarquia de Funcionários)
- Classe base `Funcionario` com:
  - `protected String nome`
  - `protected BigDecimal salario`
- Subclasses:
  - `Gerente` → bônus de **20%** do salário.
  - `Desenvolvedor` → bônus de **10%** do salário.
- Salário sempre positivo.
- Demonstração:
  - Uso de `List<Funcionario>`.
  - Iteração mostrando o **bônus de cada funcionário** (polimorfismo).

---

### Exercício 4 — Polimorfismo com Interface (IMeioTransporte)
- Interface `IMeioTransporte`:
  - `acelerar()`
  - `frear()`
- Implementações:
  - `Carro`
  - `Bicicleta`
  - `Trem`
- Cada classe define lógica própria de velocidade e limites.
- Demonstração:
  - Uso de `List<IMeioTransporte>`.
  - Chamada polimórfica de `acelerar()` e `frear()`.
  - Tratamento de exceções em operações inválidas.

---

### Exercício 5 — Abstração (Sistema de Pagamentos)
- Classe abstrata `FormaPagamento`:
  - `validarPagamento()`
  - `processarPagamento(BigDecimal valor)`
- Implementações:
  - `CartaoCredito`
  - `Boleto`
  - `Pix`
- Cada classe possui **validações específicas**:
  - Ex.: número de cartão, formato de boleto, chave Pix.
- Demonstração:
  - Uso polimórfico com lista de formas de pagamento.
  - Tratamento de `PagamentoInvalidoException`.

---

### Exercício 6 — Imutabilidade e Objetos de Valor (Carrinho de Compras)
- Objeto de valor imutável `Dinheiro`:
  - `BigDecimal valor`
  - `enum Moeda`
  - `equals()`/`hashCode()` coerentes.
- Modelagem:
  - `Produto`
  - `ItemCarrinho`
  - `Carrinho` (lista de itens **imutável**).
- Operações retornam **um novo carrinho**:
  - Adicionar item
  - Remover item
  - Aplicar cupom
- Regras:
  - Quantidade > 0
  - Valores não negativos
  - Cupom máximo de **30%**
  - Arredondamento bancário
- Demonstração em testes com fluxo completo.

---

### Exercício 7 — Generics (Repositório Genérico em Memória)
- Interface `Identificavel` com `getId()`.
- Interface genérica `IRepository<T extends Identificavel, ID>` com métodos:
  - `salvar`
  - `buscarPorId`
  - `listarTodos`
  - `remover`
- Implementação:
  - `InMemoryRepository` usando `Map<ID, T>`
  - `listarTodos()` retorna **cópia imutável**
  - `EntidadeNaoEncontradaException` em remoção inválida.
- Demonstração com entidades:
  - `Produto`
  - `Funcionario`

---

### Exercício 8 — Padrão Strategy (Cálculo de Frete com Lambdas)
- Interface `CalculadoraFrete` com `calcular(Pedido): BigDecimal`.
- Estratégias implementadas:
  - `Sedex`
  - `Pac`
  - `RetiradaNaLoja`
- Suporte a **injeção/troca de estratégia em tempo de execução**.
- Estratégia promocional via **lambda**:
  - Frete grátis acima de valor **X**.
- Regras:
  - Validação de CEP/região.
  - `IllegalArgumentException` para CEP inválido.
- Demonstração:
  - Criação de pedidos.
  - Troca de estratégia de frete em tempo de execução.

---

## 🛠️ Tecnologias Utilizadas
- **Java 17+**
- **BigDecimal** para cálculos monetários
- **Collections (List, Map, Optional)**

---

## Autor

Desenvolvido por Edimilson Borges — estudos e práticas de POO em Java
