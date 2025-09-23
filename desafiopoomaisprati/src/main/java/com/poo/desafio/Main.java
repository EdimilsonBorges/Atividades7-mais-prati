package com.poo.desafio;

import com.poo.desafio.carrinho.Carrinho;
import com.poo.desafio.carrinho.Dinheiro;
import com.poo.desafio.carrinho.Moeda;
import com.poo.desafio.exceptions.DescontoInvalidoException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.poo.desafio.exceptions.EntidadeNaoEncontradaException;
import com.poo.desafio.exceptions.PagamentoInvalidoException;
import com.poo.desafio.exceptions.VelocidadeInvalidaException;
import com.poo.desafio.frete.Pac;
import com.poo.desafio.frete.Pedido;
import com.poo.desafio.frete.RetiradaNaLoja;
import com.poo.desafio.frete.Sedex;
import com.poo.desafio.funcionarios.Desenvolvedor;
import com.poo.desafio.funcionarios.Funcionario;
import com.poo.desafio.funcionarios.Gerente;
import com.poo.desafio.pagamento.Boleto;
import com.poo.desafio.pagamento.CartaoCredito;
import com.poo.desafio.pagamento.FormaPagamento;
import com.poo.desafio.pagamento.Pix;
import com.poo.desafio.produto.Produto;
import com.poo.desafio.repositorio.IRepository;
import com.poo.desafio.repositorio.InMemoryRepository;
import com.poo.desafio.transporte.Bicicleta;
import com.poo.desafio.transporte.Carro;
import com.poo.desafio.transporte.IMeioTransporte;
import com.poo.desafio.transporte.Trem;

public class Main {
    public static void main(String[] args) {
        // Teste da atividade 1
        System.out.println("===============Teste da atividade 1===============");
        // Criando instância válida
        Produto p1 = new Produto(1,"Carro Gol", new Dinheiro(new BigDecimal("3500.00"), Moeda.BRL),1);
        System.out.println(p1);

        // Alterando valores válidos
        p1.setPreco(new Dinheiro(new BigDecimal("5500.00"), Moeda.BRL));
        p1.setQuantidadeEmEstoque(10);
        p1.setNome("Gol 1.0");
        System.out.println("Após alterações válidas: " + p1);

        // Tentativas inválidas
        try {
            p1.setPreco(new Dinheiro(new BigDecimal("-50.00"), Moeda.BRL));
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao definir preço: " + e.getMessage());
        }

        try {
            p1.setQuantidadeEmEstoque(-3);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao definir quantidade: " + e.getMessage());
        }

        try {
            p1.setNome("");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao definir nome: " + e.getMessage());
        }

        try {
            Produto p2 = new Produto(2, null, new Dinheiro(new BigDecimal("100.00"), Moeda.BRL), 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar produto: " + e.getMessage());
        }


        // Teste da atividade 2
        System.out.println("===============Teste da atividade 2===============");
        System.out.println("Preço original: " + p1.getPreco());

        // Aplicando desconto válido
        try {
            p1.aplicarDesconto(10); // 10%
            System.out.println("Preço após 10% de desconto: " + p1.getPreco());
        } catch (DescontoInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Tentativa de desconto inválido: 0%
        try {
            p1.aplicarDesconto(0);
        } catch (DescontoInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Tentativa de desconto inválido: maior que 50%
        try {
            p1.aplicarDesconto(60);
        } catch (DescontoInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Tentativa de desconto inválido: negativo
        try {
            p1.aplicarDesconto(-5);
        } catch (DescontoInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Teste da atividade 3
        System.out.println("===============Teste da atividade 3===============");
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Gerente("Pedro", new BigDecimal("50000")));
        funcionarios.add(new Desenvolvedor("Maria", new BigDecimal("3000")));
        funcionarios.add(new Desenvolvedor("Miguel", new BigDecimal("4500")));

        for (Funcionario f : funcionarios) {
            System.out.println(f.getNome() + " | Salário: " + f.getSalario() + " | Bônus: " + f.calcularBonus());
        }

        // Teste da atividade 4
        System.out.println("===============Teste da atividade 4===============");
        List<IMeioTransporte> transportes = new ArrayList<>();
        transportes.add(new Carro());
        transportes.add(new Bicicleta());
        transportes.add(new Trem());

        for (IMeioTransporte t : transportes) {
            try {
                System.out.println("=== " + t.getNome() + " ===");
                t.acelerar();
                System.out.println("Velocidade após acelerar: " + t.getVelocidade() + " km/h");
                t.frear();
                System.out.println("Velocidade após frear: " + t.getVelocidade() + " km/h\n");
            } catch (VelocidadeInvalidaException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        // Teste da atividade 5
        System.out.println("===============Teste da atividade 5===============");
        List<FormaPagamento> pagamentos = new ArrayList<>();
        pagamentos.add(new CartaoCredito("7654890312437890"));
        pagamentos.add(new Boleto("26745895612873495670932146785643659809765128635"));
        pagamentos.add(new Pix("usuario@email.com"));
        pagamentos.add(new CartaoCredito("5342")); // inválido

        for (FormaPagamento pagamento : pagamentos) {
            try {
                pagamento.processarPagamento(new BigDecimal("150.00"));
            } catch (PagamentoInvalidoException e) {
                System.out.println("Erro no pagamento: " + e.getMessage());
            }
            System.out.println("-------------------");
        }

        // Teste da atividade 6
        System.out.println("===============Teste da atividade 6===============");
        Produto pr1 = new Produto(1,"Notebook", new Dinheiro(new BigDecimal("3500.00"), Moeda.BRL),3);
        Produto pr2 = new Produto(2,"Mouse", new Dinheiro(new BigDecimal("150.00"), Moeda.BRL),3);

        Carrinho carrinho = new Carrinho(List.of());

        // Adicionando itens
        carrinho = carrinho.adicionarItem(pr1, 1);
        carrinho = carrinho.adicionarItem(pr2, 2);

        System.out.println("Carrinho inicial:");
        carrinho.getItens().forEach(i ->
                System.out.println(i.getProduto() + " x" + i.getQuantidade() + " = " + i.getTotal())
        );
        System.out.println("Total: " + carrinho.getTotal());

        // Aplicando cupom de 20%
        carrinho = carrinho.aplicarCupom(new BigDecimal("0.20"));
        System.out.println("\nApós aplicar cupom de 20%:");
        System.out.println("Total com desconto: " + carrinho.getTotal());

        // Removendo item
        carrinho = carrinho.removerItem("Mouse");
        System.out.println("\nApós remover Mouse:");
        carrinho.getItens().forEach(i ->
                System.out.println(i.getProduto().getNome() + " x" + i.getQuantidade() + " = " + i.getTotal())
        );
        System.out.println("Total: " + carrinho.getTotal());

        // Teste da atividade 7
        System.out.println("===============Teste da atividade 7===============");
        IRepository<Produto, Integer> repoProdutos = new InMemoryRepository<>();
        IRepository<Funcionario, String> repoFuncionarios = new InMemoryRepository<>();

        // Produtos
        repoProdutos.salvar(new Produto(1, "Notebook", new Dinheiro(new BigDecimal("5000.00"), Moeda.BRL), 1));
        repoProdutos.salvar(new Produto(2, "Mouse", new Dinheiro(new BigDecimal("25.00"), Moeda.BRL), 2));

        System.out.println("Lista de produtos:");
        repoProdutos.listarTodos().forEach(System.out::println);

        // Buscar produto
        repoProdutos.buscarPorId(1).ifPresent(p -> System.out.println("Encontrado: " + p));

        // Remover produto
        repoProdutos.remover(2);
        System.out.println("Após remover produto 2: " + repoProdutos.listarTodos());

        // Funcionários
        repoFuncionarios.salvar(new Gerente("A1", "Maria", new BigDecimal("8000")));
        repoFuncionarios.salvar(new Desenvolvedor("B2", "João", new BigDecimal("5000")));

        System.out.println("\nLista de funcionários:");
        repoFuncionarios.listarTodos().forEach(System.out::println);

        // Tentativa de remover funcionário inexistente
        try {
            repoFuncionarios.remover("X9");
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Teste da atividade 8
        System.out.println("===============Teste da atividade 8===============");

        Pedido pedido = new Pedido("P001", "12345678", BigDecimal.valueOf(200), new Sedex());
        System.out.println("Usando Sedex: " + pedido);

        // Troca de estratégia em runtime
        pedido.setEstrategiaFrete(new Pac());
        System.out.println("Trocado para PAC: " + pedido);

        pedido.setEstrategiaFrete(new RetiradaNaLoja());
        System.out.println("Trocado para Retirada na Loja: " + pedido);

        // Estratégia promocional via lambda
        pedido.setEstrategiaFrete(p -> {
            if (p.getValorTotal().compareTo(BigDecimal.valueOf(300)) >= 0) {
                return BigDecimal.ZERO; // frete grátis
            }
            return BigDecimal.valueOf(20); // valor padrão
        });
        System.out.println("Frete promocional (frete grátis acima de 300): " + pedido);

        // Testando com pedido mais caro
        Pedido pedido2 = new Pedido("P002", "87654321", BigDecimal.valueOf(500),
                p -> p.getValorTotal().compareTo(BigDecimal.valueOf(300)) >= 0 ? BigDecimal.ZERO : BigDecimal.valueOf(20));
        System.out.println("Pedido 2: " + pedido2);

        // Testando CEP inválido
        try {
            Pedido pedidoInvalido = new Pedido("P003", "abc123", BigDecimal.valueOf(100), new Sedex());
            System.out.println(pedidoInvalido.calcularFrete());
        } catch (Exception e) {
            System.err.println("Erro ao calcular frete: " + e.getMessage());
        }

    }
}