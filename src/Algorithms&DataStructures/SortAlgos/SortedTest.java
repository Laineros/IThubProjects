package SortAlgos;
import java.util.Arrays;
import java.util.Random;

public class SortedTest {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    // Генератор массива
    public static int[] generateArray(int size, String type) {
        int[] array = new int[size];
        Random rand = new Random();
        switch (type) {
            case "рандомный":
                for (int i = 0; i < size; i++) array[i] = rand.nextInt(10000);
                break;
            case "сортированный":
                for (int i = 0; i < size; i++) array[i] = i;
                break;
            case "обратный":
                for (int i = 0; i < size; i++) array[i] = size - i;
                break;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] sizes = {10, 1000, 10000, 100000};
        String[] cases = {"сортированный", "рандомный", "обратный"};

        for (int size : sizes) {
            for (String type : cases) {
                int[] array1 = generateArray(size, type);
                int[] array2 = Arrays.copyOf(array1, array1.length);

                long start = System.nanoTime();
                bubbleSort(array1);
                long bubbleTime = System.nanoTime() - start;

                start = System.nanoTime();
                mergeSort(array2);
                long mergeTime = System.nanoTime() - start;

                System.out.printf("Размер: %6d | Вид: %-13s | BubbleSort: %7d ms | MergeSort: %7d ms%n",
                        size, type, bubbleTime / 1_000_000, mergeTime / 1_000_000);
            }
        }
    }
}