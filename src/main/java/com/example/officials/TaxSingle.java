package com.example.officials;

import java.math.BigDecimal;

public class TaxSingle implements TaxStrategy {
    @Override
    public BigDecimal calculateTax(BigDecimal annualEarnings) {
        return annualEarnings.multiply(new BigDecimal("0.39"));
    }
}
