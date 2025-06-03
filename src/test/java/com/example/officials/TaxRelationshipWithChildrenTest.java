package com.example.officials;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TaxRelationshipWithChildrenTest {
    @Test
    void shouldCalculateTaxCorrectly() {
        // Given
        TaxRelationshipWithChildren taxStrategy = new TaxRelationshipWithChildren();
        BigDecimal yearlyIncome = new BigDecimal("60000.00");
        BigDecimal expectedTax = new BigDecimal("12000.00");

        // When
        BigDecimal actualTax = taxStrategy.calculateTax(yearlyIncome);

        // Then
        assertEquals(expectedTax, actualTax);
    }
}