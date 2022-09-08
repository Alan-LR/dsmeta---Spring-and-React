package com.devsuperior.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleService;
import com.devsuperior.dsmeta.services.SmsService;
import com.twilio.rest.lookups.v1.PhoneNumber;

@RestController
@RequestMapping(value = "/sales")
public class saleController {

    @Autowired
    private SaleService saleService;

    @Autowired
    private SmsService smsService;

    @GetMapping
    // Page serve para buscar uma página, como no exemplo foram as 20 primeiras
    // vendas
    public Page<Sale> findSales(@RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        return saleService.findSales(minDate, maxDate, pageable);
    }

    @GetMapping("/notification/{id}")
    public void notifySms(@PathVariable Long id) {
        smsService.sendSms(id);
    }
    
//    @RequestParam(value = "to", defaultValue = "") PhoneNumber to,
//    @RequestParam(value = "from", defaultValue = "") PhoneNumber from

}
