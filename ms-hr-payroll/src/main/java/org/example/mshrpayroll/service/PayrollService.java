package org.example.mshrpayroll.service;

import lombok.RequiredArgsConstructor;
import org.example.mshrpayroll.controller.WorkerFeignClient;
import org.example.mshrpayroll.domain.Payroll;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PayrollService {
    private final WorkerFeignClient feignClient;

    public Payroll getPayment(Long id, int days){
        var workerFound = feignClient.getById(id);
        var workerPayment = new Payroll();
        workerPayment.setId(workerFound.getId());
        workerPayment.setDays(days);
        workerPayment.setTotal(workerFound.getDailyIncome());
        return workerPayment;
    }
}
