package com.example.officials;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TaxChildlessRelationshipTest {
    @Test
    void shouldCalculateTaxCorrectly() {
        // Given
        TaxStrategy taxStrategy = new TaxChildlessRelationship();
        BigDecimal yearlyIncome = new BigDecimal("60000.00");
        BigDecimal expectedTax = new BigDecimal("15000.00");

        // When
        BigDecimal actualTax = taxStrategy.calculateTax(yearlyIncome);

        // Then
        assertEquals(expectedTax, actualTax);
    }
}