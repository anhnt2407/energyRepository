package br.cin.ufpe.nesc2cpn.util;

import java.text.DecimalFormat;

public class DoubleUtil {
    private static DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

    private DoubleUtil(){
        // do nothing
    }

    public static double converteToDouble(String value) {
        if(value == null)
            return 0;

        if( value.equals("") )
            return 0;

        StringBuilder buffer = new StringBuilder( value );
        while( buffer.indexOf(".") != -1 )
           buffer.deleteCharAt( buffer.indexOf(".") );

        value = buffer.toString().replace(',', '.');

        return Double.parseDouble( value );
    }

    public static String converteToString(Double value) {
        return decimalFormat.format(value);
    }

}
