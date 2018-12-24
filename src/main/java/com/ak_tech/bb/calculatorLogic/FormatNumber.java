package com.ak_tech.bb.calculatorLogic;

import java.text.DecimalFormat;

public class FormatNumber {
    public static final DecimalFormat decimalFormat = new DecimalFormat("###,###,###,###,##0.00");

    public static String format(double number) {
        try {
//            new BigDecimal(number).setScale(2, BigDecimal.ROUND_CEILING).doubleValue();
//            decimalFormat.setRoundingMode(RoundingMode.CEILING);
            return decimalFormat.format(number);
        } catch (Exception e) {
            return null;
        }
    }

}
