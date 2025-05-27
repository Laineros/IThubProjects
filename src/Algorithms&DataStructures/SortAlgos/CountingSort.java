package SortAlgos;

import java.util.Arrays;

public class CountingSort {

    public static void countingSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        // Находим максимальный элемент
        int max = Arrays.stream(arr).max().getAsInt();

        // Создаем массив для подсчета
        int[] count = new int[max + 1];

        // Заполняем массив count
        for (int num : arr) {
            count[num]++;
        }

        // Модифицируем count для хранения позиций
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Строим отсортированный массив
        int[] sortedArr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {  // Обратный проход для устойчивости
            int num = arr[i];
            sortedArr[count[num] - 1] = num;
            count[num]--;
        }

        // Копируем результат в исходный массив
        System.arraycopy(sortedArr, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("Исходный массив: " + Arrays.toString(arr));

        countingSort(arr);
        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
    }
}
