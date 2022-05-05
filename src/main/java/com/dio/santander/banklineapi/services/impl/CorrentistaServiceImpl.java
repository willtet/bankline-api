package com.dio.santander.banklineapi.services.impl;

import com.dio.santander.banklineapi.dtos.CorrentistaDto;
import com.dio.santander.banklineapi.models.Correntista;
import com.dio.santander.banklineapi.repositories.CorrentistaRepository;
import com.dio.santander.banklineapi.services.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorrentistaServiceImpl implements CorrentistaService {
    
    @Autowired
    CorrentistaRepository repository;

    @Override
    public List<Correntista> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Correntista correntista) {
        repository.save(correntista);
    }

    @Override
    public Correntista findById(Integer idConta) {
        return repository.findById(idConta).get();
    }
}
