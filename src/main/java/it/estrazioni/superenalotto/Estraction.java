package it.estrazioni.superenalotto;

import java.sql.*;
import java.util.Arrays;

public class Estraction {

    public static Integer[] randomValues(){
        Integer[] array = new Integer[6];
        for (int i = 0; i < array.length; i++) {
            int value = (int) (Math.random() * 90) + 1;
            array[i] = value;
            for(int j = 0; j < i; j++){
                if(array[j] == array[i]){
                    int value2 = (int) (Math.random() * 90) + 1;
                    array[i] = value2;
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
        try(Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement stmt = conn.prepareStatement(n1);
        ){
            stmt.setInt(1, arrayInt[0]);
            stmt.setInt(2, arrayInt[1]);
            stmt.setInt(3, arrayInt[2]);
            stmt.setInt(4, arrayInt[3]);
            stmt.setInt(5, arrayInt[4]);
            stmt.setInt(6, arrayInt[5]);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
//                System.out.println(resultSet.getInt(1) + ","
//                        + resultSet.getInt(2) + ","
//                        + resultSet.getInt(3) + ","
//                        + resultSet.getInt(4) + ","
//                        + resultSet.getInt(5) + ","
//                        + resultSet.getInt(6)
//                );
//
//                if (resultSet.getInt(1) == combination[0] && resultSet.getInt(2) == combination[1]
//                        && resultSet.getInt(3) == combination[2] && resultSet.getInt(4) == combination[3]
//                        && resultSet.getInt(5) == combination[4] && resultSet.getInt(6) == combination[5])
                    return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Integer[] firstCombination = { 16, 33, 36, 62, 73, 88 };
        Integer[] secondCombination = randomValues();
        boolean result = comparatorTest(secondCombination);
        System.out.println(Arrays.toString(secondCombination));
        System.out.println(result);
    }
}
