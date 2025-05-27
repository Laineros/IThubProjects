import java.util.Scanner;

public class EffectiveRoutes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] arr = new int[x];
        for (int i = 0; i < x; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        int idealRoute = 0;
        for (int i = 0; i < x; i++) {
            int left = i, right = i;
            while (left >= 0 && right < x && arr[left] == arr[right]) {
                idealRoute = Math.max(idealRoute, right - left + 1);
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < x && arr[left] == arr[right]) {
                idealRoute = Math.max(idealRoute, right - left + 1);
                left--;
                right++;
            }
        }
        System.out.println(idealRoute >= 2 ? idealRoute : 0);
    }
}