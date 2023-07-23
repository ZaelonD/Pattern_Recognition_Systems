package Lab3;

public class Levenshtein {
    public static int levDiv(int i, int j, int[] data1, int[] data2, int[][] matrix) {
        if (i == 0 && j == 0)
            return 0;
        if (i > 0 && j == 0)
            return i;
        if (j > 0 && i == 0)
            return j;
        int m = (data1[i - 1] == data2[i - 1]) ? 0 : 1;

        int min = matrix[i][j - 1] + 1;
        if (matrix[i - 1][j] + 1 < min)
            min = matrix[i - 1][j] + 1;
        if (matrix[i - 1][j - 1] + m < min)
            min = matrix[i - 1][j - 1] + m;
        return min;
    }

    public static int levenshteinDistance(int[] data1, int[] data2) {
        int[][] matrix = new int[data1.length + 1][data2.length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = levDiv(i, j, data1, data2, matrix);
            }
        }
        return matrix[data1.length][data2.length];
    }
}
