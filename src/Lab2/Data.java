package Lab2;

import java.util.Arrays;

public class Data {
    public static String[][] dataArray(String[][] table, int notData) {
        String[][] data = new String[table.length - 1][];
        if (table.length == 9) {
            for (int i = 0; i < table.length - 1; i++) {
                data[i] = Arrays.copyOfRange(table[i + 1], notData, Factors.getFactors().length + notData);
            }
        } else {
            for (int i = 0; i < table.length - 1; i++) {
                data[i] = Arrays.copyOfRange(table[i + 1], notData, Factors.getFactors().length + 1 + notData);
            }
        }

        return data;
    }

}
