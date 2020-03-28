package it.estrazioni.superenalotto.websupernealotto;

import it.estrazioni.superenalotto.Estraction;

import java.util.Arrays;

public class MethodsReader {

    public static String randomNumbers(){
        Integer[] array = Estraction.randomValues();
        String finalArray = Arrays.toString(array);
        return finalArray;
    }

    public static void main(String[] args) {
        String value = MethodsReader.randomNumbers();
        System.out.println(value);
    }
}
