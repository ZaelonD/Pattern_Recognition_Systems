package Lab3;

public class Solution {
    public static void main(String[] args) {

        //---------------------------ЭТАЛОНЫ---------------------------//

        // Числовой вид изображения (по горизонтали)
        Data x = new Data();
        x.put(new int[]{2, 0, 7, 1, 1, 7, 1, 1, 7}, 'Ё');
        x.put(new int[]{3, 5, 5, 5, 3, 5, 5, 5, 3}, 'Ж');
        x.put(new int[]{4, 2, 1, 1, 3, 1, 1, 2, 4}, 'З');
        x.put(new int[]{1, 3, 3, 3, 3, 3, 3, 3, 1}, 'И');
        x.put(new int[]{3, 3, 3, 3, 3, 3, 3, 3, 1}, 'Й');

        // Числовой вид изображения (по вертикали)
        Data y = new Data();
        y.put(new int[]{0, 7, 4, 3, 3, 3, 4, 3, 0}, 'Ё');
        y.put(new int[]{4, 4, 4, 3, 9, 3, 4, 4, 4}, 'Ж');
        y.put(new int[]{0, 0, 2, 2, 3, 3, 3, 6, 0}, 'З');
        y.put(new int[]{9, 1, 1, 1, 1, 1, 1, 1, 9}, 'И');
        y.put(new int[]{8, 1, 1, 2, 2, 2, 1, 1, 8}, 'Й');

        System.out.print("Введите букву в числовом виде по горизонтали: ");
        int[] inputLetterHor = Input.input(); // Вводим числовой вид буквы
        char recognizedLetterHor = Recognition.recognize(x, inputLetterHor); // Распознаем букву
        System.out.println("Распознанная буква по вертикали: " + recognizedLetterHor); // Выводим

        System.out.print("\nВведите букву в числовом виде по вертикали: ");
        int[] inputLetterVer = Input.input(); // Вводим числовой вид буквы
        char recognizedLetterVer = Recognition.recognize(y, inputLetterVer); // Распознаем букву
        System.out.println("Распознанная буква по вертикали: " + recognizedLetterVer); // Выводим

        // Проверка. Если распознанные буквы равны
        if (recognizedLetterHor == recognizedLetterVer) {
            System.out.println("\nФинальное распознавание: " + recognizedLetterVer);
        } else {
            System.out.println("\nРезультат распознавания отличается" +
                    "\nВ таком случае принято выбрать горизонтальное распознавание");
            System.out.println("\nФинальное распознавание: " + recognizedLetterHor);
        }
    }
}



