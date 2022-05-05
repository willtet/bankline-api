package com.dio.santander.banklineapi.services.impl;

import com.dio.santander.banklineapi.models.Movimentacao;
import com.dio.santander.banklineapi.repositories.MovimentacaoRepository;
import com.dio.santander.banklineapi.services.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService {
    @Autowired
    MovimentacaoRepository repository;

    @Override
    public List<Movimentacao> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Movimentacao movimentacao) {
        repository.save(movimentacao);
    }
}
