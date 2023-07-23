package Lab2;

// Класс для подсчета ширины столбца
public class CalculateCount {

    // Метод для вычисления максимальной ширины столбца
    public static int[] MaxWidthColumn(String[][] table) {
        int[] colLength = new int[table[0].length];

        for (int i = 0; i < table[0].length; i++) {
            int max = table[0][i].length();
            for (String[] cell : table) {
                if (cell[i].length() > max){
                    max = cell[i].length();
                }
            }
            colLength[i] = max;
        }
        return colLength;
    }
}
