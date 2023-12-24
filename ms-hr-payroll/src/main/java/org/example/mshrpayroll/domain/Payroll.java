package org.example.mshrpayroll.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payroll {
    private long id;
    private int days;
    private double total;

    public void setTotal(double dailyIncome){
        total = dailyIncome * days;
    }
}
