package com.example.officials;

public class Official {
    public void generateReport(Citizen citizen) {
        System.out.println("Name: " + citizen.getName());
        System.out.println("Surname: " + citizen.getSurname());
        System.out.println("Annual income: " + citizen.getAnnualEarnings() + " pln");
        System.out.println("Tax amount: " + citizen.calculateTax() + " pln");
    }
}
