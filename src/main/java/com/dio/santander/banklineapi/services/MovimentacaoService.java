package com.dio.santander.banklineapi.services;

import com.dio.santander.banklineapi.models.Movimentacao;

import java.util.List;

public interface MovimentacaoService {
    List<Movimentacao> findAll();

    void save(Movimentacao movimentacao);
}
