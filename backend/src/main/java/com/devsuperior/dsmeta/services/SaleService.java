package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SalesRepository;

@Service
public class SaleService {

    @Autowired
    private SalesRepository saleRepository;

    public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
        // Estamos pegando o dia atual com ofInstant
        // ZoneId.systemDefault pega o fuso horário do sistema
        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        // expressão condicional ternária ? :
        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
        LocalDate min = minDate.equals("") ? today.minusYears(1) : LocalDate.parse(minDate);
        return saleRepository.findSales(min, max, pageable);
    }

}
