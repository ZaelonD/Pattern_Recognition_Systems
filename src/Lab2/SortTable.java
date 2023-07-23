package Lab2;

public class SortTable {

    public String[][] tableSort(String[][] table) {
        int y1_count = ObjectClass.getY1_count();
        int y2_count = ObjectClass.getY2_count();
        String[][] tableY1 = new String[y1_count][];
        String[][] tableY2 = new String[y2_count][];
        String[][] sortTable = new String[table.length][table[0].length];
        sortTable[0] = table[0];
        int k = 0;
        int p = 0;
        for (int i = 1; i < table.length; i++) {
            if (table[i][1].equals(ObjectClass.getY()[0])) {
                tableY1[k] = table[i];
                tableY1[k][0] = String.valueOf(k + 1);
                k++;
            } else {
                tableY2[p] = table[i];
                tableY2[p][0] = String.valueOf(++y1_count);
                p++;
            }
        }
        if (y1_count == 0) {
            System.arraycopy(tableY2, 0, sortTable, 1, tableY2.length);
        } else if (y2_count == 0) {
            System.arraycopy(tableY1, 0, sortTable, 1, tableY1.length);
        }
        System.arraycopy(tableY1, 0, sortTable, 1, tableY1.length);
        System.arraycopy(tableY2, 0, sortTable, tableY1.length + 1, tableY2.length);

        return sortTable;
    }
}
