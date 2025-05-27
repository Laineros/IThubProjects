package ElemStructures;

public class RecursiveFunction {
    public static int F(int n) {
        if (n == 1 || n == 2) {
            return 3;
        }
        return 5 * F(n - 1) - 4 * F(n - 2); // Рекуррентное соотношение
    }

    public static void main(String[] args) {
        int n = 9;
        int result = F(n);
        System.out.println("F(" + n + ") = " + result);
        System.out.println("Дерево рекурсии для F(9): ");
        printRecursionTree(n, 0);
        System.out.println("Глубина дерева рекурсии для F(9): " + calculateRecursionDepth(n));
    }

    // Метод для вывода дерева рекурсии
    public static void printRecursionTree(int n, int depth) {
        if (n == 1 || n == 2) {
            System.out.println("  ".repeat(depth) + "F(" + n + ") = 3");
            return;
        }

        System.out.println("  ".repeat(depth) + "F(" + n + ") = 5 * F(" +
                (n - 1) + ") - 4 * F(" + (n - 2) + ")");

        // Рекурсивный вызов для F(n-1) и F(n-2)
        printRecursionTree(n - 1, depth + 1);
        printRecursionTree(n - 2, depth + 1);
    }

    // Метод для вычисления глубины рекурсии
    public static int calculateRecursionDepth(int n) {
        if (n == 1 || n == 2) {
            return 1; // Глубина 1 для базовых случаев
        }
        int depth1 = calculateRecursionDepth(n - 1);
        int depth2 = calculateRecursionDepth(n - 2);
        return Math.max(depth1, depth2) + 1; // Глубина дерева рекурсии
    }
}
