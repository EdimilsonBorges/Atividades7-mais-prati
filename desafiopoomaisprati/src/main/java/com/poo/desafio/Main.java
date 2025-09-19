package com.poo.desafio;

import com.poo.desafio.exceptions.DescontoInvalidoException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.poo.desafio.exceptions.VelocidadeInvalidaException;

public class Main {
    public static void main(String[] args) {
        // Teste da atividade 1
        System.out.println("===============Teste da atividade 1===============");
        // Criando instância válida
        Produto p1 = new Produto("Carro Gol", 45000.00, 5);
        System.out.println(p1);

        // Alterando valores válidos
        p1.setPreco(50000.00);
        p1.setQuantidadeEmEstoque(10);
        p1.setNome("Gol 1.0");
        System.out.println("Após alterações válidas: " + p1);

        // Tentativas inválidas
        try {
            p1.setPreco(-50);
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
            Produto p2 = new Produto(null, 100, 5);
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
    }
}