public class AdditionUsingOnlyOne {
    public static int add(int a, int b) {
        while (b > 0) {
            a = a + 1;
            b = b - 1;
        }
        while (b < 0) {
            a = a - 1;
            b = b + 1;
        }

        return a;
    }

    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 3;

        int result = add(num1, num2);
        System.out.println("Результат сложения " + num1 + " и " + num2 + " = " + result);
        num1 = 10;
        num2 = -6;
        result = add(num1, num2);
        System.out.println("Результат сложения " + num1 + " и " + num2 + " = " + result);
    }
}
