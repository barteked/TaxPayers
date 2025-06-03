package com.example.officials;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TaxSingleTest {
    @Test
    void shouldCalculateTaxCorrectly() {
        // Given
        TaxSingle taxSingle = new TaxSingle();
        BigDecimal yearlyIncome = new BigDecimal("60000.00");
        BigDecimal expectedTax = new BigDecimal("23400.00");

        // When
        BigDecimal actualTax = taxSingle.calculateTax(yearlyIncome);

        // Then
        assertEquals(expectedTax, actualTax);
    }
}