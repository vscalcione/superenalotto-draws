package it.estrazioni.superenalotto;

import java.sql.*;
import java.util.Arrays;

public class Estraction {

    public static Integer[] randomValues(){
        Integer[] array = new Integer[6];
        for (int i = 0; i < array.length; i++) {
            int value = (int) (Math.random() * 90) + 1;
            array[i] = value;
            for (int j = 0; j < i; j++) {
                if(array[j] == array[i]){
                    int secondValue = (int) (Math.random() * 90) + 1;
                    array[i] = secondValue;
                    j = -1;
                }
            }
        }
        Arrays.sort(array);
        return array;
    }

    public static boolean comparatorTest(Integer[] arrayInt) throws ClassNotFoundException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String n1 = "SELECT n1, n2, n3, n4, n5, n6 FROM Estrazioni WHERE n1=? AND n2=? AND n3=? AND n4=? AND n5=? AND n6=?";
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Estrazioni;user=sa;password=Intersistemi2019";
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             PreparedStatement stmt = connection.prepareStatement(n1);
        ) {
            stmt.setInt(1, arrayInt[0]);
            stmt.setInt(2, arrayInt[1]);
            stmt.setInt(3, arrayInt[2]);
            stmt.setInt(4, arrayInt[3]);
            stmt.setInt(5, arrayInt[4]);
            stmt.setInt(6, arrayInt[5]);
            ResultSet rs1 = stmt.executeQuery();
            while (rs1.next()) {
                System.out.println(rs1.getInt(1) + "," + rs1.getInt(2) + "," + rs1.getInt(3) + "," + rs1.getInt(4) + "," + rs1.getInt(5) + "," + rs1.getInt(6));
                if (rs1.getInt(1) == arrayInt[0] && rs1.getInt(2) == arrayInt[1]
                        && rs1.getInt(3) == arrayInt[2] && rs1.getInt(4) == arrayInt[3]
                        && rs1.getInt(5) == arrayInt[4] && rs1.getInt(6) == arrayInt[5])
                    return true;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static void main(String[] args) throws ClassNotFoundException {
        Integer[] firstCombination = {16, 33, 36, 62, 73, 88};
        Integer[] secondCombination = randomValues();
        boolean result = comparatorTest(secondCombination);
        System.out.println(Arrays.toString(secondCombination));
        System.out.println(result);
    }
}
