import java.util.Arrays;
import java.util.Random;

public class CP9 {
    public static void main(String[] args) {
        int n = 10;
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100);
        }
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        int[] indices = findThreeMinIndices(arr);
        System.out.println("Индексы минимальных элементов: " + Arrays.toString(indices));
    }

    public static int[] findThreeMinIndices(int[] arr) {
        int n = arr.length;
        int[] indices = new int[3];
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, min3 = Integer.MAX_VALUE;
        int idx1 = -1, idx2 = -1, idx3 = -1;

        for (int i = 0; i < n-1; i++) {
            if (arr[i] < min1) {
                min1 = arr[i];
                idx1 = i;
            }
        }
        for (int i = 0; i < n-1; i++) {
            if (arr[i] <= min2 && i != idx1) {
                min2 = arr[i];
                idx2 = i;
            }
        }
        for (int i = 0; i < n-1; i++) {
            if (arr[i] <= min3 && i != idx1 && i != idx2) {
                min3 = arr[i];
                idx3 = i;
            }
        }

        indices[0] = idx1;
        indices[1] = idx2;
        indices[2] = idx3;

        return indices;
    }
}
