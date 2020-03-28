package it.estrazioni.superenalotto;

import java.sql.Date;
import java.util.Arrays;

public class DataTest {
    public static void main(String[] args) {
        Date data = new Date(System.currentTimeMillis());
        System.out.println(data);
        int[] array = new int[300];
        for (int i = 0; i < array.length; i++) {
            int test = (int) (Math.random() * 90);
            if(test != 0){
                array[i] = test;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
