import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int initial_value;
        do {

            System.out.print("Введите число: ");
            initial_value = in.nextInt();

        } while (initial_value > 10000 || initial_value < 0); //Проверка введенного числа, на соответствие заданному диапазону (от 0 до 10000)

        System.out.println("Перевод с помощью встроенных методов");
        System.out.println("--------------------------------------------------------");
        System.out.println("10 -> 16: " + Integer.toHexString(initial_value));
        String binary_system = Integer.toBinaryString(initial_value);
        System.out.println("10 -> 2: " + binary_system);
        System.out.println("2 -> 10: " + Integer.parseInt(binary_system, 2));
        System.out.println("--------------------------------------------------------\n");

        System.out.println("Перевод с помощью написанных алгоритмов");
        System.out.println("--------------------------------------------------------");

        StringBuilder hexadecimal = decimal_to_hexadecimal(initial_value);
        System.out.println("10 -> 16: " + hexadecimal); //Вывод на экран шестнадцатеричного представления введенного числа

        String binary_value = decimal_to_binary(initial_value).toString();
        System.out.println("10 -> 2: " + binary_value); //Вывод на экран двоичного представления введенного числа

        int decimal_value = binary_to_decimal(binary_value);
        System.out.println("2 -> 10: " + decimal_value); //Вывод на экран десятичного представления введенного числа
        System.out.println("--------------------------------------------------------");

    }

    static public StringBuilder decimal_to_hexadecimal(int initial_value) {
        StringBuilder result = new StringBuilder();
        int remainder; //Остаток
        String index = "abcdef"; //Строка букв

        if (initial_value >= 16) {
            while (initial_value >= 16) {
                remainder = initial_value % 16; //Находим остаток

                if (remainder >= 10) { //Если остаток больше 10, тогда заменяем число на буквенное значение
                    result.append(index.charAt(remainder % 10)); //Выбираем подходящее буквенное значение согласно полученному остатку и добавляем в конечный результат
                } else {
                    result.append(remainder);
                }

                initial_value = (initial_value - remainder) / 16; // Обновляем значение

                if (initial_value < 16) { //Проверяем на оставшееся значение после деления
                    if(initial_value>=10){
                        result.append(index.charAt(initial_value % 10)); //Выбираем подходящее буквенное значение согласно оставшемуся значению и добавляем в конечный результат
                    }else {
                        result.append(initial_value); //В случае, если значение меньше 16, добавляем оставшееся число в конечный результат
                    }
                }
            }
        } else {
            if (initial_value >= 10) { //Если остаток больше 10, тогда заменяем число на буквенное значение
                result.append(index.charAt(initial_value % 10)); //Выбираем подходящее буквенное значение согласно полученному остатку и добавляем в конечный результат
            } else {
                result.append(initial_value);
            }
        }

        return result.reverse(); //Возвращаем значение в обратном порядке
    }

    static public StringBuilder decimal_to_binary(int initial_value) {
        StringBuilder result = new StringBuilder();
        int remainder; // Остаток
        if (initial_value == 0){
            return result.append(0);
        }
        while (initial_value >= 1) {
            remainder = initial_value % 2; //Находим остаток
            result.append(initial_value % 2); //Добавляем остаток к результирующему значению
            initial_value = (initial_value - remainder) / 2; //Обновляем значение
        }

        return result.reverse();//Возвращаем значение в обратном порядке
    }

    static public int binary_to_decimal(String initial_value) {
        String value = initial_value;
        int result = 0; //Результат
        for (int i = 0, j = value.length() - 1; i < value.length(); i++, j--) {
            int meaning = Integer.parseInt(String.valueOf(value.charAt(i))); //Выборка желаемого значения из ранее созданной строки
            result += meaning * Math.pow(2, j); //Умножаем значение на количество 2 равное его порядковому расположению
        }

        return result; //Возвращаем результат
    }
}