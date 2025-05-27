import java.util.Scanner;

public class AndreyAndAcid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            if (a[i] < a[i - 1]) {
                System.out.println(-1);
                return;
            }
        }

        long operations = 0;

        for (int i = 1; i < n; i++) {
            operations += a[i] - a[i - 1];
        }

        System.out.println(operations);
    }
}