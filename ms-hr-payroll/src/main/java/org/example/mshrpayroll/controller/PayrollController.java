package org.example.mshrpayroll.controller;

import lombok.RequiredArgsConstructor;
import org.example.mshrpayroll.domain.Payroll;
import org.example.mshrpayroll.service.PayrollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payroll")
public class PayrollController {
    private final PayrollService service;

    @GetMapping("/{id}/days/{days}")
    public ResponseEntity<Payroll> getPayrollById(@PathVariable Long id, @PathVariable int days){
        return ResponseEntity.status(HttpStatus.OK).body(service.getPayment(id, days));
    }
}
