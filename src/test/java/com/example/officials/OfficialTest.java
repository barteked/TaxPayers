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

class OfficialTest {
    private static final String NAME = "Jan";
    private static final String SURNAME = "Brzechwa";
    private static final BigDecimal MONTHLY_EARNINGS = new BigDecimal("5000.00");
    private static final BigDecimal YEAR_EARNINGS = new BigDecimal("60000.00");
    private static final BigDecimal SUM_TAX = new BigDecimal("12000.00");

    private Citizen citizen;
    private Official official;

    @Mock
    private TaxStrategy taxStrategy;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(taxStrategy.calculateTax(eq(YEAR_EARNINGS))).thenReturn(SUM_TAX);
        citizen = new Citizen(NAME, SURNAME, MONTHLY_EARNINGS, taxStrategy);
        official = new Official();
    }

    @Test
    public void shouldCalculateTax() {
        // when
        BigDecimal actual = citizen.calculateTax();

        // then
        assertEquals(SUM_TAX, actual);
        verify(taxStrategy).calculateTax(eq(YEAR_EARNINGS));
    }

    @Test
    public void shouldReturnCorrectDataInRaport() {
        // when
        BigDecimal year = citizen.getAnnualEarnings();
        BigDecimal tax = citizen.calculateTax();

        // then
        assertEquals(YEAR_EARNINGS, year);
        assertEquals(SUM_TAX, tax);
        assertEquals(NAME, citizen.getName());
        assertEquals(SURNAME, citizen.getSurname());
    }
}