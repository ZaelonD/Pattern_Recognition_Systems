package Lab2.print;

import Lab2.interfaces.Print;

public class PrintTable implements Print {

    private final PrintHeader header;
    private final PrintData data;

    public PrintTable(String[][] table) {
        this.header = new PrintHeader(table);
        this.data = new PrintData(table);
    }

    @Override
    public void print() {
        header.print();
        data.print();
    }
}
