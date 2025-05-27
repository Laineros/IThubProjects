package FundOfAlgos;

public class AlgorithmKaratsuba {
    public static void main(String[] args) {
        System.out.println(Karatsuba(364, 25));
        System.out.println(364*25);
    }
    public static int Karatsuba(int x, int y) {
        if (x < 10 || y < 10) {
            return x * y;
        }
        int length = Math.max(Integer.toString(x).length(), Integer.toString(y).length());
        int halfLength = length / 2;
        int max1 = x / (int) Math.pow(10, halfLength);
        int min1 = x % (int) Math.pow(10, halfLength);
        int max2 = y / (int) Math.pow(10, halfLength);
        int min2 = y % (int) Math.pow(10, halfLength);
        int a = Karatsuba(max1, max2);
        int b = Karatsuba(min1, min2);
        int c = Karatsuba(max1 + min1, max2 + min2) - a - b;
        return (a * (int) Math.pow(10, 2 * halfLength)) + (c * (int) Math.pow(10, halfLength)) + b;
    }
}
