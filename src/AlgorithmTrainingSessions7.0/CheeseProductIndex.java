import java.util.Scanner;

public class CheeseProductIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int[] count = new int[201]; // Цены от 1 до 200 включительно
        long opportunities = 0;
        // Считаем для каждой цены сколько до этого встречались цены меньше
        for (int i = 0; i < n; i++) {
            int currentPrice = prices[i];
            for (int price = 1; price < currentPrice; price++) {
                opportunities += count[price];
            }
            count[currentPrice]++;
        }

        System.out.println(opportunities);
    }
}
