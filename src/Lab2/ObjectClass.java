package Lab2;

// Класс классов объекта
public class ObjectClass {
    private static final String[] y = {"y1", "y2"}; // Класс объекта

    private static int y1_count;
    private static int y2_count;

    public static void count(String y_class) {
        if (y_class.equals(y[0])) {
            y1_count++;
        } else {
            y2_count++;
        }
    }

    public static int getY1_count() {
        return y1_count;
    }

    public static int getY2_count() {
        return y2_count;
    }

    // Геттер для получения массива классов
    public static String[] getY() {
        return y;
    }
}
