package Lab2.print;

import Lab2.interfaces.Print;

public class PrintData implements Print {
    private final String[][] printTable;
    private final PrintDivider divider;

    public PrintData(String[][] table) {
        this.printTable = table;
        this.divider = new PrintDivider(table);
    }

    @Override
    public void print() {
        int[] maxLength = divider.getMaxLength();
        for (int i = 1; i < printTable.length; i++) {
            for (int j = 0; j < printTable[0].length; j++) {
                System.out.print("|");
                System.out.print(printTable[i][j]);
                for (int k = 0; k <= maxLength[j] - printTable[i][j].length(); k++) {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
        divider.print();
    }
}
