package com.ak_tech.bb.helper;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rate1 {
    public static void main(String[] args) {
//        RateParser rateValue = new RateParser();
//        CalculatorCA calculatorCA = new CalculatorCA();
//        System.out.println(rateValue.getExchangeRate());
//        System.out.println(calculatorCA.calculateQuoteCAList());
//        DecimalFormat newFormat = new DecimalFormat("#.##");
//        newFormat.setRoundingMode(RoundingMode.UP);
//        double twoDecimal = Double.valueOf(newFormat.format(150.015));
//        double twoDecimal1 = new BigDecimal(150.015).setScale(2, RoundingMode.HALF_UP).doubleValue();



        round(150.014);
        round(150.015);
        round(150.016);
        round(150.024);
        round(150.025);
        round(150.026);

    }

    public static double round(double value) {

        double val = new BigDecimal(value)
                .setScale(2, RoundingMode.CEILING)
                .doubleValue();
        System.out.println(val);

        return val;
    }

}
