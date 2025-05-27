package ElemStructures;

import java.util.Arrays;
import java.util.Random;

public class MultidimensionalArray {
    /*1.	Написать функцию для формирования массива. В массиве содержится N строк. N – генерируется рандомно один раз для массива.
     В каждой строке M чисел. Для каждой строки M разное, но может повторяться, генерируется рандомно для каждой строки. Каждое число генерируется рандомно.
    2.	Вычислить величины (по вариантам) для всего массива и для каждой строки отдельно.
*/
    public static void main(String[] args) {
        int[][] arr = createArray();
        System.out.println(Arrays.deepToString(arr));
        int len = arr.length;
        double[] avgOfStrings = new double[len];
        double[] sumOfStrings = new double[len];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                avgOfStrings[i] += arr[i][j];
            }
            if (arr[i].length != 0) {
                avgOfStrings[i] = avgOfStrings[i] / arr[i].length;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] < avgOfStrings[i]){
                    sumOfStrings[i] += arr[i][j];
                }
            }
        }
        System.out.println(Arrays.toString(sumOfStrings));
        // Суммируем все значения
        double sum = getSum(arr);
        System.out.println(sum);
    }

    private static double getSum(int[][] arr) {
        double sum = 0;
        for (int[] lines : arr) {
            for (int elem : lines) {
                sum += elem;
            }
        }

        // Находим среднее арифметическое
        double avg = sum / arr.length;
        sum = 0;

        // Проходим с условием по массиву
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] < avg) {
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }

    // Создание массива с рандомными значениями
    static int[][] createArray() {
        Random rand = new Random();
        int[][] array = new int[rand.nextInt(10)][];
        for (int i = 0; i < array.length; i++) {
            array[i] = new int[rand.nextInt(10)];
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = rand.nextInt(100);
            }
        }

        return array;
    }
}
