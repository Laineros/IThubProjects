package FundOfAlgos;

public class CP8 {
    public static void main(String[] args) {
        /*System.out.println("Восьмое число в последовательности равно "+
                luksNumbers(8));*/

        /*intNumbers(2, 15);*/

        /*int[] array = {3, 5, 2, 8, 10, 7, 17, 6, 22, -10};
        int maxEven = findMaxEven(array, 0, array.length - 1);

        if (maxEven != 0) {
            System.out.println("Максимальный четный элемент: " + maxEven);
        } else {
            System.out.println("Четные элементы отсутствуют в массиве.");
        }*/

        SeriesSum();
    }
    public static int luksNumbers(int x) {
        if (x == 1) {
            return 2;
        } else if (x == 2) {
            return 1;
        }
        if (x > 2) {
            return luksNumbers(x - 2) + luksNumbers(x - 1);
        }
        return -1;
    }

    public static void intNumbers(int a, int b) {
        if(a > b) {return;}
        System.out.println(a);
        intNumbers(++a, b);
    }

    public static int findMaxEven(int[] array, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return (array[left] % 2 == 0) ? array[left] : 0;
        }
        int mid = left + (right - left) / 2;
        int leftMax = findMaxEven(array, left, mid);
        int rightMax = findMaxEven(array, mid + 1, right);
        return Math.max(leftMax, rightMax);
    }

    public static void SeriesSum () {
        double epsilon = 0.001;
        double sum = 0.0;
        int n = 1;
        while (true) {
            double a_n = (2.0 * n - 1) / (2.0 * n);
            sum += a_n;
            if (a_n < epsilon) { break; }
            n++;
        }

        System.out.printf("Сумма ряда с точностью ε = %.3f: %.5f%n", epsilon, sum);
    }
}
