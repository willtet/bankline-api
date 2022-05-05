package com.dio.santander.banklineapi.services;

import com.dio.santander.banklineapi.dtos.CorrentistaDto;
import com.dio.santander.banklineapi.models.Correntista;

import java.util.List;

public interface CorrentistaService {
    List<Correntista> findAll();

    void save(Correntista correntista);

    Correntista findById(Integer idConta);
}
