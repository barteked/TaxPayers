package com.example.officials;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class OfficialTest {

    private Citizen citizen;
    private Official official;

    @Mock
    private TaxStrategy taxStrategy;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        BigDecimal monthlyEarnings = new BigDecimal("5000.00");
        BigDecimal yearlyEarnings = new BigDecimal("60000.00");
        BigDecimal tax = new BigDecimal("12000.00");

        when(taxStrategy.calculateTax(yearlyEarnings)).thenReturn(tax);

        citizen = new Citizen("Jan", "Brzechwa", monthlyEarnings, taxStrategy);
        official = new Official();
    }

    @Test
    void shouldPrintReportToConsole() {
        //when
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(output));

        //then
        official.generateReport(citizen);
        System.setOut(originalOut);
        String expected = """
                Name: Jan
                Surname: Brzechwa
                Annual income: 60000.00 pln
                Tax amount: 12000.00 pln
                """;

        assertEquals(expected, output.toString());
    }
}