package com.example.cashtrack.model;

public class CashTrack {
    private double ingresos;
    private double gastos;

    public CashTrack() {
        this.ingresos = 0;
        this.gastos = 0;
    }

    public double getIngresos() {
        return ingresos;
    }

    public double getGastos() {
        return gastos;
    }

    public double getSaldo() {
        return ingresos - gastos;
    }

    public void addIngreso(double value) {
        this.ingresos += value;
    }

    public void addGasto(double value) {
        this.gastos += value;
    }
}
