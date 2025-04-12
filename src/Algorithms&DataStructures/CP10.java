import java.util.Arrays;

public class CP10 {
    public static void main(String[] args) {
        int[] arr = {3, -5, 2, 4, -1, 2, -2, 6, 7, 8};
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
                minIndex = i;
            }
        }

        int[] result = new int[arr.length];
        int resultIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            // Если элемент идет до минимального или не положительный добавляем его
            if (i < minIndex || (arr[i] <= 0) || (arr[i] > 0 && i % 2 != 0 && i > minIndex)) {
                result[resultIndex++] = arr[i];
            }
        }
        // Обрезаем массив результата до фактического размера
        result = Arrays.copyOf(result, resultIndex);
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        System.out.println("Результирующий массив: " + Arrays.toString(result));
    }
}
