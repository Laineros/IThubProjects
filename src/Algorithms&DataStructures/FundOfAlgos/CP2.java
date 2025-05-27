package FundOfAlgos;

import java.util.Scanner;

public class CP2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        while (true) {
            if(x%5==0) {
                System.out.println("Число кратно пяти");
                break;
            }
            x++;
            System.out.println(x);
        }
    }
}
