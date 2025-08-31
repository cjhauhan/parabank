package com.capstone.utils;

public class EMIUtils {
    // P = principal, r = annual rate percent, n = months
    public static double calculateEMI(double P, double annualRatePercent, int n) {
        double monthlyRate = annualRatePercent / 100.0 / 12.0;
        double rPow = Math.pow(1 + monthlyRate, n);
        double emi = (P * monthlyRate * rPow) / (rPow - 1);
        return Math.round(emi * 100.0) / 100.0;
    }
}
