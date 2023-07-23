package Lab2.print;

import Lab2.interfaces.Print;

public class PrintHeader implements Print {
    private final PrintDivider divider;
    private final String[] raw; // Шапка таблицы

    public PrintHeader(String[][] table) {
        divider = new PrintDivider(table);
        this.raw = table[0];
    }

    @Override
    public void print() {
        divider.print();
        int[] maxLength = divider.getMaxLength();
        for (int i = 0; i < raw.length; i++) {
            System.out.print("|");
            System.out.print(raw[i]);
            for (int j = 0; j <= maxLength[i] - raw[i].length(); j++) {
                System.out.print(" ");
            }
        }
        System.out.println("|");
        divider.print();
    }
}
