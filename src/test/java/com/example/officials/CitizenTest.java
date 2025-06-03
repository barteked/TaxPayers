package com.example.officials;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CitizenTest {
    private static final String NAME = "Tomek";
    private static final String SURNAME = "Mlynarz";
    private static final BigDecimal MONTHLY_EARNINGS = new BigDecimal("5000.00");
    private static final BigDecimal YEARLY_EARNINGS = new BigDecimal("60000.00");
    private static final BigDecimal TAX_RETURNED_BY_STRATEGY = new BigDecimal("15000.00");

    private Citizen citizen;

    @Mock
    private TaxStrategy taxStrategy;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        citizen = new Citizen(NAME, SURNAME, MONTHLY_EARNINGS, taxStrategy);
        when(taxStrategy.calculateTax(eq(YEARLY_EARNINGS))).thenReturn(TAX_RETURNED_BY_STRATEGY);
    }

    @Test
    void shouldReturnNameAndSurname() {
        // then
        assertEquals(NAME, citizen.getName());
        assertEquals(SURNAME, citizen.getSurname());
    }

    @Test
    void shouldCalculateAnnualEarnings() {
        // when
        BigDecimal annualEarnings = citizen.getAnnualEarnings();

        // then
        assertEquals(YEARLY_EARNINGS, annualEarnings);
    }

    @Test
    void shouldDelegateTaxCalculationToStrategy() {
        // when
        BigDecimal tax = citizen.calculateTax();

        // then
        verify(taxStrategy).calculateTax(eq(YEARLY_EARNINGS));
        assertEquals(TAX_RETURNED_BY_STRATEGY, tax);
    }
}