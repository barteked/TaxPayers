package com.example.officials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class OfficialsApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfficialsApplication.class, args);
        Citizen citizen1 = new Citizen(
                "Tomek",
                "Dubis",
                new BigDecimal("5000.00"),
                new TaxSingle()
        );

        Citizen citizen = new Citizen(
                "Anna",
                "Kowalska",
                new BigDecimal("4500.00"),
                new TaxRelationshipWithChildren()
        );

        Official official = new Official();
        official.generateReport(citizen1);
        System.out.println("---------------");
        official.generateReport(citizen);
    }
}


