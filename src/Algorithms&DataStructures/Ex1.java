import java.io.*;
import java.util.Arrays;

public class Ex1 {
    public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int[] abc = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            double d = (abc[1]*abc[1])-(4*abc[0]*abc[2]);
            if (d==0) {
                double x1 = (double) -abc[1] / (2*abc[0]);
                System.out.printf("%.6f", x1);
            } else if (d>0) {
                double x1 = (-abc[1]-Math.sqrt(d))/(2*abc[0]);
                double x2 = (-abc[1]+Math.sqrt(d))/(2*abc[0]);
                System.out.println("2");
                if (x1 > x2) {
                    System.out.printf("%.6f %.6f%n", x2, x1);
                } else {
                    System.out.printf("%.6f %.6f%n", x1, x2);
                }
            } else {
                System.out.print("0");
            }
            reader.close();
    }
}
