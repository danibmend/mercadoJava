package utils;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

// AQUI EU VOU COLOCAR UNS METODOS UTILIZADOS NO PROJETO
public class Utils {
    // METODO PARA FORMATAR UM VALOR DOUBLE PARA STRINGS

    static NumberFormat numberFormat =
            new DecimalFormat("R$ #,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));

    public static String doubleString (Double value){
        return numberFormat.format(value);
    }



}
