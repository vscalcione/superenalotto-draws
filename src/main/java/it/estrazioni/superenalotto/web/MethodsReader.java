package it.estrazioni.superenalotto.web;

import java.util.Arrays;

public class MethodsReader {

    public static String randomValues(){
        Integer[] array = Estrazione.randomValues();
        String finalArray = Arrays.toString(array);
        return finalArray;
    }

    public static void main(String[] args) {
        String value = MethodsReader.randomValues();
        System.out.println(value);
    }
}
