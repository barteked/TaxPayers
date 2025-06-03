package com.example.officials;

import java.math.BigDecimal;

public class Citizen {
    private String name;
    private String surname;
    private BigDecimal monthlyEarnings;
    private TaxStrategy taxStrategy;

    public Citizen(String name, String surname, BigDecimal monthlyEarnings, TaxStrategy taxStrategy) {
        this.name = name;
        this.surname = surname;
        this.monthlyEarnings = monthlyEarnings;
        this.taxStrategy = taxStrategy;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public BigDecimal getAnnualEarnings() {
        return monthlyEarnings.multiply(BigDecimal.valueOf(12));
    }

    public BigDecimal calculateTax() {
        return taxStrategy.calculateTax(getAnnualEarnings());
    }
}
