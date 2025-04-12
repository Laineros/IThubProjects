import java.util.Arrays;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        int K = 3; // Перед этим столбцом вставим первый столбец с нулями
        int S = 4; // После этого столбца вставим второй столбец с нулями

        // Вставляем два столбца с нулями
        matrix = insertColumns(matrix, K, S);

        // Выводим изменённый массив
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] insertColumns(int[][] matrix, int K, int S) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        // Новый массив с двумя дополнительными столбцами
        int newColumns = columns + 2;
        int[][] newMatrix = new int[rows][newColumns];

        // Копируем элементы в новый массив
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < K; j++) {
                newMatrix[i][j] = matrix[i][j]; // Копируем до K-го столбца
            }
            // Вставляем первый столбец с нулями перед K
            newMatrix[i][K] = 0;
            for (int j = K + 1; j < S + 1; j++) {
                newMatrix[i][j] = matrix[i][j - 1]; // Копируем столбцы между K и S
            }
            // Вставляем второй столбец с нулями после S
            newMatrix[i][S + 1] = 0;
            for (int j = S + 2; j < newColumns; j++) {
                newMatrix[i][j] = matrix[i][j - 2]; // Копируем столбцы после S
            }
        }

        return newMatrix;
    }
}
