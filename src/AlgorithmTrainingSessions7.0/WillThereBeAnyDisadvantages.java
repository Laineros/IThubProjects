import java.util.Scanner;
import java.util.Stack;

public class WillThereBeAnyDisadvantages {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) {
            sb.append(sc.nextLine());
        }
        sc.close();
        String input = sb.toString().replaceAll("\\s+", "");
        System.out.println(solveExpression(input));
    }

    private static long solveExpression(String str) {
        Stack<Long> nums = new Stack<>();
        Stack<Integer> opers = new Stack<>();
        long num = 0;
        int sign = 1;
        boolean buildingNumber = false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
                buildingNumber = true;
            } else {
                if (buildingNumber) {
                    nums.push(sign * num);
                    num = 0;
                    sign = 1;
                    buildingNumber = false;
                }
                if (ch == '+') {
                    sign = 1;
                } else if (ch == '-') {
                    int count = 1;
                    while (i + 1 < str.length() && (str.charAt(i + 1) == '-' || str.charAt(i + 1) == '+')) {
                        i++;
                        if (str.charAt(i) == '-') count++;
                    }
                    sign = (count % 2 == 0) ? 1 : -1;
                } else if (ch == '(') {
                    opers.push(sign);
                    sign = 1;
                    nums.push(Long.MIN_VALUE);
                } else if (ch == ')') {
                    long subtotal = 0;
                    while (!nums.isEmpty() && nums.peek() != Long.MIN_VALUE) {
                        subtotal += nums.pop();
                    }
                    nums.pop();
                    int prevSign = opers.pop();
                    nums.push(prevSign * subtotal);
                }
            }
        }
        if (buildingNumber) {
            nums.push(sign * num);
        }
        long result = 0;
        while (!nums.isEmpty()) {
            result += nums.pop();
        }
        return result;
    }
}
