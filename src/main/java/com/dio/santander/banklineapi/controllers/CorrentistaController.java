package com.dio.santander.banklineapi.controllers;

import com.dio.santander.banklineapi.dtos.CorrentistaDto;
import com.dio.santander.banklineapi.models.Conta;
import com.dio.santander.banklineapi.models.Correntista;
import com.dio.santander.banklineapi.services.CorrentistaService;
import com.dio.santander.banklineapi.services.impl.CorrentistaServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {

    @Autowired
    CorrentistaService service;

    @GetMapping
    public ResponseEntity<List<Correntista>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @PostMapping
    public  ResponseEntity<Correntista> save(@RequestBody CorrentistaDto dto){
        Correntista correntista  = new Correntista();
        BeanUtils.copyProperties(dto, correntista);

        Conta conta = new Conta();
        conta.setSaldo(0.0);
        conta.setNumero(new Date().getTime());

        correntista.setConta(conta);

        service.save(correntista);

        return ResponseEntity.status(HttpStatus.CREATED).body(correntista);
    }

}
