package com.dio.santander.banklineapi.repositories;

import com.dio.santander.banklineapi.models.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {
}
