package Lab2.print;

import Lab2.CalculateCount;
import Lab2.interfaces.Print;

public class PrintDivider implements Print {
    private final int[] maxLength;

    // Конструктор для записи в таблицу текущих данных
    public PrintDivider(String[][] table) {
        this.maxLength = CalculateCount.MaxWidthColumn(table);
    }

    // Метод для вывода границы таблицы
    @Override
    public void print() {
        for (int i : maxLength) {
            System.out.print("+");
            for (int j = 0; j < i + 1; j++) {
                System.out.print("-");
            }
        }
        System.out.println("+");
    }

    public int[] getMaxLength() {
        return maxLength;
    }
}
