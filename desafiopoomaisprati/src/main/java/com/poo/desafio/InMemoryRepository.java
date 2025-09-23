package com.poo.desafio;

import com.poo.desafio.exceptions.EntidadeNaoEncontradaException;

import java.util.*;

public class InMemoryRepository<T extends Identificavel<ID>, ID> implements IRepository<T, ID> {
    private final Map<ID, T> banco = new HashMap<>();

    @Override
    public T salvar(T entidade) {
        banco.put(entidade.getId(), entidade);
        return entidade;
    }

    @Override
    public Optional<T> buscarPorId(ID id) {
        return Optional.ofNullable(banco.get(id));
    }

    @Override
    public List<T> listarTodos() {
        return Collections.unmodifiableList(new ArrayList<>(banco.values()));
    }

    @Override
    public void remover(ID id) {
        if (!banco.containsKey(id)) {
            throw new EntidadeNaoEncontradaException("Entidade com ID " + id + " não encontrada.");
        }
        banco.remove(id);
    }
}
