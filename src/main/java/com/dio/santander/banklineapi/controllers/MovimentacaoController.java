package com.dio.santander.banklineapi.controllers;

import com.dio.santander.banklineapi.dtos.MovimentacaoDto;
import com.dio.santander.banklineapi.models.Correntista;
import com.dio.santander.banklineapi.models.Movimentacao;
import com.dio.santander.banklineapi.models.MovimentacaoTipo;
import com.dio.santander.banklineapi.repositories.MovimentacaoRepository;
import com.dio.santander.banklineapi.services.CorrentistaService;
import com.dio.santander.banklineapi.services.MovimentacaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Repeatable;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
    @Autowired
    MovimentacaoService service;

    @Autowired
    CorrentistaService correntistaService;

    @GetMapping
    public ResponseEntity<List<Movimentacao>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody MovimentacaoDto dto){
        Double valor = dto.getTipo() == MovimentacaoTipo.RECEITA ? dto.getValor() : dto.getValor()*-1;

        Movimentacao movimentacao = new Movimentacao();
        BeanUtils.copyProperties(dto, movimentacao);
        movimentacao.setDataHora(LocalDateTime.now());

        Correntista correntista = correntistaService.findById(dto.getIdConta());

        if(correntista == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Correntista não encontrada");
        }else{
            correntista.getConta().setSaldo(correntista.getConta().getSaldo()+valor);
        }
        service.save(movimentacao);
        return ResponseEntity.status(HttpStatus.OK).body(movimentacao);
    }
}
